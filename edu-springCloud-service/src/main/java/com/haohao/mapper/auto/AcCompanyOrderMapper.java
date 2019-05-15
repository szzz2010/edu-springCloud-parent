package com.haohao.mapper.auto;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.haohao.modelAndExample.AcCompanyOrder;
import com.haohao.modelAndExample.AcCompanyOrderExample;

public interface AcCompanyOrderMapper {
    long countByExample(AcCompanyOrderExample example);

    int deleteByExample(AcCompanyOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcCompanyOrder record);

    int insertSelective(AcCompanyOrder record);

    List<AcCompanyOrder> selectByExample(AcCompanyOrderExample example);

    AcCompanyOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcCompanyOrder record, @Param("example") AcCompanyOrderExample example);

    int updateByExample(@Param("record") AcCompanyOrder record, @Param("example") AcCompanyOrderExample example);

    int updateByPrimaryKeySelective(AcCompanyOrder record);

    int updateByPrimaryKey(AcCompanyOrder record);
}