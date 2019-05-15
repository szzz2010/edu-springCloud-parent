package com.haohao.util.springTools.springJdbc;

import java.util.List;
import java.util.Map;
/**
 * powered by denshinyou
 */
public interface MysqlSpringJdbcDao {
	
	void runSql(String sql);

	int insertOrUpdate(String sql, Object... args);

	int[] batchInsertOrUpdate(String sql, List<Object[]> batchArgs);
	
	Map<String, Object> queryForMap(String sql, Object... args);
	
	Map<String, Object> queryForMap2(String tableName, Object[]... wheres);

	Map<String, Object> queryForMap3(String tableName, Object[][] wheres, String clause);

	List<Map<String, Object>> queryForList(String sql, Object... args);
	
	List<Map<String, Object>> queryForList2(String tableName, Object[]... wheres);

	List<Map<String, Object>> queryForList3(String tableName, Object[][] wheres, String clause);

	<T> Object queryForObject(String sql, Class<T> clazz, Object... args);

	Number addSelectiveAndGetId(String tableName, Map<String, Object> args);
	
	Number addSelectiveAndGetId2(String tableName ,String generatedKey , Map<String, Object> args);

	Map<String, Object> addSelectiveAndReturn(String tableName, Map<String, Object> args);

	Map<String, Object> addSelectiveAndReturn2(String tableName, String generatedKey, Map<String, Object> args);
	
	int Update(Map<String, Object> params, String tableName, Map<String, Object> wheres);

	int Update(Object[][] params, String tableName, Object[]... wheres);

	Map<String, Object> commonData(Map<String, Object> params);

	
}
