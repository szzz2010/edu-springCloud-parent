package com.haohao.util.service;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.validator.HibernateValidator;
/**
 * <p>Description：</p>
 * @date 2018年5月16日 上午10:57:59
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
public class ValidationUtils {
	
	/**
     * 使用hibernate的注解来进行验证
     * 
     */
    private static Validator validator = Validation
            .byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();

    /**
     * 功能描述: <br>
     * 〈注解验证参数〉
     *
     * @param obj
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static <T> String validate(T obj) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        for (ConstraintViolation<T> constraintViolation : constraintViolations) {
        	return constraintViolation.getMessage();//抛出一个错误提示
		}
        return null;
    }

}
