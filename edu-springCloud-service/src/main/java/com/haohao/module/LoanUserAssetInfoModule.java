package com.haohao.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.haohao.dao.LoanUserAssetInfoDao;
import com.haohao.modelAndExample.LoanUserAssetInfo;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午8:19:11
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Component
public class LoanUserAssetInfoModule {
	@Autowired
	private LoanUserAssetInfoDao loanUserAssetInfoDao;
	
	public int insertSelective(LoanUserAssetInfo record) {
		long now = System.currentTimeMillis()/1000;
		record.setCreateTime(now);
		record.setUpdateTime(now);
		return loanUserAssetInfoDao.insertSelective(record);
	}
	
	public LoanUserAssetInfo findByOrderId(Integer orderId) {
		return loanUserAssetInfoDao.findByOrderId(orderId);
	}

}
