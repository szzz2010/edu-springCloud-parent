package com.haohao.util.paramAndDto;


/**
 * @author rienniu
 * @version 2018年1月23日 上午10:50:01
 *          对外接口返回参数类型
 */
public class ResponseMsg {
    private String code;
    private String msg;
    private Object data;

    public ResponseMsg() {
    }


    public ResponseMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseMsg(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseMsg getResponseMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public static ResponseMsg build(String code, String msg, Object data) {
        return new ResponseMsg(code, msg, data);
    }

    public static ResponseMsg build(String code, String msg) {
        return build(code, msg, null);
    }

    //getters and setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
