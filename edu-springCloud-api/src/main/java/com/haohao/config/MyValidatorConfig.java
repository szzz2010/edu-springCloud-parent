package com.haohao.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Configuration
public class MyValidatorConfig {

    /**
     * MethodValidationPostProcessor 实现对Controller中单个参数的校验
     * 注意:需要在Controller类上加@Validated注解,方法和参数无效
     *
     * @return
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        /**默认是普通模式，会返回所有的验证不通过信息集合*/
        return new MethodValidationPostProcessor();
    }

    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                //true:快速失败返回模式;false:普通模式
                .addProperty("hibernate.validator.fail_fast", "false")
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        return validator;
    }
}
