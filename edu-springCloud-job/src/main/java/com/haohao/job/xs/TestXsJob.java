package com.haohao.job.xs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.haohao.service.xs.AssetsDockingService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;

@JobHandler(value = "testXsJob")
@Component
public class TestXsJob extends IJobHandler{
	
	@Autowired
	AssetsDockingService assetsDockingService;
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * 测试注册中心
	 * http://xxljob.tt.sanwenqian.cn/jobinfo  
	 * 
	 */
	
	
	@Override
    public ReturnT<String> execute(String param) throws Exception {
		log.info("================>this is a test method !");
        return SUCCESS;
    }
	
	
}
