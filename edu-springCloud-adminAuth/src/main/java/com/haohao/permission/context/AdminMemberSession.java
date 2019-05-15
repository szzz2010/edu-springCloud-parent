package com.haohao.permission.context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.haohao.permission.model.po.ResourcePO;
import com.haohao.permission.model.vo.AdminVO;
import com.haohao.permission.model.vo.ResourceVO;

/**
 * 用户session
 * 
 * @author wanglicheng
 * @date 2018年8月9日
 */
public class AdminMemberSession implements Serializable {

	public List<Integer> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<Integer> roleIdList) {
		this.roleIdList = roleIdList;
	}

	public AdminVO getAdmin() {
		return admin;
	}

	public void setAdmin(AdminVO admin) {
		this.admin = admin;
	}


	public List<ResourceVO> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<ResourceVO> menuList) {
		this.menuList = menuList;
	}

	public List<String> getUrlList() {
		return urlList;
	}

	public void setUrlList(List<String> urlList) {
		this.urlList = urlList;
	}

	public List<String> getButtonList() {
		return buttonList;
	}

	public void setButtonList(List<String> buttonList) {
		this.buttonList = buttonList;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3743273389862047598L;


	
	private AdminVO admin;

	private List<Integer> roleIdList = new ArrayList<Integer>();
	
	private List<ResourceVO> menuList = new ArrayList<ResourceVO>();

	private List<String> urlList = new ArrayList<String>();

	private List<String> buttonList = new ArrayList<String>();
	
	
}
