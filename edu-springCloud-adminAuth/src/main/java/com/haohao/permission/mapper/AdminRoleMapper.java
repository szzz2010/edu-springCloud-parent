package com.haohao.permission.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AdminRoleMapper {

	List<Integer> getRoleIdListByAdminId(@Param("adminId") Integer adminId);

	List<Integer> getAdminIdListByRoleIds(@Param("roleIds") Integer[] roleIds);

	void deleteByAdminId(@Param("id") Integer id);

	void deleteByRoleId(@Param("id") Integer id);

	void save(@Param("id") Integer id,@Param("roleIdList") List<Integer> roleIdList,@Param("time") Integer time);

}