package com.haohao.asset.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.haohao.asset.dto.SpCompanyDTO;
import com.haohao.asset.service.JieZhongService;
import com.haohao.asset.utils.R;
import com.haohao.util.springTools.springJdbc.helper.HttpClientHelper;

/**
 * @author feng
 * @discription 大众资产
 * @date 2019/1/23
 */
@Service
@SuppressWarnings("unchecked")
public class JieZhongServiceImpl implements JieZhongService {

    Logger logger = LoggerFactory.getLogger(JieZhongServiceImpl.class);

    @Value("${jiezhong.url}")
    private String jiezhongUrl;

    @Override
    public R jieZhongData(Integer select, String usccCodeOrNameOrMobile, String createStartTime, String createEndTime, String checkStartTime, String checkEndTime, Integer status, Integer page, Integer limit) {

        String url = jiezhongUrl +"/api/v1/center/getAllCompanyList"+"?page="+page+"&limit="+limit;
        if (select != null){
            url = url+"&select="+select;
        }
        if (StringUtils.isNotBlank(usccCodeOrNameOrMobile)){
            url = url+"&usccCodeOrNameOrMobile="+usccCodeOrNameOrMobile;
        }
        if (StringUtils.isNotBlank(createStartTime)){
            url = url+"&createStartTime="+createStartTime;
        }if (StringUtils.isNotBlank(createEndTime)){
            url = url+"&createEndTime="+createEndTime;
        }
        if (StringUtils.isNotBlank(checkStartTime)){
            url = url+"&checkStartTime="+checkStartTime;
        }
        if (StringUtils.isNotBlank(checkStartTime)){
            url = url+"&checkStartTime="+checkStartTime;
        }
        if (status != null){
            url = url+"&status="+status;
        }
        String result = null;
        try {
            result = HttpClientHelper.exec(url, "0", "0", null);
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (jsonObject!=null){
                return new R().setMsg(jsonObject.getString("msg")).setCode(jsonObject.getInteger("code")).
                        setData((List<SpCompanyDTO>) jsonObject.get("data")).setCount(jsonObject.getInteger("count"));
            } else {
                return new R().setMsg("查询失败").setCode(1);
            }
        } catch (Exception e) {
            logger.info("服务异常：",e);
            return new R().setMsg("服务异常").setCode(1);
        }
    }

    @Override
    public R check(Integer id, Integer status) {
        try {
            String url = jiezhongUrl +"/api/v1/center/updataCheckResult"+"?companyId="+id+"&status="+status;
            String result = HttpClientHelper.exec(url, "0", "0", null);
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (jsonObject!=null && jsonObject.getInteger("code")==0){
                return new R().setMsg("审核成功").setCode(0);
            } else {
                return new R().setMsg("审核失败").setCode(1);
            }
        } catch (Exception e) {
            logger.info("服务异常：",e);
            return new R().setMsg("服务异常").setCode(1);
        }
    }

    @Override
    public Map<String,Object> getCompanyDetail(Integer id) {
        Map<String,Object> map = new HashMap<>();
        Integer code = 0;
        String msg = "请求成功";
        try {
            String url = jiezhongUrl +"/api/v1/center/getCompanyDetail"+"?companyId="+id;
            String result = HttpClientHelper.exec(url, "0", "0", null);
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (jsonObject!=null && jsonObject.getInteger("code")==0){
                map.put("code",code);
                map.put("msg",msg);
                map.put("data",jsonObject.get("data"));
                return map;
            } else {
                code = 1;
                msg = "查询失败";
                map.put("code",code);
                map.put("msg",msg);
                return map;
            }
        } catch (Exception e) {
            logger.info("服务异常：",e);
            code = 1;
            msg = "服务异常";
            map.put("code",code);
            map.put("msg",msg);
            return map;
        }
    }
    
    
    @Override
    public R jieZhongDataRegister(Integer select, String usccCodeOrNameOrMobile, String createStartTime, String createEndTime, String checkStartTime, String checkEndTime, Integer status, Integer page, Integer limit) {

        String url = jiezhongUrl +"/api/v1/center/getAllCompanyRegisterList"+"?page="+page+"&limit="+limit;
        if (select != null){
            url = url+"&select="+select;
        }
        if (StringUtils.isNotBlank(usccCodeOrNameOrMobile)){
            url = url+"&usccCodeOrNameOrMobile="+usccCodeOrNameOrMobile;
        }
        if (StringUtils.isNotBlank(createStartTime)){
            url = url+"&createStartTime="+createStartTime;
        }if (StringUtils.isNotBlank(createEndTime)){
            url = url+"&createEndTime="+createEndTime;
        }
        if (StringUtils.isNotBlank(checkStartTime)){
            url = url+"&checkStartTime="+checkStartTime;
        }
        if (StringUtils.isNotBlank(checkStartTime)){
            url = url+"&checkStartTime="+checkStartTime;
        }
        if (status != null){
            url = url+"&status="+status;
        }
        String result = null;
        try {
            result = HttpClientHelper.exec(url, "0", "0", null);
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (jsonObject!=null){
                return new R().setMsg(jsonObject.getString("msg")).setCode(jsonObject.getInteger("code")).
                        setData((List<SpCompanyDTO>) jsonObject.get("data")).setCount(jsonObject.getInteger("count"));
            } else {
                return new R().setMsg("查询失败").setCode(1);
            }
        } catch (Exception e) {
            logger.info("服务异常：",e);
            return new R().setMsg("服务异常").setCode(1);
        }
    }
    
    @Override
    public R checkRegister(Integer id, Integer status) {
        try {
            String url = jiezhongUrl +"/api/v1/center/updataRegisterCheckResult"+"?companyId="+id+"&status="+status;
            String result = HttpClientHelper.exec(url, "0", "0", null);
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (jsonObject!=null && jsonObject.getInteger("code")==0){
                return new R().setMsg("审核成功").setCode(0);
            } else {
                return new R().setMsg("审核失败").setCode(1);
            }
        } catch (Exception e) {
            logger.info("服务异常：",e);
            return new R().setMsg("服务异常").setCode(1);
        }
    }
    
    
}
