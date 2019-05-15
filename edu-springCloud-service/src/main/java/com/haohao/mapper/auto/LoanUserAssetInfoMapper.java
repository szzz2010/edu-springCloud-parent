package com.haohao.mapper.auto;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haohao.modelAndExample.LoanUserAssetInfo;
import com.haohao.modelAndExample.LoanUserAssetInfoExample;

public interface LoanUserAssetInfoMapper {
    long countByExample(LoanUserAssetInfoExample example);

    int deleteByExample(LoanUserAssetInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LoanUserAssetInfo record);

    int insertSelective(LoanUserAssetInfo record);

    List<LoanUserAssetInfo> selectByExample(LoanUserAssetInfoExample example);

    LoanUserAssetInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LoanUserAssetInfo record, @Param("example") LoanUserAssetInfoExample example);

    int updateByExample(@Param("record") LoanUserAssetInfo record, @Param("example") LoanUserAssetInfoExample example);

    int updateByPrimaryKeySelective(LoanUserAssetInfo record);

    int updateByPrimaryKey(LoanUserAssetInfo record);
}