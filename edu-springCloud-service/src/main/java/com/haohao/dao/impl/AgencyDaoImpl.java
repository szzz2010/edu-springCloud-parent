package com.haohao.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haohao.constant.AgencyConstant;
import com.haohao.dao.AgencyDao;
import com.haohao.mapper.auto.AgencyMapper;
import com.haohao.modelAndExample.Agency;
import com.haohao.modelAndExample.AgencyExample;
import com.haohao.util.paramAndDto.AgencyParam;

/**
 * <p>Description：三方机构配置</p>
 * @date 2018年5月10日 下午4:33:36
 * @author zhangqiang
 * @version v1.0
 * Copyright (c) 2018 haohao
 */
@Repository
public class AgencyDaoImpl implements AgencyDao{
	@Autowired
	private AgencyMapper agencyMapper;

	@Override
	public Agency selectByPrimaryKey(String source) {
		return agencyMapper.selectByPrimaryKey(source);
	}
	@Override
	public Agency findBySourceAndStatus(String source,Integer agencyEnable){
		AgencyExample example = new AgencyExample();
		AgencyExample.Criteria criteria = example.createCriteria();
		criteria.andSourceEqualTo(source);
		criteria.andAgencyEnableEqualTo(agencyEnable);
		List<Agency> list = agencyMapper.selectByExample(example);
		return (list == null || list.size() == 0) ? null : list.get(0);
	}

	@Override
	public List<Agency> selectEnableAgencies() {
		AgencyExample example = new AgencyExample();
		AgencyExample.Criteria criteria = example.createCriteria();
		criteria.andAgencyEnableEqualTo(AgencyConstant.Enable.NORMAL);
		return agencyMapper.selectByExample(example);
	}
	@Override
	public List<Agency> selectAgenciesByParam(AgencyParam param) {
		return agencyMapper.selectAgenciesByParam(param);
	}
	@Override
	public void inster(Agency agency) {
		agencyMapper.insertSelective(agency);
		
	}
	@Override
	public void update(Agency agency) {
		agencyMapper.updateByPrimaryKeySelective(agency);
	}
}
