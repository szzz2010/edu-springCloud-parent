package com.haohao.modelAndExample;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class LoanUserInfo {
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
     *   姓名，加密
     */
    @NotBlank(message="姓名[name]不能为空")
    private String name;

    /**
     *   用户身份证号，加密
     */
    @NotBlank(message="身份证[idCardNo]不能为空")
    private String idCardNo;

    /**
     *   手机号，加密
     */
    @NotBlank(message="手机号[cellPhone]不能为空")
    private String cellPhone;

    /**
     *   学历
     */
    @NotBlank(message="学历[education]不能为空")
    @Pattern(regexp = "[12345]", message = "学历[education]格式不正确")
    private String education;

    /**
     *   出生日期
     */
    @Pattern(regexp = "((19)|(20))\\d\\d-((0[1-9])|(1[012]))-((0[1-9])|([12][0-9])|(3[01]))", message = "出生日期[birthday]格式不正确")    
    private String birthday;

    /**
     *   年龄
     */
    @NotNull(message="年龄[age]不能为空")
    @Min(value = 1,message="年龄[age]格式不正确")
    private Integer age;

    /**
     *   性别
     */
    @NotNull(message="性别[gender]不能为空")
    @Min(value = 0,message="性别[gender]格式不正确")
    @Max(value = 1,message="性别[gender]格式不正确")
    private Integer gender;

    /**
     *   邮箱
     */
    @Email(message="邮箱[email]格式不正确")
    private String email;

    /**
     *   身份证有效期至
     */
    @Pattern(regexp = "((19)|(20))\\d\\d-((0[1-9])|(1[012]))-((0[1-9])|([12][0-9])|(3[01]))", message = "身份证有效期[idperiod]格式不正确")
    private String idperiod;

    /**
     *   户籍地址
     */
    private String homeTownAddr;

    /**
     *   户籍是否申请所在地
     */
    @Pattern(regexp = "[01]", message = "户籍是否申请所在地[homeTownAppLocation]格式不正确")
    private String homeTownAppLocation;

    /**
     *   现住址
     */
    private String communicateAddr;

    /**
     *   现地址居住时间
     */
    private String localYears;

    /**
     *   现居住地电话
     */
    private String localPhone;

    /**
     *   婚姻状况
     */
    @NotBlank(message="婚姻状况[marriage]不能为空")
    @Pattern(regexp = "[1234]", message = "婚姻状况[marriage]格式不正确")
    private String marriage;

    /**
     *   供养人口情况
     */
    private String familySituation;

    /**
     *   申请所在地
     */
    private String appCity;

    /**
     *   有无子女
     */
    @Pattern(regexp = "[01]", message = "有无子女[isHasChild]格式不正确")
    private String isHasChild;

    /**
     *   签约日期
     */
    @NotBlank(message="签约日期[signDate]不能为空")
    @Pattern(regexp = "((19)|(20))\\d\\d-((0[1-9])|(1[012]))-((0[1-9])|([12][0-9])|(3[01]))", message = "签约日期[signDate]格式不正确")
    private String signDate;

    /**
     *   审批日期
     */
    @Pattern(regexp = "((19)|(20))\\d\\d-((0[1-9])|(1[012]))-((0[1-9])|([12][0-9])|(3[01]))", message = "审批日期[apprDate]格式不正确")
    private String apprDate;

    /**
     *   借款提交城市
     */
    private String submitCity;

    /**
     *   家人是否知晓
     */
    @NotBlank(message="家人是否知晓[familyIsKnown]不能为空")
    @Pattern(regexp = "[01]", message = "家人是否知晓[familyIsKnown]格式不正确")
    private String familyIsKnown;

    /**
     *   能接受的最高月还款额
     */
    private BigDecimal monthPayment;

    /**
     *   共同居住者
     */
    @Pattern(regexp = "16|[1248]", message = "共同居住者[homePartner]格式不正确")
    private String homePartner;

    /**
     *   住宅类型
     */
    @Pattern(regexp = "[12345678]", message = "住宅类型[homeType]格式不正确")
    private String homeType;

    /**
     *   确认时间
     */
    @Pattern(regexp = "((19)|(20))\\d\\d-((0[1-9])|(1[012]))-((0[1-9])|([12][0-9])|(3[01]))\\s((0[0-9])|(1[0-9])|(2[0-3])):[0-5][0-9]:[0-5][0-9]", message = "确认时间[affirmDateTime]格式不正确")
    private String affirmDateTime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo == null ? null : idCardNo.trim();
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone == null ? null : cellPhone.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIdperiod() {
        return idperiod;
    }

    public void setIdperiod(String idperiod) {
        this.idperiod = idperiod == null ? null : idperiod.trim();
    }

    public String getHomeTownAddr() {
        return homeTownAddr;
    }

    public void setHomeTownAddr(String homeTownAddr) {
        this.homeTownAddr = homeTownAddr == null ? null : homeTownAddr.trim();
    }

    public String getHomeTownAppLocation() {
        return homeTownAppLocation;
    }

    public void setHomeTownAppLocation(String homeTownAppLocation) {
        this.homeTownAppLocation = homeTownAppLocation == null ? null : homeTownAppLocation.trim();
    }

    public String getCommunicateAddr() {
        return communicateAddr;
    }

    public void setCommunicateAddr(String communicateAddr) {
        this.communicateAddr = communicateAddr == null ? null : communicateAddr.trim();
    }

    public String getLocalYears() {
        return localYears;
    }

    public void setLocalYears(String localYears) {
        this.localYears = localYears == null ? null : localYears.trim();
    }

    public String getLocalPhone() {
        return localPhone;
    }

    public void setLocalPhone(String localPhone) {
        this.localPhone = localPhone == null ? null : localPhone.trim();
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage == null ? null : marriage.trim();
    }

    public String getFamilySituation() {
        return familySituation;
    }

    public void setFamilySituation(String familySituation) {
        this.familySituation = familySituation == null ? null : familySituation.trim();
    }

    public String getAppCity() {
        return appCity;
    }

    public void setAppCity(String appCity) {
        this.appCity = appCity == null ? null : appCity.trim();
    }

    public String getIsHasChild() {
        return isHasChild;
    }

    public void setIsHasChild(String isHasChild) {
        this.isHasChild = isHasChild == null ? null : isHasChild.trim();
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate == null ? null : signDate.trim();
    }

    public String getApprDate() {
        return apprDate;
    }

    public void setApprDate(String apprDate) {
        this.apprDate = apprDate == null ? null : apprDate.trim();
    }

    public String getSubmitCity() {
        return submitCity;
    }

    public void setSubmitCity(String submitCity) {
        this.submitCity = submitCity == null ? null : submitCity.trim();
    }

    public String getFamilyIsKnown() {
        return familyIsKnown;
    }

    public void setFamilyIsKnown(String familyIsKnown) {
        this.familyIsKnown = familyIsKnown == null ? null : familyIsKnown.trim();
    }

    public BigDecimal getMonthPayment() {
        return monthPayment;
    }

    public void setMonthPayment(BigDecimal monthPayment) {
        this.monthPayment = monthPayment;
    }

    public String getHomePartner() {
        return homePartner;
    }

    public void setHomePartner(String homePartner) {
        this.homePartner = homePartner == null ? null : homePartner.trim();
    }

    public String getHomeType() {
        return homeType;
    }

    public void setHomeType(String homeType) {
        this.homeType = homeType == null ? null : homeType.trim();
    }

    public String getAffirmDateTime() {
        return affirmDateTime;
    }

    public void setAffirmDateTime(String affirmDateTime) {
        this.affirmDateTime = affirmDateTime == null ? null : affirmDateTime.trim();
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