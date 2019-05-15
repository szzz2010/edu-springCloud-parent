package com.haohao.job.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;

@JobHandler(value = "orderAuditJob")
@Component
public class OrderAuditJob extends IJobHandler{

	private final Logger log = LoggerFactory.getLogger(getClass());

//	@Autowired
//	private OrderAuditTask orderAuditTask;
//
	@Override
    public ReturnT<String> execute(String param) {
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + this.getClass().getSimpleName());
//		orderAuditTask.auditOrder();
        return SUCCESS;
    }
}
