package com.haohao.controller.asset;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.haohao.modelAndExample.Agency;
import com.haohao.modelAndExample.AgencyMethod;
import com.haohao.module.AgencyMethodModule;
import com.haohao.module.AgencyModule;
import com.haohao.service.xs.AssetInterface;
import com.haohao.util.service.CommonThirdResponse;
import com.haohao.util.service.DateUtil;
import com.haohao.util.service.EncryptUtil;
import com.haohao.util.springTools.springJdbc.helper.HttpServletLogAspect.PrintLog;
import com.haohao.util.tools.CommonThirdRequest;


/**
 * <p>Description：三方资产通用接口</p>
 *
 * @author zhangqiang
 * @version v1.0
 *          Copyright (c) 2018 haohao
 * @date 2018年5月9日 下午8:06:31
 */
@Controller
public class CommonRequestFromThirdController implements ApplicationContextAware {
    private final static Logger log = LoggerFactory.getLogger(CommonRequestFromThirdController.class);
    private ApplicationContext applicationContext;
    private static int TIME = 600;
    @Autowired
    private AgencyModule agencyModule;
    @Autowired
    private AgencyMethodModule agencyMethodModule;

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/api/third/commonRequest", method = RequestMethod.POST)
    @ResponseBody
    @PrintLog
    public Object commonRequest(@ModelAttribute CommonThirdRequest request) {
        String source = request.getSource();
        if (StringUtils.isBlank(source)) {
            return CommonThirdResponse.createFailed("资产来源为空");
        }
        Agency agency = agencyModule.findBySourceAndStatus(source, 0);
        if (null == agency) {
            return CommonThirdResponse.createFailed("资产来源不支持");
        }
        //2,验证版本号
        if (!agency.getVersion().equals(request.getVersion())) {
            return CommonThirdResponse.createFailed("协议版本不支持");
        }
        //3,验证方法名
        String method = request.getMethod();
        if (StringUtils.isBlank(method)) {
            return CommonThirdResponse.createFailed("方法为空");
        }
        AgencyMethod agencyMethod = agencyMethodModule.find(source, method, 0);
        if (agencyMethod == null) {
            return CommonThirdResponse.createFailed("没有对应接口");
        }
        //验证服务器时间
        try {
            int requestTime = DateUtil.getUnixTimeStamp(request.getTimestamp(), DateUtil.YYYY_MM_DD_HH_MM_SS);
            int now = (int) (System.currentTimeMillis() / 1000);
            int cha = now - requestTime;
            if (Math.abs(cha) > TIME) {
                return CommonThirdResponse.createFailed("客户端与服务端时间不一致");
            }
        } catch (Exception e1) {
            log.error("请求时间格式不正确", e1);
            return CommonThirdResponse.createFailed("时间格式[timestamp]格式不正确");
        }
        try {
            //4,签名验证
            if (!request.getSign().equals(EncryptUtil.md5(objectToMap(request), agency.getMd5Key()))) {
                return CommonThirdResponse.createFailed("签名验证不通过");
            }
            //5,解密请求主体
            String content = EncryptUtil.decrypt(request.getContent(), agency.getAesKey());
            log.info("三方请求的解密参数content = {}", content);
            Map<String, Object> reqMap = JSON.parseObject(content, Map.class);
            reqMap.put("source", source);
            //6,执行对应的接口 && 获得返回结果
            Map<String, Object> respMap = ((AssetInterface) applicationContext.getBean(method)).execution(reqMap);
            //7,封装响应报文 && 加密响应主体
            log.info("返回三方的数据参数  respMap = {}", respMap);
            return CommonThirdResponse.createSuccess(JSON.toJSONString(respMap), agency.getAesKey());
        } catch (Exception e) {
            log.error("三方请求系统出现异常", e);
            return CommonThirdResponse.createFailed("请求出现异常");
        }
    }

    private static Map<String, String> objectToMap(Object obj) throws Exception {
        if (obj == null)
            return null;
        Map<String, String> map = BeanUtils.describe(obj);
        map.remove("class");
        map.remove("sign");
        return map;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
