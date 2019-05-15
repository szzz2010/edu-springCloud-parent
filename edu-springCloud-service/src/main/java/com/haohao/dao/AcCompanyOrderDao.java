package com.haohao.dao;

import com.haohao.modelAndExample.AcCompanyOrder;

public interface AcCompanyOrderDao {

	AcCompanyOrder insertSelective(AcCompanyOrder record);

	int updateByPrimaryKeySelective(AcCompanyOrder record);

	AcCompanyOrder findById(int id);

	AcCompanyOrder findByLoanNumber(String loanNumber);

}
