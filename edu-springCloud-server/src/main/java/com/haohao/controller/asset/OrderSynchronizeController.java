package com.haohao.controller.asset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.haohao.util.springTools.springJdbc.MysqlSpringJdbcDao;
import com.haohao.util.springTools.springJdbc.helper.MapObjHelper;
import com.haohao.util.springTools.springJdbc.helper.RequestHelper;
import com.haohao.util.springTools.springJdbc.helper.HttpServletLogAspect.PrintLog;

@Controller
public class OrderSynchronizeController {

	@Autowired
	MysqlSpringJdbcDao mysqlSpringJcbcDao;
	
	private final static Logger log = LoggerFactory.getLogger(CommonRequestFromXsController.class);

	protected String cm = MapObjHelper.getCMF();
	
	@RequestMapping(value = "/api/assetsCenter/orderSynchronize")
	@ResponseBody
	@PrintLog
	public Map<String, Object> orderSynchronize(HttpServletRequest request) {
		Map<String, Object> returnMap = new HashMap<>();
		Map<String, Object> parameters = RequestHelper.getParameters(request);
		log.info("{}",parameters);
		String agency_code = (String) parameters.get("agencyCode");
		if("haohao".equals(agency_code)){
			returnMap.put("status", "0000");
			returnMap.put("msg", "操作成功");
			returnMap.put("data", validatePersonOrder(parameters));
		}else{
			returnMap.put("status", "9999");
			returnMap.put("msg", "不支持的机构编码");
		}
		return returnMap;
	}
	
	@SuppressWarnings("unchecked")
	private Map<String,Object> validatePersonOrder(Map<String,Object>parameters){
		String dataJson = (String) parameters.get("dataJson");
		Map<String,Object> dataMap = JSON.parseObject(dataJson, Map.class);
		log.info("同步订单接收size={}条,dataMap={}",dataMap.keySet().size(),dataMap);
		if(!ObjectUtils.isEmpty(dataMap)){
			Set<String> keySet = dataMap.keySet();
			String whereClause = "('"+StringUtils.join(keySet, "','")+"')";
			String sql = " select loan_number from person where loan_number in "+whereClause;
			log.info("打印同步订单sql=[{}]",sql);
			List<Map<String, Object>> queryForList = mysqlSpringJcbcDao.queryForList(sql);
			if(!ObjectUtils.isEmpty(queryForList)){
				for(Map<String,Object> map: queryForList){
					String loan_number = (String) map.get("loan_number") ;
					log.info("存在相同元素，需要移除的loan_number={}",loan_number);
					dataMap.remove(loan_number);
				}
			}
		}
		log.info("同步订单返回size={}条,dataMap={}",dataMap.keySet().size(),dataMap);
		return dataMap;
	}
	
	
	
}
