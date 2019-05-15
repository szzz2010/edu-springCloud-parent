package com.haohao.pojo;

import java.io.Serializable;

public class ResponseBaseBean implements Serializable {

    private static final long serialVersionUID = 6723117009921895541L;

    /**
     * 返回状态码
     */
    private int code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 真实的返回数据的数据模型
     */
    private Object data;

    public ResponseBaseBean() {
    }

    public ResponseBaseBean(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseBaseBean [code=" + code + ", message=" + message + ", data=" + data + "]";
    }

}
