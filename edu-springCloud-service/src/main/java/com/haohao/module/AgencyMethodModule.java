package com.haohao.module;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.haohao.dao.AgencyMethodDao;
import com.haohao.modelAndExample.AgencyMethod;
import com.haohao.util.paramAndDto.AgencyMethodParam;

/**
 * <p>Description：机构方法配置</p>
 * @date 2018年5月15日 下午5:04:02
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Component
public class AgencyMethodModule {
	@Autowired
	private AgencyMethodDao agencyMethodDao;
	
	public AgencyMethod find(String source,String method,Integer methodEnable){
		return agencyMethodDao.find(source, method, methodEnable);
	}
	
	
	/**
	 * 根据条件分页获取机构配置信息
	 * @descript <p> </p>
	 * @author wanglicheng
	 * @date 2018年5月23日
	 * @param param
	 * @return
	 */
	public List<AgencyMethod> selectAgenciesByParam(AgencyMethodParam param){
		return agencyMethodDao.selectAgenciesByParam(param);
	}
	
	/**
	 *
	 * @descript <p> 新增 </p>
	 * @author wanglicheng
	 * @date 2018年5月23日
	 * @param agency
	 */
	public void save(AgencyMethod agency){
		agencyMethodDao.inster(agency);
	}
	/**
	 * 
	 * @descript <p> 修改</p>
	 * @author wanglicheng
	 * @date 2018年5月23日
	 * @param agency
	 */
	public void update(AgencyMethod agency){
		agencyMethodDao.update(agency);
	}

}
