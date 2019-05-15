package com.haohao.constant;

import java.math.BigDecimal;

/**
 * 利息配置
 *
 * @Author:rienchou
 * @Date: 2018/6/6 18:22
 */
public class InterestConfig {
    /** 总利息 月利率 **/
    public final static BigDecimal INTEREST_TOTAL = BigDecimal.valueOf(0.015);
    /** 实际利息 月利率 **/
    public final static BigDecimal INTEREST_ACTUAL = BigDecimal.valueOf(0.0092);
    /** 服务费利息 月利率 **/
    public final static BigDecimal INTEREST_SERVICE = BigDecimal.valueOf(0.0058);
    /** 逾期利息 日利率 **/
    //public final static BigDecimal INTEREST_OVERDUE = BigDecimal.valueOf(0.001);
    public final static BigDecimal INTEREST_OVERDUE = BigDecimal.valueOf(0.00065);

    /** 催收费  一期一次性收取 **/
    //public final static BigDecimal COLLECTION = BigDecimal.valueOf(200);
    public final static BigDecimal COLLECTION = BigDecimal.valueOf(0);

    /** 实际利率  学习年化利率 = 实际月利率*12 **/
    public final static BigDecimal loan_xs_year_rate = BigDecimal.valueOf(0.1104);

    /** 订单最小本金 **/
    //public final static BigDecimal MIN_ACT_MONEY = BigDecimal.valueOf(20);

    /** 总额度(单位:万) **/
    public final static BigDecimal TOTAL_LIMIT = BigDecimal.valueOf(100);

    /** 商品入库后,按70%价格折算 **/
    public final static BigDecimal PRICE_RATE = BigDecimal.valueOf(0.7);

    /** 提交质押物,评估区间 **/
    public final static BigDecimal APPLY_EVALMONEY_MIN = BigDecimal.valueOf(0.7);
    public final static BigDecimal APPLY_EVALMONEY_MAX = BigDecimal.valueOf(0.8);

    /** 确认借款时最低借款金额 **/
    public final static BigDecimal MIN_ORDER_MONEY = BigDecimal.valueOf(200000);

    public final static String REFUND_DESC = "一次性还本付息";
}
