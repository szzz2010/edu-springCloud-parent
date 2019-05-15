package com.haohao.constant;

import java.util.ArrayList;
import java.util.List;


/**
 * 各种订单状态
 *
 * @Author:rienchou
 * @Date: 2018/6/1 17:05
 */
public class OrderStatusConfig {

	/**
     * 审核中
     */
    public final static List<String> wait_risk = new ArrayList<String>() {
        {
            add(OrderStatusEnums.RISK_WAIT.name());
        }
    };
	
    /**
     * 审核失败
     */
    public final static List<String> risk_failed = new ArrayList<String>() {
        {
            add(OrderStatusEnums.RISK_FAILED.name());
        }
    };
	
    
    /**
     * 放款中
     */
    public final static List<String> loaning = new ArrayList<String>() {
        {
            add(OrderStatusEnums.CONFIRM_LOAN.name());
            add(OrderStatusEnums.ASSET_PUSHED.name());
            add(OrderStatusEnums.ASSET_PUSH_SUCCESS.name());
            add(OrderStatusEnums.ASSET_AUTH_SUCCESS.name());
        }
    };

    /**
     * 放款成功
     */
    public final static List<String> loan_success = new ArrayList<String>() {
        {
            add(OrderStatusEnums.LOAN_SUCCESS.name());
            add(OrderStatusEnums.WITHDRAW_SUCCESS.name());
            add(OrderStatusEnums.WITHDRAW_FAILED.name());
            add(OrderStatusEnums.OVERDUE.name());
        }
    };
    
    /**
     * 放款失败
     */
    public final static List<String> loan_failed = new ArrayList<String>() {
        {
            add(OrderStatusEnums.LOAN_FAILED.name());
        }
    };
    
    /**
     * 还款成功
     */
    public final static List<String> repay_success = new ArrayList<String>() {
        {
            add(OrderStatusEnums.REFUND_SUCCESS.name());
        }
    };

    /**
     * 还款失败
     */
    public final static List<String> repay_failed = new ArrayList<String>() {
        {
            add(OrderStatusEnums.REFUND_FAILED.name());
        }
    };

    /**
     * 在借中
     */
    public final static List<String> lending = new ArrayList<String>() {
        {
            add(OrderStatusEnums.CONFIRM_LOAN.name());
            add(OrderStatusEnums.ASSET_PUSHED.name());
            add(OrderStatusEnums.ASSET_PUSH_SUCCESS.name());
            add(OrderStatusEnums.ASSET_AUTH_SUCCESS.name());
            add(OrderStatusEnums.LOAN_SUCCESS.name());
            add(OrderStatusEnums.WITHDRAW_SUCCESS.name());
            add(OrderStatusEnums.WITHDRAW_FAILED.name());
            add(OrderStatusEnums.OVERDUE.name());
            add(OrderStatusEnums.REFUND_FAILED.name());
        }
    };

    
    
}
