package com.haohao.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haohao.dao.LoanBankCardInfoDao;
import com.haohao.mapper.auto.LoanBankCardInfoMapper;
import com.haohao.modelAndExample.LoanBankCardInfo;
import com.haohao.modelAndExample.LoanBankCardInfoExample;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午7:54:07
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Repository
public class LoanBankCardInfoDaoImpl implements LoanBankCardInfoDao{
	@Autowired
	private LoanBankCardInfoMapper loanBankCardInfoMapper;

	@Override
	public int insertSelective(LoanBankCardInfo record) {
		return loanBankCardInfoMapper.insertSelective(record);
	}

	@Override
	public LoanBankCardInfo findByOrderId(Integer orderId) {
		LoanBankCardInfoExample example = new LoanBankCardInfoExample();
		LoanBankCardInfoExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<LoanBankCardInfo> list = loanBankCardInfoMapper.selectByExample(example);
		return (list == null || list.size() == 0) ? null : list.get(0);
	}

}
