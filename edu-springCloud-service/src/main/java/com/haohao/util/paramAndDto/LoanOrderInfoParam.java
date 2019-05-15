package com.haohao.util.paramAndDto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
/**
 * <p> 订单信息condition </p>
 * @author wanglicheng
 * @date	2018年5月22日
 */
public class LoanOrderInfoParam extends PageParam{

	 /**
     *   主键
     */
    private Integer orderId;

    /**
     *   机构编码
     */
    private String source;

    /**
     *   订单是否有效（0有效 1无效）
     */
    private Integer enable;

    /**
     *   额度包编号
     */
    @NotBlank(message="额度包编号[contractCode]不能为空")
    private String contractCode;

    /**
     *   借款编号
     */
    @NotBlank(message="借款编号[loanNumber]不能为空")
    private String loanNumber;

    /**
     *   合同金额
     */
    @NotNull(message="合同金额[contractAmt]不能为空")
    @DecimalMin(value ="0.01",message="合同金额[contractAmt]格式不正确")
    @Digits(integer=8, fraction=2,message="合同金额[contractAmt]格式不正确")
    private BigDecimal contractAmt;

    /**
     *   借款服务费
     */
    @NotNull(message="借款服务费[consultAmt]不能为空")
    @DecimalMin(value ="0.01",message="借款服务费[consultAmt]格式不正确")
    @Digits(integer=8, fraction=2,message="借款服务费[consultAmt]格式不正确")
    private BigDecimal consultAmt;

    /**
     *   放款金额
     */
    @NotNull(message="放款金额[loanAmt]不能为空")
    @DecimalMin(value ="0.01",message="放款金额[loanAmt]格式不正确")
    @Digits(integer=8, fraction=2,message="放款金额[loanAmt]格式不正确")
    private BigDecimal loanAmt;

    /**
     *   风险金金额
     */
    @NotNull(message="风险金金额[riskAmt]不能为空")
    @DecimalMin(value ="0",message="风险金金额[riskAmt]格式不正确")
    private BigDecimal riskAmt;

    /**
     *   还款方式
     */
    @NotBlank(message="还款方式[repayType]不能为空")
    @Pattern(regexp = "RT0[1234]", message = "还款方式[repayType]格式不正确")
    private String repayType;

    /**
     *   信用保证金
     */
    @NotNull(message="信用保证金[creditDeposit]不能为空")
    @DecimalMin(value ="0",message="信用保证金[creditDeposit]格式不正确")
    private BigDecimal creditDeposit;

    /**
     *   保险费
     */
    @NotNull(message="保险费[premium]不能为空")
    @DecimalMin(value ="0",message="保险费[premium]格式不正确")
    private BigDecimal premium;

    /**
     *   借款利率
     */
    @NotNull(message="借款利率[rate]不能为空")
    @DecimalMin(value ="0.01",message="借款利率[rate]格式不正确")
    private BigDecimal rate;

    /**
     *   产品类型
     */
    @NotBlank(message="产品类型[productCode]不能为空")
    @Pattern(regexp = "0[12]", message = "产品类型[productCode]格式不正确")
    private String productCode;

    /**
     *   借款用途
     */
    @NotBlank(message="借款用途[loanPurpose]不能为空")
    @Pattern(regexp = "[1234567]", message = "借款用途[loanPurpose]格式不正确") 
    private String loanPurpose;

    /**
     *   借款期限
     */
    @NotNull(message="借款期限[loanTerms]不能为空")
    @Min(value = 1,message="借款期限[loanTerms]格式不正确")
    private Integer loanTerms;

    /**
     *   订单是否要放款（0放款 1不需要放款）
     */
    @NotNull(message="订单是否要放款[payStatus]不能为空")
    @Min(value = 0,message="订单是否要放款[payStatus]格式不正确")
    @Max(value = 1,message="订单是否要放款[payStatus]格式不正确")
    private Integer payStatus;

    /**
     *   附件路径
     */
    @NotBlank(message="附件路径[filePath]不能为空")
    private String filePath;

