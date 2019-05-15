package com.haohao.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.haohao.dao.LoanUserCreditInfoDao;
import com.haohao.modelAndExample.LoanUserCreditInfo;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午8:23:47
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Component
public class LoanUserCreditInfoModule {
	@Autowired
	private LoanUserCreditInfoDao loanUserCreditInfoDao;
	public int insertSelective(LoanUserCreditInfo record) {
		long now = System.currentTimeMillis()/1000;
		record.setCreateTime(now);
		record.setUpdateTime(now);
		return loanUserCreditInfoDao.insertSelective(record);
	}
	
	public LoanUserCreditInfo findByOrderId(Integer orderId){
		return loanUserCreditInfoDao.findByOrderId(orderId);
	}
}
