package com.haohao.util;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * <p>Description：校验100倍数</p>
 * @date 2018年5月22日 下午8:29:48
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {Decimal100Validator.class})
public @interface Decimal100 {
	
	String message() default "{javax.validation.constraints.Not100.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default {};
	
	
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		Decimal100[] value();
	}

}
