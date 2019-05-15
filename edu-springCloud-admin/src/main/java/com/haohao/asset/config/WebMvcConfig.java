package com.haohao.asset.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.haohao.asset.interceptor.ErrorPageInterceptor;
import com.haohao.asset.interceptor.LogInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home/init").setViewName("home/init");
	}


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		//将静态资源文件  放在 webapp下
		
//		  registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		  
		  
		  
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ErrorPageInterceptor())
				.addPathPatterns("/**")
		        .excludePathPatterns("/static/**");
		registry.addInterceptor(new LogInterceptor())
				.addPathPatterns("/**")
		        .excludePathPatterns("/static/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
		registry.viewResolver(viewResolver);
	}

}
