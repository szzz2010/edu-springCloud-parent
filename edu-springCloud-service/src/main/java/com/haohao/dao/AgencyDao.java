package com.haohao.dao;

import java.util.List;

import com.haohao.modelAndExample.Agency;
import com.haohao.util.paramAndDto.AgencyParam;

/**
 * <p>Description：三方机构配置</p>
 * @date 2018年5月10日 下午4:32:05
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
public interface AgencyDao {
	
	public Agency selectByPrimaryKey(String source);

	/**
	 * <p>Description：查询机构</p>
	 * @date 2018年5月11日 下午5:23:11
	 * @author zhangqiang
	 * @param source
	 * @param agencyEnable
	 * @return
	 */
	public Agency findBySourceAndStatus(String source, Integer agencyEnable);

	/**
	 * @Desc 查询可用机构
	 * @Author xiekunliang
	 * @Date 2018/5/19 15:53
	 */
    List<Agency> selectEnableAgencies();
    
    
    /**
	 * 根据条件分页获取机构信息
	 * @descript <p> </p>
	 * @author wanglicheng
	 * @date 2018年5月23日
	 * @param param
	 * @return
	 */
	public List<Agency> selectAgenciesByParam(AgencyParam param);
	
	/**
	 * 
	 * @descript <p> 新增 </p>
	 * @author wanglicheng
	 * @date 2018年5月23日
	 * @param agency
	 */
	public void inster(Agency agency);
	
	/**
	 * 修改
	 * @descript <p> </p>
	 * @author wanglicheng
	 * @date 2018年5月23日
	 * @param agency
	 */
	public void update(Agency agency);
    
}
