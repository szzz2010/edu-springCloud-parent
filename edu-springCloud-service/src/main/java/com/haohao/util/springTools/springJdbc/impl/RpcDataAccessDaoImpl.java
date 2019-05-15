package com.haohao.util.springTools.springJdbc.impl;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.haohao.util.springTools.springJdbc.RpcDataAccessDao;
import com.haohao.util.springTools.springJdbc.SpringJdbcDeployVersion;

/**
 * powered by denshinyou
 * 
 * @ if you want to deploy interface to register center
 * whether there are parent subclasses or inheritance relationships 
 * i strongly recomment you to use annotation Component 
 * in stead of Repository which will cause errors and ultimately leads to failure.
 * 
 * 
 * tough the life ,fuck the reality , free the mind
 * 
 * This component will allow you to penetrate RPC interaction 
 * and go directly to the data center at any time and anywhere .
 * 
 * @Component(RpcDataAccessDaoImpl.beanName)
 * @Service(version = "1.0.0")
 */
@Component(RpcDataAccessDaoImpl.beanName)
@Service
public class RpcDataAccessDaoImpl extends MysqlSpringJdbcDaoImpl implements RpcDataAccessDao{
    private static final long serialVersionUID = -9123985173874091840L;
    public static final String beanName = "rpcDataAccessDao"+SpringJdbcDeployVersion.deployVersion;
}
