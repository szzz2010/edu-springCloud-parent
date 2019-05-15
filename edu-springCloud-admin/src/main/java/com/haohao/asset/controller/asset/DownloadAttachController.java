package com.haohao.asset.controller.asset;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haohao.asset.service.IDownloadAttachService;
import com.haohao.util.springTools.springJdbc.helper.RequestHelper;
/**   
 * @ClassName:  DownloadAttachController   
 * @Description:(下载附件)   
 * @author: xs_sj
 * @date:   2019年1月27日 上午11:42:42     
 * @Copyright: 2019 haohaojiekuan Inc. All rights reserved.
 * 
 */  
@Controller
@RequestMapping("/attach")
public class DownloadAttachController {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private IDownloadAttachService downloadAttachService;
	
	/**   
	 * @Title: downloadAttach   
	 * @Description: (下载附件)   
	 * @param: @param type 个人或企业 0 个人，1 企业
	 * @param: @param loan_agency_id 个人合作机构id
	 * @param: @param fileName 文件名
	 * @param: @param response      
	 * @return: void      
	 * @throws   
	 */  
	@RequestMapping("/downloadAttach")
	public void downloadAttach(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> params = RequestHelper.getParameters(request);
		log.info("开始下载订单附件：params={}",params);
		String fileName = (String) params.get("fileName");
		if(StringUtils.isBlank(fileName)) {
			try {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().println("参数错误");
				response.getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		try {
			downloadAttachService.downloadOrderAttach(params, response);
		} catch(Exception e) {
			e.printStackTrace();
			try {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().println("服务器错误");
				response.getWriter().close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return;
		}
	}
	
	/**
	 * 获取电子签章列表
	 * 2019年2月25日15:27:03
	 * denshinyou
	 * @param request
	 * @param response
	 */
	@RequestMapping("/getElectronicSignatureList")
	@ResponseBody
	public Map<String, Object> getElectronicSignatureList(HttpServletRequest request) {
		Map<String,Object> returnMap = new HashMap<>();
		Map<String, Object> params = RequestHelper.getParameters(request);
		log.info("查询电子签章列表：params={}",params);
//		String loan_agency_code = (String) params.get("loan_agency_code");
		String loan_number = (String) params.get("loan_number");
		returnMap = downloadAttachService.getElectronicSignatureList(loan_number);
		log.info("查询电子签章列表返回：returnMap={}",returnMap);
		return returnMap;
	}
	
	/**
	 * 下载电子签章合同
	 * 2019年2月25日15:27:03
	 * denshinyou
	 * @param request
	 * @param response
	 */
	@RequestMapping("/downloadElectronicSignature")
	public void downloadElectronicSignature(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> params = RequestHelper.getParameters(request);
		log.info("开始下载电子签章：params={}",params);
		String fileName = (String) params.get("fileName");
		if(StringUtils.isBlank(fileName)) {
			try {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().println("参数错误");
				response.getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		try {
			downloadAttachService.downloadElectronicSignature(params, response);
		} catch(Exception e) {
			e.printStackTrace();
			try {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().println("服务器错误");
				response.getWriter().close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return;
		}
	}
}