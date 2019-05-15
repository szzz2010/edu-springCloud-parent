package com.haohao.dao;

import java.math.BigDecimal;
import java.util.List;

import com.haohao.util.paramAndDto.ContractDetail;
import com.haohao.util.paramAndDto.ContractDetailParam;

/**
 * @Desc 额度包明细Dao
 * @Author xiekunliang
 * @Date 2018/5/19 18:02
 */
public interface ContractDetailDao {

    /**
     * @Desc 查询明细
     * @Author xiekunliang
     * @Date 2018/5/19 18:04
     */
    List<ContractDetail> selectContractDetails(ContractDetailParam param);

    /**
     * @Desc 使用总金额
     * @Author xiekunliang
     * @Date 2018/5/19 21:39
     */
    BigDecimal countSumContractAmt(String contractCode);
}