    /**
     *   是否过风控了（0：未过风控，1：已过）
     */
    private Integer riskStatus;

    /**
     *   风控等级（A、B、C、D、E）
     */
    private String riskLevel;

    /**
     *   订单学习进件状态（0初始，1调用接口成功，2成功，3失败，4审批成功，5审批失败）
     */
    private Integer xsEntryStatus;

    /**
     *   学习打款状态（0初始，1成功，2失败）
     */
    private Integer xsPayStatus;
    
    /**
     *   放款时间
     */
    private Long xsPayTime;
    
    /**
     *   放款时间 开始
     */
    private Long xsPayTimeStart;
    
    /**
     *   放款时间 结束
     */
    private Long xsPayTimeEnd;

    /**
     *   添加时间
     */
    private Long createTime;
    
    /**
     * 创建时间 a b 之间
     */
    private String[] createBetweenTime;
    
    private String  createBetweenDateStr;

    /**
     *   修改时间
     */
    private Long updateTime;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public BigDecimal getContractAmt() {
		return contractAmt;
	}

	public void setContractAmt(BigDecimal contractAmt) {
		this.contractAmt = contractAmt;
	}

	public BigDecimal getConsultAmt() {
		return consultAmt;
	}

	public void setConsultAmt(BigDecimal consultAmt) {
		this.consultAmt = consultAmt;
	}

	public BigDecimal getLoanAmt() {
		return loanAmt;
	}

	public void setLoanAmt(BigDecimal loanAmt) {
		this.loanAmt = loanAmt;
	}

	public BigDecimal getRiskAmt() {
		return riskAmt;
	}

	public void setRiskAmt(BigDecimal riskAmt) {
		this.riskAmt = riskAmt;
	}

	public String getRepayType() {
		return repayType;
	}

	public void setRepayType(String repayType) {
		this.repayType = repayType;
	}

	public BigDecimal getCreditDeposit() {
		return creditDeposit;
	}

	public void setCreditDeposit(BigDecimal creditDeposit) {
		this.creditDeposit = creditDeposit;
	}

	public BigDecimal getPremium() {
		return premium;
	}

	public void setPremium(BigDecimal premium) {
		this.premium = premium;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getLoanPurpose() {
		return loanPurpose;
	}

	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}

	public Integer getLoanTerms() {
		return loanTerms;
	}

	public void setLoanTerms(Integer loanTerms) {
		this.loanTerms = loanTerms;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Integer getRiskStatus() {
		return riskStatus;
	}

	public void setRiskStatus(Integer riskStatus) {
		this.riskStatus = riskStatus;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public Integer getXsEntryStatus() {
		return xsEntryStatus;
	}

	public void setXsEntryStatus(Integer xsEntryStatus) {
		this.xsEntryStatus = xsEntryStatus;
	}

	public Integer getXsPayStatus() {
		return xsPayStatus;
	}

	public void setXsPayStatus(Integer xsPayStatus) {
		this.xsPayStatus = xsPayStatus;
	}

	public Long getXsPayTime() {
		return xsPayTime;
	}

	public void setXsPayTime(Long xsPayTime) {
		this.xsPayTime = xsPayTime;
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

	public String[] getCreateBetweenTime() {
		return createBetweenTime;
	}

	public void setCreateBetweenTime(String[] createBetweenTime) {
		this.createBetweenTime = createBetweenTime;
	}

	public String getCreateBetweenDateStr() {
		return createBetweenDateStr;
	}

	public void setCreateBetweenDateStr(String createBetweenDateStr) {
		this.createBetweenDateStr = createBetweenDateStr;
	}

	public Long getXsPayTimeStart() {
		return xsPayTimeStart;
	}

	public void setXsPayTimeStart(Long xsPayTimeStart) {
		this.xsPayTimeStart = xsPayTimeStart;
	}

	public Long getXsPayTimeEnd() {
		return xsPayTimeEnd;
	}

	public void setXsPayTimeEnd(Long xsPayTimeEnd) {
		this.xsPayTimeEnd = xsPayTimeEnd;
	}
	
}
