package com.haohao.permission.model.vo;

public class RoleVO extends AbstractVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1585583923505630679L;

	private Integer id;

    private String roleName;

    private Integer enable;

    private Integer createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
    

}