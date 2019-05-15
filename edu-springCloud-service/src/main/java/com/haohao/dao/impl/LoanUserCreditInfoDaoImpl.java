package com.haohao.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haohao.dao.LoanUserCreditInfoDao;
import com.haohao.mapper.auto.LoanUserCreditInfoMapper;
import com.haohao.modelAndExample.LoanUserCreditInfo;
import com.haohao.modelAndExample.LoanUserCreditInfoExample;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午8:22:42
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Repository
public class LoanUserCreditInfoDaoImpl implements LoanUserCreditInfoDao{
	@Autowired
	private LoanUserCreditInfoMapper loanUserCreditInfoMapper;

	@Override
	public int insertSelective(LoanUserCreditInfo record) {
		return loanUserCreditInfoMapper.insertSelective(record);
	}

	@Override
	public LoanUserCreditInfo findByOrderId(Integer orderId) {
		LoanUserCreditInfoExample example = new LoanUserCreditInfoExample();
		LoanUserCreditInfoExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<LoanUserCreditInfo> list = loanUserCreditInfoMapper.selectByExample(example);
		return (list == null || list.size() == 0) ? null : list.get(0);
	}

}
