package com.haohao.dao;

import com.haohao.modelAndExample.LoanUserJobInfo;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午8:06:57
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
public interface LoanUserJobInfoDao {
	public int insertSelective(LoanUserJobInfo record);
	
	public LoanUserJobInfo findByOrderId(Integer orderId);

}
