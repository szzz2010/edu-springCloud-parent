package com.haohao.util.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.haohao.modelAndExample.Agency;
import com.haohao.modelAndExample.AgencyMethod;

/**
 * <p>Description：请求学习和三方工具类</p>
 * @date 2018年5月11日 上午11:40:03
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
public class RequestUtil {
	
	private final static Logger log = LoggerFactory.getLogger("RequestUtil.class");
	
	/**
	 * <p>Description：请求学习工具</p>
	 * @date 2018年5月11日 下午3:19:50
	 * @author zhangqiang
	 * @param map
	 * @param method
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> requestXS(Map<String,Object> map,String method) throws Exception {
		JSONObject sendJson = createRequestXsParam(map, method);
		String url = XsConstants.XS_ZC_URL;
		String resultJson = HttpClientUtil.exec(url, "1", "1", sendJson);
		log.info("请求学习接口发送数据,method=【{}】,sendData=[{}],sendJson=[{}],url=【{}】",method,map,sendJson,url);
    	log.info("请求学习接口返回结果,method=【{}】,resultJson=[{}],url=【{}】",method,resultJson,url);
    	if(ObjectUtils.isEmpty(resultJson)||resultJson.contains("[#对方错误#]")){
    		log.info("学习响应错误。");
    	}
    	CommonXsResponse resp = JSON.parseObject(resultJson,CommonXsResponse.class);
		Map<String,Object> resultData = null;
		if(!resp.verifySign()){
			log.info("调用学习接口返回值验签失败,method:"+method);
			log.info("请求学习接口返回结果,method=【{}】,resultJson=[{}],resultData=[{}],url=【{}】",method,resultJson,resultData,url);
			return null;
		}
		resultData = resp.parseContent();
		log.info("解密结果,resultData=[{}]",resultData);
		return resultData;
	}
	
	/**
	 * <p>Description：请求三方工具</p>
	 * @date 2018年5月11日 下午3:20:05
	 * @author zhangqiang
	 * @param map
	 * @param method
	 * @param agency
	 * @param agencyMethod
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> requestThird(Map<String,Object> map,String method,Agency agency,AgencyMethod agencyMethod) throws Exception {
		JSONObject sendJson = createRequestThirdParam(map, method, agency, agencyMethod);
		String url = agencyMethod.getUrl();
		String resultJson = HttpClientUtil.exec(url, "1", "1", sendJson);
		log.info("请求三方接口发送数据,method=【{}】,sendData=[{}],sendJson=[{}],url=【{}】",method,map,sendJson,url);
    	log.info("请求三方接口返回结果,method=【{}】,resultJson=[{}],url=【{}】",method,resultJson,url);
    	if(ObjectUtils.isEmpty(resultJson)||resultJson.contains("[#对方错误#]")){
    		log.info("学习响应错误。");
    	}
    	CommonThirdResponse resp = JSON.parseObject(resultJson,CommonThirdResponse.class);
		Map<String,Object> resultData = null;
		resultData = resp.parseContent(agency.getAesKey());
		log.info("解密结果,resultData=[{}]",resultData);
		return resultData;
	}
	
	private static JSONObject createRequestXsParam(Map<String,Object> map,String method)throws Exception {
		String content = EncryptUtil.encrypt(JSONObject.toJSONString(map),XsConstants.XS_AES_KEY);
        Map<String,String> request = new HashMap<>();
        request.put("appId", XsConstants.XS_APPID);
        request.put("method", method);
        request.put("version", XsConstants.XS_VERSION);
        request.put("content", content);
        request.put("timestamp", DateUtil.dateToString(new Date(), DateUtil.YYYY_MM_DD_HH_MM_SS));
        request.put("sign", EncryptUtil.md5(request,XsConstants.XS_MD5_KEY));
        
        JSONObject params = new JSONObject();
        params.put("appId", request.get("appId"));
        params.put("method", method);
        params.put("version", request.get("version"));
        params.put("sign", request.get("sign"));
        params.put("content", content);
        params.put("timestamp", request.get("timestamp"));
        return params;
	}
	
	
	private static JSONObject createRequestThirdParam(Map<String,Object> map,String method,Agency agency,AgencyMethod agencyMethod)throws Exception {
		String content = EncryptUtil.encrypt(JSONObject.toJSONString(map),agency.getAesKey());
		Map<String,String> request = new HashMap<>();
        request.put("source", agency.getSource());
        request.put("method", method);
        request.put("version", agency.getVersion());
        request.put("content", content);
        request.put("timestamp", DateUtil.dateToString(new Date(), DateUtil.YYYY_MM_DD_HH_MM_SS));
        request.put("sign", EncryptUtil.md5(request,agency.getMd5Key()));
        
        JSONObject params = new JSONObject();
        params.put("source", request.get("source"));
        params.put("method", request.get("method"));
        params.put("version", request.get("version"));
        params.put("sign", request.get("sign"));
        params.put("content", content);
        params.put("timestamp", request.get("timestamp"));
        return params;
	}

}
