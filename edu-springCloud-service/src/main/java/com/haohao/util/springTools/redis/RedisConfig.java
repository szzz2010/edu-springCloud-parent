package com.haohao.util.springTools.redis;
/**
 * <p>Description：redis key管理</p>
 * @date 2018年5月10日 下午5:44:03
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
public class RedisConfig {
	
	/**三方几个配置*/
	public static final String KEY_AGENCY_PREFIX = "asset_agency_";//后面接source
	
	public static final String KEY_AGENCY_ORDER_RISK_LIST = "asset_agency_order_risk_list";//list 存放order_id,过风控的list

	public static final String KEY_ORDER_ENTRY_LIST = "asset_order_entry_list";//list 存放需要给学习进件的order_id
	
	public static final String KEY_LOAN_RESULT_SEARCH_LIST = "asset_loan_result_search_list";//list 存放需要查询进件结果的order_id
	
	public static final String KEY_LOAN_AUDIT_SEARCH_LIST = "asset_loan_audit_search_list";//list 存放需要查询审批结果的order_id

	public static final String KEY_LOAN_ORDER_ENTRY_RESULT_LIST = "asset_loan_order_entry_result_list";//list 存放需要给三方进件结果通知的order_id
	
	public static final String KEY_LOAN_LOAN_SEARCH_LIST = "asset_loan_loan_search_list";//list 存放需要查询放款结果的order_id
	
	public static final String KEY_LOAN_RESULT_TO_RISK_LIST = "asset_loan_result_to_risk_list";//list 查询到放款结果通知风控order_id

}
