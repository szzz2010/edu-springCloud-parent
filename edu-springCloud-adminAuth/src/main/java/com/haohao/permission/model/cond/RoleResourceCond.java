package com.haohao.permission.model.cond;

public class RoleResourceCond extends AbstractCondition{

    /**
	 * 
	 */
	private static final long serialVersionUID = 526320052867585660L;


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