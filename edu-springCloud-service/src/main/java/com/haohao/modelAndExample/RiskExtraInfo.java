package com.haohao.modelAndExample;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class RiskExtraInfo {
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
     *   认证类型(1：淘宝，2：支付宝，3：社保，4：公积金，5：信用卡，6：邮箱，7：语音认证，8：京东)
     */
    @NotBlank(message="认证类型[authType]不能为空")
//    @Pattern(regexp = "[12345678]", message = "认证类型[authType]格式不正确") 
    private String authType;

    /**
     *   运营商是否实名认证（0：否 1：是）
     */
    @NotBlank(message="运营商是否实名认证[mobileAuthStatus]不能为空")
    @Pattern(regexp = "[01]", message = "运营商是否实名认证[mobileAuthStatus]格式不正确") 
    private String mobileAuthStatus;

    /**
     *   手机在网时长，单位天
     */
    @NotNull(message="手机在网时长[netDuration]不能为空")
    @Min(value = 0,message="手机在网时长[netDuration]格式不正确")
    private Integer netDuration;

    /**
     *   淘宝订单个数
     */
    @NotNull(message="淘宝订单个数[orderNum]不能为空")
    @Min(value = 0,message="淘宝订单个数[orderNum]格式不正确")
    private Integer orderNum;

    /**
     *   淘宝收货地址个数
     */
    @NotNull(message="淘宝收货地址个数[orderAddressNum]不能为空")
    @Min(value = 0,message="淘宝收货地址个数[orderAddressNum]格式不正确")
    private Integer orderAddressNum;

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

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType == null ? null : authType.trim();
    }

    public String getMobileAuthStatus() {
        return mobileAuthStatus;
    }

    public void setMobileAuthStatus(String mobileAuthStatus) {
        this.mobileAuthStatus = mobileAuthStatus == null ? null : mobileAuthStatus.trim();
    }

    public Integer getNetDuration() {
        return netDuration;
    }

    public void setNetDuration(Integer netDuration) {
        this.netDuration = netDuration;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getOrderAddressNum() {
        return orderAddressNum;
    }

    public void setOrderAddressNum(Integer orderAddressNum) {
        this.orderAddressNum = orderAddressNum;
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