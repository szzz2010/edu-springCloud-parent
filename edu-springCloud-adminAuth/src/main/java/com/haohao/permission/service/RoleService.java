package com.haohao.permission.service;

import java.util.List;

import javax.annotation.Resource;

import com.haohao.permission.model.cond.RoleCond;
import com.haohao.permission.model.po.RolePO;
import com.haohao.permission.model.vo.ResourceVO;
import com.haohao.permission.model.vo.RoleVO;

/**
 * @author:abner
 */
public interface RoleService {

	@Resource

	/**
	 * 根据条件查询roleList
	 *
	 * @param roleParams 参数
	 * @return List<Admin>
	 * @author:abner
	 */
	public List<RoleVO> getList(RoleCond roleParams) ;

	/**
	 * 根据id查询role
	 *
	 * @param id roleId
	 * @return role
	 * @author:abner
	 */
	public RoleVO getRoleById(Integer id) ;

	/**
	 * 根据roleName查询role
	 *
	 * @param roleName roleName
	 * @return role
	 * @author:abner
	 */
	public RoleVO getRoleByRoleName(String roleName);

	/**
	 * 新增role
	 *
	 * @author:abner
	 */
	public void save(RolePO role);

	/**
	 * 修改admin
	 *
	 * @author:abner
	 */
	public void update(RolePO role);

	/**
	 * 查询roleList
	 *
	 * @return List<Admin>
	 * @author:abner
	 */
	public List<RoleVO> getList();

	/**
	 * 根据adminId获取List<Role.id>
	 * @author:abner
	 * @param id adminId
	 * @return List<Integer>
	 */
	public List<Integer> getResourceIdListByRoleId(Integer id) ;

	/**
	 * 根据roleId 获取树状菜单
	 * @author:abner
	 * @param roleId roleId
	 */
	public List<ResourceVO> resourceList(Integer roleId) ;

	/**
	 * 保存角色资源
	 * @param roleParams 参数
	 */
	public void saveResource(RoleCond roleParams) ;
}
