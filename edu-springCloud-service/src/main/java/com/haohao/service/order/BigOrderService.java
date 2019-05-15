package com.haohao.service.order;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.haohao.module.BigOrderModule;

@Service
public class BigOrderService {

	@Autowired
	BigOrderModule bigOrderModule;
	
	public PageInfo<Map<String, Object>> getCompanyOrderList(Map<String,Object>params){
		return bigOrderModule.getCompanyOrderList(params);
	}
	
	public Map<String,Object> getCompanyOrderInfoById(int id){
		return bigOrderModule.getCormpanyOrderInfoById(id);
	}
	
	public PageInfo<Map<String, Object>> getPersonOrderList(Map<String,Object>params){
		return bigOrderModule.getPersonOrderList(params);
	}
	
	public Map<String,Object> getPersonOrderInfoById(int id){
		return bigOrderModule.getPersonOrderInfoById(id);
	}
	
}
