package com.haohao.util;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * <p>Description：校验是否是100整数</p>
 * @date 2018年5月22日 下午8:38:08
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
public class Decimal100Validator implements ConstraintValidator<Decimal100, BigDecimal>{

	@Override
	public void initialize(Decimal100 constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
		if(value == null){
			return true;
		}
		BigDecimal[] results = value.divideAndRemainder(new BigDecimal(100));
		return results[1].compareTo(BigDecimal.ZERO) == 0;
	}

}
