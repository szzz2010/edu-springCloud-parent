package com.haohao.controller.asset;

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
public class JieZhongAcceptController {

	@Autowired
	MysqlSpringJdbcDao mysqlSpringJcbcDao;
	
	private final static Logger log = LoggerFactory.getLogger(CommonRequestFromXsController.class);

	protected String cm = MapObjHelper.getCMF();
	
	@RequestMapping(value = "/jz/assetsCenter/commonRequest")
	@ResponseBody
	@PrintLog
	public Map<String, Object> commonRequest(HttpServletRequest request) {
		Map<String, Object> returnMap = new HashMap<>();
		Map<String, Object> parameters = RequestHelper.getParameters(request);
		String agency_code = (String) parameters.get("loan_agency_code");
		if(!"jiezhong".equals(agency_code)){
			returnMap.put("status", "9999");
			returnMap.put("msg", "机构不存在");
			return returnMap;
		}
		log.info("{}",parameters);
		try {
			boolean savePersonOrder = saveCompanyOrder(parameters);
			if(savePersonOrder){
				returnMap.put("status", "0000");
				returnMap.put("msg", "操作成功");
			}else{
				returnMap.put("status", "9999");
				returnMap.put("msg", "操作失败  ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnMap;
	}
	
	
	private boolean saveCompanyOrder(Map<String,Object> params){
		
		String loan_number = (String) params.get("loan_number");
		List<Map<String, Object>> personList = mysqlSpringJcbcDao.queryForList2("company", new Object[][]{{"loan_number",loan_number}});
		if(!ObjectUtils.isEmpty(personList)){
			log.info("记录已 经 存在 ，loan_number={}",loan_number);
			return true;
		}
		Map<String,Object> personOrder2 = MapObjHelper.transAndFlushMap(params, getPersonOrderTransNames());
		
		try {
			Number addSelectiveAndGetId = mysqlSpringJcbcDao.addSelectiveAndGetId("company", personOrder2);
			if(addSelectiveAndGetId.intValue()>0){
				log.info("保存 的  companyOrderId={}",addSelectiveAndGetId);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("{}",e);
			return false;
		}
		return true;
	}
	
	private List<Object[]> getPersonOrderTransNames(){
		List<Object[]> orderTransNames = new ArrayList<Object[]>();                                
		orderTransNames.add(new Object[]{"loan_number","loan_number","",""}); 
		orderTransNames.add(new Object[]{"loan_agency_code","loan_agency_code","",""}); 
		orderTransNames.add(new Object[]{"loan_agency_name","loan_agency_name","",""}); 
		orderTransNames.add(new Object[]{"loan_company_name","loan_company_name","",""}); 
		orderTransNames.add(new Object[]{"loan_company_id_card","loan_company_id_card","",""}); 
		orderTransNames.add(new Object[]{"loan_company_mobile","loan_company_mobile","",""}); 
		orderTransNames.add(new Object[]{"loan_consult_amt","loan_consult_amt",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"loan_apply_time","loan_apply_time",null,cm+TimeHelper.YYYY_MM_DD_HH_MM_SS}); 
		orderTransNames.add(new Object[]{"loan_contract_amt","loan_contract_amt",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"loan_amt","loan_amt",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"loan_product_type","loan_product_type",1,cm+"int"}); 
		orderTransNames.add(new Object[]{"loan_purpose","loan_purpose",1,cm+"int"}); 
		orderTransNames.add(new Object[]{"loan_interest_rate","loan_interest_rate",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"loan_year_interest_rate","loan_year_interest_rate",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"loan_give_quota","loan_give_quota",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"loan_terms","loan_terms",1,cm+"int"}); 
		
		orderTransNames.add(new Object[]{"loan_success_time","loan_success_time",null,cm+TimeHelper.YYYY_MM_DD_HH_MM_SS}); 
		orderTransNames.add(new Object[]{"loan_risk_amt","loan_risk_amt",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"loan_risk_level","loan_risk_level","A",""}); 
		orderTransNames.add(new Object[]{"loan_risk_advice","loan_risk_advice","A",""}); 
		orderTransNames.add(new Object[]{"repay_month_amount","repay_month_amount",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"repay_month_principal","repay_month_principal",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		
		orderTransNames.add(new Object[]{"repay_expiry_time","repay_expiry_time",null,cm+TimeHelper.YYYY_MM_DD_HH_MM_SS}); 
		orderTransNames.add(new Object[]{"repay_period","repay_period",0,cm+"int"}); 
		orderTransNames.add(new Object[]{"repay_is_settle","repay_is_settle",0,cm+"int"});
		//orderTransNames.add(new Object[]{"repay_first_date","repay_first_date",null,cm+TimeHelper.YYYY_MM_DD}); 
		orderTransNames.add(new Object[]{"repay_month_date","repay_month_date",0,cm+"int"}); 
		
		orderTransNames.add(new Object[]{"bank_num","bank_num","",""}); 
		orderTransNames.add(new Object[]{"bank_name","bank_name","",""}); 
		orderTransNames.add(new Object[]{"bank_card_no","bank_card_no","",""}); 
		orderTransNames.add(new Object[]{"bank_mobile","bank_mobile","",""}); 
		orderTransNames.add(new Object[]{"bank_province","bank_province","",""}); 
		orderTransNames.add(new Object[]{"bank_city","bank_city","",""}); 
		orderTransNames.add(new Object[]{"bank_branch_name","bank_branch_name","",""}); 
		
		orderTransNames.add(new Object[]{"legal_name","legal_name","",""}); 
		orderTransNames.add(new Object[]{"legal_id_card","legal_id_card","",""}); 
		orderTransNames.add(new Object[]{"legal_mobile","legal_mobile","",""}); 
		orderTransNames.add(new Object[]{"legal_card_face","legal_card_face","",""}); 
		orderTransNames.add(new Object[]{"legal_card_back","legal_card_back","",""}); 
		orderTransNames.add(new Object[]{"handle_name","handle_name","",""}); 
		orderTransNames.add(new Object[]{"handle_id_card","handle_id_card","",""}); 
		orderTransNames.add(new Object[]{"handle_mobile","handle_mobile","",""}); 
		orderTransNames.add(new Object[]{"handle_duty","handle_duty","",""}); 
		
		orderTransNames.add(new Object[]{"company_assure_id_card","company_assure_id_card","",""}); 
		orderTransNames.add(new Object[]{"company_assure_name","company_assure_name","",""}); 
		orderTransNames.add(new Object[]{"company_risk_rank","company_risk_rank","B",""}); 
		orderTransNames.add(new Object[]{"company_nature","company_nature",0,cm+"int"});
		orderTransNames.add(new Object[]{"company_refer_province","company_refer_province","",""}); 
		orderTransNames.add(new Object[]{"company_refer_city","company_refer_city","",""}); 
		orderTransNames.add(new Object[]{"company_place_province","company_place_province","",""}); 
		orderTransNames.add(new Object[]{"company_place_city","company_place_city","",""}); 
		orderTransNames.add(new Object[]{"company_address","company_address","",""}); 
		orderTransNames.add(new Object[]{"company_create_date","company_create_date",null,cm+TimeHelper.YYYY_MM_DD}); 
		orderTransNames.add(new Object[]{"company_industry","company_industry","",""}); 
		orderTransNames.add(new Object[]{"company_operate_status","company_operate_status","",""}); 
		orderTransNames.add(new Object[]{"company_year_income","company_year_income",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"company_debt_amount","company_debt_amount",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"company_operate_start_date","company_operate_start_date",null,cm+TimeHelper.YYYY_MM_DD}); 
		orderTransNames.add(new Object[]{"company_operate_end_date","company_operate_end_date",null,cm+TimeHelper.YYYY_MM_DD}); 
		orderTransNames.add(new Object[]{"company_register_amount","company_register_amount",new BigDecimal("0.00"),cm+"bigDecimal"}); 
		orderTransNames.add(new Object[]{"company_register_organ","company_register_organ","",""}); 
		orderTransNames.add(new Object[]{"company_operate_range","company_operate_range","",""}); 
		orderTransNames.add(new Object[]{"company_operate_finance_state","company_operate_finance_state","",""}); 
		orderTransNames.add(new Object[]{"company_repay_ability_change","company_repay_ability_change","",""}); 
		orderTransNames.add(new Object[]{"company_overdue_status","company_overdue_status",0,cm+"int"});
		orderTransNames.add(new Object[]{"company_is_involve","company_is_involve",0,cm+"int"});
		orderTransNames.add(new Object[]{"company_is_administrative_penalty","company_is_administrative_penalty",0,cm+"int"});
		
		orderTransNames.add(new Object[]{"file_is_upload_corporation_card","file_is_upload_corporation_card",1,cm+"int"});
		orderTransNames.add(new Object[]{"file_is_upload_finance_statement","file_is_upload_finance_statement",1,cm+"int"});
		orderTransNames.add(new Object[]{"file_is_upload_guarantee_letter","file_is_upload_guarantee_letter",1,cm+"int"});
		orderTransNames.add(new Object[]{"file_is_upload_credit_report","file_is_upload_credit_report",1,cm+"int"});
		orderTransNames.add(new Object[]{"file_finance_attach","file_finance_attach","",""}); 
		orderTransNames.add(new Object[]{"file_guarantee_attach","file_guarantee_attach","",""}); 
		orderTransNames.add(new Object[]{"file_credit_attach","file_credit_attach","",""}); 
		
		orderTransNames.add(new Object[]{"create_time","create_time",null,cm+TimeHelper.YYYY_MM_DD_HH_MM_SS}); 
		
		return orderTransNames;
	}
	
	
	
}
