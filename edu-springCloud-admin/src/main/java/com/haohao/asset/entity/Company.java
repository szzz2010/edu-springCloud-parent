package com.haohao.asset.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xueyx
 * @since 2019-03-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @TableId
    private Integer id;

    /**
     * 借款编号
     */
    private String loanNumber;

    /**
     * 借款企业名称
     */
    private String loanCompanyName;

    /**
     * 借款企业证件号
     */
    private String loanCompanyIdCard;

    /**
     * 借款企业手机号
     */
    private String loanCompanyMobile;

    /**
     * 合作机构
     */
    private String loanAgencyId;

    /**
     * 合作机构编码
     */
    private String loanAgencyCode;

    /**
     * 合作机构名称
     */
    private String loanAgencyName;

    /**
     * 合同金额
     */
    private BigDecimal loanContractAmt;

    /**
     * 放款金额
     */
    private BigDecimal loanAmt;

    /**
     * 年化利率
     */
    private BigDecimal loanYearInterestRate;

    /**
     * 借款申请时间 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime loanApplyTime;

    /**
     * 借款服务费
     */
    private BigDecimal loanConsultAmt;

    /**
     * 产品类型：：1 信用贷 2抵押贷
     */
    private Integer loanProductType;

    /**
     * 授信额度
     */
    private BigDecimal loanGiveQuota;

    /**
     * 授信剩余额度
     */
    private BigDecimal loanSurplusQuota;

    /**
     * 借款标题
     */
    private String loanTitle;

    /**
     * 1资金周转
     */
    private Integer loanPurpose;

    /**
     * 借款期限
     */
    private Integer loanTerms;

    /**
     * 债权类型（1：原始债权；2：转让债权；）',
     */
    private Integer loanNature;

    /**
     * 借款利率
     */
    private BigDecimal loanInterestRate;

    /**
     * 风险金金额
     */
    private BigDecimal loanRiskAmt;

    /**
     * j借款风控等级
     */
    private String loanRiskLevel;

    /**
     * 借款风控建议
     */
    private String loanRiskAdvice;

    /**
     * 贴息利率
     */
    private BigDecimal loanDiscountRate;

    /**
     * 放款时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime loanSuccessTime;

    /**
     * 企业借款资金运用情况
     */
    private String loanFundUse;

    /**
     * 授权流水号
     */
    private String loanAuthNo;

    /**
     * 月还金额
     */
    private BigDecimal repayMonthAmount;

    /**
     * 月还本金
     */
    private BigDecimal repayMonthPrincipal;

    /**
     * 还款方式:RT01：等额本息；RT02：先息后本；RT03：到期本息
     */
    private String repayType;

    /**
     * 提前还款方式：1.借款期限内，随时还款
     */
    private Integer repayPreType;

    /**
     * 还款到期日
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime repayExpiryTime;

    /**
     * 还款总期数
     */
    private Integer repayPeriod;

    /**
     * 月还款日
     */
    private Integer repayMonthDate;

    /**
     * 首次还款日
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private LocalDate repayFirstDate;

    /**
     * 剩余还款期数
     */
    private Integer repayPeriodSurplus;

    /**
     * 是否结清：0否，1是
     */
    private Integer repayIsSettle;

    /**
     * 还款来源
     */
    private String repaySource;

    /**
     * 银行编号
     */
    private String bankNum;

    /**
     * 银行卡名称
     */
    private String bankName;

    /**
     * 银行卡号
     */
    private String bankCardNo;

    /**
     * 银行卡预留手机号
     */
    private String bankMobile;

    /**
     * 开户行所在省
     */
    private String bankProvince;

    /**
     * 开户行所在市
     */
    private String bankCity;

    /**
     * 支行名称
     */
    private String bankBranchName;

    /**
     * 法人姓名
     */
    private String legalName;

    /**
     * 法人身份证
     */
    private String legalIdCard;

    /**
     * 法人手机号
     */
    private String legalMobile;

    /**
     * 法人身份证前照路径
     */
    private String legalCardFace;

    /**
     * 法人身份证背照路径
     */
    private String legalCardBack;

    /**
     * 经办人姓名
     */
    private String handleName;

    /**
     * 经办人身份证
     */
    private String handleIdCard;

    /**
     * 经办人手机号
     */
    private String handleMobile;

    /**
     * 经办人公司职务
     */
    private String handleDuty;

    /**
     * 担保企业证件号
     */
    private String companyAssureIdCard;

    /**
     * 担保企业名称
     */
    private String companyAssureName;

    /**
     * 企业风险等级：1 A，2 B，3 C，4 D，5 E
     */
    private String companyRiskRank;

    /**
     * 企业性质：1.国营企业，2.民营企业
     */
    private Integer companyNature;

    /**
     * 贷款提交省
     */
    private String companyReferProvince;

    /**
     * 贷款提交市
     */
    private String companyReferCity;

    /**
     * 企业所在省
     */
    private String companyPlaceProvince;

    /**
     * 企业所在市
     */
    private String companyPlaceCity;

    /**
     * 企业地址
     */
    private String companyAddress;

    /**
     * 创建日期
     */
    private String companyCreateDate;

    /**
     * 所属行业
     */
    private String companyIndustry;

    /**
     * 经营状态
     */
    private String companyOperateStatus;

    /**
     * 企业营业收入
     */
    private BigDecimal companyYearIncome;

    /**
     * 企业负债金额
     */
    private BigDecimal companyDebtAmount;

    /**
     * 营业期限（起）
     */
    private String companyOperateStartDate;

    /**
     * 营业期限（止）
     */
    private String companyOperateEndDate;

    /**
     * 注册资本
     */
    private BigDecimal companyRegisterAmount;

    /**
     * 等级机关
     */
    private String companyRegisterOrgan;

    /**
     * 经营范围
     */
    private String companyOperateRange;

    /**
     * 企业经营财务情况
     */
    private String companyOperateFinanceState;

    /**
     * 企业还款能力变化情况
     */
    private String companyRepayAbilityChange;

    /**
     * 企业是否逾期0.否，1.是
     */
    private Integer companyOverdueStatus;

    /**
     * 企业是否涉诉0.否，1.是
     */
    private Integer companyIsInvolve;

    /**
     * 企业是否受行政处罚0.否，1.是
     */
    private Integer companyIsAdministrativePenalty;

    /**
     * 公司章名称
     */
    private String companySignName;

    /**
     * 公司章code
     */
    private String companySignCode;

    /**
     * 公司章类型:1公章，2其他
     */
    private Integer companySignType;

    /**
     * 是否上传法人身份证0.否，1.是
     */
    private Integer fileIsUploadCorporationCard;

    /**
     * 是否上传财务报表0.否，1.是
     */
    private Integer fileIsUploadFinanceStatement;

    /**
     * 是否上传担保函0.否，1.是
     */
    private Integer fileIsUploadGuaranteeLetter;

    /**
     * 是否上传征信报告0.否，1.是
     */
    private Integer fileIsUploadCreditReport;

    /**
     * 财务报表路径
     */
    private String fileFinanceAttach;

    /**
     * 担保函路径
     */
    private String fileGuaranteeAttach;

    /**
     * 征信报告路径
     */
    private String fileCreditAttach;

    /**
     * 收货单号
     */
    private String goodsOrderId;

    /**
     * 收货仓库
     */
    private String goodsWarehouse;

    /**
     * 收货日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private LocalDate goodsCollectGoodsDate;

    /**
     * 仓库管理员
     */
    private String goodsGodownKeeper;

    /**
     * 质押货物联系人
     */
    private String goodsContactName;

    /**
     * 联系电话
     */
    private String goodsContactMobile;

    /**
     * 序号
     */
    private String goodsSerialNumber;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品类别
     */
    private String goodsCategory;

    /**
     * 品牌
     */
    private String goodsBrand;

    /**
     * 规格
     */
    private String goodsSpecifications;

    /**
     * 型号
     */
    private String goodsModel;

    /**
     * 货物条形码
     */
    private String goodsBarCode;

    /**
     * 质押价格
     */
    private BigDecimal goodsPrice;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime updateTime;


}
