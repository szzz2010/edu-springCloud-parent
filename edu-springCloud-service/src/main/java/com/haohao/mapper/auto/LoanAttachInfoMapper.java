package com.haohao.mapper.auto;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haohao.modelAndExample.LoanAttachInfo;
import com.haohao.modelAndExample.LoanAttachInfoExample;

public interface LoanAttachInfoMapper {
    long countByExample(LoanAttachInfoExample example);

    int deleteByExample(LoanAttachInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LoanAttachInfo record);

    int insertSelective(LoanAttachInfo record);

    List<LoanAttachInfo> selectByExample(LoanAttachInfoExample example);

    LoanAttachInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LoanAttachInfo record, @Param("example") LoanAttachInfoExample example);

    int updateByExample(@Param("record") LoanAttachInfo record, @Param("example") LoanAttachInfoExample example);

    int updateByPrimaryKeySelective(LoanAttachInfo record);

    int updateByPrimaryKey(LoanAttachInfo record);
}