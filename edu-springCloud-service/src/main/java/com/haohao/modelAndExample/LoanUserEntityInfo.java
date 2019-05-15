package com.haohao.modelAndExample;

import java.math.BigDecimal;

import javax.validation.constraints.Pattern;

public class LoanUserEntityInfo {
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
     *   经营实体名称
     */
    private String bizEntityName;

    /**
     *   经营主体类型
     */
    @Pattern(regexp = "[123456]", message = "经营主体类型[bizEntiryType]格式不正确")
    private String bizEntiryType;

    /**
     *   注册资本
     */
    private BigDecimal registerAmt;

    /**
     *   企业成立日期
     */
    @Pattern(regexp = "((19)|(20))\\d\\d-((0[1-9])|(1[012]))-((0[1-9])|([12][0-9])|(3[01]))", message = "企业成立日期[foundedDate]格式不正确")
    private String foundedDate;

    /**
     *   注册地址
     */
    private String registerAddr;

    /**
     *   融资人持股比例
     */
    private String sgiareRatio;

    /**
     *   员工数量
     */
    @Pattern(regexp = "[12345]", message = "员工数量[employeeNum]格式不正确")
    private String employeeNum;

    /**
     *   行业
     */
    private String myCompanyIndustry;

    /**
     *   经营场所
     */
    @Pattern(regexp = "[123]", message = "经营场所[comAddr]格式不正确")
    private String comAddr;

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

    public String getBizEntityName() {
        return bizEntityName;
    }

    public void setBizEntityName(String bizEntityName) {
        this.bizEntityName = bizEntityName == null ? null : bizEntityName.trim();
    }

    public String getBizEntiryType() {
        return bizEntiryType;
    }

    public void setBizEntiryType(String bizEntiryType) {
        this.bizEntiryType = bizEntiryType == null ? null : bizEntiryType.trim();
    }

    public BigDecimal getRegisterAmt() {
        return registerAmt;
    }

    public void setRegisterAmt(BigDecimal registerAmt) {
        this.registerAmt = registerAmt;
    }

    public String getFoundedDate() {
        return foundedDate;
    }

    public void setFoundedDate(String foundedDate) {
        this.foundedDate = foundedDate == null ? null : foundedDate.trim();
    }

    public String getRegisterAddr() {
        return registerAddr;
    }

    public void setRegisterAddr(String registerAddr) {
        this.registerAddr = registerAddr == null ? null : registerAddr.trim();
    }

    public String getSgiareRatio() {
        return sgiareRatio;
    }

    public void setSgiareRatio(String sgiareRatio) {
        this.sgiareRatio = sgiareRatio == null ? null : sgiareRatio.trim();
    }

    public String getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(String employeeNum) {
        this.employeeNum = employeeNum == null ? null : employeeNum.trim();
    }

    public String getMyCompanyIndustry() {
        return myCompanyIndustry;
    }

    public void setMyCompanyIndustry(String myCompanyIndustry) {
        this.myCompanyIndustry = myCompanyIndustry == null ? null : myCompanyIndustry.trim();
    }

    public String getComAddr() {
        return comAddr;
    }

    public void setComAddr(String comAddr) {
        this.comAddr = comAddr == null ? null : comAddr.trim();
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