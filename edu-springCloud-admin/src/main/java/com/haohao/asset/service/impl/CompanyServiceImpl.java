package com.haohao.asset.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haohao.asset.entity.Company;
import com.haohao.asset.mapper.CompanyMapper;
import com.haohao.asset.service.ICompanyService;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xueyx
 * @since 2019-03-25
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

}
