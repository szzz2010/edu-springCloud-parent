package com.haohao.dao;

import java.math.BigDecimal;
import java.util.List;

import com.haohao.modelAndExample.Contract;
import com.haohao.util.paramAndDto.ContractParam;

/**
 * @Desc 额度申请Dao
 * @Author xiekunliang
 * @Date 2018/5/16 15:10
 */
public interface ContractDao extends CommonDao<Contract> {

    /**
     * @Desc 分页列表
     * @Author xiekunliang
     * @Date 2018/5/16 15:47
     */
    List<Contract> selectByContractParam(ContractParam param);

    /**
     * @Desc 推送成功，更新数据
     * @Author xiekunliang
     * @Date 2018/5/17 17:24
     */
    int quotaApplySuccess(List<Integer> successIds, Contract contract);

    /**
     * @Desc 根据contractCode查询
     * @Author xiekunliang
     * @Date 2018/5/18 14:10
     */
    Contract selectByContractCode(String contractCode);

    /**
     * <p>Description：扣减额度</p>
     *
     * @param contractCode
     * @param subtract
     * @return
     * @date 2018年5月18日 下午8:44:45
     * @author zhangqiang
     */
    int subtractBalance(String contractCode, BigDecimal subtract);

    /**
     * @Desc 查询剩余总额度
     * @Author xiekunliang
     * @Date 2018/5/19 20:41
     */
    BigDecimal countSumBalance();
}
