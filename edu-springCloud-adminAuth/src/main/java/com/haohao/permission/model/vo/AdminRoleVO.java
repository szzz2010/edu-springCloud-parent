package com.haohao.permission.model.vo;

public class AdminRoleVO extends AbstractVO{

    /**
	 * 
	 */
	private static final long serialVersionUID = 179601006659286314L;

	private Integer adminId;

    private Integer roleId;

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

	private Integer createTime;

}