package com.haohao.permission.model.po;

import java.util.List;

public class ResourcePO extends AbstractPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2301483021740206504L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public List<ResourcePO> getChildren() {
		return children;
	}

	public void setChildren(List<ResourcePO> children) {
		this.children = children;
	}

	public Integer getSortCode() {
		return sortCode;
	}

	public void setSortCode(Integer sortCode) {
		this.sortCode = sortCode;
	}

	public Integer getSystemType() {
		return systemType;
	}

	public void setSystemType(Integer systemType) {
		this.systemType = systemType;
	}

	private Integer id;

	private Integer parentId;

	private String resourceName;

	private String resourceCode;

	private String resourceUrl;

	private Integer type;

	private Integer enable;

	private Integer createTime;

	private List<ResourcePO> children;

	private Integer sortCode;

	private Integer systemType;

}
