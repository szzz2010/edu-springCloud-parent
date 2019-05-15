package com.haohao.util.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * <p>Description：</p>
 * @date 2018年5月10日 下午5:21:48
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
public class CommonThirdResponse {
	private String retCode;
    private String message;
    private String data;
    public CommonThirdResponse() {}
    public CommonThirdResponse(String retCode, String message, String data) {
        this.retCode = retCode;
        this.message = message;
        this.data = data;
    }
    /**
     * 返回失败结果
     * @param respCode
     * @param method
     * @return
     */
    public static CommonThirdResponse createFailed(String message) {
        return new CommonThirdResponse("31001", message, "");
    }
    
    /**
     * 返回成功结果, 此处应该自动计算签名和加密data
     * @param respCode
     * @param method
     * @param data
     * @return
     */
    public static CommonThirdResponse createSuccess(String data,String aesKey) throws Exception {
        return new CommonThirdResponse("21001", "成功访问接口",  EncryptUtil.encrypt(data,aesKey));
    }
    
    /**
     * 解密主报文
     * @return
     * @throws Exception
     */
	public Map<String,Object> parseContent(String aesKey) throws Exception{
        String content = EncryptUtil.decrypt(this.data, aesKey);
        return JSONObject.parseObject(content);
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

}
