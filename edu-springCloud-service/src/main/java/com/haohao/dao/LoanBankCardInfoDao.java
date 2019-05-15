package com.haohao.dao;

import com.haohao.modelAndExample.LoanBankCardInfo;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午7:53:24
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
public interface LoanBankCardInfoDao {
	
	public int insertSelective(LoanBankCardInfo record);
	
	public LoanBankCardInfo findByOrderId(Integer orderId);

}
