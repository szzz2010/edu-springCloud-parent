package com.haohao.module;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.github.pagehelper.PageInfo;
import com.haohao.util.springTools.springJdbc.MysqlSpringJdbcDao;
import com.haohao.util.springTools.springJdbc.helper.MapObjHelper;
import com.haohao.util.springTools.springJdbc.helper.MessageHelper;
import com.haohao.util.springTools.springJdbc.helper.SqlHelper;
import com.haohao.util.springTools.springJdbc.helper.TimeHelper;

@Component
public class BigOrderModule {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	MysqlSpringJdbcDao mysqlSpringJdbcDao;

	public PageInfo<Map<String, Object>> getCompanyOrderList(Map<String, Object> params) {
		Integer pageIndex = Integer.parseInt(String.valueOf(params.get("page")));
		Integer pageSize = Integer.parseInt(String.valueOf(params.get("limit")));
		Map<String, Object> wheres = new HashMap<>();
		String clause = "  ";
		if (!ObjectUtils.isEmpty(params.get("id"))) {
			wheres.put("id", params.get("id"));
		}
		if (!ObjectUtils.isEmpty(params.get("loan_number"))) {
			wheres.put("loan_number", params.get("loan_number"));
		}

		if (!ObjectUtils.isEmpty(params.get("loan_agency_code"))) {
			wheres.put("loan_agency_code", params.get("loan_agency_code"));
		}
		
		if (!ObjectUtils.isEmpty(params.get("loan_apply_time"))) {
			String timeRange = (String) params.get("loan_apply_time");
			String[] split = StringUtils.split(timeRange, " ~ ");
			String t1 = split[0];
			String t2 = split[1];
			clause += MessageHelper.format(" and loan_apply_time between '{}' and '{}'  ", t1,t2);
		}
		String sql = SqlHelper.getParamSql2("company", MapObjHelper.transMapToObjectArray(wheres))+clause;
		String limitSql = SqlHelper.getLimitSql(sql + " order by loan_apply_time desc ", pageIndex, pageSize);
		String countSql = SqlHelper.getCountSql(sql);
		List<Map<String, Object>> listData = mysqlSpringJdbcDao.queryForList(limitSql);
		log.info(listData.toString());
		if (!ObjectUtils.isEmpty(listData)) {
			for (Map<String, Object> data : listData) {
				Date loan_apply_time = (Date) data.get("loan_apply_time");
				String aa2 = TimeHelper.transTimeByFormat(loan_apply_time, TimeHelper.YYYY_MM_DD_HH_MM_SS);
				data.put("loan_apply_time", aa2);
			}
		}

		Integer count = (Integer) mysqlSpringJdbcDao.queryForObject(countSql, Integer.class);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>();
		page.setList(listData);
		page.setTotal(count);
		return page;
	}

	public Map<String, Object> getCormpanyOrderInfoById(int id) {
		Map<String, Object> data = mysqlSpringJdbcDao.queryForMap2("company", new Object[][] { { "id", id } });
		Date loan_success_time = (Date) data.get("loan_success_time");
		Date loan_apply_time = (Date) data.get("loan_apply_time");
		String aa = TimeHelper.transTimeByFormat(loan_success_time, TimeHelper.YYYY_MM_DD_HH_MM_SS);
		String aa2 = TimeHelper.transTimeByFormat(loan_apply_time, TimeHelper.YYYY_MM_DD_HH_MM_SS);
		data.put("loan_success_time", aa);
		data.put("loan_apply_time", aa2);
		data.put("loan_number_attach", data.get("loan_number") + ".zip");
		return data;
	}

	//-----------以下是个人业务------------------
	
	public PageInfo<Map<String, Object>> getPersonOrderList(Map<String, Object> params) {
		Integer pageIndex = Integer.parseInt(String.valueOf(params.get("page")));
		Integer pageSize = Integer.parseInt(String.valueOf(params.get("limit")));
		Map<String, Object> wheres = new HashMap<>();
		String clause = "  ";
		if (!ObjectUtils.isEmpty(params.get("id"))) {
			wheres.put("id", params.get("id"));
		}
		if (!ObjectUtils.isEmpty(params.get("loan_number"))) {
			wheres.put("loan_number", params.get("loan_number"));
		}

		if (!ObjectUtils.isEmpty(params.get("loan_agency_code"))) {
			wheres.put("loan_agency_code", params.get("loan_agency_code"));
		}
		
		if (!ObjectUtils.isEmpty(params.get("loan_apply_time"))) {
			String timeRange = (String) params.get("loan_apply_time");
			String[] split = StringUtils.split(timeRange, " ~ ");
			String t1 = split[0];
			String t2 = split[1];
			clause += MessageHelper.format(" and loan_apply_time between '{}' and '{}'  ", t1,t2);
		}
		//按入库id倒序排列
//		String sql = SqlHelper.getParamSql2("person", MapObjHelper.transMapToObjectArray(wheres))+clause;
		String sql = SqlHelper.getSqlByListFieldsAndWhere("person","id,loan_number,loan_user_name,loan_user_id_card,loan_user_mobile,loan_contract_amt,loan_apply_time,loan_success_time,loan_agency_name", MapObjHelper.transMapToObjectArray(wheres))+clause;
		String limitSql = SqlHelper.getLimitSql(sql + " order by loan_apply_time desc ", pageIndex, pageSize);
		log.info("limitSql_person_list_sql==>"+limitSql);
		String countSql = SqlHelper.getCountSql(sql);
		List<Map<String, Object>> listData = mysqlSpringJdbcDao.queryForList(limitSql);
		if (!ObjectUtils.isEmpty(listData)) {
			for (Map<String, Object> data : listData) {
				Date loan_apply_time = (Date) data.get("loan_apply_time");
				String aa2 = TimeHelper.transTimeByFormat(loan_apply_time, TimeHelper.YYYY_MM_DD_HH_MM_SS);
				data.put("loan_apply_time", aa2);
			}
		}
		Integer count = (Integer) mysqlSpringJdbcDao.queryForObject(countSql, Integer.class);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>();
		page.setList(listData);
		page.setTotal(count);
		return page;
	}

	public Map<String, Object> getPersonOrderInfoById(int id) {
		Map<String, Object> data = mysqlSpringJdbcDao.queryForMap2("person", new Object[][] { { "id", id } });
		Date loan_success_time = (Date) data.get("loan_success_time");
		Date loan_apply_time = (Date) data.get("loan_apply_time");
		String aa = TimeHelper.transTimeByFormat(loan_success_time, TimeHelper.YYYY_MM_DD_HH_MM_SS);
		String aa2 = TimeHelper.transTimeByFormat(loan_apply_time, TimeHelper.YYYY_MM_DD_HH_MM_SS);
		data.put("loan_success_time", aa);
		data.put("loan_apply_time", aa2);
		if(("jieyue").equals(data.get("loan_agency_code"))){
			data.put("loan_number_attach", data.get("loan_number") + "_ok.zip");//捷越是_ok.zip
		}else{
			data.put("loan_number_attach", data.get("loan_number") + ".zip");
		}
		return data;
	}

	
	
	
	
	
}
