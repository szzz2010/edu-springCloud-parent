package com.haohao.dao;

import com.haohao.modelAndExample.LoanUserCreditInfo;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午8:22:16
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
public interface LoanUserCreditInfoDao {
	
	public int insertSelective(LoanUserCreditInfo record);
	
	public LoanUserCreditInfo findByOrderId(Integer orderId);

}
