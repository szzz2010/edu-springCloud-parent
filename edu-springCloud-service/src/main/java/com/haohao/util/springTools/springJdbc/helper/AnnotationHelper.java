package com.haohao.util.springTools.springJdbc.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;


import java.lang.annotation.*;
import java.lang.reflect.Method;
/**
 * powered by denshinyou
 */
public class AnnotationHelper {
	private static final Logger log = LoggerFactory.getLogger(AnnotationHelper.class);
	@Documented
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface AnnotationJump{String value () default "";}
	public static Method findAnotationMethod(Class<?> clazz,String value){
		Method[] methods = clazz.getMethods();
		Method myMethod = null;
		for (Method m : methods) {
			AnnotationJump annotation = m.getAnnotation(AnnotationJump.class);
			if (!ObjectUtils.isEmpty(annotation)&&value.equals(annotation.value())) {
				myMethod = m;
				log.info(value+"-->"+m.toString());
				break;
			}
		}
		return myMethod;
	}
	
	
}
