package com.haohao.pojo;

/**
 * @author rienchou
 * @Description:
 * @date 2018/9/19 17:23
 */
public class HttpCode {
    /** 成功 **/
    public final static int SUCCESS = 200;
    /** 失败 **/
    public final static int FAIL = 201;
    /** 参数错误 **/
    public final static int PARA_ERR = 202;


    /** 未完善企业信息 **/
    public final static int COMPANY_EMPTY = 300;
    /** 已经完善企业信息 **/
    public final static int COMPANY_EXIT = 301;
    /** 企业不存在 **/
    public final static int COMPANY_NULL = 302;
    /** session过期 **/
    public final static int SESSION_TIMEOUT = 303;
    /** 尚未开户 **/
    public final static int UN_OPEN_ACCOUNT = 304;
}
