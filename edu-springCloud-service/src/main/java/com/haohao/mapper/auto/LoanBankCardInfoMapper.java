package com.haohao.mapper.auto;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haohao.modelAndExample.LoanBankCardInfo;
import com.haohao.modelAndExample.LoanBankCardInfoExample;

public interface LoanBankCardInfoMapper {
    long countByExample(LoanBankCardInfoExample example);

    int deleteByExample(LoanBankCardInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LoanBankCardInfo record);

    int insertSelective(LoanBankCardInfo record);

    List<LoanBankCardInfo> selectByExample(LoanBankCardInfoExample example);

    LoanBankCardInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LoanBankCardInfo record, @Param("example") LoanBankCardInfoExample example);

    int updateByExample(@Param("record") LoanBankCardInfo record, @Param("example") LoanBankCardInfoExample example);

    int updateByPrimaryKeySelective(LoanBankCardInfo record);

    int updateByPrimaryKey(LoanBankCardInfo record);
}