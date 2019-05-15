package com.haohao.util.paramAndDto;

import org.apache.commons.lang3.StringUtils;

/**
 * @Desc 查询额度明细
 * @Author xiekunliang
 * @Date 2018/5/19 17:33
 */
public class ContractDetailParam extends PageParam {

    /**
     * 额度包编号
     */
    private String contractCode;

    /**
     * 借款编号
     */
    private String loanNumber;

    /**
     * 借款人姓名
     * 姓名字段在数据库是加密的
     * 无法模糊查询
     */
    private String loanUserName;

    /**
     * 使用时间
     */
    private String createBetweenTime;

    public String[] getCreateBetweenTime() {
        if (StringUtils.isNotBlank(createBetweenTime) && createBetweenTime.contains(",")) {
            return createBetweenTime.split(",");
        }
        return null;
    }

    public void setCreateBetweenTime(String createBetweenTime) {
        this.createBetweenTime = createBetweenTime;
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

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }
}
