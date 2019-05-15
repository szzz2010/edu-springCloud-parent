package com.haohao.util.springTools.springJdbc.helper;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/**
 * powered by denshinyou
 */
public class ConfigHelper extends PropertyPlaceholderConfigurer {

	private static Map<String, String> propertiesMap;

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		propertiesMap = new HashMap<String, String>();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			propertiesMap.put(keyStr, value);
		}
	}

	public static String getPropertyByName(String name) {
		return propertiesMap.get(name);
	}
}