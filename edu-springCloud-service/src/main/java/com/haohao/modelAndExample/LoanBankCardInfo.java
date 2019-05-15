package com.haohao.modelAndExample;

import org.hibernate.validator.constraints.NotBlank;

public class LoanBankCardInfo {
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
    @NotBlank(message="放款对象[debtor]不能为空")
    private String debtor;

    /**
     *   放款银行
     */
    @NotBlank(message="放款银行[loanBank]不能为空")
    private String loanBank;

    /**
     *   放款银行卡号
     */
    @NotBlank(message="放款银行卡号[loanBankNum]不能为空")
    private String loanBankNum;

    /**
     *   开户行所在省
     */
    private String bankProvince;

    /**
     *   开户行所在市
     */
    private String bankCity;

    /**
     *   支行名称
     */
    private String branchName;

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

    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor == null ? null : debtor.trim();
    }

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank == null ? null : loanBank.trim();
    }

    public String getLoanBankNum() {
        return loanBankNum;
    }

    public void setLoanBankNum(String loanBankNum) {
        this.loanBankNum = loanBankNum == null ? null : loanBankNum.trim();
    }

    public String getBankProvince() {
        return bankProvince;
    }

    public void setBankProvince(String bankProvince) {
        this.bankProvince = bankProvince == null ? null : bankProvince.trim();
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity == null ? null : bankCity.trim();
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
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