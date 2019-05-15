package com.haohao.permission.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface RoleResourceMapper {

	List<Integer> getResourceIdListByRoleIdList(@Param("roleIdList") List<Integer> roleIdList);

	void deleteByResourceId(@Param("id") Integer id);

	void deleteByRoleId(@Param("id") Integer id);

	void save(@Param("id") Integer id,@Param("resourceIdList") List<Integer> resourceIdList,@Param("time") Integer time);
}