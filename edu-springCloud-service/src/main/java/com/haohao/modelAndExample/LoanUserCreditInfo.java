package com.haohao.modelAndExample;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class LoanUserCreditInfo {
    /**
     *   主键
     */
    private Integer id;

    /**
     *   机构编码
     */
    private String source;

    /**
     *   订单id
     */
    private Integer orderId;

    /**
     *   信用卡张数
     */
    @Min(value = 0,message="信用卡张数[creditCardNums]格式不正确")
    private Integer creditCardNums;

    /**
     *   信用卡最高额度
     */
    @DecimalMin(value ="0",message="信用卡最高额度[maxLimit]格式不正确")
    private BigDecimal maxLimit;

    /**
     *   信用卡是否付全额
     */
    @Pattern(regexp = "[01]", message = "信用卡是否付全额[payEntire]格式不正确")
    private String payEntire;

    /**
     *   贷款最高逾期期数
     */
    @Min(value = 0,message="贷款最高逾期期数[loanovdHigh]格式不正确")
    private Integer loanovdHigh;

    /**
     *   查询次数
     */
    @Min(value = 0,message="查询次数[queryTimes]格式不正确")
    private Integer queryTimes;

    /**
     *   征信报告是否为空白
     */
    @Pattern(regexp = "[01]", message = "征信报告是否为空白[appPbocBlank]格式不正确")
    private String appPbocBlank;

    /**
     *   添加时间
     */
    private Long createTime;

    /**
     *   修改时间
     */
    private Long updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCreditCardNums() {
        return creditCardNums;
    }

    public void setCreditCardNums(Integer creditCardNums) {
        this.creditCardNums = creditCardNums;
    }

    public BigDecimal getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(BigDecimal maxLimit) {
        this.maxLimit = maxLimit;
    }

    public String getPayEntire() {
        return payEntire;
    }

    public void setPayEntire(String payEntire) {
        this.payEntire = payEntire == null ? null : payEntire.trim();
    }

    public Integer getLoanovdHigh() {
        return loanovdHigh;
    }

    public void setLoanovdHigh(Integer loanovdHigh) {
        this.loanovdHigh = loanovdHigh;
    }

    public Integer getQueryTimes() {
        return queryTimes;
    }

    public void setQueryTimes(Integer queryTimes) {
        this.queryTimes = queryTimes;
    }

    public String getAppPbocBlank() {
        return appPbocBlank;
    }

    public void setAppPbocBlank(String appPbocBlank) {
        this.appPbocBlank = appPbocBlank == null ? null : appPbocBlank.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}