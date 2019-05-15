package com.haohao.modelAndExample;

import java.math.BigDecimal;

import javax.validation.constraints.Pattern;

public class LoanUserAssetInfo {
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
     *   房产类型
     */
    @Pattern(regexp = "[123]", message = "房产类型[houseType]格式不正确")
    private String houseType;

    /**
     *   房产所在地
     */
    private String houseAddr;

    /**
     *   共有人
     */
    private String sharedPeopleNum;

    /**
     *   建筑面积
     */
    private String houseArea;

    /**
     *   购买时间格式
     */
    @Pattern(regexp = "((19)|(20))\\d\\d-((0[1-9])|(1[012]))-((0[1-9])|([12][0-9])|(3[01]))\\s((0[0-9])|(1[0-9])|(2[0-3])):[0-5][0-9]:[0-5][0-9]", message = "购买时间[buyTime]格式不正确")
    private String buyTime;

    /**
     *   购买单价
     */
    private BigDecimal housePrice;

    /**
     *   产权比例
     */
    private String houseProrightRate;

    /**
     *   住房贷款年限
     */
    private Integer houseloYearLimit;

    /**
     *   住房贷款月供
     */
    private BigDecimal houseMonthlyPayment;

    /**
     *   住房贷款余额
     */
    private BigDecimal houseloBalance;

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

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType == null ? null : houseType.trim();
    }

    public String getHouseAddr() {
        return houseAddr;
    }

    public void setHouseAddr(String houseAddr) {
        this.houseAddr = houseAddr == null ? null : houseAddr.trim();
    }

    public String getSharedPeopleNum() {
        return sharedPeopleNum;
    }

    public void setSharedPeopleNum(String sharedPeopleNum) {
        this.sharedPeopleNum = sharedPeopleNum == null ? null : sharedPeopleNum.trim();
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea == null ? null : houseArea.trim();
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime == null ? null : buyTime.trim();
    }

    public BigDecimal getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(BigDecimal housePrice) {
        this.housePrice = housePrice;
    }

    public String getHouseProrightRate() {
        return houseProrightRate;
    }

    public void setHouseProrightRate(String houseProrightRate) {
        this.houseProrightRate = houseProrightRate == null ? null : houseProrightRate.trim();
    }

    public Integer getHouseloYearLimit() {
        return houseloYearLimit;
    }

    public void setHouseloYearLimit(Integer houseloYearLimit) {
        this.houseloYearLimit = houseloYearLimit;
    }

    public BigDecimal getHouseMonthlyPayment() {
        return houseMonthlyPayment;
    }

    public void setHouseMonthlyPayment(BigDecimal houseMonthlyPayment) {
        this.houseMonthlyPayment = houseMonthlyPayment;
    }

    public BigDecimal getHouseloBalance() {
        return houseloBalance;
    }

    public void setHouseloBalance(BigDecimal houseloBalance) {
        this.houseloBalance = houseloBalance;
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