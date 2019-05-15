package com.haohao.permission.model.cond;

import java.util.List;

public class AdminCond extends AbstractCondition{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4040532579884017762L;

	private Integer id;

    private String userName;

    private String password;

    private String realName;

    private Integer enable;

    private Integer createTime;

    private List<Integer> adminIdList;

    private List<Integer> roleIdList;

    private Integer page;

    public List<Integer> getAdminIdList() {
		return adminIdList;
	}

	public void setAdminIdList(List<Integer> adminIdList) {
		this.adminIdList = adminIdList;
	}

	public List<Integer> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<Integer> roleIdList) {
		this.roleIdList = roleIdList;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	private Integer limit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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
