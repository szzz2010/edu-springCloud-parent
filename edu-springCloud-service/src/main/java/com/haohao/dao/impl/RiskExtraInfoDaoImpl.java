package com.haohao.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haohao.dao.RiskExtraInfoDao;
import com.haohao.mapper.auto.RiskExtraInfoMapper;
import com.haohao.modelAndExample.RiskExtraInfo;
import com.haohao.modelAndExample.RiskExtraInfoExample;

/**
 * <p>Description：用钱宝风控附加信息</p>
 * @date 2018年6月25日 下午3:06:27
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Repository
public class RiskExtraInfoDaoImpl implements RiskExtraInfoDao{
	@Autowired
	private RiskExtraInfoMapper riskExtraInfoMapper;

	@Override
	public int insertSelective(RiskExtraInfo riskExtraInfo) {
		return riskExtraInfoMapper.insertSelective(riskExtraInfo);
	}

	@Override
	public RiskExtraInfo findByOrderId(Integer orderId) {
		RiskExtraInfoExample example = new RiskExtraInfoExample();
		RiskExtraInfoExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(orderId);
		List<RiskExtraInfo> list = riskExtraInfoMapper.selectByExample(example);
		return (list == null || list.size() == 0) ? null : list.get(0);
	}

}
