package com.haohao.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.haohao.dao.LoanUserInfoDao;
import com.haohao.modelAndExample.LoanUserInfo;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午6:21:15
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Component
public class LoanUserInfoModule {
	@Autowired
	private LoanUserInfoDao loanUserInfoDao;
	
	public int insertSelective(LoanUserInfo record) {
		long now = System.currentTimeMillis()/1000;
		record.setCreateTime(now);
		record.setUpdateTime(now);
		return loanUserInfoDao.insertSelective(record);
	}
	
	public LoanUserInfo findByOrderId(Integer orderId){
		return loanUserInfoDao.findByOrderId(orderId);
	}
}
