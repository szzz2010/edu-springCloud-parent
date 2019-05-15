package com.haohao.permission.service;


import java.util.List;

import com.haohao.permission.context.AdminMemberSession;
import com.haohao.permission.model.cond.AdminCond;
import com.haohao.permission.model.po.AdminPO;
import com.haohao.permission.model.vo.AdminVO;

/**
 * @author:abner
 */

public interface AdminService {


	/**
	 * 根据参数查询admin
	 * @author:abner
	 * @param AdminCond 参数
	 * @return admin
	 */
	public AdminVO getAdmin(AdminCond AdminCond);

	/**
	 * 根据userName查询admin
	 * @author:abner
	 * @param userName userName
	 * @return admin
	 */
	public AdminVO getAdminByUserName(String userName);

	/**
	 * 根据id查询admin
	 * @author:abner
	 * @param id adminId
	 * @return admin
	 */
	public AdminVO getAdminById(Integer id);

	/**
	 * 封装权限
	 * @author:abner
	 * @param admin 当前管理员
	 */
	public AdminMemberSession principalPermission(AdminVO admin, Integer systemType);

	/**
	 * 根据条件查询adminList
	 * @author:abner
	 * @param AdminCond 参数
	 * @return List<Admin>
	 */
	public List<AdminVO> getList(AdminCond AdminCond);

	/**
	 * 根据角色roleIds查询adminList roleIds.length<1 return allAdmin
	 * @author:abner
	 * @param roleIds roleIds
	 * @return List<Admin>
	 */
	public List<AdminVO> getListByRoleIds(Integer... roleIds);

	/**
	 * 新增admin
	 * @author:abner
	 */
	public void save(AdminPO admin) ;

	/**
	 * 修改admin
	 * @author:abner
	 */
	public void update(AdminPO admin);

	/**
	 * 根据adminId获取List<Role.id>
	 * @author:abner
	 * @param id adminId
	 * @return List<Integer>
	 */
	public List<Integer> getRoleIdListByAdminId(Integer id);

	/**
	 * 保存用户角色
	 * @author:abner
	 * @param AdminCond 参数
	 */
	public void saveRole(AdminCond adminCond);

	/**
	 * 修改密码
	 * @author:abner
	 */
	public void updatePassword(Integer userId, String newPassword);
}
