package com.haohao.modelAndExample;

import java.math.BigDecimal;
import java.util.Date;

public class AcCompanyOrder {
    /**
     */
    private Integer id;

    /**
     *   �����
     */
    private String loanNumber;

    /**
     *   �����ҵ����
     */
    private String loanCompanyName;

    /**
     *   �����ҵ֤����
     */
    private String loanCompanyIdCard;

    /**
     *   �����ҵ�ֻ���
     */
    private String loanCompanyMobile;

    /**
     *   ��������
     */
    private String loanAgencyId;

    /**
     *   ������������
     */
    private String loanAgencyCode;

    /**
     *   ������������
     */
    private String loanAgencyName;

    /**
     *   ��ͬ���
     */
    private BigDecimal loanContractAmt;

    /**
     *   �ſ���
     */
    private BigDecimal loanAmt;

    /**
     *   �껯����
     */
    private BigDecimal loanYearInterestRate;

    /**
     *   �������ʱ�� 
     */
    private Date loanApplyTime;

    /**
     *   �������
     */
    private BigDecimal loanConsultAmt;

    /**
     *   ��Ʒ���ͣ���1 ���ô� 2��Ѻ��
     */
    private Integer loanProductType;

    /**
     *   ���Ŷ��
     */
    private BigDecimal loanGiveQuota;

    /**
     *   ����ʣ����
     */
    private BigDecimal loanSurplusQuota;

    /**
     *   ������
     */
    private String loanTitle;

    /**
     *   1�ʽ���ת
     */
    private Integer loanPurpose;

    /**
     *   �������
     */
    private Integer loanTerms;

    /**
     *   ծȨ���ͣ�1��ԭʼծȨ��2��ת��ծȨ����',
     */
    private Integer loanNature;

    /**
     *   �������
     */
    private BigDecimal loanInterestRate;

    /**
     *   ���ս���
     */
    private BigDecimal loanRiskAmt;

    /**
     *   j����صȼ�
     */
    private String loanRiskLevel;

    /**
     *   ����ؽ���
     */
    private String loanRiskAdvice;

    /**
     *   ��Ϣ����
     */
    private BigDecimal loanDiscountRate;

    /**
     *   �ſ�ʱ��
     */
    private Date loanSuccessTime;

    /**
     *   ��ҵ����ʽ��������
     */
    private String loanFundUse;

    /**
     *   �»����
     */
    private BigDecimal repayMonthAmount;

    /**
     *   �»�����
     */
    private BigDecimal repayMonthPrincipal;

    /**
     *   ���ʽ:RT01���ȶϢ��RT02����Ϣ�󱾣�RT03����Ϣ��2��
     */
    private String repayType;

    /**
     *   �������
     */
    private Date repayExpiryTime;

    /**
     *   ����������
     */
    private Integer repayPeriod;

    /**
     *   �»�����
     */
    private Integer repayMonthDate;

    /**
     *   �״λ�����
     */
    private Date repayFirstDate;

    /**
     *   ʣ�໹������
     */
    private Integer repayPeriodSurplus;

    /**
     *   �Ƿ���壺0��1��
     */
    private Integer repayIsSettle;

    /**
     *   ���б��
     */
    private String bankNum;

    /**
     *   ���п�����
     */
    private String bankName;

    /**
     *   ���п���
     */
    private String bankCardNo;

    /**
     *   ���п�Ԥ���ֻ���
     */
    private String bankMobile;

    /**
     *   ����������ʡ
     */
    private String bankProvince;

    /**
     *   ������������
     */
    private String bankCity;

    /**
     *   ֧������
     */
    private String bankBranchName;

    /**
     *   ��������
     */
    private String legalName;

    /**
     *   �������֤
     */
    private String legalIdCard;

    /**
     *   �����ֻ���
     */
    private String legalMobile;

    /**
     *   �������֤ǰ��·��
     */
    private String legalCardFace;

    /**
     *   �������֤����·��
     */
    private String legalCardBack;

    /**
     *   ����������
     */
    private String handleName;

