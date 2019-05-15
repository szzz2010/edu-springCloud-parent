package com.haohao.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haohao.dao.ContractDetailDao;
import com.haohao.mapper.auto.ContractDetailMapper;
import com.haohao.util.paramAndDto.ContractDetail;
import com.haohao.util.paramAndDto.ContractDetailParam;

/**
 * @Desc
 * @Author xiekunliang
 * @Date 2018/5/19 18:04
 */
@Repository
public class ContractDetailDaoImpl implements ContractDetailDao {

    @Autowired
    private ContractDetailMapper contractDetailMapper;

    @Override
    public List<ContractDetail> selectContractDetails(ContractDetailParam param) {
        return contractDetailMapper.selectContractDetails(param);
    }

    @Override
    public BigDecimal countSumContractAmt(String contractCode) {
        return contractDetailMapper.countSumContractAmt(contractCode);
    }
}
