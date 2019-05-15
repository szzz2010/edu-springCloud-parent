package com.haohao.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haohao.dao.LoanUserJobInfoDao;
import com.haohao.mapper.auto.LoanUserJobInfoMapper;
import com.haohao.modelAndExample.LoanUserJobInfo;
import com.haohao.modelAndExample.LoanUserJobInfoExample;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午8:07:24
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Repository
public class LoanUserJobInfoDaoImpl implements LoanUserJobInfoDao{
	@Autowired
	private LoanUserJobInfoMapper loanUserJobInfoMapper;

	@Override
	public int insertSelective(LoanUserJobInfo record) {
		return loanUserJobInfoMapper.insertSelective(record);
	}

	@Override
	public LoanUserJobInfo findByOrderId(Integer orderId) {
		LoanUserJobInfoExample example = new LoanUserJobInfoExample();
		LoanUserJobInfoExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<LoanUserJobInfo> list = loanUserJobInfoMapper.selectByExample(example);
		return (list == null || list.size() == 0) ? null : list.get(0);
	}
	
}
