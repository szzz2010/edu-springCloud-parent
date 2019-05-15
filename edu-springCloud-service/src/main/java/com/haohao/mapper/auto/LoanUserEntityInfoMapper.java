package com.haohao.mapper.auto;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haohao.modelAndExample.LoanUserEntityInfo;
import com.haohao.modelAndExample.LoanUserEntityInfoExample;

public interface LoanUserEntityInfoMapper {
    long countByExample(LoanUserEntityInfoExample example);

    int deleteByExample(LoanUserEntityInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LoanUserEntityInfo record);

    int insertSelective(LoanUserEntityInfo record);

    List<LoanUserEntityInfo> selectByExample(LoanUserEntityInfoExample example);

    LoanUserEntityInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LoanUserEntityInfo record, @Param("example") LoanUserEntityInfoExample example);

    int updateByExample(@Param("record") LoanUserEntityInfo record, @Param("example") LoanUserEntityInfoExample example);

    int updateByPrimaryKeySelective(LoanUserEntityInfo record);

    int updateByPrimaryKey(LoanUserEntityInfo record);
}