package com.haohao.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haohao.dao.LoanUserInfoDao;
import com.haohao.mapper.auto.LoanUserInfoMapper;
import com.haohao.modelAndExample.LoanUserInfo;
import com.haohao.modelAndExample.LoanUserInfoExample;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午6:19:36
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Repository
public class LoanUserInfoDaoImpl implements LoanUserInfoDao{
	@Autowired
	private LoanUserInfoMapper loanUserInfoMapper;

	@Override
	public int insertSelective(LoanUserInfo record) {
		return loanUserInfoMapper.insertSelective(record);
	}

	@Override
	public LoanUserInfo findByOrderId(Integer orderId) {
		LoanUserInfoExample example = new LoanUserInfoExample();
		LoanUserInfoExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<LoanUserInfo> list = loanUserInfoMapper.selectByExample(example);
		return (list == null || list.size() == 0) ? null : list.get(0);
	}
}
