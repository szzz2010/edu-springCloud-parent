package com.haohao.util.paramAndDto;

import org.apache.commons.lang3.StringUtils;

/**
 * @Desc 额度包查询参数
 * @Author xiekunliang
 * @Date 2018/5/16 15:22
 */
public class ContractParam extends PageParam {

    /**
     * 机构名称
     */
    private String source;

    /**
     * 申请状态
     */
    private String status;

    /**
     * 创建时间区间
     */
    private String createBetweenDate;

    /**
     * 申请时间区间
     */
    private String startBetweenDate;

    /**
     * 结束时间区间
     */
    private String invalidBetweenDate;

    /**
     * 额度有效期
     */
    private Integer validDayNum;

    public Long getValidSecond() {
        return validDayNum != null ? validDayNum * 24 * 3600L : null;
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getStartBetweenDate() {
        return StringUtils.isBlank(startBetweenDate) || !startBetweenDate.contains(",")
                ? null : startBetweenDate.split(",");
    }

    public void setStartBetweenDate(String startBetweenDate) {
        this.startBetweenDate = startBetweenDate;
    }

    public String[] getInvalidBetweenDate() {
        return StringUtils.isBlank(invalidBetweenDate) || !invalidBetweenDate.contains(",")
                ? null : invalidBetweenDate.split(",");
    }

    public String[] getCreateBetweenDate() {
        return StringUtils.isBlank(createBetweenDate) || !createBetweenDate.contains(",")
                ? null : createBetweenDate.split(",");
    }

    public void setCreateBetweenDate(String createBetweenDate) {
        this.createBetweenDate = createBetweenDate;
    }

    public void setInvalidBetweenDate(String invalidBetweenDate) {
        this.invalidBetweenDate = invalidBetweenDate;
    }

    public Integer getValidDayNum() {
        return validDayNum;
    }

    public void setValidDayNum(Integer validDayNum) {
        this.validDayNum = validDayNum;
    }
}
