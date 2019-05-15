package com.haohao.permission.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.haohao.permission.model.cond.ResourceCond;
import com.haohao.permission.model.po.ResourcePO;
import com.haohao.permission.model.vo.ResourceVO;
@Mapper
public interface ResourceMapper {

	List<ResourceVO> getList(ResourceCond resourceParams);

	ResourceVO getResource(ResourceCond resourceParams);

	void save(ResourcePO resource);

	void update(ResourcePO resource);
}