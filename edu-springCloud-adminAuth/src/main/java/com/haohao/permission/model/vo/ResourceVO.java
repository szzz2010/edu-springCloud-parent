package com.haohao.permission.model.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.haohao.permission.model.po.ResourcePO;

public class ResourceVO extends AbstractVO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2504038599050915885L;


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

	public List<ResourceVO> getChildren() {
		return children;
	}

	public void setChildren(List<ResourceVO> children) {
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
	private String title;

	private Integer value;

	private ResourceVO resource;

	private String name = "resourceIdList";

	private boolean checked;

	private boolean disabled;

	private List<ResourceVO> data = new ArrayList<ResourceVO>();

	private Integer id;

	private Integer parentId;

	private String resourceName;

	private String resourceCode;

	private String resourceUrl;

	private Integer type;

	private Integer enable;

	private Integer createTime;

	private List<ResourceVO> children;

	private Integer sortCode;

	private Integer systemType;
	
	
	
	public ResourceVO( Integer id, Integer parentId, String resourceName, String resourceCode,
			String resourceUrl, Integer type, Integer enable, Integer createTime, 
			Integer sortCode, Integer systemType) {
		this.id = id;
		this.parentId = parentId;
		this.resourceName = resourceName;
		this.resourceCode = resourceCode;
		this.resourceUrl = resourceUrl;
		this.type = type;
		this.enable = enable;
		this.createTime = createTime;
		this.sortCode = sortCode;
		this.systemType = systemType;
	}
	
	

	public ResourceVO(ResourceVO resource, List<Integer> list) {
		this.resource = resource;
		this.title = resource.getResourceName();
		this.value = resource.getId();
		this.checked = list.contains(resource.getId());
	}
	public ResourceVO() {
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public ResourceVO getResource() {
		return resource;
	}

	public void setResource(ResourceVO resource) {
		this.resource = resource;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public List<ResourceVO> getData() {
		return data;
	}

	public void setData(List<ResourceVO> data) {
		this.data = data;
	}
	
	public static List<ResourceVO> getList(List<ResourceVO> resourceList, List<Integer> list) {
		List<ResourceVO> collect = resourceList.stream().map(r -> new ResourceVO(r, list)).collect(Collectors.toList());
		collect.forEach(m->m.setData(collect.stream().filter(m1->m.getValue().equals(m1.getResource().getParentId())).collect(Collectors.toList())));
		return collect.stream().filter(m -> m.getResource().getType() == 3 && m.getResource().getParentId() == 0).collect(Collectors.toList());
	}

}
