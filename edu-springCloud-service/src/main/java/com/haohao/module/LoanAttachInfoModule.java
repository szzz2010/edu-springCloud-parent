package com.haohao.module;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.haohao.dao.LoanAttachInfoDao;
import com.haohao.modelAndExample.LoanAttachInfo;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午8:01:56
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Component
public class LoanAttachInfoModule {
	@Autowired
	private LoanAttachInfoDao loanAttachInfoDao;
	
	public int insertSelective(LoanAttachInfo record) {
		long now = System.currentTimeMillis()/1000;
		record.setCreateTime(now);
		record.setUpdateTime(now);
		return loanAttachInfoDao.insertSelective(record);
	}
	
	public List<LoanAttachInfo> findByOrderId(Integer orderId){
		return loanAttachInfoDao.findByOrderId(orderId);
	}
}
