package com.haohao.util.service;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * <p>Description：学习请求系统返回值和系统请求学习返回值</p>
 * @date 2018年2月27日 下午3:42:07
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2017 sanwenqian
 */
public class CommonXsResponse {
	 	private String retCode;
	    private String message;
	    private String method;
	    private String sign;
	    private String data;
	    public CommonXsResponse() {}

	    public CommonXsResponse(String retCode, String message, String method, String sign, String data) {
	        this.retCode = retCode;
	        this.message = message;
	        this.method = method;
	        this.sign = sign;
	        this.data = data;
	    }


	    /**
	     * 返回失败结果
	     * @param respCode
	     * @param method
	     * @return
	     */
	    public static CommonXsResponse createFailed(String method,String message) {
	        return new CommonXsResponse("41002", message, method, "", "");
	    }

	    /**
	     * 返回成功结果, 此处应该自动计算签名和加密data
	     * @param respCode
	     * @param method
	     * @param data
	     * @return
	     */
	    public static CommonXsResponse createSuccess(String method,String sign, String data) throws Exception {
	        return new CommonXsResponse("21001", "成功访问接口", method, sign, EncryptUtil.encrypt(data,XsConstants.XS_AES_KEY));
	    }

	    public boolean verifySign() throws Exception {
	        return this.sign.equals(EncryptUtil.md5(objectToMap(this),XsConstants.XS_MD5_KEY));
	    }

	    /**
	     * 解密主报文
	     * @return
	     * @throws Exception
	     */
		public Map<String,Object> parseContent() throws Exception{
	        String content = EncryptUtil.decrypt(this.data, XsConstants.XS_AES_KEY);
	        return JSONObject.parseObject(content);
	    }


	    private static Map<String, String> objectToMap(Object obj) throws Exception{
	        if (obj == null)
	            return null;
			Map<String,String> map = BeanUtils.describe(obj);
	        map.remove("class");
	        map.remove("sign");
	        return map;
	    }

	    public String getRetCode() {
	        return retCode;
	    }

	    public void setRetCode(String retCode) {
	        this.retCode = retCode;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	    public String getMethod() {
	        return method;
	    }

	    public void setMethod(String method) {
	        this.method = method;
	    }

	    public String getSign() {
	        return sign;
	    }

	    public void setSign(String sign) {
	        this.sign = sign;
	    }

	    public String getData() {
	        return data;
	    }

	    public void setData(String data) {
	        this.data = data;
	    }
}
