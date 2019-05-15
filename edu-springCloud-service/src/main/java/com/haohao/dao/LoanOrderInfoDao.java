package com.haohao.dao;

import java.util.List;

import com.haohao.modelAndExample.LoanOrderInfo;
import com.haohao.util.paramAndDto.LoanOrderInfoParam;

/**
 * <p>Description：</p>
 *
 * @author zhangqiang
 * @version v1.0
 *          Copyright (c) 2018 haohao
 * @date 2018年5月16日 下午6:09:08
 */
public interface LoanOrderInfoDao {

    int insertSelective(LoanOrderInfo record);

    LoanOrderInfo find(String loanNumber, Integer enable, String source);

    LoanOrderInfo selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(LoanOrderInfo record);

    /**
     * <p>Description：学习进件结果修改</p>
     *
     * @param orderId
     * @param xsEntryStatus 目标状态
     * @return
     * @date 2018年5月18日 下午1:54:39
     * @author zhangqiang
     */
    int handleEntryResult(Integer orderId, Integer xsEntryStatus);

    /**
     * <p>Description：学习审批结果修改</p>
     *
     * @param orderId
     * @param xsEntryStatus 目标状态
     * @return
     * @date 2018年5月18日 下午1:58:33
     * @author zhangqiang
     */
    int handleAuditResult(Integer orderId, Integer xsEntryStatus);

    /**
     * <p>Description：执行风控结果</p>
     *
     * @param orderId
     * @param riskStatus 目标状态
     * @param riskLevel  目标等级
     * @return
     * @date 2018年5月19日 下午12:41:45
     * @author zhangqiang
     */
    int handleRiskResult(Integer orderId, Integer riskStatus, String riskLevel);
    
    /**
     * <p>Description：放款结果更新</p>
     * @date 2018年5月21日 下午8:45:51
     * @author zhangqiang
     * @param orderId
     * @param xsPayStatus
     * @return
     */
    int handleXsPayStatus(Integer orderId,Integer xsPayStatus,Long payTime);

    /**
     * 
     * @descript <p> 根據條件 分页获取定单信息</p>
     * @author wanglicheng
     * @date 2018年5月22日
     * @param param
     * @return
     */
    public List<LoanOrderInfo> selectByOrderParam(LoanOrderInfoParam param);
}
