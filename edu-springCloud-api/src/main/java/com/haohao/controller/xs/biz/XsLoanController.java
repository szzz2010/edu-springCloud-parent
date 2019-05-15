
package com.haohao.controller.xs.biz;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.haohao.service.xs.AssetsDockingService;
import com.haohao.util.springTools.springJdbc.helper.RequestHelper;
import com.haohao.util.tools.XsCodeMessageTool;
import com.haohao.util.tools.XsCodeMessageTool.CodeMessage;

/**
 * <p>Description：企业借款 对接学习 控制器
 */
@Controller
@RequestMapping(value = "/xs/account/")
public class XsLoanController {

	private final static Logger log = LoggerFactory.getLogger(XsLoanController.class);

	@Autowired
	private AssetsDockingService assetsDockingService;


	/**
	 * 校验是否开户
	 */
	@RequestMapping(value = "hasOpenAccount", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> hasOpenAcount(HttpServletRequest request) {
		try {
			Map<String,Object> params = RequestHelper.getParameters(request);
			Integer company_id = Integer.parseInt(String.valueOf(params.get("company_id")));
			params.put("company_id", company_id);
			Boolean hasAccount = assetsDockingService.hasOpenAcount(params);
			if(BooleanUtils.isFalse(hasAccount)){
				//没有 账户  跳转开户
				log.info("检测是否开户：没有账户，company_id={}", company_id);
				return XsCodeMessageTool.getSuccessMessage(CodeMessage.account_hasNotOpenPingAnAccount_error);
			}else if(BooleanUtils.isTrue(hasAccount)){
				//有账户  放行
				return XsCodeMessageTool.getSuccessMessage(null);
			}else{
				//未查到确定的 结果
				log.info("检测是否开户：未查询到  确定的状态，company_id={}", company_id);
				return XsCodeMessageTool.getFailedMessage(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("检测是否开户异常");
			return XsCodeMessageTool.getFailedMessage(null);
		}
	}


	/**
	 * <p>Description：获取开户绑卡参数</p>
	 * http://localhost:8080/api/xs/account/cardSet?company_id=1&mobile=15808633809&cardNum=6222003723622385753&cardName=工商银行
	 */
	@RequestMapping(value = "cardSet")
	public String cardSet(HttpServletRequest request,ModelMap modelMap){
		Map<String,Object> params = RequestHelper.getParameters(request);
		Integer company_id = Integer.parseInt(String.valueOf(params.get("company_id")));
		params.put("company_id", company_id);
		try {
			Map<String, Object> resultMap = assetsDockingService.cardSet(params);
			if("9999".equals(resultMap.get("code"))){
				modelMap.addAttribute("returnMap", JSON.toJSONString(XsCodeMessageTool.getFailedMessage(CodeMessage.bank_card_account_exist)));
				return "asset/asset_finish";
			}
			modelMap.addAttribute("params", resultMap);
			return "asset/asset_h5";
		} catch (Exception e) {
			log.error("开户构造参数出现异常，company_id:"+company_id, e);
			modelMap.addAttribute("returnMap",  JSON.toJSONString(XsCodeMessageTool.getFailedMessage(null)));
			return "asset/asset_finish";
		}

	}

	/**
	 * <p>Description：更换银行卡</p>
	 * http://localhost:8080/xs/account/cardChange?company_id=1&cardNum=6228480790859137323
	 * 新的银行卡号
	 */
	@RequestMapping(value = "cardChange")
	public String cardChange(HttpServletRequest request,ModelMap modelMap){
		Map<String,Object> params = RequestHelper.getParameters(request);
		Integer company_id = Integer.parseInt(String.valueOf(params.get("company_id")));
		params.put("company_id", company_id);
		try {
			Map<String, Object> resultMap = assetsDockingService.cardChange(params);
			if("9999".equals(resultMap.get("code"))){
				modelMap.addAttribute("returnMap", JSON.toJSONString(XsCodeMessageTool.getFailedMessage(CodeMessage.bank_card_has_not_bind_error)));
				return "asset/asset_finish";
			}
			modelMap.addAttribute("params", resultMap);
			return "asset/asset_h5";
		} catch (Exception e ) {
			log.info("更换银行卡异常");
			modelMap.addAttribute("returnMap",  JSON.toJSONString(XsCodeMessageTool.getFailedMessage(null)));
			return "asset/asset_finish";
		}
	}

	/**
	 * <p>Description：修改交易密码</p>
	 */
	@RequestMapping(value = "upPwd")
	public String upPwd(HttpServletRequest request,ModelMap modelMap){
		Map<String,Object> params = RequestHelper.getParameters(request);
		Integer company_id = Integer.parseInt(String.valueOf(params.get("company_id")));
		params.put("company_id", company_id);
		try {
			Map<String,Object>resultMap = assetsDockingService.upPwd(params);
			if("9999".equals(resultMap.get("code"))){
				modelMap.addAttribute("returnMap", JSON.toJSONString(XsCodeMessageTool.getFailedMessage(CodeMessage.account_hasNotOpenPingAnAccount_error)));
				return "asset/asset_finish";
			}
			modelMap.addAttribute("params", resultMap);
			return "asset/asset_h5";
		} catch (Exception e) {
			log.error("修改交易密码出现异常，company_id:"+company_id, e);
			modelMap.addAttribute("returnMap",  JSON.toJSONString(XsCodeMessageTool.getFailedMessage(null)));
			return "asset/asset_finish";
		}

	}

	/**
	 * <p>Description：重置交易密码</p>
	 * http://localhost:8080/xs/account/resetPwd?company_id=1
	 */
	@RequestMapping(value = "resetPwd")
	public String resetPwd(HttpServletRequest request,ModelMap modelMap){
		Map<String,Object> params = RequestHelper.getParameters(request);
		Integer company_id = Integer.parseInt(String.valueOf(params.get("company_id")));
		params.put("company_id", company_id);
		try {
			Map<String,Object>resultMap = assetsDockingService.resetPwd(params);
			if("9999".equals(resultMap.get("code"))){
				modelMap.addAttribute("returnMap", JSON.toJSONString(XsCodeMessageTool.getFailedMessage(CodeMessage.account_hasNotOpenPingAnAccount_error)));
				return "asset/asset_finish";
			}
			modelMap.addAttribute("params", resultMap);
			return "asset/asset_h5";
		} catch (Exception e ) {
			log.error("重置交易密码构造参数出现异常，company_id:"+company_id, e);
			modelMap.addAttribute("returnMap",  JSON.toJSONString(XsCodeMessageTool.getFailedMessage(null)));
			return "asset/asset_finish";
		}
	}

	/**
	 * 修改银行预留手机号
	 * http://localhost:8080/xs/account/upCardMobile?company_id=1&mobile=13758004082
	 * <p>Description：</p>
	 */
	@RequestMapping(value = "upCardMobile")
	public String upCardMobile(HttpServletRequest request,ModelMap modelMap){
		Map<String,Object> params = RequestHelper.getParameters(request);
		Integer company_id = Integer.parseInt(String.valueOf(params.get("company_id")));
		params.put("company_id", company_id);
		try {
			Map<String,Object>resultMap = assetsDockingService.upCardMobile(params);
			if("9999".equals(resultMap.get("code"))){
				modelMap.addAttribute("returnMap", JSON.toJSONString(XsCodeMessageTool.getFailedMessage(CodeMessage.account_hasNotOpenPingAnAccount_error)));
				return "asset/asset_finish";
			}
			modelMap.addAttribute("params", resultMap);
			return "asset/asset_h5";
		} catch (Exception e) {
			log.error("修改手机号参数出现异常，company_id:"+company_id, e);
			modelMap.addAttribute("returnMap",  JSON.toJSONString(XsCodeMessageTool.getFailedMessage(null)));
			return "asset/asset_finish";
		}
	}

	/**
	 * 设置授权信息
	 * http://localhost:8080/xs/account/doAuth?company_id=1
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "doAuth")
	public String doAuth(HttpServletRequest request, ModelMap modelMap) {
		Map<String,Object> params = RequestHelper.getParameters(request);
		Integer company_id = Integer.parseInt(String.valueOf(params.get("company_id")));
		params.put("company_id", company_id);
		try {
			Map<String,Object>resultMap = assetsDockingService.doAuth(params);
			if("9999".equals(resultMap.get("code"))){
				modelMap.addAttribute("returnMap",JSON.toJSONString(XsCodeMessageTool.getFailedMessage(CodeMessage.account_hasNotOpenPingAnAccount_error)));
				return "asset/asset_finish";
			}
			modelMap.addAttribute("params", resultMap);
			return "asset/asset_h5";
		} catch (Exception e) {
			log.error("开户构造参数出现异常，company_id:"+company_id, e);
			modelMap.addAttribute("returnMap",  JSON.toJSONString(XsCodeMessageTool.getFailedMessage(null)));
			return "asset/asset_finish";
		}
	}

	/**
	 * <p>Description：提现接口</p>
	 * http://localhost:8080/xs/account/moneyTixian?order_id=1
	 * @param modelMap
	 */
	@RequestMapping(value = "moneyTixian")
	public String moneyTixian(HttpServletRequest request,ModelMap modelMap){
		Map<String,Object> params = RequestHelper.getParameters(request);
		try {
			Map<String,Object>resultMap = assetsDockingService.moneyTixian(params);
			if("9999".equals(resultMap.get("code"))){
				modelMap.addAttribute("returnMap",JSON.toJSONString(resultMap.get("data")));
				return "asset/asset_finish";
			}
			modelMap.addAttribute("params", resultMap);
			return "asset/asset_h5";
		} catch (Exception e) {
			log.error("提现构造参数出现异常，params=【{}】，e=[{e}]",params, e);
			modelMap.addAttribute("returnMap",  JSON.toJSONString(XsCodeMessageTool.getFailedMessage(null)));
			return "asset/asset_finish";
		}
	}



}
