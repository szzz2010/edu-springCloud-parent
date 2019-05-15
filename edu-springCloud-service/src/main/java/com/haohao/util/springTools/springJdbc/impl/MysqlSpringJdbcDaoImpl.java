package com.haohao.util.springTools.springJdbc.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import com.haohao.util.springTools.springJdbc.MysqlSpringJdbcDao;
import com.haohao.util.springTools.springJdbc.SpringJdbcDeployVersion;
import com.haohao.util.springTools.springJdbc.helper.DaoHelper;
import com.haohao.util.springTools.springJdbc.helper.SqlHelper;
/**
 * powered by denshinyou
 * 
 * @ if you want to deploy interface to register center
 * wheather there are parent subclasses or inheritance relationships 
 * i strongly recomment you to use annotation @Primary and @Component
 * in stead of Repository which will cause errors and ultimately leads to failure.
 * 
 * @Component(MysqlSpringJdbcDaoImpl.beanName)
 * @Service(version = "1.0.0")
 */
@Primary
@Component(MysqlSpringJdbcDaoImpl.beanName)
public class MysqlSpringJdbcDaoImpl implements MysqlSpringJdbcDao ,Serializable{

	private static final long serialVersionUID = 6268159560498754626L;

	public static final String beanName = "mysqlSpringJdbcDao"+SpringJdbcDeployVersion.deployVersion;
	
	private static final Logger log = LoggerFactory.getLogger(MysqlSpringJdbcDaoImpl.class);
	
	private static final String generatedKey = "id";
	
	@Autowired(required=false)
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}

	private SimpleJdbcInsert simpleJdbcInsert() {
		return new SimpleJdbcInsert(jdbcTemplate());
	}

	@Override
	public void runSql(String sql) {
		jdbcTemplate().execute(sql);
	}

	@Override
	public int insertOrUpdate(String sql, Object... args) {
		return jdbcTemplate().update(sql, args);
	}

	@Override
	public Map<String, Object> queryForMap(String sql, Object... args) {
		try {
			return jdbcTemplate().queryForMap(sql, args);
		} catch (Exception e) {
			log.info("[{}]", e.getMessage()+"-----> return : "+e.getCause());
			return null;
		}
	}

	@Override
	public Map<String, Object> queryForMap2(String tableName, Object[]... wheres) {
		return queryForMap(SqlHelper.getParamSql2(tableName, wheres));
	}
	
	@Override
	public Map<String, Object> queryForMap3(String tableName, Object[][] wheres ,String clause) {
		return queryForMap(SqlHelper.getParamSql3(tableName, wheres, clause));
	}
	
	@Override
	public List<Map<String, Object>> queryForList(String sql, Object... args) {
		return jdbcTemplate().queryForList(sql, args);
	}

	@Override
	public List<Map<String, Object>> queryForList2(String tableName, Object[]... wheres) {
		return queryForList(SqlHelper.getParamSql2(tableName, wheres));
	}
	
	@Override
	public List<Map<String, Object>> queryForList3(String tableName, Object[][] wheres, String clause) {
		return queryForList(SqlHelper.getParamSql3(tableName, wheres, clause));
	}
	
	@Override
	public int[] batchInsertOrUpdate(String sql, List<Object[]> batchArgs) {
		return jdbcTemplate().batchUpdate(sql, batchArgs);
	}

	@Override
	public <T> Object queryForObject(String sql, Class<T> clazz, Object... args) {
		return jdbcTemplate().queryForObject(sql, clazz, args);
	}

	@Override
	public Number addSelectiveAndGetId(String tableName, Map<String, Object> args) {
		return simpleJdbcInsert().withTableName(tableName).usingGeneratedKeyColumns(generatedKey).usingColumns(args.keySet().toArray(new String[]{})).executeAndReturnKey(args);
	}

	@Override
	public Number addSelectiveAndGetId2(String tableName,String generatedKey, Map<String, Object> args) {
		return simpleJdbcInsert().withTableName(tableName).usingGeneratedKeyColumns(generatedKey).usingColumns(args.keySet().toArray(new String[]{})).executeAndReturnKey(args);
	}
	
	@Override
	public Map<String, Object> addSelectiveAndReturn(String tableName, Map<String, Object> args) {
		return queryForMap2(tableName, new Object[][]{{generatedKey,addSelectiveAndGetId(tableName, args)}});
	}

	@Override
	public Map<String, Object> addSelectiveAndReturn2(String tableName, String generatedKey, Map<String, Object> args) {
		return queryForMap2(tableName, new Object[][]{{generatedKey,addSelectiveAndGetId2(tableName, generatedKey, args)}});
	}
	
	@Override
	public int Update(Map<String, Object> params, String tableName, Map<String, Object> wheres) {
		return insertOrUpdate(SqlHelper.getUpdateSql(params, tableName, wheres));
	}

	@Override
	public int Update( Object [][] params , String tableName, Object[]... wheres) {
		return insertOrUpdate(SqlHelper.getUpdateSql2(params, tableName, wheres));
	}
	
	@Override
	public Map<String, Object> commonData(Map<String, Object> params) {
		String sql = (String) params.get("sql");
		String command = (String) params.get("command");
		Object data = null;
		if ("execute".equals(command)) {
			DaoHelper.getMysqlSpringJdbcDao().runSql(sql);
		}
		if ("insertOrUpdate".equals(command)) {
			data = DaoHelper.getMysqlSpringJdbcDao().insertOrUpdate(sql);
		}
		if ("queryForMap".equals(command)) {
			data = DaoHelper.getMysqlSpringJdbcDao().queryForMap(sql);
		}
		if ("queryForList".equals(command)) {
			data = DaoHelper.getMysqlSpringJdbcDao().queryForList(sql);
		}
		params.put("data", data);
		return params;
	}

}
