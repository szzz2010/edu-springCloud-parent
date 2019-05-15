package com.haohao.util.springTools.springJdbc.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.util.ObjectUtils;

import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.SQLUtils.FormatOption;
/**
 * powered by denshinyou
 */
public class SqlHelper {

	protected static enum DB {
		mysql, oracle, postgresql, sqlserver, db2, odps;
	}

	public static final String dbType = DB.mysql.name();

	public static String getParamSql(String sql, Object... args) {
		return SQLUtils.format(sql, dbType, Arrays.asList(args), new FormatOption(true));
	}
	
	public static String getCountSql(String sql) {
		return PagerUtils.count(sql, dbType);
	}

	public static String getLimitSql(String sql, int pageIndex, int pageSize) {
		return PagerUtils.limit(sql, dbType, (pageIndex - 1) * pageSize, pageSize);
	}

	public static String getLimitClause(int pageIndex, int pageSize) {
		return MessageHelper.format(" limit {},{} ", (pageIndex - 1) * pageSize, pageSize);
	}

	public static String getParamSql2(String tableName, Object[]... wheres) {
		StringBuilder sql = new StringBuilder(" select * from " + tableName + "  WHERE 1=1 ");
		List<Object> list = new ArrayList<Object>();
		if (!ObjectUtils.isEmpty(wheres)) {
			for (Object[]kv:wheres) {
				if(ObjectUtils.isEmpty(kv)){
					continue;
				}
				sql.append(" and `"+kv[0]+ "`=?  ");
				list.add(kv[1]);
			}
		}
		return getParamSql(sql.toString(), list.toArray());
	}
	
	public static String getSqlByListFieldsAndWhere(String tableName,String fields, Object[]... wheres) {
		StringBuilder sql = new StringBuilder(" select "+ fields +" from " + tableName + "  WHERE 1=1 ");
		List<Object> list = new ArrayList<Object>();
		if (!ObjectUtils.isEmpty(wheres)) {
			for (Object[]kv:wheres) {
				if(ObjectUtils.isEmpty(kv)){
					continue;
				}
				sql.append(" and `"+kv[0]+ "`=?  ");
				list.add(kv[1]);
			}
		}
		return getParamSql(sql.toString(), list.toArray());
	}
	
	public static String getParamSql3(String tableName, Object[][] wheres ,String clause) {
		String paramSql2 = getParamSql2(tableName, wheres);
		return paramSql2+" "+clause;
	}
	
	public static String getUpdateSql(Map<String, Object> params, String tableName, Map<String, Object> wheres) {
		StringBuilder sql = new StringBuilder(" UPDATE `" + tableName + "` SET ");
		List<Object> list = new ArrayList<Object>();
		for (String k : params.keySet()) {
			sql.append("  `" + k + "`=?,");
			list.add(params.get(k));
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append("  WHERE 1=1  ");
		if (!ObjectUtils.isEmpty(wheres)) {
			for (String k : wheres.keySet()) {
				sql.append(" and  `" + k + "`=? ");
				list.add(wheres.get(k));
			}
		}
		return getParamSql(sql.toString(), list.toArray());
	}

	public static String getUpdateSql2( Object [][] params , String tableName, Object[]... wheres) {
		StringBuilder sql = new StringBuilder(" UPDATE `" + tableName + "` SET ");
		List<Object> list = new ArrayList<Object>();
		for(Object[]kv:params){
			if(ObjectUtils.isEmpty(kv)){
				continue;
			}
			sql.append(" `"+ kv[0] +"`=?,");
			list.add(kv[1]);
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append("  WHERE 1=1  ");
		if (!ObjectUtils.isEmpty(wheres)) {
			for (Object[]kv:wheres) {
				if(ObjectUtils.isEmpty(kv)){
					continue;
				}
				sql.append(" and `"+kv[0]+ "`=?  ");
				list.add(kv[1]);
			}
		}
		return getParamSql(sql.toString(), list.toArray());
	}
	
	
	
}
