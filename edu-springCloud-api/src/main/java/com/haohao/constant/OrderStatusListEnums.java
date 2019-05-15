package com.haohao.constant;

import java.util.List;

import com.haohao.constant.OrderStatusConfig;
import com.haohao.constant.OrderStatusListEnums;

/**
 * 订单状态集合枚举
 * @Author:MaJinXu
 */
public enum OrderStatusListEnums {

	WAIT_RISK(1,"审核中",OrderStatusConfig.wait_risk),
	RISK_FAILED(2,"审核失败",OrderStatusConfig.repay_failed),
	LOANING(3,"放款中",OrderStatusConfig.loaning),
	LOAN_SUCCESS(4,"放款成功",OrderStatusConfig.loan_success),
	LOAN_FAILED(5,"放款失败",OrderStatusConfig.loan_failed),
	REPAY_SUCCESS(6,"还款成功",OrderStatusConfig.repay_success),
	REPAY_FAILED(7,"还款失败",OrderStatusConfig.repay_failed);

    private Integer paramsStatus;
	private String  remarks;
    private List<String> statusList;

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getParamsStatus() {
		return paramsStatus;
	}

	public void setParamsStatus(Integer paramsStatus) {
		this.paramsStatus = paramsStatus;
	}

	public List<String> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

	OrderStatusListEnums(Integer paramsStatus, String remarks, List<String> statusList) {
		this.paramsStatus = paramsStatus;
		this.remarks = remarks;
		this.statusList = statusList;
	}

	public static OrderStatusListEnums query(Integer type) {
		switch (type) {

			case 1:
				return OrderStatusListEnums.WAIT_RISK;

			// 手机运营商认证
			case 2:

				return OrderStatusListEnums.RISK_FAILED;


			// 3 信用卡认证
			case 3:
				return OrderStatusListEnums.LOANING;


			// 4 储蓄卡认证
			case 4:
				return OrderStatusListEnums.LOAN_SUCCESS;


			case 5:
				return OrderStatusListEnums.LOAN_FAILED;


			case 6:
				return OrderStatusListEnums.REPAY_SUCCESS;


			case 7:
				return OrderStatusListEnums.REPAY_FAILED;

			default:
				return null;
		}
	}
}
