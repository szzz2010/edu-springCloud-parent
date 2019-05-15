package com.haohao.dao;

import com.haohao.modelAndExample.RiskExtraInfo;

/**
 * <p>Description：用钱宝风控附加信息</p>
 * @date 2018年6月25日 下午3:05:21
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
public interface RiskExtraInfoDao {
	
	public int insertSelective(RiskExtraInfo riskExtraInfo);
	
	public RiskExtraInfo findByOrderId(Integer orderId);

}
