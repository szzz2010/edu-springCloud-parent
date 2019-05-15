package com.haohao.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.haohao.dao.LoanUserEntityInfoDao;
import com.haohao.modelAndExample.LoanUserEntityInfo;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午8:13:42
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Component
public class LoanUserEntityInfoModule {
	@Autowired
	private LoanUserEntityInfoDao loanUserEntityInfoDao;
	
	public int insertSelective(LoanUserEntityInfo record) {
		long now = System.currentTimeMillis()/1000;
		record.setCreateTime(now);
		record.setUpdateTime(now);
		return loanUserEntityInfoDao.insertSelective(record);
	}
	
	public LoanUserEntityInfo findByOrderId(Integer orderId){
		return loanUserEntityInfoDao.findByOrderId(orderId);
	}

}
