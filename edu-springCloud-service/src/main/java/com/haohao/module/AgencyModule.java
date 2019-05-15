package com.haohao.module;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.haohao.dao.AgencyDao;
import com.haohao.modelAndExample.Agency;
import com.haohao.util.paramAndDto.AgencyParam;
import com.haohao.util.springTools.redis.RedisClientTemplate;
import com.haohao.util.springTools.redis.RedisConfig;

/**
 * <p>Description：</p>
 * @date 2018年5月10日 下午4:41:36
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Component
public class AgencyModule {
	@Autowired
	private RedisClientTemplate redisClientTemplate;
	@Autowired
	private AgencyDao agencyDao;
	
	public Agency selectByPrimaryKey(String source){
		String key =  RedisConfig.KEY_AGENCY_PREFIX +  source;
		String agencyStr = redisClientTemplate.get(key);
		if(StringUtils.isBlank(agencyStr)){
			Agency agency = agencyDao.selectByPrimaryKey(source);
			if(null != agency){
				redisClientTemplate.set(key, JSON.toJSONString(agency));
			}
			return agency;
		}
		return JSONObject.parseObject(agencyStr, Agency.class);
	}
	
	/**
	 * <p>Description：查询机构</p>
	 * @date 2018年5月11日 下午5:23:11
	 * @author zhangqiang
	 * @param source
	 * @param agencyEnable
	 * @return
	 */
	public Agency findBySourceAndStatus(String source, Integer agencyEnable){
		return agencyDao.findBySourceAndStatus(source, agencyEnable);
	}

	/**
	 * @Desc 查询可用机构
	 * @Author xiekunliang
	 * @Date 2018/5/19 15:38
	 */
	public List<Agency> selectEnableAgencies() {
		return agencyDao.selectEnableAgencies();
	}
	/**
	 * 根据条件分页获取机构信息
	 * @descript <p> </p>
	 * @author wanglicheng
	 * @date 2018年5月23日
	 * @param param
	 * @return
	 */
	public List<Agency> selectAgenciesByParam(AgencyParam param){
		return agencyDao.selectAgenciesByParam(param);
	}
	
	/**
	 *
	 * @descript <p> 新增 </p>
	 * @author wanglicheng
	 * @date 2018年5月23日
	 * @param agency
	 */
	public void save(Agency agency){
		agencyDao.inster(agency);
	}
	/**
	 * 
	 * @descript <p> 修改</p>
	 * @author wanglicheng
	 * @date 2018年5月23日
	 * @param agency
	 */
	public void update(Agency agency){
		agencyDao.update(agency);
		//key
		final String key = RedisConfig.KEY_AGENCY_PREFIX + agency.getSource();
		//查询是否存在 存在删除key
		if(redisClientTemplate.exists(key)){
			redisClientTemplate.del(key);
		}
	}
	
}
