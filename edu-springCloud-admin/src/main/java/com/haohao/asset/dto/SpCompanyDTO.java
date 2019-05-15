package com.haohao.asset.dto;

/**
 * @author feng
 * @discription 企业信息
 * @date 2019/1/8
 */
public class SpCompanyDTO {

    /**
     *   编号
     */
    private Integer id;

    /**
     *   企业名称
     */
    private String name;

    /**
     *   企业注册手机号
     */
    private String mobile;

    /**
     *   角色
     */
    private String role = "企业";

    /**
     *   企业用户类型 1借款人 2担保户
     */
    private String typeStr;

    /**
     *   对公账户号
     */
    private String publicAccount;

    /**
     *   银行子账号
     */
    private String childBankAccount;

    /**
     *   证件类型名称
     */
    private String licenseTypeStr = "统一社会信用代码";

    /**
     *   统一社会信用代码
     */
    private String usccCode;

    /**
     *   对公账户类型名(他行/本行)
     */
    private String publicAccountStr ;

    /**
     *   开户手机号
     */
    private String openAccountMobile ;

    /**
     *   开户时间
     */
    private String openAccountTime ;

    /**
     *   担保户ID
     */
    private Integer guaranteeCompanyId;

    /**
     *   审核状态
     */
    private  String status;

    /**
     *   注册时间
     */
    private  String createTime;

    /**
     *   审核通过时间
     */
    private  String checkTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTypeStr() {
        return typeStr;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }

    public String getPublicAccount() {
        return publicAccount;
    }

    public void setPublicAccount(String publicAccount) {
        this.publicAccount = publicAccount;
    }

    public String getChildBankAccount() {
        return childBankAccount;
    }

    public void setChildBankAccount(String childBankAccount) {
        this.childBankAccount = childBankAccount;
    }

    public String getLicenseTypeStr() {
        return licenseTypeStr;
    }

    public void setLicenseTypeStr(String licenseTypeStr) {
        this.licenseTypeStr = licenseTypeStr;
    }

    public String getUsccCode() {
        return usccCode;
    }

    public void setUsccCode(String usccCode) {
        this.usccCode = usccCode;
    }

    public String getPublicAccountStr() {
        return publicAccountStr;
    }

    public void setPublicAccountStr(String publicAccountStr) {
        this.publicAccountStr = publicAccountStr;
    }

    public String getOpenAccountMobile() {
        return openAccountMobile;
    }

    public void setOpenAccountMobile(String openAccountMobile) {
        this.openAccountMobile = openAccountMobile;
    }

    public String getOpenAccountTime() {
        return openAccountTime;
    }

    public void setOpenAccountTime(String openAccountTime) {
        this.openAccountTime = openAccountTime;
    }

    public Integer getGuaranteeCompanyId() {
        return guaranteeCompanyId;
    }

    public void setGuaranteeCompanyId(Integer guaranteeCompanyId) {
        this.guaranteeCompanyId = guaranteeCompanyId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }
}
