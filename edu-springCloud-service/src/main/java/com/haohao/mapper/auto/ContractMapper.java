package com.haohao.mapper.auto;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haohao.modelAndExample.Contract;
import com.haohao.modelAndExample.ContractExample;
import com.haohao.util.paramAndDto.ContractParam;

public interface ContractMapper {
    int countByExample(ContractExample example);

    int deleteByExample(ContractExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Contract record);

    int insertSelective(Contract record);

    List<Contract> selectByExample(ContractExample example);

    Contract selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Contract record, @Param("example") ContractExample example);

    int updateByExample(@Param("record") Contract record, @Param("example") ContractExample example);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);

    List<Contract> selectByContractParam(ContractParam param);
    
    int subtractBalance(@Param("contractCode")String contractCode,@Param("subtract")BigDecimal subtract);

    BigDecimal countSumBalance();

}