    /**
     *   ���������֤
     */
    private String handleIdCard;

    /**
     *   �������ֻ���
     */
    private String handleMobile;

    /**
     *   �����˹�˾ְ��
     */
    private String handleDuty;

    /**
     *   ������ҵ֤����
     */
    private String companyAssureIdCard;

    /**
     *   ������ҵ����
     */
    private String companyAssureName;

    /**
     *   ��ҵ���յȼ���1 A��2 B��3 C��4 D��5 E
     */
    private String companyRiskRank;

    /**
     *   ��ҵ���ʣ�1.��Ӫ��ҵ��2.��Ӫ��ҵ
     */
    private Integer companyNature;

    /**
     *   �����ύʡ
     */
    private String companyReferProvince;

    /**
     *   �����ύ��
     */
    private String companyReferCity;

    /**
     *   ��ҵ����ʡ
     */
    private String companyPlaceProvince;

    /**
     *   ��ҵ������
     */
    private String companyPlaceCity;

    /**
     *   ��ҵ��ַ
     */
    private String companyAddress;

    /**
     *   ��������
     */
    private Date companyCreateDate;

    /**
     *   ������ҵ
     */
    private String companyIndustry;

    /**
     *   ��Ӫ״̬
     */
    private String companyOperateStatus;

    /**
     *   ��ҵӪҵ����
     */
    private BigDecimal companyYearIncome;

    /**
     *   ��ҵ��ծ���
     */
    private BigDecimal companyDebtAmount;

    /**
     *   Ӫҵ���ޣ���
     */
    private Date companyOperateStartDate;

    /**
     *   Ӫҵ���ޣ�ֹ��
     */
    private Date companyOperateEndDate;

    /**
     *   ע���ʱ�
     */
    private BigDecimal companyRegisterAmount;

    /**
     *   �ȼ�����
     */
    private String companyRegisterOrgan;

    /**
     *   ��Ӫ��Χ
     */
    private String companyOperateRange;

    /**
     *   ��ҵ��Ӫ�������
     */
    private String companyOperateFinanceState;

    /**
     *   ��ҵ���������仯���
     */
    private String companyRepayAbilityChange;

    /**
     *   ��ҵ�Ƿ�����0.��1.��
     */
    private Integer companyOverdueStatus;

    /**
     *   ��ҵ�Ƿ�����0.��1.��
     */
    private Integer companyIsInvolve;

    /**
     *   ��ҵ�Ƿ�����������0.��1.��
     */
    private Integer companyIsAdministrativePenalty;

    /**
     *   �Ƿ��ϴ��������֤0.��1.��
     */
    private Integer fileIsUploadCorporationCard;

    /**
     *   �Ƿ��ϴ����񱨱�0.��1.��
     */
    private Integer fileIsUploadFinanceStatement;

    /**
     *   �Ƿ��ϴ�������0.��1.��
     */
    private Integer fileIsUploadGuaranteeLetter;

    /**
     *   �Ƿ��ϴ����ű���0.��1.��
     */
    private Integer fileIsUploadCreditReport;

    /**
     *   ���񱨱�·��
     */
    private String fileFinanceAttach;

    /**
     *   ������·��
     */
    private String fileGuaranteeAttach;

    /**
     *   ���ű���·��
     */
    private String fileCreditAttach;

    /**
     *   �ջ�����
     */
    private String goodsOrderId;

    /**
     *   �ջ��ֿ�
     */
    private String goodsWarehouse;

    /**
     *   �ջ�����
     */
    private Date goodsCollectGoodsDate;

    /**
     *   �ֿ����Ա
     */
    private String goodsGodownKeeper;

    /**
     *   ��Ѻ������ϵ��
     */
    private String goodsContactName;

    /**
     *   ��ϵ�绰
     */
    private String goodsContactMobile;

    /**
     *   ���
     */
    private String goodsSerialNumber;

    /**
     *   ��Ʒ����
     */
    private String goodsName;

    /**
     *   ��Ʒ���
     */
    private String goodsCategory;

