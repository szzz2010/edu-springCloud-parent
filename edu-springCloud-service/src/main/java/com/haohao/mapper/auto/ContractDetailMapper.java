package com.haohao.mapper.auto;

import java.math.BigDecimal;
import java.util.List;

import com.haohao.util.paramAndDto.ContractDetail;
import com.haohao.util.paramAndDto.ContractDetailParam;

/**
 * @Desc 额度包的明细查询Dao
 * 视图 or 关联查询
 * @Author xiekunliang
 * @Date 2018/5/19 17:54
 */
public interface ContractDetailMapper {

    List<ContractDetail> selectContractDetails(ContractDetailParam param);

    BigDecimal countSumContractAmt(String contractCode);
}
