package com.haohao.permission.model.cond;

public class AdminRoleCond extends AbstractCondition{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1947122759777717003L;

	private Integer adminId;

    private Integer roleId;

    private Integer createTime;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
    
    

}