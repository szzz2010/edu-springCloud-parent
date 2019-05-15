package com.haohao.mapper.auto;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haohao.modelAndExample.RiskExtraInfo;
import com.haohao.modelAndExample.RiskExtraInfoExample;

public interface RiskExtraInfoMapper {
    long countByExample(RiskExtraInfoExample example);

    int deleteByExample(RiskExtraInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RiskExtraInfo record);

    int insertSelective(RiskExtraInfo record);

    List<RiskExtraInfo> selectByExample(RiskExtraInfoExample example);

    RiskExtraInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RiskExtraInfo record, @Param("example") RiskExtraInfoExample example);

    int updateByExample(@Param("record") RiskExtraInfo record, @Param("example") RiskExtraInfoExample example);

    int updateByPrimaryKeySelective(RiskExtraInfo record);

    int updateByPrimaryKey(RiskExtraInfo record);
}