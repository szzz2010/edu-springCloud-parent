package com.haohao.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.haohao.dao.LoanUserJobInfoDao;
import com.haohao.modelAndExample.LoanUserJobInfo;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午8:08:48
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Component
public class LoanUserJobInfoModule {
	@Autowired
	private LoanUserJobInfoDao loanUserJobInfoDao;
	public int insertSelective(LoanUserJobInfo record) {
		long now = System.currentTimeMillis()/1000;
		record.setCreateTime(now);
		record.setUpdateTime(now);
		return loanUserJobInfoDao.insertSelective(record);
	}
	
	public LoanUserJobInfo findByOrderId(Integer orderId) {
		return loanUserJobInfoDao.findByOrderId(orderId);
	}

}
