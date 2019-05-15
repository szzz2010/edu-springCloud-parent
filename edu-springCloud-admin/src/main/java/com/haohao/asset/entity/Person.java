package com.haohao.asset.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

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
//@TableName("person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;
    
    /**
     * 借款编号
     */
    private String loanNumber;

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
     * 借款人姓名
     */
    private String loanUserName;

    /**
     * 借款人身份证
     */
    private String loanUserIdCard;

    /**
     * 借款人手机号
     */
    private String loanUserMobile;

    /**
     * 借款服务费
     */
    private BigDecimal loanConsultAmt;

    /**
     * 借款申请时间
     */
    private LocalDateTime loanApplyTime;

    /**
     * 合同金额
     */
    private BigDecimal loanContractAmt;

    /**
     * 放款金额
     */
    private BigDecimal loanAmt;

    /**
     * 1：资金周转
     */
    private Integer loanProductType;

    /**
     * 借款标题
     */
    private String loanTitle;

    /**
     * 借款目的1：资金周转 2：购生活品 3：教育支出 4：旅游 5：购原材料 6：装修家居 7：其他

     */
    private String loanPurpose;

    /**
     * 借款利率
     */
    private BigDecimal loanInterestRate;

    /**
     * 年化利率
     */
    private BigDecimal loanYearInterestRate;

    /**
     * 授信额度
     */
    private BigDecimal loanGiveQuota;

    /**
     * 借款期限
     */
    private Integer loanTerms;

    /**
     * 放款时间
     */
    private LocalDateTime loanSuccessTime;

    /**
     * 风险金金额
     */
    private BigDecimal loanRiskAmt;

    /**
     * 借款风控等级
     */
    private String loanRiskLevel;

    /**
     * 借款风控建议
     */
    private String loanRiskAdvice;

    /**
     * 月还款金额
     */
    private BigDecimal repayMonthAmount;

    /**
     * 月还本金
     */
    private BigDecimal repayMonthPrincipal;

    /**
     * RT01：等额本息；RT02：先息后本；RT03：先息后本2；
     */
    private String repayType;

    /**
     * 还款到期时间
     */
    private LocalDateTime repayExpiryTime;

    /**
     * 还款总期数
     */
    private Integer repayPeriod;

    /**
     * 首次还款日
     */
    private LocalDate repayFirstDate;

    /**
     * 月还款日
     */
    private Integer repayMonthDate;

    /**
     * 剩余还款期数
     */
    private Integer repayPeriodSurplus;

    /**
     * 还款是否结清，0否，1是
     */
    private Integer repayIsSettle;

    /**
     * 银行编号
     */
    private String bankNum;

    /**
     * '放款银行（04135810:广州银行；102:工商银行；103:农业银行；104:中国银行；105:建设银行；301:交通银行；302:中信银行；303:光大银行；304:华夏银行；305:民生银行；306:广发银行；307:深圳发展银行/平安银行；308:招商银行；309:兴业银行；310:浦发银行；403:邮政储蓄银行；）',
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
     * 年龄
     */
    private Integer personAge;

    /**
     * 申请时的出生天数
     */
    private Integer personApplyAgeDays;

    /**
     * 出生日期
     */
    private String personBirthDate;

    /**
     * 1男，0女
     */
    private Integer personGender;

    /**
     * （1：硕士及以上；2：本科；3：专科；4：高中；5：初中及以下；）

     */
    private Integer personEducation;

    /**
     * 身份证有效日期
     */
    private LocalDate personIdPeriod;

    /**
     * 邮箱
     */
    private String personEmail;

    /**
     * （1：未婚；2：已婚；3：离异；4：丧偶；）
     */
    private Integer personMarriage;

    /**
     * （1：有；0：无；）
     */
    private Integer personHasChild;

    /**
     * 户籍地址
     */
    private String personHomeTownAddr;

    /**
     * （1：是；0：否；）
     */
    private Integer personIsApplyHomeTown;

    /**
     * 现居住地址
     */
    private String personLocalAddr;

    /**
     * 来本市年份
     */
    private String personLocalYear;

    /**
     * 申请所在城市
     */
    private String personAppCity;

    /**
     * 借款提交城市
     */
    private String personSubmitCity;

    /**
     * 家人是否知晓
     */
    private Integer personIsFamilyKnow;

    /**
     * 与本人关系1（1父母；2配偶；3兄弟；4姐妹；0未选择）',
     */
    private Integer personRelationFirst;

    /**
     * 第一联系人姓名
     */
    private String personRelationFirstName;

    /**
     * 第一联系人手机号
     */
    private String personRelationFirstMobile;

    /**
     * 与本人关系1（1父母；2配偶；3兄弟；4姐妹；0未选择）',
     */
    private Integer personRelationSecond;

    /**
     * 第二联系人姓名
     */
    private String personRelationSecondName;

    /**
     * 第二联系人 手机
     */
    private String personRelationSecondMobile;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件真实名称
     */
    private String fileRealName;

    /**
     * 文件分类:(C1:个人征信报告，D5：收入证明，E2：工作证明)
     */
    private String fileCategory;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * （1：图片；2：视频；3：HTML页面；4：PDF文件；5：WORD文档；10：其他；）
     */
    private Integer fileType;

    /**
     * 身份证附件是否存在
     */
    private Integer fileIsExistIdCard;

    /**
     * 信用报告是否存在
     */
    private Integer fileIsExistCredit;

    /**
     * 工作证明是否存在
     */
    private Integer fileIsExistJob;

    /**
     * 收入证明是否存在
     */
    private Integer fileIsExistIncome;

    /**
     * 车产证明是否存在
     */
    private Integer fileIsExistCar;

    /**
     * 房产证明是否存在
     */
    private Integer fileIsExistHouse;

    /**
     * 信用卡最高违逾期期数
     */
    private Integer creditOvdHigh;

    /**
     * 信用卡张数
     */
    private Integer creditCardNum;

    /**
     * 信用卡最高额度
     */
    private BigDecimal creditMaxLimit;

    /**
     * 近六个月人行查询次数
     */
    private Integer creditPbocinQuerytimes;

    /**
     * 信用卡是否全额付款  :  0否，1是
     */
    private Integer creditIsPayEntire;

    /**
     * 信贷征信报告是否空白（1：是；0：否；）
     */
    private Integer creditIsAppPbocBlank;

    /**
     * 工作单位名称
     */
    private String jobCompanyName;

    /**
     * 公司性质：（1:机关及事业单位；2:国营；3:民营；4:三资企业；5:其他；6:上市企业；7:外资企业；8:合资企业；9:个体工商户；）
     */
    private Integer jobCompanyProperty;

    /**
     * 公司行业性质
     */
    private String jobCompanyBusinessInfo;

    /**
     * 公司规模
     */
    private String jobCompanyScale;

    /**
     * 公司单位座机
     */
    private String jobCompanyPhoneLine;

    /**
     * 公司详细地址
     */
    private String jobCompnayDetailAddr;

    /**
     * 职业
     */
    private String jobProfession;

    /**
     * 职务（1:高层管理人员；2:次高层管理人员；3:中层管理人员；4:初级管理人员；5:普通员工；）
     */
    private Integer jobDuty;

    /**
     * 参加工作时间
     */
    private LocalDate jobStartDate;

    /**
     * 雇佣类型（10：自雇；20：受薪；）
     */
    private String jobHireType;

    /**
     * 月收入
     */
    private BigDecimal jobMonthlyIncome;

    /**
     * 经营实体名称
     */
    private String bizEntityName;

    /**
     * 行业
     */
    private String bizCompanyIndustry;

    /**
     * 经营场所（1：租用；2：自有房产；3：其他；）
     */
    private Integer bizComAddr;

    /**
     * 经营实体类型（1:独资；2:合伙；3:有限责任公司；4:股份培训学校；5:个体工商户；6:其他；）
     */
    private Integer bizEntiryType;

    /**
     * 注册资本
     */
    private BigDecimal bizRegisterAmt;

    /**
     * 成立日期
     */
    private LocalDate bizFoundDate;

    /**
     * 注册地址
     */
    private String bizRegisterAddr;

    /**
     * 员工数量（1:10人以下；2:10人至50人以下；3:50人至100人以下；4:100人至200人以下；5:200及以上；）
     */
    private Integer bizEmployeeNum;

    /**
     * 融资人持股比例
     */
    private String bizSgiareRatio;

    /**
     * （1：全款房；2：商业按揭房；3：公积金按揭房；）
     */
    private Integer houseType;

    /**
     * 房产所在地
     */
    private String houseAddr;

    /**
     * 房产共有人数
     */
    private Integer houseSharedPeopleNum;

    /**
     * 建筑面积
     */
    private String houseArea;

    /**
     * 购买单价
     */
    private BigDecimal housePrice;

    /**
     * 购买日期
     */
    private LocalDate houseBuyDate;

    /**
     * 房屋产权比例
     */
    private String houseProRightRate;

    /**
     * 住房贷款年限
     */
    private Integer houseLoanYearLimit;

    /**
     * 住房贷款月供
     */
    private BigDecimal houseMonthlyPayment;

    /**
     * 住房贷款余额
     */
    private BigDecimal houseLoanBalance;

    /**
     * 创建时间s
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
