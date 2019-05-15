package com.haohao.modelAndExample;

import java.math.BigDecimal;

public class Contract {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 机构编码
     */
    private String source;

    /**
     * 额度包编号
     */
    private String contractCode;

    /**
     * 总额度
     */
    private BigDecimal quotaSum;

    /**
     * 剩余额度
     */
    private BigDecimal balance;

    /**
     * 状态
     *
     * @see ContractConstant.Status
     */
    private Integer status;

    /**
     * 是否可用
     * 0：可用
     * 1：不可用
     */
    private Integer enable;

    /**
     * 起始时间
     */
    private Long startDate;

    /**
     * 结束时间
     */
    private Long invalidDate;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 最后更新时间
     */
    private Long updateTime;

    /**
     * 操作人
     */
    private Integer operatorId;

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

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode == null ? null : contractCode.trim();
    }

    public BigDecimal getQuotaSum() {
        return quotaSum;
    }

    public void setQuotaSum(BigDecimal quotaSum) {
        this.quotaSum = quotaSum;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(Long invalidDate) {
        this.invalidDate = invalidDate;
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

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
}