package com.haohao.permission.model.po;

public class RolePO extends AbstractPO{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1535464757661661891L;

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