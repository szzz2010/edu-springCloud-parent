package com.haohao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.haohao.util.springTools.springJdbc.helper.ConfigBootHelper;

@SpringBootApplication
@ServletComponentScan
@ComponentScan({"com.haohao"})
@MapperScan({"com.haohao.mapper","microservice.qssj.mapper"})
@EntityScan({"com.haohao.modelAndExample"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class AssetCenterApiApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(AssetCenterApiApplication.class, args);
        System.out.println("****************************************");
        System.out.println(ConfigBootHelper.getPropertyByName("project")+" has been loaded ... ");
        System.out.println("****************************************");
    }
}








