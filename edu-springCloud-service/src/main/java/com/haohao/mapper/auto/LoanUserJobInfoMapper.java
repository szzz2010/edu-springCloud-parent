package com.haohao.mapper.auto;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haohao.modelAndExample.LoanUserJobInfo;
import com.haohao.modelAndExample.LoanUserJobInfoExample;

public interface LoanUserJobInfoMapper {
    long countByExample(LoanUserJobInfoExample example);

    int deleteByExample(LoanUserJobInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LoanUserJobInfo record);

    int insertSelective(LoanUserJobInfo record);

    List<LoanUserJobInfo> selectByExample(LoanUserJobInfoExample example);

    LoanUserJobInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LoanUserJobInfo record, @Param("example") LoanUserJobInfoExample example);

    int updateByExample(@Param("record") LoanUserJobInfo record, @Param("example") LoanUserJobInfoExample example);

    int updateByPrimaryKeySelective(LoanUserJobInfo record);

    int updateByPrimaryKey(LoanUserJobInfo record);
}