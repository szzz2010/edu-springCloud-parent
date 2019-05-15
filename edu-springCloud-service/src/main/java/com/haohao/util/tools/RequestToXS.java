package com.haohao.util.tools;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.haohao.util.springTools.springJdbc.helper.HttpClientHelper;
import com.haohao.util.springTools.springJdbc.helper.TimeHelper;

public class RequestToXS {

	/** 
     * 日志打印 
     */  
    private static Logger log = LoggerFactory.getLogger("RequestToXS.class");   
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public static Map<String, Object> request(Object content_para, String method_para) {
		String url =        XsConfig.url;
		String appId =      XsConfig.appId;
		String version =    XsConfig.version;
		String xs_md5_key=  XsConfig.xs_md5_key;
		String xs_aes_key=  XsConfig.xs_aes_key;
		// 给请求正文AES加密
		String contentTemp = JSON.toJSONString(content_para);
		String content = "";
		try {
			content = XSEncryptUtil.encrypt(contentTemp,xs_aes_key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String method = method_para;
		String timestamp = TimeHelper.getCurrentTime();
		Map<String, String> inParams = new HashMap<String, String>();
		inParams.put("appId", appId);
		inParams.put("content", content);
		inParams.put("method", method);
		inParams.put("timestamp", timestamp);
		inParams.put("version", version);
		String sign = "";
		try {
			sign = XSEncryptUtil.md5(inParams,xs_md5_key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		inParams.put("sign", sign);
		Map<String, Object> params = new HashMap<String, Object>();
		params.putAll(inParams);
		log.info(">>>>>>>>>>>>>>请求学习content_Temp=[{}],sendJson=[{}],url=[{}]" ,contentTemp,JSON.toJSONString(params),url);
		String result = HttpClientHelper.exec(url, "1", "0", params);
		log.info(">>>>>>>>>>>>>> 请求学习返回数据：resultJson=[{}]",result);
		Map<String, Object> resultMap = null;
		try {
			if(result.contains("[#对方错误#]")){
				return null;
			}
			resultMap = JSON.parseObject(result, Map.class);
		} catch (Exception e1) {
			e1.printStackTrace();
			return null;
		}
		String content_json = (String) resultMap.get("data");
		String content_str = "";
		try {
			content_str =passContent(content_json);
			log.info(">>>>>>>>>>>>>>请求学习解密后的数据：" + content_str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		Map<String, Object> contentMap = JSON.parseObject(content_str, Map.class); 
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("message", (String) resultMap.get("message"));
		returnMap.put("method", (String) resultMap.get("method"));
		returnMap.put("retCode", (String) resultMap.get("retCode"));
		returnMap.put("sign", (String) resultMap.get("sign"));
		returnMap.put("content", contentMap);
		return contentMap;
	}
	
	public static String passContent(String str) throws Exception{
		return XSEncryptUtil.decrypt(str, XsConfig.xs_aes_key);
	}
	
	//构造请求学习h5参数
	public static Map<String,Object> createH5Body(Map<String,Object> params) throws Exception{
		StringBuffer sb = new StringBuffer();
		for (String key : params.keySet()) {
			sb.append(key).append(params.get(key));
		}
		sb.append(XsConfig.xs_md5_key);
		String sign = XSEncryptUtil.md5(sb.toString());
		String data = JSON.toJSONString(params);
		Map<String,Object> returnMap = new HashMap<>();
		returnMap.put("sourceName", XsConfig.xs_source_name);
		returnMap.put("data", data);
		returnMap.put("sign", sign);
		returnMap.put("requestUrl", XsConfig.xs_h5_url);
		log.info("H5构造的参数params=[{}]",returnMap);
		return returnMap;
	}
}
