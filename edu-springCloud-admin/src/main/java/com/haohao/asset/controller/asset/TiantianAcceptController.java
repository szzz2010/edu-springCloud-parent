package com.haohao.asset.controller.asset;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haohao.util.springTools.springJdbc.MysqlSpringJdbcDao;
import com.haohao.util.springTools.springJdbc.helper.MapObjHelper;
import com.haohao.util.springTools.springJdbc.helper.RequestHelper;
import com.haohao.util.springTools.springJdbc.helper.TimeHelper;
import com.haohao.util.springTools.springJdbc.helper.HttpServletLogAspect.PrintLog;

@Controller
public class TiantianAcceptController {

	@Autowired
	MysqlSpringJdbcDao mysqlSpringJcbcDao;
	
	private final static Logger log = LoggerFactory.getLogger(TiantianAcceptController.class);

	protected String cm = MapObjHelper.getCMF();
	
	@RequestMapping(value = "/api/assetsCenter/commonRequest")
	@ResponseBody
	@PrintLog
	public Map<String, Object> commonRequest(HttpServletRequest request) {
		Map<String, Object> returnMap = new HashMap<>();
		Map<String, Object> parameters = RequestHelper.getParameters(request);
		String agency_code = (String) parameters.get("loan_agency_code");
		if(!"haohao".equals(agency_code)){
			returnMap.put("status", "9999");
			returnMap.put("msg", "机构不存在");
			return returnMap;
		}
		log.info("{}",parameters);
		try {
			boolean savePersonOrder = savePersonOrder(parameters);
			if(savePersonOrder){
				returnMap.put("status", "0000");
				returnMap.put("msg", "操作成功");
			}else{
				returnMap.put("status", "9999");
				returnMap.put("msg", "操作失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnMap;
	}
	
	
	private boolean savePersonOrder(Map<String,Object> params){
		String loan_number = (String) params.get("loan_number");
		List<Map<String, Object>> personList = mysqlSpringJcbcDao.queryForList2("person", new Object[][]{{"loan_number",loan_number}});
		if(!ObjectUtils.isEmpty(personList)){
			log.info("记录已经存在，loan_number={}",loan_number);
			return true;
		}
		Map<String,Object> personOrder2 = MapObjHelper.transAndFlushMap(params, getPersonOrderTransNames());
		try {
			Number addSelectiveAndGetId = mysqlSpringJcbcDao.addSelectiveAndGetId("person", personOrder2);
			if(addSelectiveAndGetId.intValue()>0){
				log.info("保存的 personOrderId={}",addSelectiveAndGetId);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("{} ",e);
			return false;
		}
		return true;
	}
	
	private List<Object[]> getPersonOrderTransNames(){
		List<Object[]> orderTransNames = new ArrayList<Object[]>();                                
		orderTransNames.add(new Object[]{"loan_number","loan_number","",""}); 
		orderTransNames.add(new Object[]{"loan_agency_code","loan_agency_code","",""}); 
		orderTransNames.add(new Object[]{"loan_agency_name","loan_agency_name","",""}); 
		orderTransNames.add(new Object[]{"loan_agency_id","loan_agency_id","",""}); 
		orderTransNames.add(new Object[]{"loan_user_name","loan_user_name","",""}); 
		orderTransNames.add(new Object[]{"loan_user_id_card","loan_user_id_card","",""}); 
		orderTransNames.add(new Object[]{"loan_user_mobile","loan_user_mobile","",""}); 
		orderTransNames.add(new Object[]{"loan_consult_amt","loan_consult_amt",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"loan_apply_time","loan_apply_time",null,cm+TimeHelper.YYYY_MM_DD_HH_MM_SS}); 
		orderTransNames.add(new Object[]{"loan_contract_amt","loan_contract_amt",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"loan_amt","loan_amt",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"loan_product_type","loan_product_type",1,cm+"int"}); 
		orderTransNames.add(new Object[]{"loan_purpose","loan_purpose",1,cm+"int"}); 
		orderTransNames.add(new Object[]{"loan_interest_rate","loan_interest_rate","",""}); 
		orderTransNames.add(new Object[]{"loan_year_interest_rate","loan_year_interest_rate","",""}); 
		orderTransNames.add(new Object[]{"loan_give_quota","loan_give_quota",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"loan_terms","loan_terms",6,cm+"int"}); 
		orderTransNames.add(new Object[]{"loan_success_time","loan_success_time",null,cm+TimeHelper.YYYY_MM_DD_HH_MM_SS}); 
		orderTransNames.add(new Object[]{"loan_risk_amt","loan_risk_amt",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"loan_risk_level","loan_risk_level","A",""}); 
		orderTransNames.add(new Object[]{"loan_risk_advice","loan_risk_advice","A",""}); 
		orderTransNames.add(new Object[]{"repay_month_amount","repay_month_amount",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"repay_month_principal","repay_month_principal",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"repay_expiry_time","repay_expiry_time",null,cm+TimeHelper.YYYY_MM_DD_HH_MM_SS}); 
		orderTransNames.add(new Object[]{"repay_period","repay_period",0,cm+"int"}); 
		orderTransNames.add(new Object[]{"repay_is_settle","repay_is_settle",0,cm+"int"});
		
		orderTransNames.add(new Object[]{"repay_first_date","repay_first_date",null,cm+TimeHelper.YYYY_MM_DD}); 
		orderTransNames.add(new Object[]{"repay_month_date","repay_month_date",0,cm+"int"}); 
		
		
		orderTransNames.add(new Object[]{"bank_num","bank_num","",""}); 
		orderTransNames.add(new Object[]{"bank_name","bank_name","",""}); 
		orderTransNames.add(new Object[]{"bank_card_no","bank_card_no","",""}); 
		orderTransNames.add(new Object[]{"bank_mobile","bank_mobile","",""}); 
		orderTransNames.add(new Object[]{"bank_province","bank_province","",""}); 
		orderTransNames.add(new Object[]{"bank_city","bank_city","",""}); 
		orderTransNames.add(new Object[]{"bank_branch_name","bank_branch_name","",""}); 
		orderTransNames.add(new Object[]{"person_age","person_age",0,cm+"int"}); 
		orderTransNames.add(new Object[]{"person_birth_date","person_birth_date",null,cm+TimeHelper.YYYY_MM_DD}); 
		orderTransNames.add(new Object[]{"person_gender","person_gender",0,cm+"int"}); 
		orderTransNames.add(new Object[]{"person_education","person_education",0,cm+"int"}); 
		orderTransNames.add(new Object[]{"person_marriage","person_marriage",0,cm+"int"}); 
		orderTransNames.add(new Object[]{"person_local_addr","person_local_addr","",""}); 
		orderTransNames.add(new Object[]{"job_company_name","job_company_name","",""}); 
		orderTransNames.add(new Object[]{"job_company_property","job_company_property",0,cm+"int"}); 
		orderTransNames.add(new Object[]{"job_compnay_detail_addr","job_compnay_detail_addr","",""}); 
		orderTransNames.add(new Object[]{"job_profession","job_profession","",""}); 
		orderTransNames.add(new Object[]{"job_monthly_income","job_monthly_income",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		
		orderTransNames.add(new Object[]{"person_relation_first","person_relation_first",0,cm+"int"}); 
		orderTransNames.add(new Object[]{"person_relation_first_name","person_relation_first_name","",""}); 
		orderTransNames.add(new Object[]{"person_relation_first_mobile","person_relation_first_mobile","",""}); 
		orderTransNames.add(new Object[]{"person_relation_second","person_relation_second",0,cm+"int"}); 
		orderTransNames.add(new Object[]{"person_relation_second_name","person_relation_second_name","",""}); 
		orderTransNames.add(new Object[]{"person_relation_second_mobile","person_relation_second_mobile","",""}); 
	
		orderTransNames.add(new Object[]{"create_time","create_time",null,cm+TimeHelper.YYYY_MM_DD_HH_MM_SS}); 
		
		
		return orderTransNames;
	}
	
	
	
}
