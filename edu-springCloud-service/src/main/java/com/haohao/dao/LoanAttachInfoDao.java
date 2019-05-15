package com.haohao.dao;

import java.util.List;

import com.haohao.modelAndExample.LoanAttachInfo;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午8:00:15
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
public interface LoanAttachInfoDao {
	
	public int insertSelective(LoanAttachInfo record);
	
	public List<LoanAttachInfo> findByOrderId(Integer orderId);

}
