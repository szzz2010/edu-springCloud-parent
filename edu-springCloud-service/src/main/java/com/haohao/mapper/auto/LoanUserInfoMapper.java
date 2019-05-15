package com.haohao.mapper.auto;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haohao.modelAndExample.LoanUserInfo;
import com.haohao.modelAndExample.LoanUserInfoExample;

public interface LoanUserInfoMapper {
    long countByExample(LoanUserInfoExample example);

    int deleteByExample(LoanUserInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LoanUserInfo record);

    int insertSelective(LoanUserInfo record);

    List<LoanUserInfo> selectByExample(LoanUserInfoExample example);

    LoanUserInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LoanUserInfo record, @Param("example") LoanUserInfoExample example);

    int updateByExample(@Param("record") LoanUserInfo record, @Param("example") LoanUserInfoExample example);

    int updateByPrimaryKeySelective(LoanUserInfo record);

    int updateByPrimaryKey(LoanUserInfo record);
}