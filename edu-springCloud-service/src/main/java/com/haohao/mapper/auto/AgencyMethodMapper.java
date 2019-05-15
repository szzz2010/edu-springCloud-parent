package com.haohao.mapper.auto;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haohao.modelAndExample.AgencyMethod;
import com.haohao.modelAndExample.AgencyMethodExample;
import com.haohao.util.paramAndDto.AgencyMethodParam;

public interface AgencyMethodMapper {
    long countByExample(AgencyMethodExample example);

    int deleteByExample(AgencyMethodExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AgencyMethod record);

    int insertSelective(AgencyMethod record);

    List<AgencyMethod> selectByExample(AgencyMethodExample example);

    AgencyMethod selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AgencyMethod record, @Param("example") AgencyMethodExample example);

    int updateByExample(@Param("record") AgencyMethod record, @Param("example") AgencyMethodExample example);

    int updateByPrimaryKeySelective(AgencyMethod record);

    int updateByPrimaryKey(AgencyMethod record);
    
    
    List<AgencyMethod> selectAgenciesByParam(AgencyMethodParam param);
}