package com.haohao.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haohao.dao.LoanUserEntityInfoDao;
import com.haohao.mapper.auto.LoanUserEntityInfoMapper;
import com.haohao.modelAndExample.LoanUserEntityInfo;
import com.haohao.modelAndExample.LoanUserEntityInfoExample;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午8:12:34
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Repository
public class LoanUserEntityInfoDaoImpl implements LoanUserEntityInfoDao{
	@Autowired
	private LoanUserEntityInfoMapper loanUserEntityInfoMapper;

	@Override
	public int insertSelective(LoanUserEntityInfo record) {
		return loanUserEntityInfoMapper.insertSelective(record);
	}

	@Override
	public LoanUserEntityInfo findByOrderId(Integer orderId) {
		LoanUserEntityInfoExample example = new LoanUserEntityInfoExample();
		LoanUserEntityInfoExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<LoanUserEntityInfo> list = loanUserEntityInfoMapper.selectByExample(example);
		return (list == null || list.size() == 0) ? null : list.get(0);
	}

}
