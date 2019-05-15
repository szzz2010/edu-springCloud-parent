package com.haohao.asset.controller.asset;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.haohao.asset.entity.Company;
import com.haohao.asset.entity.Person;
import com.haohao.asset.service.ICompanyService;
import com.haohao.asset.service.IPersonService;
import com.haohao.asset.utils.Result;
import com.haohao.util.service.DateUtil;

/**
 * <p>
 *  资产管理
 * </p>
 *
 * @author xueyx
 * @since 2019-03-25
 */
@Controller
@RequestMapping("/asset/Manage")
public class AssetManageController {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private ICompanyService companyService;
	
	@Autowired
	private IPersonService personService;
	
	@RequestMapping("/init")
	public String init() {
		return "asset/assetOrderList";
	}
	/**
	 * 查询列表
	 * @param params
	 * @param request
	 * @return
	 */
	@RequestMapping("/showList")
	@ResponseBody
	public Result showList(@RequestParam Map<String, String> params, HttpServletRequest request) {
		String loanNumber = params.get("loanNumber");
		log.info("查询债权编号：loanNumber={}", loanNumber);
		if (loanNumber == null) {
			return Result.error("搜索一下吧");
		}
		Company company = new Company().setLoanNumber(loanNumber);
		List<Map<String,Object>> companyList = companyService.listMaps(new QueryWrapper<Company>(company));
		if (companyList != null && companyList.size() > 0) {
			companyList.forEach(companyTemp -> {
				companyTemp.put("source", "0");
				companyTemp.put("loan_name", companyTemp.get("loan_company_name"));
				companyTemp.put("loan_id_card", companyTemp.get("loan_company_id_card"));
				companyTemp.put("loan_mobile", companyTemp.get("loan_company_mobile"));
				companyTemp.put("loan_apply_time", DateUtil.dateToString((Date) companyTemp.get("loan_apply_time"), "yyyy-MM-dd HH:mm:ss"));
			});
			return Result.success(companyList);
		}
		Person person = new Person().setLoanNumber(loanNumber);
		List<Map<String,Object>> personList = personService.listMaps(new QueryWrapper<Person>(person));
		if (personList != null && personList.size() > 0) {
			personList.forEach(personTemp -> {
				personTemp.put("source", "1");
				personTemp.put("loan_name", personTemp.get("loan_user_name"));
				personTemp.put("loan_id_card", personTemp.get("loan_user_id_card"));
				personTemp.put("loan_mobile", personTemp.get("loan_user_mobile"));
				personTemp.put("loan_apply_time", DateUtil.dateToString((Date) personTemp.get("loan_apply_time"), "yyyy-MM-dd HH:mm:ss"));
			});
			return Result.success(personList);
		}
		return Result.error("无数据");
	}
	/**
	 * 详情页
	 * @param params
	 * @param model
	 * @return
	 */
	@RequestMapping("/toOrderDetail")
	public String detail(@RequestParam Map<String, String> params, Model model) {
		String source = params.get("source");
		String id = params.get("id");
		String page = "";
		model.addAttribute("id", id);
		if ("0".equals(source)) {//公司
			Company company = companyService.getById(id);
			model.addAttribute("loan_number", company.getLoanNumber());
			model.addAttribute("loan_agency_code", company.getLoanAgencyCode());
			page = "asset/companyOrderDetail";
		}else if ("1".equals(source)) {
			Person person = personService.getById(id);
			model.addAttribute("loan_number", person.getLoanNumber());
			model.addAttribute("loan_agency_code", person.getLoanAgencyCode());
			page = "asset/personOrderDetail";
		}
		return page;
	}
	/**
	 * 公司ID查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/getCompanyOrderInfoById")
	@ResponseBody
	public Map<String, Object> getCompanyOrderInfoById(Integer id) {
		return companyService.getMap(new QueryWrapper<Company>(new Company().setId(id)));
	}
	/**
	 * 个人ID查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/getPersonOrderInfoById")
	@ResponseBody
	public Map<String, Object> getPersonOrderInfoById(Integer id) {
		return personService.getMap(new QueryWrapper<Person>(new Person().setId(id)));
	}
}
