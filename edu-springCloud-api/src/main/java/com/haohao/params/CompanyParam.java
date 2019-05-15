package com.haohao.params;

import java.io.Serializable;

/**
 * @program: CompanyParam
 * @description:
 * @author: MaJinXu
 * @create: 2018-09-20 15:22
 **/
public class CompanyParam implements Serializable {

	private static final long serialVersionUID = -6597467017415142876L;
	private Integer page;

	private Integer pageSize;

	private String companyName;

	private String orderNo;

	private Integer orderStatus;

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "CompanyParam{" +
				"page=" + page +
				", pageSize=" + pageSize +
				", companyName='" + companyName + '\'' +
				", orderNo='" + orderNo + '\'' +
				", orderStatus=" + orderStatus +
				'}';
	}
}
