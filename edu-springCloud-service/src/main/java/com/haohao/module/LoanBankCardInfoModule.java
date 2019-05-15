package com.haohao.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.haohao.dao.LoanBankCardInfoDao;
import com.haohao.modelAndExample.LoanBankCardInfo;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午7:55:35
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Component
public class LoanBankCardInfoModule {
	@Autowired
	private LoanBankCardInfoDao loanBankCardInfoDao;
	
	public int insertSelective(LoanBankCardInfo record) {
		long now = System.currentTimeMillis()/1000;
		record.setCreateTime(now);
		record.setUpdateTime(now);
		return loanBankCardInfoDao.insertSelective(record);
	}
	
	public LoanBankCardInfo findByOrderId(Integer orderId) {
		return loanBankCardInfoDao.findByOrderId(orderId);
	}

}
