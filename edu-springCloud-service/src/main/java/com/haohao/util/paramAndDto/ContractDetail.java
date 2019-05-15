package com.haohao.util.paramAndDto;

import java.math.BigDecimal;

/**
 * @Desc 额度包明细
 * @Author xiekunliang
 * @Date 2018/5/19 17:57
 */
public class ContractDetail {

    /**
     * 借款编号
     */
    private String loanNumber;

    /**
     * 借款人姓名
     */
    private String loanUserName;

    /**
     * 借款期限
     */
    private Integer loanTerms;

    /**
     * 合同金额
     */
    private BigDecimal contractAmt;

    /**
     * 使用时间
     */
    private Long createTime;

    /**
     * 历史剩余额度
     */
    private BigDecimal balance;

    /**
     * 额度包总额度
     */
    private BigDecimal quotaSum;

    /**
     * 已经使用总额度
     */
    private BigDecimal sumContractAmt;

    public BigDecimal getSumContractAmt() {
        return sumContractAmt;
    }

    public void setSumContractAmt(BigDecimal sumContractAmt) {
        this.sumContractAmt = sumContractAmt;
    }

    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getLoanUserName() {
        return loanUserName;
    }

    public void setLoanUserName(String loanUserName) {
        this.loanUserName = loanUserName;
    }

    public Integer getLoanTerms() {
        return loanTerms;
    }

    public void setLoanTerms(Integer loanTerms) {
        this.loanTerms = loanTerms;
    }

    public BigDecimal getContractAmt() {
        return contractAmt;
    }

    public void setContractAmt(BigDecimal contractAmt) {
        this.contractAmt = contractAmt;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getQuotaSum() {
        return quotaSum;
    }

    public void setQuotaSum(BigDecimal quotaSum) {
        this.quotaSum = quotaSum;
    }
}
