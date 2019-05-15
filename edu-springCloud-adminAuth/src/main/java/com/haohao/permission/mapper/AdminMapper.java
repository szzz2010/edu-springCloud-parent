package com.haohao.permission.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.haohao.permission.model.cond.AdminCond;
import com.haohao.permission.model.po.AdminPO;
import com.haohao.permission.model.vo.AdminVO;
@Mapper
public interface AdminMapper {

    int update(AdminPO admin);

	AdminVO getAdmin(AdminCond AdminCond);

	List<AdminVO> getList(AdminCond AdminCond);

	void save(AdminPO admin);
}