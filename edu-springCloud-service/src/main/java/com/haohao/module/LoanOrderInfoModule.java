package com.haohao.module;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.haohao.dao.LoanOrderInfoDao;
import com.haohao.modelAndExample.LoanOrderInfo;
import com.haohao.util.paramAndDto.LoanOrderInfoParam;
import com.haohao.util.springTools.redis.RedisClientTemplate;
import com.haohao.util.springTools.redis.RedisConfig;

/**
 * <p>Description：</p>
 * @date 2018年5月16日 下午6:13:06
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Component
public class LoanOrderInfoModule {
	@Autowired
	private LoanOrderInfoDao loanOrderInfoDao;
	@Autowired
	private RedisClientTemplate redis;
	
	public int insertSelective(LoanOrderInfo record){
		long now = System.currentTimeMillis()/1000;
		record.setCreateTime(now);
		record.setUpdateTime(now);
		return loanOrderInfoDao.insertSelective(record);
	}
	
	public LoanOrderInfo find(String loanNumber, Integer enable,String source){
		return loanOrderInfoDao.find(loanNumber, enable,source);
	}
	
	public LoanOrderInfo selectByPrimaryKey(Integer orderId){
		return loanOrderInfoDao.selectByPrimaryKey(orderId);
	}
	
	public int updateByPrimaryKeySelective(LoanOrderInfo record) {
		return loanOrderInfoDao.updateByPrimaryKeySelective(record);
	}

	/**
	 * <p>Description：学习进件结果修改</p>
	 * @date 2018年5月18日 下午1:54:39
	 * @author zhangqiang
	 * @param orderId
	 * @param xsEntryStatus 目标状态
	 * @param status 学习给的状态是否进件成功
	 * @return
	 */
	public int handleEntryResult(Integer orderId,boolean status){
		Integer xsEntryStatus = status ? 2 :3;
		int count = loanOrderInfoDao.handleEntryResult(orderId, xsEntryStatus);
		if(count > 0){
			if(status){//成功
				redis.lpush(RedisConfig.KEY_LOAN_AUDIT_SEARCH_LIST, orderId + "");
			}else{
				redis.lpush(RedisConfig.KEY_LOAN_ORDER_ENTRY_RESULT_LIST, orderId + "");
			}
		}
		return count;
	}
	
	/**
	 * <p>Description：学习审批结果修改</p>
	 * @date 2018年5月18日 下午1:58:33
	 * @author zhangqiang
	 * @param orderId 
	 * @param result 学习审批成功与否
	 * @return
	 */
	public int handleAuditResult(Integer orderId, boolean result){
		Integer xsEntryStatus = result ? 4 :5;
		int count = loanOrderInfoDao.handleAuditResult(orderId, xsEntryStatus);
		if(count > 0){
			if(result){//成功
				redis.lpush(RedisConfig.KEY_LOAN_LOAN_SEARCH_LIST, orderId + "");
			}
			redis.lpush(RedisConfig.KEY_LOAN_ORDER_ENTRY_RESULT_LIST, orderId + "");
		}
		return loanOrderInfoDao.handleAuditResult(orderId, xsEntryStatus);
	}
	
	public int handleRiskResult(Integer orderId,Integer riskStatus,String riskLevel){
		return loanOrderInfoDao.handleRiskResult(orderId, riskStatus, riskLevel);
	}
	
	public int handleXsPayStatus(Integer orderId,Integer xsPayStatus,Long payTime){
		return loanOrderInfoDao.handleXsPayStatus(orderId, xsPayStatus, payTime);
	}
	/**
	 * 
	 * @descript <p> 根据条件 分页获取订单信息 </p>
	 * @author wanglicheng
	 * @date 2018年5月22日
	 * @param param
	 * @return
	 */
	public List<LoanOrderInfo> selectByOrderParam(LoanOrderInfoParam param){
		
		return loanOrderInfoDao.selectByOrderParam(param);
	}
}
