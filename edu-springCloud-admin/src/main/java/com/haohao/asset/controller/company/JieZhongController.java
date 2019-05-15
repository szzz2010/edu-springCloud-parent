package com.haohao.asset.controller.company;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haohao.asset.service.JieZhongService;
import com.haohao.asset.utils.R;
import com.haohao.util.springTools.springJdbc.helper.RequestHelper;

/**
 * @author feng
 * @discription 大众企业
 * @date 2019/1/23
 */
@Controller
@RequestMapping("/jiezhong")
public class JieZhongController {

	private Logger log = LoggerFactory.getLogger(JieZhongController.class);
	
    @Autowired
    private JieZhongService jieZhongService;

    @Value("${jiezhong.url}")
    private String jiezhongUrl ;

    /**
     * 页面加载
     * @author feng
     * @date 2019/1/23 14:02
     * @param model
     * @return java.lang.String
     */
    @GetMapping("/list")
    public String jieZhongList(Model model) {
        return "/company/jiezhongList";
    }

    /**
     * 获取数据列表
     * @author feng
     * @date 2019/1/23 14:09
     * @param select
     * @param usccCodeOrNameOrMobile
     * @param createStartTime
     * @param createEndTime
     * @param checkStartTime
     * @param checkEndTime
     * @param status
     * @param page
     * @param limit
     * @return com.asset.manager.util.R
     */
    @GetMapping("/data")
    @ResponseBody
    public R jieZhongData(Integer select, String usccCodeOrNameOrMobile, String createStartTime, String createEndTime,
                          String checkStartTime, String checkEndTime, Integer status, Integer page, Integer limit ) {
        return jieZhongService.jieZhongData(select,usccCodeOrNameOrMobile,createStartTime,createEndTime,checkStartTime,checkEndTime,status,page,limit);
    }

    /**
     * 企业审核
     * @author feng
     * @date 2019/1/23 17:24
     * @param id
     * @param status
     * @return com.asset.manager.util.R
     */
    @GetMapping("/check")
    @ResponseBody
    public R check(Integer id,Integer status) {
        return jieZhongService.check(id,status);
    }

    /**
     * 企业详情页
     * @author feng
     * @date 2019/1/23 18:13
     * @param id
     * @return java.lang.String
     */
    @GetMapping("/companyDetailPage")
    public String companyDetailPage(Integer id,Model model) {
    	model.addAttribute("order_id", id);
    	model.addAttribute("jiezhongUrl", jiezhongUrl);
        return "/company/companyDetail";
    }

    /**
     * 企业详情数据
     * @author feng
     * @date 2019/1/23 18:25
     * @param id
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @GetMapping("/companyDetail")
    @ResponseBody
    public Map<String,Object> getCompanyDetail(Integer id) {
        return jieZhongService.getCompanyDetail(id);
    }

    /**
     * 页面加载
     * @author feng
     * @date 2019/1/23 14:02
     * @param model
     * @return java.lang.String
     */
    @GetMapping("/registerList")
    public String jieZhongRegisterList(Model model) {
        return "/company/jieZhongRegisterList";
    }
    
    /**
     * 获取数据列表
     * @author feng
     * @date 2019/1/23 14:09
     * @param select
     * @param usccCodeOrNameOrMobile
     * @param createStartTime
     * @param createEndTime
     * @param checkStartTime
     * @param checkEndTime
     * @param status
     * @param page
     * @param limit
     * @return com.asset.manager.util.R
     */
    @GetMapping("/dataRegister")
    @ResponseBody
    public R jieZhongDataRegister(Integer select, String usccCodeOrNameOrMobile, String createStartTime, String createEndTime,
                          String checkStartTime, String checkEndTime, Integer status, Integer page, Integer limit ) {
        return jieZhongService.jieZhongDataRegister(select,usccCodeOrNameOrMobile,createStartTime,createEndTime,checkStartTime,checkEndTime,status,page,limit);
    }
    
    /**
     * 企业注册审核
     * @author feng
     * @date 2019/1/23 17:24
     * @param id
     * @param status
     * @return com.asset.manager.util.R
     */
    @RequestMapping("/checkRegister")
    @ResponseBody
    public R checkRegister(Integer id,Integer status) {
        return jieZhongService.checkRegister(id,status);
    }
    
    @RequestMapping("/ensureInit")
    public String ensureInit(HttpServletRequest request , Model model) {
    	Map<String, Object> params = RequestHelper.getParameters(request);
    	params.put("jiezhongUrl", jiezhongUrl);
    	model.addAttribute("params",params);
    	log.info("{}",params);
        return "/company/detail/ensure";
    }
    
    @RequestMapping("/refuseInit")
    public String refuseInit(HttpServletRequest request , Model model) {
    	Map<String, Object> params = RequestHelper.getParameters(request);
    	params.put("jiezhongUrl", jiezhongUrl);
    	model.addAttribute("params",params);
    	log.info("{}",params);
    	return "/company/detail/refuse";
    }
    
    @RequestMapping("/cancelInit")
    public String cancelInit(HttpServletRequest request , Model model) {
    	Map<String, Object> params = RequestHelper.getParameters(request);
    	params.put("jiezhongUrl", jiezhongUrl);
    	model.addAttribute("params",params);
    	log.info("{}",params);
    	return "/company/detail/cancel";
    }

}
