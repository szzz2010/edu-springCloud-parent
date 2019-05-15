package com.haohao.service.xs.impl_v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haohao.service.xs.CompanyInfoService;
import com.haohao.util.springTools.springJdbc.MysqlSpringJdbcDao;

import java.util.List;
import java.util.Map;

/**
 * Created by fanzukun on 2018/9/20.
 */
@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {

    @Autowired
    private MysqlSpringJdbcDao jdbcDao;


    @Override
    public Map<String, Object> getCompany(Integer id) {
        return jdbcDao.queryForMap("select * from jz_ac_company_order where id=?", id);
    }

    @Override
    public int orderCount(Integer companyId) {
        return (int) jdbcDao.queryForObject("select count(*) from jz_ac_company_order where company_id=?", Integer.class, companyId);
    }

    @Override
    public List<Map<String, Object>> orderList(Integer companyId) {
        return jdbcDao.queryForList("select * from jz_ac_company_order where company_id=? order by id desc ", companyId);
    }
}
