package com.haohao.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haohao.dao.AgencyMethodDao;
import com.haohao.mapper.auto.AgencyMethodMapper;
import com.haohao.modelAndExample.AgencyMethod;
import com.haohao.modelAndExample.AgencyMethodExample;
import com.haohao.util.paramAndDto.AgencyMethodParam;

/**
 * <p>Description：机构方法配置</p>
 * @date 2018年5月15日 下午5:08:42
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Repository
public class AgencyMethodDaoImpl implements AgencyMethodDao{
	@Autowired
	private AgencyMethodMapper agencyMethodMapper;

	@Override
	public AgencyMethod find(String source, String method, Integer methodEnable) {
		AgencyMethodExample example = new AgencyMethodExample();
		AgencyMethodExample.Criteria criteria = example.createCriteria();
		criteria.andSourceEqualTo(source);
		criteria.andMethodEqualTo(method);
		criteria.andMethodEnableEqualTo(methodEnable);
		List<AgencyMethod> list = agencyMethodMapper.selectByExample(example);
		return (list == null || list.size() == 0) ? null : list.get(0);
	}

	@Override
	public List<AgencyMethod> selectAgenciesByParam(AgencyMethodParam param) {
		// TODO Auto-generated method stub
		return agencyMethodMapper.selectAgenciesByParam(param);
	}

	@Override
	public void inster(AgencyMethod agency) {
		agencyMethodMapper.insertSelective(agency);
	}

	@Override
	public void update(AgencyMethod agency) {
		agencyMethodMapper.updateByPrimaryKeySelective(agency);
	}

}
