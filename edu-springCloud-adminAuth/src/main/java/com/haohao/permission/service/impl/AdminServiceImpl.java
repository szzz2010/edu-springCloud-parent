package com.haohao.permission.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haohao.permission.context.AdminMemberSession;
import com.haohao.permission.mapper.AdminMapper;
import com.haohao.permission.mapper.AdminRoleMapper;
import com.haohao.permission.model.cond.AdminCond;
import com.haohao.permission.model.po.AdminPO;
import com.haohao.permission.model.vo.AdminVO;
import com.haohao.permission.model.vo.ResourceVO;
import com.haohao.permission.service.AdminService;
import com.haohao.permission.util.DateUtil;

/**
 * @author:
 */

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminMapper adminMapper;

	@Autowired
	private AdminRoleMapper adminRoleMapper;

	@Autowired
	private ResourceServiceImpl resourceModule;


	/**
	 * 组装菜单
	 * @author:abner
	 * @param list 资源
	 */
	private List<ResourceVO> assemblyMenu(List<ResourceVO> list, Integer systemType) {
		list.forEach(r->r.setChildren(list.stream().filter(r1->r.getId().equals(r1.getParentId())).collect(Collectors.toList())));
		return list.stream().filter(r -> r.getParentId().equals(systemType)).collect(Collectors.toList());
	}


	/**
	 * 根据角色roleIds查询adminList roleIds.length<1 return allAdmin
	 * @author:abner
	 * @param roleIds roleIds
	 * @return List<Admin>
	 */
	@Override
	public List<AdminVO> getListByRoleIds(Integer... roleIds){
		AdminCond adminParams = new AdminCond();
		if (roleIds.length>0) {
			List<Integer> adminIdList = adminRoleMapper.getAdminIdListByRoleIds(roleIds);
			if (adminIdList.size()>0) {
				adminParams.setAdminIdList(adminIdList);
				adminParams.setEnable(1);
			}else {
				return new ArrayList<>();
			}
		}
		return adminMapper.getList(adminParams);
	}

	/**
	 * 根据adminId获取List<Role.id>
	 * @author:abner
	 * @param id adminId
	 * @return List<Integer>
	 */
	public List<Integer> getRoleIdListByAdminId(Integer id) {
		return adminRoleMapper.getRoleIdListByAdminId(id);
	}

	/**
	 * 保存用户角色
	 * @author:abner
	 * @param adminParams 参数
	 */
	@Override
	@Transactional
	public void saveRole(AdminCond adminParams) {
		Integer id = adminParams.getId();
		List<Integer> roleIdList = adminParams.getRoleIdList();
		adminRoleMapper.deleteByAdminId(id);
		if (null != roleIdList && roleIdList.size()>0) {
			adminRoleMapper.save(id,roleIdList, DateUtil.unixTimestamp());
		}
	}

	/**
	 * 修改密码
	 * @author:abner
	 */
	@Override
	public void updatePassword(Integer userId, String newPassword) {
		AdminPO admin = new AdminPO();
		admin.setId(userId);
		admin.setPassword(DigestUtils.md5Hex(newPassword));
		adminMapper.update(admin);
	}

	@Override
	public AdminVO getAdmin(AdminCond AdminCond) {
		return adminMapper.getAdmin(AdminCond);
	}

	@Override
	public AdminVO getAdminByUserName(String userName) {
		AdminCond adminParams = new AdminCond();
		adminParams.setUserName(userName);
		return adminMapper.getAdmin(adminParams);
	}

	@Override
	public AdminVO getAdminById(Integer id) {
		AdminCond adminParams = new AdminCond();
		adminParams.setId(id);
		return adminMapper.getAdmin(adminParams);
	}

	@Override
	public AdminMemberSession principalPermission(AdminVO admin, Integer systemType) {
		List<Integer> roleIdList = adminRoleMapper.getRoleIdListByAdminId(admin.getId());
		AdminMemberSession principal = new AdminMemberSession();
		principal.setAdmin(admin);
		principal.setRoleIdList(roleIdList);
		if (roleIdList.size()>0) {
			List<ResourceVO> resourceList = resourceModule.getListByRoleIdList(roleIdList,systemType);
			principal.setUrlList(resourceList.stream().filter(resource -> StringUtils.isNotBlank(resource.getResourceUrl())).map(ResourceVO::getResourceUrl).distinct().collect(Collectors.toList()));
			principal.setButtonList(resourceList.stream().filter(resource -> StringUtils.isNotBlank(resource.getResourceCode())).map(ResourceVO::getResourceCode).distinct().collect(Collectors.toList()));
			principal.setMenuList(assemblyMenu(resourceList.stream().filter(resource -> resource.getType() == 0).collect(Collectors.toList()),systemType));
		}
		return principal;
	}

	@Override
	public List<AdminVO> getList(AdminCond adminCond) {
		return adminMapper.getList(adminCond);
	}

	@Override
	@Transactional
	public void save(AdminPO admin) {
		adminMapper.save(admin);
	}

	@Override
	@Transactional
	public void update(AdminPO admin) {
		if (null != admin.getEnable() && 0==admin.getEnable()) {
			adminRoleMapper.deleteByAdminId(admin.getId());
		}
		adminMapper.update(admin);
	}

}
