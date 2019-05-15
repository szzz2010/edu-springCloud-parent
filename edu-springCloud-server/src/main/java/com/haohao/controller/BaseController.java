package com.haohao.controller;

import com.alibaba.fastjson.JSON;
import com.haohao.pojo.HttpCode;
import com.haohao.pojo.ResponseBaseBean;

import org.apache.commons.collections4.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected static final String SESSION_MOBILE_KEY = "session_mobile_key";

    @Autowired
    private Validator validator;
    private HttpServletRequest request;
    private HttpServletResponse response;

    /**
     * 表单校验
     *
     * @param object
     * @return
     */
    protected ResponseBaseBean validParas(Object object) {
        Set<ConstraintViolation<Object>> validate = validator.validate(object);
        if (null != validate && validate.size() > 0) {
            Map<String, String> paraResMap = new HashedMap(4);
            for (ConstraintViolation<Object> model : validate) {
                paraResMap.put(model.getPropertyPath().toString(), model.getMessage());
            }
            logger.error("请求参数错误,errMsg:{}", JSON.toJSONString(paraResMap));
            return responseBean(paraResMap, HttpCode.PARA_ERR, "参数校验失败");
        }
        return null;
    }

    protected final <T> ResponseBaseBean responseBean(final T entity, final int code, String msg) {
        return new ResponseBaseBean(code, msg, entity);
    }

    protected final <T> ResponseBaseBean responseBean(final int code, String msg) {
        return new ResponseBaseBean(code, msg, null);
    }

    protected final <T> ResponseBaseBean responseBean(final int code, Object data, String msg) {
        return new ResponseBaseBean(code, msg, data);
    }

    /**
     * 用于转换日期
     *
     * @param binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }


    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    /**
     * 获取request
     */
    protected final HttpServletRequest getRequest() {
        return request;
    }

    /**
     * 获取response
     */
    protected final HttpServletResponse getResponse() {
        return response;
    }

    /**
     * 缓存mobile
     *
     * @param mobile
     */
    protected final void setSessionMobile(String mobile) {
        getRequest().getSession().setAttribute(SESSION_MOBILE_KEY, mobile);
    }

    /**
     * 获取缓存中的mobile
     */
    protected final String getSessionMobile() {
        Object mobile = getRequest().getSession().getAttribute(SESSION_MOBILE_KEY);
        return mobile == null ? null : mobile.toString();
    }

    /**
     * 移出缓存中mobile
     */
    protected final void removeSessionMobile() {
        getRequest().getSession().removeAttribute(SESSION_MOBILE_KEY);
    }


}
