package com.haohao.constant;

/**
 * 订单状态枚举
 *
 * @Author:rienchou
 * @Date: 2018/5/8 15:27
 */
public enum OrderStatusEnums {

    //APPLY_COMMIT("提交质押诉求", 1), // 废弃
    // 该状态可能会出现在第一次贷款用户未开户即提交质押诉求
    //OPEN_ACCOUNT_COMMIT("完成开户", 2), // 废弃
    // 平安银行开户可能会失败,此时需要人工客服介入
    //OPEN_ACCOUNT_FAIL("开户失败", 3), //废弃
    // 完成开户之后,订单状态变为等待入库
    RISK_WAIT("等待风控", 4),
    RISK_FAILED("风控不通过", 5),
    // 等待价值评估
    //STORAGE_COMMIT("已入库,计算放款金额中", 5),
    // 完成价值评估,等待确认借金额
//    COMMIT_EVALUATE("等待确认借款金额", 6),
    // 完成平安银行授权,每次借款必须完成授权
//    PINGAN_AUTH_CONFIRM("完成平安银行授权", 7),
    // 平安银行授权失败
//    PINGAN_AUTH_FAIL("平安银行授权失败", 8),
    // 用户已确认借款
    CONFIRM_LOAN("风控通过", 9),
    // 学习--推送进件
    ASSET_PUSHED("已推送进件", 10),
    // 学习--推送进件成功
    ASSET_PUSH_SUCCESS("进件成功", 11),
    // 学习--推送进件失败
    ASSET_PUSH_FAILED("进件失败", 12),
    // 学习--进件审批成功(学习对该订单进行审批)
    ASSET_AUTH_SUCCESS("审批成功", 13),
    // 学习--进件审批失败
    ASSET_AUTH_FAILED("审批失败", 14),
    // 学习--放款成功(学习财务进行放款)
    LOAN_SUCCESS("放款成功", 15),
    // 学习--放款失败
    LOAN_FAILED("放款失败", 16),
    // 学习--完成提现
    WITHDRAW_SUCCESS("提现成功", 17),
    // 学习--完成提现
    WITHDRAW_FAILED("提现失败", 18),
    // 订单逾期
    OVERDUE("逾期", 19),
    // 逾期已还部分
    // OVERDUE_REFUND_PART("逾期已还部分", 20),
    // 用户申请还款
    // REFUND_APPLY("申请还款", 21),
    // 用户申请还款确认中
    // REFUND_WAIT_CONFIRM("申请还款确认中", 22),

    // 银行V1.0新增状态,当用户点击还款后,订单状态变为还款确认中,并通过财务在后台修改订单状态为还款成功
//    REFUND_CONFRIM("还款确认中", 24),

    // 用户完成还款(到该状态之后需要我公司出具还清证明,然后才能提货)
    REFUND_SUCCESS("还款成功", 20),
    // 还款失败
    REFUND_FAILED("还款失败", 22),
    // 完成提货
//    TAKE_GOODS("还款已提货", 21),
    //一个月内只能取消一次订单,该状态是用户人为取消订单,且取消订单的操作必须在确认借款之前
    CANCEL("取消订单", 22),
    //订单失效,该状态是订单生成后,5个工作日内,用户无任何下一步操作,则该订单失效,只能确认借款之前,可置为失效,如用户已经提现,则改订单不可置为失效
    INVALID("订单失效", 23);


    private String name;
    private int index;

    public static boolean contains(String type) {
        for (OrderStatusEnums typeEnum : OrderStatusEnums.values()) {
            if (typeEnum.name().equals(type)) {
                return true;
            }
        }
        return false;
    }

	public static String getNameByStatus(String type) {
		for (OrderStatusEnums typeEnum : OrderStatusEnums.values()) {
			if (typeEnum.name().equals(type)) {
				System.out.println(typeEnum.getName());
				return typeEnum.getName();
			}
		}
		return "";
	}

    private OrderStatusEnums(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
