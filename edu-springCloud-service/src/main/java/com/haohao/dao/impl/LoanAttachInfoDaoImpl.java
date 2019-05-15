package com.haohao.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haohao.dao.LoanAttachInfoDao;
import com.haohao.mapper.auto.LoanAttachInfoMapper;
import com.haohao.modelAndExample.LoanAttachInfo;
import com.haohao.modelAndExample.LoanAttachInfoExample;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午8:00:42
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Repository
public class LoanAttachInfoDaoImpl implements LoanAttachInfoDao{
	@Autowired
	private LoanAttachInfoMapper loanAttachInfoMapper;

	@Override
	public int insertSelective(LoanAttachInfo record) {
		return loanAttachInfoMapper.insertSelective(record);
	}

	@Override
	public List<LoanAttachInfo> findByOrderId(Integer orderId) {
		LoanAttachInfoExample example = new LoanAttachInfoExample();
		LoanAttachInfoExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<LoanAttachInfo> list = loanAttachInfoMapper.selectByExample(example);
		return list;
	}

}
