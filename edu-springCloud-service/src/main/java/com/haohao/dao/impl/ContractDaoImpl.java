package com.haohao.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haohao.dao.ContractDao;
import com.haohao.mapper.auto.ContractMapper;
import com.haohao.modelAndExample.Contract;
import com.haohao.modelAndExample.ContractExample;
import com.haohao.util.paramAndDto.ContractParam;

/**
 * @Desc 额度申请Dao实现
 * @Author xiekunliang
 * @Date 2018/5/16 15:11
 */
@Repository
public class ContractDaoImpl implements ContractDao {

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return contractMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Contract contract) {
        return contractMapper.insertSelective(contract);
    }

    @Override
    public Contract selectByPrimaryKey(Integer id) {
        return contractMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Contract contract) {
        return contractMapper.updateByPrimaryKeySelective(contract);
    }

    @Override
    public List<Contract> selectByContractParam(ContractParam param) {
        return contractMapper.selectByContractParam(param);
    }

    @Override
    public int quotaApplySuccess(List<Integer> successIds, Contract contract) {
        ContractExample example = new ContractExample();
        ContractExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(successIds);
        return contractMapper.updateByExampleSelective(contract, example);
    }

    @Override
    public Contract selectByContractCode(String contractCode) {
        ContractExample example = new ContractExample();
        ContractExample.Criteria criteria = example.createCriteria();
        criteria.andContractCodeEqualTo(contractCode);
        List<Contract> list = contractMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }
    @Override
    public int subtractBalance(String contractCode,BigDecimal subtract){
    	return contractMapper.subtractBalance(contractCode, subtract);
    }

    @Override
    public BigDecimal countSumBalance() {
        return contractMapper.countSumBalance();
    }
}
