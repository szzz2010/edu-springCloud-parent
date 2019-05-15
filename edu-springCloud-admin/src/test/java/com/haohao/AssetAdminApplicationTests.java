package com.haohao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haohao.asset.entity.Company;
import com.haohao.asset.service.ICompanyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssetAdminApplicationTests {

	@Autowired
	private ICompanyService companyService;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testSelect() {
		Company one = companyService.getOne(new QueryWrapper<Company>().eq("id", 1));
		System.out.println(one);
		List<Company> page = companyService.page(new Page<>(1, 2)).getRecords();
		page.forEach(System.out::print);
	}
}
