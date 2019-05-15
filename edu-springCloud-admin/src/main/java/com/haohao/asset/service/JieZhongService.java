package com.haohao.asset.service;

import java.util.Map;

import com.haohao.asset.utils.R;

/**
 * @author feng
 * @discription 大众资产
 * @date 2019/1/23
 */
public interface JieZhongService {

    /**
     * 获取数据列表
     * @author feng
     * @date 2019/1/23 14:10
     * @param select
     * @param usccCodeOrNameOrMobile
     * @param createStartTime
     * @param createEndTime
     * @param checkStartTime
     * @param checkEndTime
     * @param status
     * @param page
     * @param limit
     * @return com.asset.manager.util.R
     */
    R jieZhongData(Integer select, String usccCodeOrNameOrMobile, String createStartTime, String createEndTime, String checkStartTime, String checkEndTime, Integer status, Integer page, Integer limit);

    /**
     * 企业审核
     * @author feng
     * @date 2019/1/23 17:10
     * @param id
     * @param status
     * @return com.asset.manager.util.R
     */
    R check(Integer id, Integer status);

    /**
     * 企业详情数据
     * @author feng
     * @date 2019/1/23 18:21
     * @param id 
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    Map<String,Object> getCompanyDetail(Integer id);

    /**
     * 获取数据列表
     * @author feng
     * @date 2019/1/23 14:10
     * @param select
     * @param usccCodeOrNameOrMobile
     * @param createStartTime
     * @param createEndTime
     * @param checkStartTime
     * @param checkEndTime
     * @param status
     * @param page
     * @param limit
     * @return com.asset.manager.util.R
     */
	R jieZhongDataRegister(Integer select, String usccCodeOrNameOrMobile, String createStartTime, String createEndTime, String checkStartTime, String checkEndTime, Integer status, Integer page, Integer limit);

	R checkRegister(Integer id, Integer status);
}
