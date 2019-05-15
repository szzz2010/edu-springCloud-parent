package com.haohao.job.xs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.haohao.service.xs.AssetsDockingService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;

@JobHandler(value = "autoDeployOrder")
@Component
public class AutoDeployOrder extends IJobHandler{
	
	@Autowired
	AssetsDockingService assetsDockingService;
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
    public ReturnT<String> execute(String param) throws Exception {
		log.info("================>开始自动进件");
        assetsDockingService.autoDeployOrder();
        return SUCCESS;
    }
	
	
}