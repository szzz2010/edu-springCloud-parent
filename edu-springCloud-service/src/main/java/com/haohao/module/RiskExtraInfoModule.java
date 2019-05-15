package com.haohao.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.haohao.dao.RiskExtraInfoDao;
import com.haohao.modelAndExample.RiskExtraInfo;

/**
 * <p>Description：</p>
 * @date 2018年6月25日 下午3:08:33
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Component
public class RiskExtraInfoModule {
	@Autowired
	private RiskExtraInfoDao riskExtraInfoDao;
	
	public int insertSelective(RiskExtraInfo record){
		long now = System.currentTimeMillis()/1000;
		record.setCreateTime(now);
		record.setUpdateTime(now);
		return riskExtraInfoDao.insertSelective(record);
	}
	
	public RiskExtraInfo findByOrderId(Integer orderId) {
		return riskExtraInfoDao.findByOrderId(orderId);
	}

}