    /**
     *   Ʒ��
     */
    private String goodsBrand;

    /**
     *   ���
     */
    private String goodsSpecifications;

    /**
     *   �ͺ�
     */
    private String goodsModel;

    /**
     *   ����������
     */
    private String goodsBarCode;

    /**
     *   ��Ѻ�۸�
     */
    private BigDecimal goodsPrice;

    /**
     *   ����ʱ��
     */
    private Date createTime;

    /**
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber == null ? null : loanNumber.trim();
    }

    public String getLoanCompanyName() {
        return loanCompanyName;
    }

    public void setLoanCompanyName(String loanCompanyName) {
        this.loanCompanyName = loanCompanyName == null ? null : loanCompanyName.trim();
    }

    public String getLoanCompanyIdCard() {
        return loanCompanyIdCard;
    }

    public void setLoanCompanyIdCard(String loanCompanyIdCard) {
        this.loanCompanyIdCard = loanCompanyIdCard == null ? null : loanCompanyIdCard.trim();
    }

    public String getLoanCompanyMobile() {
        return loanCompanyMobile;
    }

    public void setLoanCompanyMobile(String loanCompanyMobile) {
        this.loanCompanyMobile = loanCompanyMobile == null ? null : loanCompanyMobile.trim();
    }

    public String getLoanAgencyId() {
        return loanAgencyId;
    }

    public void setLoanAgencyId(String loanAgencyId) {
        this.loanAgencyId = loanAgencyId == null ? null : loanAgencyId.trim();
    }

    public String getLoanAgencyCode() {
        return loanAgencyCode;
    }

    public void setLoanAgencyCode(String loanAgencyCode) {
        this.loanAgencyCode = loanAgencyCode == null ? null : loanAgencyCode.trim();
    }

    public String getLoanAgencyName() {
        return loanAgencyName;
    }

    public void setLoanAgencyName(String loanAgencyName) {
        this.loanAgencyName = loanAgencyName == null ? null : loanAgencyName.trim();
    }

    public BigDecimal getLoanContractAmt() {
        return loanContractAmt;
    }

    public void setLoanContractAmt(BigDecimal loanContractAmt) {
        this.loanContractAmt = loanContractAmt;
    }

    public BigDecimal getLoanAmt() {
        return loanAmt;
    }

    public void setLoanAmt(BigDecimal loanAmt) {
        this.loanAmt = loanAmt;
    }

    public BigDecimal getLoanYearInterestRate() {
        return loanYearInterestRate;
    }

    public void setLoanYearInterestRate(BigDecimal loanYearInterestRate) {
        this.loanYearInterestRate = loanYearInterestRate;
    }

    public Date getLoanApplyTime() {
        return loanApplyTime;
    }

    public void setLoanApplyTime(Date loanApplyTime) {
        this.loanApplyTime = loanApplyTime;
    }

    public BigDecimal getLoanConsultAmt() {
        return loanConsultAmt;
    }

    public void setLoanConsultAmt(BigDecimal loanConsultAmt) {
        this.loanConsultAmt = loanConsultAmt;
    }

    public Integer getLoanProductType() {
        return loanProductType;
    }

    public void setLoanProductType(Integer loanProductType) {
        this.loanProductType = loanProductType;
    }

    public BigDecimal getLoanGiveQuota() {
        return loanGiveQuota;
    }

    public void setLoanGiveQuota(BigDecimal loanGiveQuota) {
        this.loanGiveQuota = loanGiveQuota;
    }

    public BigDecimal getLoanSurplusQuota() {
        return loanSurplusQuota;
    }

    public void setLoanSurplusQuota(BigDecimal loanSurplusQuota) {
        this.loanSurplusQuota = loanSurplusQuota;
    }

    public String getLoanTitle() {
        return loanTitle;
    }

    public void setLoanTitle(String loanTitle) {
        this.loanTitle = loanTitle == null ? null : loanTitle.trim();
    }

    public Integer getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(Integer loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public Integer getLoanTerms() {
        return loanTerms;
    }

    public void setLoanTerms(Integer loanTerms) {
        this.loanTerms = loanTerms;
    }

    public Integer getLoanNature() {
        return loanNature;
    }

    public void setLoanNature(Integer loanNature) {
        this.loanNature = loanNature;
    }

    public BigDecimal getLoanInterestRate() {
        return loanInterestRate;
    }

    public void setLoanInterestRate(BigDecimal loanInterestRate) {
        this.loanInterestRate = loanInterestRate;
    }

    public BigDecimal getLoanRiskAmt() {
        return loanRiskAmt;
    }

    public void setLoanRiskAmt(BigDecimal loanRiskAmt) {
        this.loanRiskAmt = loanRiskAmt;
    }

    public String getLoanRiskLevel() {
        return loanRiskLevel;
    }

    public void setLoanRiskLevel(String loanRiskLevel) {
        this.loanRiskLevel = loanRiskLevel == null ? null : loanRiskLevel.trim();
    }

    public String getLoanRiskAdvice() {
        return loanRiskAdvice;
    }

    public void setLoanRiskAdvice(String loanRiskAdvice) {
        this.loanRiskAdvice = loanRiskAdvice == null ? null : loanRiskAdvice.trim();
    }

    public BigDecimal getLoanDiscountRate() {
        return loanDiscountRate;
    }

    public void setLoanDiscountRate(BigDecimal loanDiscountRate) {
        this.loanDiscountRate = loanDiscountRate;
    }

    public Date getLoanSuccessTime() {
        return loanSuccessTime;
    }

    public void setLoanSuccessTime(Date loanSuccessTime) {
        this.loanSuccessTime = loanSuccessTime;
    }

    public String getLoanFundUse() {
        return loanFundUse;
    }

    public void setLoanFundUse(String loanFundUse) {
        this.loanFundUse = loanFundUse == null ? null : loanFundUse.trim();
    }

    public BigDecimal getRepayMonthAmount() {
        return repayMonthAmount;
    }

    public void setRepayMonthAmount(BigDecimal repayMonthAmount) {
        this.repayMonthAmount = repayMonthAmount;
    }

    public BigDecimal getRepayMonthPrincipal() {
        return repayMonthPrincipal;
    }

    public void setRepayMonthPrincipal(BigDecimal repayMonthPrincipal) {
        this.repayMonthPrincipal = repayMonthPrincipal;
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType == null ? null : repayType.trim();
    }

    public Date getRepayExpiryTime() {
        return repayExpiryTime;
    }

    public void setRepayExpiryTime(Date repayExpiryTime) {
        this.repayExpiryTime = repayExpiryTime;
    }

    public Integer getRepayPeriod() {
        return repayPeriod;
    }

    public void setRepayPeriod(Integer repayPeriod) {
        this.repayPeriod = repayPeriod;
    }

    public Integer getRepayMonthDate() {
        return repayMonthDate;
    }

    public void setRepayMonthDate(Integer repayMonthDate) {
        this.repayMonthDate = repayMonthDate;
    }

    public Date getRepayFirstDate() {
        return repayFirstDate;
    }

    public void setRepayFirstDate(Date repayFirstDate) {
        this.repayFirstDate = repayFirstDate;
    }

    public Integer getRepayPeriodSurplus() {
        return repayPeriodSurplus;
    }

    public void setRepayPeriodSurplus(Integer repayPeriodSurplus) {
        this.repayPeriodSurplus = repayPeriodSurplus;
    }

    public Integer getRepayIsSettle() {
        return repayIsSettle;
    }

    public void setRepayIsSettle(Integer repayIsSettle) {
        this.repayIsSettle = repayIsSettle;
    }

    public String getBankNum() {
        return bankNum;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum == null ? null : bankNum.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo == null ? null : bankCardNo.trim();
    }

    public String getBankMobile() {
        return bankMobile;
    }

    public void setBankMobile(String bankMobile) {
        this.bankMobile = bankMobile == null ? null : bankMobile.trim();
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

    public String getBankBranchName() {
        return bankBranchName;
    }

    public void setBankBranchName(String bankBranchName) {
        this.bankBranchName = bankBranchName == null ? null : bankBranchName.trim();
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName == null ? null : legalName.trim();
    }

    public String getLegalIdCard() {
        return legalIdCard;
    }

    public void setLegalIdCard(String legalIdCard) {
        this.legalIdCard = legalIdCard == null ? null : legalIdCard.trim();
    }

    public String getLegalMobile() {
        return legalMobile;
    }

    public void setLegalMobile(String legalMobile) {
        this.legalMobile = legalMobile == null ? null : legalMobile.trim();
    }

    public String getLegalCardFace() {
        return legalCardFace;
    }

    public void setLegalCardFace(String legalCardFace) {
        this.legalCardFace = legalCardFace == null ? null : legalCardFace.trim();
    }

    public String getLegalCardBack() {
        return legalCardBack;
    }

    public void setLegalCardBack(String legalCardBack) {
        this.legalCardBack = legalCardBack == null ? null : legalCardBack.trim();
    }

    public String getHandleName() {
        return handleName;
    }

    public void setHandleName(String handleName) {
        this.handleName = handleName == null ? null : handleName.trim();
    }

    public String getHandleIdCard() {
        return handleIdCard;
    }

    public void setHandleIdCard(String handleIdCard) {
        this.handleIdCard = handleIdCard == null ? null : handleIdCard.trim();
    }

    public String getHandleMobile() {
        return handleMobile;
    }

    public void setHandleMobile(String handleMobile) {
        this.handleMobile = handleMobile == null ? null : handleMobile.trim();
    }

    public String getHandleDuty() {
        return handleDuty;
    }

    public void setHandleDuty(String handleDuty) {
        this.handleDuty = handleDuty == null ? null : handleDuty.trim();
    }

    public String getCompanyAssureIdCard() {
        return companyAssureIdCard;
    }

    public void setCompanyAssureIdCard(String companyAssureIdCard) {
        this.companyAssureIdCard = companyAssureIdCard == null ? null : companyAssureIdCard.trim();
    }

    public String getCompanyAssureName() {
        return companyAssureName;
    }

    public void setCompanyAssureName(String companyAssureName) {
        this.companyAssureName = companyAssureName == null ? null : companyAssureName.trim();
    }

    public String getCompanyRiskRank() {
        return companyRiskRank;
    }

    public void setCompanyRiskRank(String companyRiskRank) {
        this.companyRiskRank = companyRiskRank == null ? null : companyRiskRank.trim();
    }

    public Integer getCompanyNature() {
        return companyNature;
    }

    public void setCompanyNature(Integer companyNature) {
        this.companyNature = companyNature;
    }

    public String getCompanyReferProvince() {
        return companyReferProvince;
    }

    public void setCompanyReferProvince(String companyReferProvince) {
        this.companyReferProvince = companyReferProvince == null ? null : companyReferProvince.trim();
    }

    public String getCompanyReferCity() {
        return companyReferCity;
    }

    public void setCompanyReferCity(String companyReferCity) {
        this.companyReferCity = companyReferCity == null ? null : companyReferCity.trim();
    }

    public String getCompanyPlaceProvince() {
        return companyPlaceProvince;
    }

    public void setCompanyPlaceProvince(String companyPlaceProvince) {
        this.companyPlaceProvince = companyPlaceProvince == null ? null : companyPlaceProvince.trim();
    }

    public String getCompanyPlaceCity() {
        return companyPlaceCity;
    }

    public void setCompanyPlaceCity(String companyPlaceCity) {
        this.companyPlaceCity = companyPlaceCity == null ? null : companyPlaceCity.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public Date getCompanyCreateDate() {
        return companyCreateDate;
    }

    public void setCompanyCreateDate(Date companyCreateDate) {
        this.companyCreateDate = companyCreateDate;
    }

    public String getCompanyIndustry() {
        return companyIndustry;
    }

    public void setCompanyIndustry(String companyIndustry) {
        this.companyIndustry = companyIndustry == null ? null : companyIndustry.trim();
    }

    public String getCompanyOperateStatus() {
        return companyOperateStatus;
    }

    public void setCompanyOperateStatus(String companyOperateStatus) {
        this.companyOperateStatus = companyOperateStatus == null ? null : companyOperateStatus.trim();
    }

    public BigDecimal getCompanyYearIncome() {
        return companyYearIncome;
    }

    public void setCompanyYearIncome(BigDecimal companyYearIncome) {
        this.companyYearIncome = companyYearIncome;
    }

    public BigDecimal getCompanyDebtAmount() {
        return companyDebtAmount;
    }

    public void setCompanyDebtAmount(BigDecimal companyDebtAmount) {
        this.companyDebtAmount = companyDebtAmount;
    }

    public Date getCompanyOperateStartDate() {
        return companyOperateStartDate;
    }

    public void setCompanyOperateStartDate(Date companyOperateStartDate) {
        this.companyOperateStartDate = companyOperateStartDate;
    }

    public Date getCompanyOperateEndDate() {
        return companyOperateEndDate;
    }

    public void setCompanyOperateEndDate(Date companyOperateEndDate) {
        this.companyOperateEndDate = companyOperateEndDate;
    }

    public BigDecimal getCompanyRegisterAmount() {
        return companyRegisterAmount;
    }

    public void setCompanyRegisterAmount(BigDecimal companyRegisterAmount) {
        this.companyRegisterAmount = companyRegisterAmount;
    }

    public String getCompanyRegisterOrgan() {
        return companyRegisterOrgan;
    }

    public void setCompanyRegisterOrgan(String companyRegisterOrgan) {
        this.companyRegisterOrgan = companyRegisterOrgan == null ? null : companyRegisterOrgan.trim();
    }

    public String getCompanyOperateRange() {
        return companyOperateRange;
    }

    public void setCompanyOperateRange(String companyOperateRange) {
        this.companyOperateRange = companyOperateRange == null ? null : companyOperateRange.trim();
    }

    public String getCompanyOperateFinanceState() {
        return companyOperateFinanceState;
    }

    public void setCompanyOperateFinanceState(String companyOperateFinanceState) {
        this.companyOperateFinanceState = companyOperateFinanceState == null ? null : companyOperateFinanceState.trim();
    }

    public String getCompanyRepayAbilityChange() {
        return companyRepayAbilityChange;
    }

    public void setCompanyRepayAbilityChange(String companyRepayAbilityChange) {
        this.companyRepayAbilityChange = companyRepayAbilityChange == null ? null : companyRepayAbilityChange.trim();
    }

    public Integer getCompanyOverdueStatus() {
        return companyOverdueStatus;
    }

    public void setCompanyOverdueStatus(Integer companyOverdueStatus) {
        this.companyOverdueStatus = companyOverdueStatus;
    }

    public Integer getCompanyIsInvolve() {
        return companyIsInvolve;
    }

    public void setCompanyIsInvolve(Integer companyIsInvolve) {
        this.companyIsInvolve = companyIsInvolve;
    }

    public Integer getCompanyIsAdministrativePenalty() {
        return companyIsAdministrativePenalty;
    }

    public void setCompanyIsAdministrativePenalty(Integer companyIsAdministrativePenalty) {
        this.companyIsAdministrativePenalty = companyIsAdministrativePenalty;
    }

    public Integer getFileIsUploadCorporationCard() {
        return fileIsUploadCorporationCard;
    }

    public void setFileIsUploadCorporationCard(Integer fileIsUploadCorporationCard) {
        this.fileIsUploadCorporationCard = fileIsUploadCorporationCard;
    }

    public Integer getFileIsUploadFinanceStatement() {
        return fileIsUploadFinanceStatement;
    }

    public void setFileIsUploadFinanceStatement(Integer fileIsUploadFinanceStatement) {
        this.fileIsUploadFinanceStatement = fileIsUploadFinanceStatement;
    }

    public Integer getFileIsUploadGuaranteeLetter() {
        return fileIsUploadGuaranteeLetter;
    }

    public void setFileIsUploadGuaranteeLetter(Integer fileIsUploadGuaranteeLetter) {
        this.fileIsUploadGuaranteeLetter = fileIsUploadGuaranteeLetter;
    }

    public Integer getFileIsUploadCreditReport() {
        return fileIsUploadCreditReport;
    }

    public void setFileIsUploadCreditReport(Integer fileIsUploadCreditReport) {
        this.fileIsUploadCreditReport = fileIsUploadCreditReport;
    }

    public String getFileFinanceAttach() {
        return fileFinanceAttach;
    }

    public void setFileFinanceAttach(String fileFinanceAttach) {
        this.fileFinanceAttach = fileFinanceAttach == null ? null : fileFinanceAttach.trim();
    }

    public String getFileGuaranteeAttach() {
        return fileGuaranteeAttach;
    }

    public void setFileGuaranteeAttach(String fileGuaranteeAttach) {
        this.fileGuaranteeAttach = fileGuaranteeAttach == null ? null : fileGuaranteeAttach.trim();
    }

    public String getFileCreditAttach() {
        return fileCreditAttach;
    }

    public void setFileCreditAttach(String fileCreditAttach) {
        this.fileCreditAttach = fileCreditAttach == null ? null : fileCreditAttach.trim();
    }

    public String getGoodsOrderId() {
        return goodsOrderId;
    }

    public void setGoodsOrderId(String goodsOrderId) {
        this.goodsOrderId = goodsOrderId == null ? null : goodsOrderId.trim();
    }

    public String getGoodsWarehouse() {
        return goodsWarehouse;
    }

    public void setGoodsWarehouse(String goodsWarehouse) {
        this.goodsWarehouse = goodsWarehouse == null ? null : goodsWarehouse.trim();
    }

    public Date getGoodsCollectGoodsDate() {
        return goodsCollectGoodsDate;
    }

    public void setGoodsCollectGoodsDate(Date goodsCollectGoodsDate) {
        this.goodsCollectGoodsDate = goodsCollectGoodsDate;
    }

    public String getGoodsGodownKeeper() {
        return goodsGodownKeeper;
    }

    public void setGoodsGodownKeeper(String goodsGodownKeeper) {
        this.goodsGodownKeeper = goodsGodownKeeper == null ? null : goodsGodownKeeper.trim();
    }

    public String getGoodsContactName() {
        return goodsContactName;
    }

    public void setGoodsContactName(String goodsContactName) {
        this.goodsContactName = goodsContactName == null ? null : goodsContactName.trim();
    }

    public String getGoodsContactMobile() {
        return goodsContactMobile;
    }

    public void setGoodsContactMobile(String goodsContactMobile) {
        this.goodsContactMobile = goodsContactMobile == null ? null : goodsContactMobile.trim();
    }

    public String getGoodsSerialNumber() {
        return goodsSerialNumber;
    }

    public void setGoodsSerialNumber(String goodsSerialNumber) {
        this.goodsSerialNumber = goodsSerialNumber == null ? null : goodsSerialNumber.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory == null ? null : goodsCategory.trim();
    }

    public String getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand) {
        this.goodsBrand = goodsBrand == null ? null : goodsBrand.trim();
    }

    public String getGoodsSpecifications() {
        return goodsSpecifications;
    }

    public void setGoodsSpecifications(String goodsSpecifications) {
        this.goodsSpecifications = goodsSpecifications == null ? null : goodsSpecifications.trim();
    }

    public String getGoodsModel() {
        return goodsModel;
    }

    public void setGoodsModel(String goodsModel) {
        this.goodsModel = goodsModel == null ? null : goodsModel.trim();
    }

    public String getGoodsBarCode() {
        return goodsBarCode;
    }

    public void setGoodsBarCode(String goodsBarCode) {
        this.goodsBarCode = goodsBarCode == null ? null : goodsBarCode.trim();
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}