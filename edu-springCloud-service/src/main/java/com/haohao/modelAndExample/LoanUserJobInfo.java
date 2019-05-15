package com.haohao.modelAndExample;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class LoanUserJobInfo {
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
     *   工作单位
     */
    private String companyName;

    /**
     *   单位性质
     */
    @Pattern(regexp = "[123456789]", message = "单位性质[companyProperty]格式不正确")
    private String companyProperty;

    /**
     *   工作单位座机
     */
    private String fixedLine;

    /**
     *   单位地址
     */
    private String companyAddr;

    /**
     *   本工作开始日期
     */
    @NotBlank(message="本工作开始日期[startDate]不能为空")
    @Pattern(regexp = "((19)|(20))\\d\\d-((0[1-9])|(1[012]))-((0[1-9])|([12][0-9])|(3[01]))\\s((0[0-9])|(1[0-9])|(2[0-3])):[0-5][0-9]:[0-5][0-9]", message = "本工作开始日期[startDate]格式不正确")
    private String startDate;

    /**
     *   职业
     */
    private String profession;

    /**
     *   职务
     */
    @NotBlank(message="职务[dutyJob]不能为空")
    @Pattern(regexp = "[12345]", message = "职务[dutyJob]格式不正确")
    private String dutyJob;

    /**
     *   个人月收入
     */
    @NotNull(message="个人月收入[monthlyIncome]不能为空")
    @DecimalMin(value ="0",message="个人月收入[monthlyIncome]格式不正确")
    private BigDecimal monthlyIncome;

    /**
     *   雇佣类型
     */
    @Pattern(regexp = "(10)|(20)", message = "雇佣类型[hireType]格式不正确")
    private String hireType;

    /**
     *   行业信息
     */
    private String businessInfo;

    /**
     *   单位规模
     */
    private String companyScale;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyProperty() {
        return companyProperty;
    }

    public void setCompanyProperty(String companyProperty) {
        this.companyProperty = companyProperty == null ? null : companyProperty.trim();
    }

    public String getFixedLine() {
        return fixedLine;
    }

    public void setFixedLine(String fixedLine) {
        this.fixedLine = fixedLine == null ? null : fixedLine.trim();
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr == null ? null : companyAddr.trim();
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getDutyJob() {
        return dutyJob;
    }

    public void setDutyJob(String dutyJob) {
        this.dutyJob = dutyJob == null ? null : dutyJob.trim();
    }

    public BigDecimal getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(BigDecimal monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getHireType() {
        return hireType;
    }

    public void setHireType(String hireType) {
        this.hireType = hireType == null ? null : hireType.trim();
    }

    public String getBusinessInfo() {
        return businessInfo;
    }

    public void setBusinessInfo(String businessInfo) {
        this.businessInfo = businessInfo == null ? null : businessInfo.trim();
    }

    public String getCompanyScale() {
        return companyScale;
    }

    public void setCompanyScale(String companyScale) {
        this.companyScale = companyScale == null ? null : companyScale.trim();
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