package com.haohao.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haohao.dao.LoanUserAssetInfoDao;
import com.haohao.mapper.auto.LoanUserAssetInfoMapper;
import com.haohao.modelAndExample.LoanUserAssetInfo;
import com.haohao.modelAndExample.LoanUserAssetInfoExample;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午8:17:50
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Repository
public class LoanUserAssetInfoDaoImpl implements LoanUserAssetInfoDao{
	@Autowired
	private LoanUserAssetInfoMapper loanUserAssetInfoMapper;

	@Override
	public int insertSelective(LoanUserAssetInfo record) {
		return loanUserAssetInfoMapper.insertSelective(record);
	}

	@Override
	public LoanUserAssetInfo findByOrderId(Integer orderId) {
		LoanUserAssetInfoExample example = new LoanUserAssetInfoExample();
		LoanUserAssetInfoExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<LoanUserAssetInfo> list = loanUserAssetInfoMapper.selectByExample(example);
		return (list == null || list.size() == 0) ? null : list.get(0);
	}

}
