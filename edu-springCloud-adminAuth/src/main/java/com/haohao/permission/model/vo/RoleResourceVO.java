package com.haohao.permission.model.vo;

public class RoleResourceVO extends AbstractVO{


	/**
	 * 
	 */
	private static final long serialVersionUID = 7557476776539275534L;

	private Integer roleId;

    private Integer resourceId;

    public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	private Integer createTime;

}