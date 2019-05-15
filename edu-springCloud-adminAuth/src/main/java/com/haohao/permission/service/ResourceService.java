package com.haohao.permission.service;

import java.util.List;

import com.haohao.permission.model.cond.ResourceCond;
import com.haohao.permission.model.po.ResourcePO;
import com.haohao.permission.model.vo.ResourceVO;

/**
 * @author:abner
 */
public interface ResourceService {


	/**
	 * 根据roleId查询List<Resource>
	 *
	 * @param roleIdList 角色id
	 * @return List<Resource>
	 * @author:abner
	 */
	public List<ResourceVO> getListByRoleIdList(List<Integer> roleIdList, Integer systemType);

	/**
	 * 根据条件查询resourceList
	 *
	 * @param resourceParams 参数
	 * @return List<Resource>
	 * @author:abner
	 */
	public List<ResourceVO> getList(ResourceCond resourceParams);

	/**
	 * @author:abner
	 */
	public List<ResourceVO> getTreeList(ResourceCond resourceParams);

	/**
	 * 根据id查询resource
	 *
	 * @param id resourceId
	 * @return Resource
	 * @author:abner
	 */
	public ResourceVO getResourceById(Integer id);

	/**
	 * 根据resourceName查询resource
	 *
	 * @param resourceName resourceName
	 * @return resource
	 * @author:abner
	 */
	public ResourceVO getResourceByResourceName(String resourceName);

	/**
	 * 新增resource
	 *
	 * @author:abner
	 */
	public void save(ResourcePO resource);

	/**
	 * 修改resource
	 *
	 * @author:abner
	 */
	public void update(ResourcePO resource);

	/**
	 * 根据resourceCode查询resource
	 *
	 * @param resourceCode resourceCode
	 * @return resource
	 * @author:abner
	 */
	public ResourceVO getResourceByResourceCode(String resourceCode) ;

	/**
	 * 查询resourceList
	 *
	 * @return List<Resource>
	 * @author:abner
	 */
	public List<ResourceVO> getList();
}
