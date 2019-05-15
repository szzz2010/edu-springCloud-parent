package com.haohao.mapper.auto;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haohao.modelAndExample.LoanOrderInfo;
import com.haohao.modelAndExample.LoanOrderInfoExample;
import com.haohao.util.paramAndDto.LoanOrderInfoParam;

public interface LoanOrderInfoMapper {
    long countByExample(LoanOrderInfoExample example);

    int deleteByExample(LoanOrderInfoExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(LoanOrderInfo record);

    int insertSelective(LoanOrderInfo record);

    List<LoanOrderInfo> selectByExample(LoanOrderInfoExample example);

    LoanOrderInfo selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") LoanOrderInfo record, @Param("example") LoanOrderInfoExample example);

    int updateByExample(@Param("record") LoanOrderInfo record, @Param("example") LoanOrderInfoExample example);

    int updateByPrimaryKeySelective(LoanOrderInfo record);

    int updateByPrimaryKey(LoanOrderInfo record);
    
    List<LoanOrderInfo> selectByOrderParam(LoanOrderInfoParam param);

}