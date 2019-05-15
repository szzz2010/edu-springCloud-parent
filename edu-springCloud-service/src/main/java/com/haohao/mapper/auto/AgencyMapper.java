package com.haohao.mapper.auto;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haohao.modelAndExample.Agency;
import com.haohao.modelAndExample.AgencyExample;
import com.haohao.util.paramAndDto.AgencyParam;

public interface AgencyMapper {
    long countByExample(AgencyExample example);

    int deleteByExample(AgencyExample example);

    int deleteByPrimaryKey(String source);

    int insert(Agency record);

    int insertSelective(Agency record);

    List<Agency> selectByExample(AgencyExample example);

    Agency selectByPrimaryKey(String source);

    int updateByExampleSelective(@Param("record") Agency record, @Param("example") AgencyExample example);

    int updateByExample(@Param("record") Agency record, @Param("example") AgencyExample example);

    int updateByPrimaryKeySelective(Agency record);

    int updateByPrimaryKey(Agency record);
    
    List<Agency> selectAgenciesByParam(AgencyParam param);
}