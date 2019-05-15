package com.haohao.permission.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haohao.permission.mapper.ResourceMapper;
import com.haohao.permission.mapper.RoleResourceMapper;
import com.haohao.permission.model.cond.ResourceCond;
import com.haohao.permission.model.po.ResourcePO;
import com.haohao.permission.model.vo.ResourceVO;
import com.haohao.permission.service.ResourceService;

/**
 * @author:abner
 */
@Service
public class ResourceServiceImpl implements ResourceService{

	@Autowired
	private RoleResourceMapper roleResourceMapper;

	@Autowired
	private ResourceMapper resourceMapper;

	/**
	 * 根据roleId查询List<Resource>
	 *
	 * @param roleIdList 角色id
	 * @return List<Resource>
	 * @author:abner
	 */
	@Override
	public List<ResourceVO> getListByRoleIdList(List<Integer> roleIdList, Integer systemType) {
		List<Integer> list = roleResourceMapper.getResourceIdListByRoleIdList(roleIdList);
		if (list.size() > 0) {
			ResourceCond resourceParams = new ResourceCond();
			resourceParams.setResourceIdList(list);
			resourceParams.setEnable(1);
			resourceParams.setSystemType(systemType);
			return resourceMapper.getList(resourceParams);
		} else {
			return new ArrayList<>();
		}
	}

	/**
	 * 根据条件查询resourceList
	 *
	 * @param resourceParams 参数
	 * @return List<Resource>
	 * @author:abner
	 */
	@Override
	public List<ResourceVO> getList(ResourceCond resourceParams) {
		return resourceMapper.getList(resourceParams);
	}

	/**
	 * @author:abner
	 */
	@Override
	public List<ResourceVO> getTreeList(ResourceCond resourceParams){
		List<ResourceVO> resourceList = resourceMapper.getList(resourceParams);
		resourceList.forEach(r->r.setChildren(resourceList.stream().filter(r1->r.getId().equals(r1.getParentId())).collect(Collectors.toList())));
		return resourceList.stream().filter(r -> r.getParentId().equals(resourceParams.getSystemType())).collect(Collectors.toList());
	}

	/**
	 * 根据id查询resource
	 *
	 * @param id resourceId
	 * @return Resource
	 * @author:abner
	 */
	@Override
	public ResourceVO getResourceById(Integer id) {
		ResourceCond resourceParams = new ResourceCond();
		resourceParams.setId(id);
		return resourceMapper.getResource(resourceParams);
	}

	/**
	 * 根据resourceName查询resource
	 *
	 * @param resourceName resourceName
	 * @return resource
	 * @author:abner
	 */
	@Override
	public ResourceVO getResourceByResourceName(String resourceName) {
		ResourceCond resourceParams = new ResourceCond();
		resourceParams.setResourceName(resourceName);
		return resourceMapper.getResource(resourceParams);
	}

	/**
	 * 新增resource
	 *
	 * @author:abner
	 */
	@Override
	public void save(ResourcePO resource) {
		resourceMapper.save(resource);
	}

	/**
	 * 修改resource
	 *
	 * @author:abner
	 */
	@Override
	@Transactional
	public void update(ResourcePO resource) {
		if (null != resource.getEnable() && 0 == resource.getEnable()) {
			roleResourceMapper.deleteByResourceId(resource.getId());
		}
		resourceMapper.update(resource);
	}

	/**
	 * 根据resourceCode查询resource
	 *
	 * @param resourceCode resourceCode
	 * @return resource
	 * @author:abner
	 */
	@Override
	public ResourceVO getResourceByResourceCode(String resourceCode) {
		ResourceCond resourceParams = new ResourceCond();
		resourceParams.setResourceCode(resourceCode);
		return resourceMapper.getResource(resourceParams);
	}

	/**
	 * 查询resourceList
	 *
	 * @return List<Resource>
	 * @author:abner
	 */
	@Override
	public List<ResourceVO> getList() {
		ResourceCond resourceParams = new ResourceCond();
		resourceParams.setEnable(1);
		return resourceMapper.getList(resourceParams);
	}
}
