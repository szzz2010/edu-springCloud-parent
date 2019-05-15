package com.haohao.service.order;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.haohao.constant.AgencyConstant;
import com.haohao.modelAndExample.Agency;
import com.haohao.modelAndExample.AgencyMethod;
import com.haohao.module.AgencyMethodModule;
import com.haohao.module.AgencyModule;
import com.haohao.module.ContractModule;
import com.haohao.util.paramAndDto.PredicateUtil;
import com.haohao.util.service.RequestUtil;

/**
 * @Desc 额度推送
 * @Author xiekunliang
 * @Date 2018/5/16 17:30
 */
@Component
public class QuotaApplyService {

    @Autowired
    private AgencyModule agencyModule;

    @Autowired
    private AgencyMethodModule agencyMethodModule;

    @Autowired
    private ContractModule contractModule;


    /**
     * @param contractCode 额度包编号
     * @param quotaSum     募集金额，单位元，精确到分。
     * @param startDate    格式：yyyy-MM-dd，默认系统日期
     * @param invalidDate  格式：yyyy-MM-dd，超过失效日期，该额度不可用。
     * @param source       机构组织码
     * @param method       请求方法
     * @return {result:***, message:***}
     * @Desc 推送额度申请
     * @Author xiekunliang
     * @Date 2018/5/16 16:43
     */
    public Map<String, Object> quotaApply(String contractCode,
                                          BigDecimal quotaSum,
                                          String startDate,
                                          String invalidDate,
                                          String source,
                                          String method) throws Exception {

        Agency agency = agencyModule.findBySourceAndStatus(source, AgencyConstant.Enable.NORMAL);
        PredicateUtil.notNull(agency, "该机构不可用");
        AgencyMethod agencyMethod = agencyMethodModule.find(source, method, AgencyConstant.MethodEnable.NORMAL);
        PredicateUtil.notNull(agencyMethod, "请求方法不可用");
        Map<String, Object> content = new HashMap<String, Object>() {{
            put("contractCode", contractCode);
            put("quotaSum", quotaSum);
            put("startDate", startDate);
            put("invalidDate", invalidDate);
        }};
        return RequestUtil.requestThird(content, method, agency, agencyMethod);
    }

}
