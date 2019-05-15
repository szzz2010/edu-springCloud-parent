package com.haohao.dao;

import com.haohao.modelAndExample.LoanUserInfo;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午6:17:00
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
public interface LoanUserInfoDao {
	
	public int insertSelective(LoanUserInfo record);
	
	public LoanUserInfo findByOrderId(Integer orderId);

}
