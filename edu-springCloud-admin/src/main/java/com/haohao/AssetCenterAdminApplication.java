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
import org.springframework.context.annotation.Configuration;

import com.haohao.util.springTools.springJdbc.helper.ConfigBootHelper;

@SpringBootApplication
@ServletComponentScan
@ComponentScan({"com.haohao"})
@MapperScan({"com.haohao.asset.mapper","com.haohao.permission.mapper","com.haohao.mapper.auto","microservice.qssj.mapper"})
@EntityScan({"com.haohao.asset.entity","com.haohao.permission.model","com.haohao.modelAndExample"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class AssetCenterAdminApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(AssetCenterAdminApplication.class, args);
        System.out.println("****************************************");
        System.out.println(ConfigBootHelper.getPropertyByName("project")+" has been loaded ... ");
        System.out.println("****************************************");
    }
}
