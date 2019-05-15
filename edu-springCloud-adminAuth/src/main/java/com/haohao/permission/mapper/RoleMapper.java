package com.haohao.permission.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.haohao.permission.model.cond.RoleCond;
import com.haohao.permission.model.po.RolePO;
import com.haohao.permission.model.vo.RoleVO;
@Mapper
public interface RoleMapper {

    List<RoleVO> getList(RoleCond roleParams);

    RoleVO getRole(RoleCond roleParams);

    void save(RolePO role);

    void update(RolePO role);
}