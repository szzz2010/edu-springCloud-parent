package com.haohao.controller.asset;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.haohao.constant.XSMethodTemplate;
import com.haohao.service.xs.AssetInterface;
import com.haohao.util.service.CommonXsResponse;
import com.haohao.util.service.DateUtil;
import com.haohao.util.service.EncryptUtil;
import com.haohao.util.service.XsConstants;
import com.haohao.util.springTools.springJdbc.helper.HttpServletLogAspect.PrintLog;
import com.haohao.util.tools.CommonXsRequest;

/**
 * <p>Description：学习调用通用接口</p>
 * @date 2018年5月10日 上午10:42:03
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Controller
public class CommonRequestFromXsController implements ApplicationContextAware{
	private final static Logger log = LoggerFactory.getLogger(CommonRequestFromXsController.class);
	private ApplicationContext applicationContext;
	private static int TIME = 600;
	private static Map<String, String> method = new HashMap<String,String>(){
		private static final long serialVersionUID = 1L;
	{
		put(XSMethodTemplate.LOAN_ATTACH_SEARCH, "loanAttachSearch");
		put(XSMethodTemplate.LOAN_RESULT_NOTICE, "loanResultNotice");
		put(XSMethodTemplate.LOAN_AUDIT_RESULT, "loanAuditResult");
        
    }};
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/api/xs/commonRequest",method = RequestMethod.POST)
    @ResponseBody
    @PrintLog
	public Object commonRequest(@ModelAttribute CommonXsRequest request) {
		//1,验证商户号
    	if(!XsConstants.XS_APPID.equals(request.getAppId())){
    		return CommonXsResponse.createFailed(request.getMethod(), "商户不存在");
    	}
    	//2,验证版本号
    	if(!XsConstants.XS_VERSION.equals(request.getVersion())){
    		return CommonXsResponse.createFailed(request.getMethod(), "协议版本不支持");
    	}
    	//3,验证方法名
    	if(method.get(request.getMethod()) == null){
    		return CommonXsResponse.createFailed(request.getMethod(), "没有对应接口");
    	}
    	//验证服务器时间
    	try {
			int requestTime = DateUtil.getUnixTimeStamp(request.getTimestamp(), DateUtil.YYYY_MM_DD_HH_MM_SS);
			int now = (int)(System.currentTimeMillis()/1000);
			int cha = now - requestTime;
			if(Math.abs(cha) > TIME){
				return CommonXsResponse.createFailed(request.getMethod(), "客户端与服务端时间不一致");
			}
		} catch (Exception e1) {
			log.error("请求时间格式不正确", e1);
			return CommonXsResponse.createFailed(request.getMethod(), "时间格式[timestamp]格式不正确");
		}
    	try {
			//4,签名验证
			if(!request.getSign().equals(EncryptUtil.md5(objectToMap(request),XsConstants.XS_MD5_KEY))){
				return CommonXsResponse.createFailed(request.getMethod(), "签名验证不通过");
			}
			//5,解密请求主体
            String content = EncryptUtil.decrypt(request.getContent(), XsConstants.XS_AES_KEY);
            log.info("学习请求的解密参数content = {}",content);
            Map<String, Object> reqMap = JSON.parseObject(content, Map.class);
            //6,执行对应的接口 && 获得返回结果
            Map<String, Object> respMap = ((AssetInterface) applicationContext.getBean(method.get(request.getMethod()))).execution(reqMap);
            //7,封装响应报文 && 加密响应主体
            log.info("返回学习的数据参数  respMap = {}",respMap);
            return CommonXsResponse.createSuccess(request.getMethod(), request.getSign(), JSON.toJSONString(respMap));
		}catch (Exception e) {
			log.error("学习请求系统出现异常", e);
			return CommonXsResponse.createFailed(request.getMethod(), "请求出现异常");
		}
	}
	private static Map<String, String> objectToMap(Object obj) throws Exception{
        if (obj == null)
            return null;
        Map<String,String> map = BeanUtils.describe(obj);
        map.remove("class");
        map.remove("sign");
        return map;
    }
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
