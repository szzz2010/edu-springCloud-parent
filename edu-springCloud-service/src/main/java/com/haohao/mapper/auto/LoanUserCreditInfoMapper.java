package com.haohao.mapper.auto;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haohao.modelAndExample.LoanUserCreditInfo;
import com.haohao.modelAndExample.LoanUserCreditInfoExample;

public interface LoanUserCreditInfoMapper {
    long countByExample(LoanUserCreditInfoExample example);

    int deleteByExample(LoanUserCreditInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LoanUserCreditInfo record);

    int insertSelective(LoanUserCreditInfo record);

    List<LoanUserCreditInfo> selectByExample(LoanUserCreditInfoExample example);

    LoanUserCreditInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LoanUserCreditInfo record, @Param("example") LoanUserCreditInfoExample example);

    int updateByExample(@Param("record") LoanUserCreditInfo record, @Param("example") LoanUserCreditInfoExample example);

    int updateByPrimaryKeySelective(LoanUserCreditInfo record);

    int updateByPrimaryKey(LoanUserCreditInfo record);
}