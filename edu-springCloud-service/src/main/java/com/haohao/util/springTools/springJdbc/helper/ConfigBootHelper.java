package com.haohao.util.springTools.springJdbc.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration

@PropertySources({

		@PropertySource(value = "classpath:missing.properties", ignoreResourceNotFound = true),

		@PropertySource(value = "classpath:application.properties" , ignoreResourceNotFound = true), 
		@PropertySource(value = "classpath:system/dubbo.properties", ignoreResourceNotFound = true),
		@PropertySource(value = "classpath:system/redis.properties", ignoreResourceNotFound = true),

})
public class ConfigBootHelper implements EnvironmentAware {
	@Autowired
	private static Environment env;

	@Override
	public void setEnvironment(Environment environment) {
		env = environment;
	}

	public static String getPropertyByName(String name) {
		return env.getProperty(name);
	}

}
