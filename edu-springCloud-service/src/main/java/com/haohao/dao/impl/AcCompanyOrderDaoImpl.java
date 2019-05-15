package com.haohao.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.haohao.dao.AcCompanyOrderDao;
import com.haohao.mapper.auto.AcCompanyOrderMapper;
import com.haohao.modelAndExample.AcCompanyOrder;
import com.haohao.modelAndExample.AcCompanyOrderExample;

@Repository
public class AcCompanyOrderDaoImpl implements AcCompanyOrderDao{

	@Autowired
	private AcCompanyOrderMapper acCompanyOrderMapper;

	@Override
	public AcCompanyOrder insertSelective(AcCompanyOrder record) {
		int insertSelective = acCompanyOrderMapper.insertSelective(record);
		if(insertSelective>0){
			return record;
		}
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(AcCompanyOrder record) {
		return acCompanyOrderMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public AcCompanyOrder findById(int id) {
		return acCompanyOrderMapper.selectByPrimaryKey(id);
	}

	@Override
	public AcCompanyOrder findByLoanNumber(String loanNumber) {
		AcCompanyOrderExample example = new AcCompanyOrderExample();
		AcCompanyOrderExample.Criteria cc = example.createCriteria();
		cc.andLoanNumberEqualTo(loanNumber);
		List<AcCompanyOrder> list = acCompanyOrderMapper.selectByExample(example);
		return ObjectUtils.isEmpty(list)?null:list.get(0);
	}
	
}
