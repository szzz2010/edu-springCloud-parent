package com.haohao.dao;

import com.haohao.modelAndExample.LoanUserEntityInfo;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午8:12:06
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
public interface LoanUserEntityInfoDao {
	
	public int insertSelective(LoanUserEntityInfo record);
	
	public LoanUserEntityInfo findByOrderId(Integer orderId);

}
