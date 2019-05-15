package com.haohao.dao;

import java.util.List;

import com.haohao.modelAndExample.AgencyMethod;
import com.haohao.util.paramAndDto.AgencyMethodParam;

/**
 * <p>Description：机构方法配置</p>
 * @date 2018年5月15日 下午5:06:31
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
public interface AgencyMethodDao {
	
	public AgencyMethod find(String source,String method,Integer methodEnable);

	  /**
		 * 根据条件分页获取机构配置信息
		 * @descript <p> </p>
		 * @author wanglicheng
		 * @date 2018年5月23日
		 * @param param
		 * @return
		 */
		public List<AgencyMethod> selectAgenciesByParam(AgencyMethodParam param);
		
		/**
		 * 
		 * @descript <p> 新增 </p>
		 * @author wanglicheng
		 * @date 2018年5月23日
		 * @param agency
		 */
		public void inster(AgencyMethod agency);
		
		/**
		 * 修改
		 * @descript <p> </p>
		 * @author wanglicheng
		 * @date 2018年5月23日
		 * @param agency
		 */
		public void update(AgencyMethod agency);
	    
}
