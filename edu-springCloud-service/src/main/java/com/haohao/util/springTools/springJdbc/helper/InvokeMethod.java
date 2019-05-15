package com.haohao.util.springTools.springJdbc.helper;

import java.lang.reflect.Method;
/**
 * powered by denshinyou
 */
public class InvokeMethod {
	
	public static Object invoke(String cm,Class<?>[] classes, Object... args) throws Exception {
		String[] split = cm.split("#");
		Class<?> onwClass = Class.forName(split[0]);
		Method method = onwClass.getDeclaredMethod(split[1], classes);
		method.setAccessible(true);
		return method.invoke(onwClass.newInstance(), args);
	}
	
}
