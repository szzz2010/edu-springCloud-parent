package com.haohao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.haohao.util.springTools.springJdbc.helper.ConfigBootHelper;



@SpringBootApplication
@ComponentScan({"com.haohao"})
@MapperScan({"com.haohao.mapper","microservice.qssj.mapper"})
@EntityScan({"com.haohao.modelAndExample","com.haohao.util.paramAndDto"})
public class AssetCenterJobApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(AssetCenterJobApplication.class, args);
        System.out.println("****************************************");
        System.out.println(ConfigBootHelper.getPropertyByName("project")+" has been loaded ... ");
        System.out.println("****************************************");
    }
}
