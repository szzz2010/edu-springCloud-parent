package com.haohao.permission.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haohao.permission.mapper.AdminRoleMapper;
import com.haohao.permission.mapper.RoleMapper;
import com.haohao.permission.mapper.RoleResourceMapper;
import com.haohao.permission.model.cond.RoleCond;
import com.haohao.permission.model.po.RolePO;
import com.haohao.permission.model.vo.ResourceVO;
import com.haohao.permission.model.vo.RoleVO;
import com.haohao.permission.service.RoleService;
import com.haohao.permission.util.DateUtil;

/**
 * @author:abner
 */
@Service
public class RoleServiceImpl implements RoleService{

	@Resource
	private RoleMapper roleMapper;

	@Resource
	private RoleResourceMapper roleResourceMapper;

	@Resource
	private AdminRoleMapper adminRoleMapper;

	@Resource
	private ResourceServiceImpl resourceModule;

	/**
	 * 根据条件查询roleList
	 *
	 * @param roleParams 参数
	 * @return List<Admin>
	 * @author:abner
	 */
	@Override
	public List<RoleVO> getList(RoleCond roleParams) {
		return roleMapper.getList(roleParams);
	}

	/**
	 * 根据id查询role
	 *
	 * @param id roleId
	 * @return role
	 * @author:abner
	 */
	@Override
	public RoleVO getRoleById(Integer id) {
		RoleCond roleParams = new RoleCond();
		roleParams.setId(id);
		return roleMapper.getRole(roleParams);
	}

	/**
	 * 根据roleName查询role
	 *
	 * @param roleName roleName
	 * @return role
	 * @author:abner
	 */
	@Override
	public RoleVO getRoleByRoleName(String roleName) {
		RoleCond roleParams = new RoleCond();
		roleParams.setRoleName(roleName);
		return roleMapper.getRole(roleParams);
	}

	/**
	 * 新增role
	 *
	 * @author:abner
	 */
	@Override
	public void save(RolePO role) {
		roleMapper.save(role);
	}

	/**
	 * 修改admin
	 *
	 * @author:abner
	 */
	@Override
	@Transactional
	public void update(RolePO role) {
		if (null != role.getEnable() && 0 == role.getEnable()) {
			adminRoleMapper.deleteByRoleId(role.getId());
			roleResourceMapper.deleteByRoleId(role.getId());
		}
		roleMapper.update(role);
	}

	/**
	 * 查询roleList
	 *
	 * @return List<Admin>
	 * @author:abner
	 */
	@Override
	public List<RoleVO> getList() {
		RoleCond roleParams = new RoleCond();
		roleParams.setEnable(1);
		return getList(roleParams);
	}

	/**
	 * 根据adminId获取List<Role.id>
	 * @author:abner
	 * @param id adminId
	 * @return List<Integer>
	 */
	@Override
	public List<Integer> getResourceIdListByRoleId(Integer id) {
		List<Integer> list = new ArrayList<>();
		list.add(id);
		return roleResourceMapper.getResourceIdListByRoleIdList(list);
	}

	/**
	 * 根据roleId 获取树状菜单
	 * @author:abner
	 * @param roleId roleId
	 */
	@Override
	public List<ResourceVO> resourceList(Integer roleId) {
		List<ResourceVO> resourceList = resourceModule.getList();
		List<Integer> list = getResourceIdListByRoleId(roleId);
		return ResourceVO.getList(resourceList,list);
	}

	/**
	 * 保存角色资源
	 * @param roleParams 参数
	 */
	@Override
	@Transactional
	public void saveResource(RoleCond roleParams) {
		Integer id = roleParams.getId();
		List<Integer> resourceIdList = roleParams.getResourceIdList();
		roleResourceMapper.deleteByRoleId(id);
		if (null != resourceIdList && resourceIdList.size()>0) {
			roleResourceMapper.save(id,resourceIdList, DateUtil.unixTimestamp());
		}
	}
}
