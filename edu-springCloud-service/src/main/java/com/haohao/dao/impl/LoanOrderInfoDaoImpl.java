package com.haohao.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haohao.dao.LoanOrderInfoDao;
import com.haohao.mapper.auto.LoanOrderInfoMapper;
import com.haohao.modelAndExample.LoanOrderInfo;
import com.haohao.modelAndExample.LoanOrderInfoExample;
import com.haohao.util.paramAndDto.LoanOrderInfoParam;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午6:11:14
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Repository
public class LoanOrderInfoDaoImpl implements LoanOrderInfoDao{
	@Autowired
	private LoanOrderInfoMapper loanOrderInfoMapper;

	@Override
	public int insertSelective(LoanOrderInfo record) {
		return loanOrderInfoMapper.insertSelective(record);
	}
	@Override
	public LoanOrderInfo find(String loanNumber,Integer enable,String source){
		LoanOrderInfoExample example = new LoanOrderInfoExample();
		LoanOrderInfoExample.Criteria criteria = example.createCriteria();
		criteria.andLoanNumberEqualTo(loanNumber);
		criteria.andEnableEqualTo(enable);
		if(null != source){
			criteria.andSourceEqualTo(source);
		}
		List<LoanOrderInfo> list = loanOrderInfoMapper.selectByExample(example);
		return (list == null || list.size() == 0) ? null : list.get(0);
	}
	@Override
	public LoanOrderInfo selectByPrimaryKey(Integer orderId) {
		return loanOrderInfoMapper.selectByPrimaryKey(orderId);
	}

	@Override
	public int updateByPrimaryKeySelective(LoanOrderInfo record) {
		record.setUpdateTime(System.currentTimeMillis()/1000);
		return loanOrderInfoMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public int handleEntryResult(Integer orderId,Integer xsEntryStatus){
		LoanOrderInfoExample example = new LoanOrderInfoExample();
		LoanOrderInfoExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		criteria.andXsEntryStatusEqualTo(1);
		LoanOrderInfo record = new LoanOrderInfo();
		record.setXsEntryStatus(xsEntryStatus);
		record.setUpdateTime(System.currentTimeMillis()/1000);
		return loanOrderInfoMapper.updateByExampleSelective(record, example);
	}
	@Override
	public int handleAuditResult(Integer orderId, Integer xsEntryStatus) {
		LoanOrderInfoExample example = new LoanOrderInfoExample();
		LoanOrderInfoExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<Integer> values = new ArrayList<Integer>();
		values.add(1);
		values.add(2);
		criteria.andXsEntryStatusIn(values);
		LoanOrderInfo record = new LoanOrderInfo();
		record.setXsEntryStatus(xsEntryStatus);
		record.setUpdateTime(System.currentTimeMillis()/1000);
		return loanOrderInfoMapper.updateByExampleSelective(record, example);
	}
	@Override
	public int handleRiskResult(Integer orderId, Integer riskStatus, String riskLevel) {
		LoanOrderInfoExample example = new LoanOrderInfoExample();
		LoanOrderInfoExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		criteria.andRiskStatusEqualTo(0);
		LoanOrderInfo record = new LoanOrderInfo();
		record.setRiskStatus(riskStatus);
		record.setRiskLevel(riskLevel);
		record.setUpdateTime(System.currentTimeMillis()/1000);
		return loanOrderInfoMapper.updateByExampleSelective(record, example);
	}
	@Override
	public int handleXsPayStatus(Integer orderId, Integer xsPayStatus, Long payTime) {
		LoanOrderInfoExample example = new LoanOrderInfoExample();
		LoanOrderInfoExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		criteria.andXsPayStatusEqualTo(0);
		LoanOrderInfo record = new LoanOrderInfo();
		record.setXsPayStatus(xsPayStatus);
		if(null != payTime){//放款失败 payTime为null
			record.setXsPayTime(payTime);
		}
		record.setUpdateTime(System.currentTimeMillis()/1000);
		return loanOrderInfoMapper.updateByExampleSelective(record, example);
	}
	@Override
	public List<LoanOrderInfo> selectByOrderParam(LoanOrderInfoParam param) {
		// TODO Auto-generated method stub
		return loanOrderInfoMapper.selectByOrderParam(param);
	}
}
