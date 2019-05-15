package com.haohao.job.xs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.haohao.service.xs.AssetsDockingService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;

@JobHandler(value = "searchLoanResult")
@Component
public class SearchLoanResult extends IJobHandler{
	
	@Autowired
	AssetsDockingService assetsDockingService;
	
	private static final Logger log = LoggerFactory.getLogger("TestXsJob.class");
	
	@Override
    public ReturnT<String> execute(String param) throws Exception {
		log.info("================>查询放款结果");//0 */5 * * * ?
        assetsDockingService.searchLoanResult();
        return SUCCESS;
    }
	
	
}
