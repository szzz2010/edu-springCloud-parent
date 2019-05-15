package com.haohao.asset.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * 加载属性文件的值
 * @author xueyx
 *
 */
@Configuration
@PropertySource(value = { "classpath:config/value.properties" }, ignoreResourceNotFound = true, encoding = "utf-8")
public class PropertyLoader {
//	@Bean  //通配符使用以下方法。
//    public static PropertySourcesPlaceholderConfigurer getPropertyPlaceholderConfigurer() 
//              throws IOException { 
//          PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer(); 
//          ppc.setLocations(new PathMatchingResourcePatternResolver().getResources("classpath:config/*.properties")); 
//          return ppc; 
//    } 
}
