package com.haohao.service.xs.impl_v1;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haohao.constant.OrderStatusEnums;
import com.haohao.util.springTools.springJdbc.MysqlSpringJdbcDao;
@Service
public class XsService_v1 {

	@Autowired
	protected MysqlSpringJdbcDao mysqlSpringJdbcDao;
	
	public Map<String,Object> getCompanyById(int company_id){
		return mysqlSpringJdbcDao.queryForMap(" select * from jz_ac_company_order where id = ? ", company_id);
	}
	
	public Map<String,Object> getBankAccountByCompanyIdAndIdCard(int company_id,String id_card){
		return mysqlSpringJdbcDao.queryForMap(" select * from jz_ac_xs_company_bank_account where company_id = ? and id_card = ? ", company_id, id_card);
	}
	
	public Map<String,Object> getNewestBankAccountByCompanyId(int company_id){
		return mysqlSpringJdbcDao.queryForMap(" select * from jz_ac_xs_company_bank_account where company_id = ? order by id desc limit 1 ", company_id);
	}
	
	public Map<String,Object> getNewestCompanyMobileCodeByCompanyIdAndMobile(int company_id,String mobile){
		return mysqlSpringJdbcDao.queryForMap(" select * from jz_ac_xs_company_mobile_code where company_id = ? and mobile = ? order by id desc limit 1 ", company_id,mobile);
	}
	
	public List<Map<String,Object>> getNeedDeployOrders(){
		return mysqlSpringJdbcDao.queryForList(" select * from jz_ac_company_order where status = ? and del_flg = 0 order by id asc ", OrderStatusEnums.CONFIRM_LOAN.name());
	}
	
	public Map<String,Object> getAbleNewestBankCardByCompanyId(int company_id){
		return mysqlSpringJdbcDao.queryForMap(" select * from jz_ac_xs_company_bank_card where company_id = ? and card_status = 1 and is_temp = 0 and del_flg = 0  order by create_time desc limit 1 ", company_id);
	}
	
	public Map<String,Object> getOrderByOrderNo(String order_no){
		return mysqlSpringJdbcDao.queryForMap(" select * from jz_ac_company_order where order_no = ? ", order_no);
	}
	
	public Map<String,Object> getNewestBatchOrderByDeployStatusAndOrderNo(int deploy_status,String order_no){
		return mysqlSpringJdbcDao.queryForMap(" select * from jz_ac_xs_batch_order where order_no = ? and deploy_status = ? order by id desc limit 1 ", order_no ,deploy_status);
	}
	
	public List<Map<String, Object>> getBatchOrdersByDeployStatus(int deploy_status){
		 return mysqlSpringJdbcDao.queryForList(" select * from jz_ac_xs_batch_order where deploy_status = ? order by id asc limit 10  " , deploy_status);
	}
	
}
