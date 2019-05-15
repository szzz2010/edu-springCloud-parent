package com.haohao.dao;

import com.haohao.modelAndExample.LoanUserAssetInfo;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午8:17:19
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
public interface LoanUserAssetInfoDao {
	
	public int insertSelective(LoanUserAssetInfo record);
	
	public LoanUserAssetInfo findByOrderId(Integer orderId);

}
