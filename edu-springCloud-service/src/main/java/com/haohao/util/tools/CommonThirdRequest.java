package com.haohao.util.tools;
/**
 * <p>Description：</p>
 * @date 2018年5月10日 上午10:40:36
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
public class CommonThirdRequest {
	private String source;
	private String method;
	private String version;
	private String sign;
    private String content;
    private String timestamp;
    

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
