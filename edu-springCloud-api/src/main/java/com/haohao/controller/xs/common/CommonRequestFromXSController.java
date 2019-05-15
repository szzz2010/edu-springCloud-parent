package com.haohao.controller.xs.common;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.haohao.service.xs.AssetsDockingService;
import com.haohao.util.springTools.springJdbc.helper.AnnotationHelper;
import com.haohao.util.springTools.springJdbc.helper.InvokeMethod;
import com.haohao.util.springTools.springJdbc.helper.MapObjHelper;
import com.haohao.util.springTools.springJdbc.helper.RequestHelper;
import com.haohao.util.springTools.springJdbc.helper.HttpServletLogAspect.PrintLog;
import com.haohao.util.tools.RequestToXS;
import com.haohao.util.tools.XSEncryptUtil;
import com.haohao.util.tools.XSMethodActionTool;
import com.haohao.util.tools.XsCodeMessageTool;
import com.haohao.util.tools.XsConfig;

@Controller
public class CommonRequestFromXSController {

	@Autowired
	AssetsDockingService assetsDockingService;

	private Logger log = LoggerFactory.getLogger(getClass());
	
	//银行H5异步通知开始    ---------------------------------------------------------------------------------------------------------------------
    /**
     * <p>Description：学习有银行页面参与的接口异步通知</p>
     * http://localhost:8088/xs/asyncNotice
     */
	@RequestMapping(value = "/xs/asyncNotice")
	public void asyncNotice(HttpServletRequest request){
		try {
			Map<String, Object> params = RequestHelper.getParameters(request);
			log.info("进入异步通知：params = [{}]",params);
			
			String method = (String) params.get("method");
			String data = (String) params.get("data");
			String sign = (String) params.remove("sign");
			
			Map<String, Object> contentMap = JSON.parseObject(RequestToXS.passContent(data));
			String s2 = XSEncryptUtil.md5(MapObjHelper.mapObjToString(params),XsConfig.xs_md5_key);
			
			if(sign.equals(s2)){
				log.info("学习异步通知到来，method=【{}】， 解密结果content=【{}】",method,contentMap);
				String method2 = XSMethodActionTool.getActionByMethodName(method);
				Method myMethod = AnnotationHelper.findAnotationMethod(AssetsDockingService.class, method2);
				if (!ObjectUtils.isEmpty(myMethod)) {
					myMethod.invoke(assetsDockingService, contentMap);
				}else{
					log.info("学习异步通知未找到method= [{}]",method);
				}
			}else{
				log.info("验证签名不通过");
			}
			
		} catch (Exception e) {
			log.error("学习异步通知出现异常", e);
		}
	}
	
	//银行H5同步通知开始    ---------------------------------------------------------------------------------------------------------------------
	/**
	 * <p>Description：学习有银行页面参与的接口同步通知</p>
	 * http://localhost:8080/api/xs/syncNotice/sss
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/xs/syncNotice/{path}")
	public String syncNotice(@PathVariable(required = true) String path,HttpServletRequest request,ModelMap modelMap){
		//{busOrderId=1D20190116150554, error=, bankResponse={"BK_SERIAL":"1901160007277049","TranWebCode":"6034","custAccId":"6034000000096636","errorCode":"000000","errorMessage":"交易接收成功,请稍后查询处理结果","orderid":"17121560201000000132","thirdCustId":"1022156012600000047","transState":"S"}}
		Map<String,Object> params = RequestHelper.getParameters(request);
		String bankres = request.getParameter("bankResponse");
		log.info("进入同步通知：path=[{}],params = [{}]",path,params);
		log.info("bankResponse = [{}]",bankres);
		log.info("{}",request);
		
		String bankResponse = (String) params.get("bankResponse");
		String busOrderId = (String) params.get("busOrderId");
		Map<String,Object> contentMap =  JSON.parseObject(bankResponse,Map.class);
		if("null".equals(bankResponse)||ObjectUtils.isEmpty(bankResponse) || ObjectUtils.isEmpty(contentMap)|| ObjectUtils.isEmpty(busOrderId)){
			log.info("[错误]银行响应参数错误   bankResponse=[{}],busOrderId=[{}]",bankResponse,busOrderId);
			modelMap.addAttribute("returnMap",  JSON.toJSONString(XsCodeMessageTool.getFailedMessage(null)));
			return "xs/asset/asset_finish";
		}
		contentMap.put("busOrderId", busOrderId);
		try {
			String method = path;
			Method myMethod = AnnotationHelper.findAnotationMethod(AssetsDockingService.class, method);
			if (ObjectUtils.isEmpty(myMethod)) {
				log.error("学习同步通知出现异常,没有对应方法，busOrderId:" + busOrderId);
				modelMap.addAttribute("returnMap",  JSON.toJSONString(XsCodeMessageTool.getFailedMessage(null)));
				return "xs/asset/asset_finish";
			}
			Map<String, Object> data = (Map<String, Object>) myMethod.invoke(assetsDockingService, contentMap);
			modelMap.addAttribute("returnMap", JSON.toJSONString(data));

			log.info("==银行通用消息返回data:{}",JSON.toJSONString(data));

			return "xs/asset/asset_finish";
		} catch (Exception e) {
			log.error("学习同步通知出现异常,busOrderId:" + busOrderId, e);
			modelMap.addAttribute("returnMap",  JSON.toJSONString(XsCodeMessageTool.getFailedMessage(null)));
			return "xs/asset/asset_finish";
		}
	}
	
	//资产对接类接口  开始-----------------------------------------------------------------------------------------------------------------
	
	/**
	 * 21001:成功访问接口； 31001:验签通过； 41001:签名验证不通过； 41002:访问接口失败；41003:校验不通过；
	 * 41004:商户不存在；41005:没有对应接口； 41006:协议版本不支持；41007:请求已过期；
	 * 41008:不支持的签名加密；41009:没有收到参数
	 * 
	 * @param request
	 * @return.
	 * http://localhost:8088/xs/commonRequest
	 */
	@SuppressWarnings("unchecked")
	@PrintLog
	@RequestMapping(value = "/api/xs/commonRequest")
	public @ResponseBody Map<String, Object> commonRequest(HttpServletRequest request) {
		Map<String, Object> data = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		returnMap.put("code", "0000");
		returnMap.put("msg", "操作成功");
		return returnMap;
		/*returnMap.put("data", data);
		String request_content = null;
		String response_content = null;
		String xs_aes_key = XsConfig.xs_aes_key;

		// 获取请求参数
		Map<String, Object> params = RequestHelper.getParameters(request);
		if (CollectionUtils.isEmpty(params)) {
			return setReturnMessage(params, returnMap, request_content, response_content, "41009", "没有收到参数");
		}

		String sign = (String) params.get("sign");
		returnMap.put("sign", sign);

		String method = (String) params.get("method");
		log.info("学习请求方法：" + method);
		returnMap.put("method", method);
		if (StringUtils.isEmpty(method)) {
			return setReturnMessage(params, returnMap, request_content, response_content, "41005", "方法不能为空");
		}

		String content_json = (String) params.get("content");
		if (StringUtils.isEmpty(content_json)) {
			return setReturnMessage(params, returnMap, request_content, response_content, "41009", "content参数没有");
		}

		// 解密并封装主体参数
		Map<String, Object> contentMap = null;
		try {
			String content_str = XSEncryptUtil.decrypt(content_json, xs_aes_key);
			request_content = content_str;
			log.info("学习请求主体参数：" + content_str);
			contentMap = JSON.parseObject(content_str, Map.class);
		} catch (Exception e) {
			e.printStackTrace();
			return setReturnMessage(params, returnMap, request_content, response_content, "41008", "不支持的签名加密" + e.getMessage());
		}
		if (ObjectUtils.isEmpty(contentMap)) {
			return setReturnMessage(params, returnMap, request_content, response_content, "41008", "不支持的签名加密");
		}
		// 以下是做主要业务
		try {
			Method myMethod = AnnotationHelper.findAnotationMethod(AssetsDockingService.class, method);
			if (ObjectUtils.isEmpty(myMethod)) {
				return setReturnMessage(params, returnMap, request_content, response_content, "41002", "未找到该方法");
			}
			data = (Map<String, Object>) myMethod.invoke(assetsDockingService, contentMap);
		} catch (Exception e) {
			return setReturnMessage(params, returnMap, request_content, response_content, "41002", "该方法请求响应失败" + e.getMessage());
		}
		String data_aes = "";
		try {
			String data_str = JSON.toJSONString(data);
			log.info("返回参数:" + data_str);
			data_aes = XSEncryptUtil.encrypt(data_str, xs_aes_key);
			response_content = data_str;
		} catch (Exception e) {
			e.printStackTrace();
			return setReturnMessage(params, returnMap, request_content, response_content, "41008", "加密错误" + e.getMessage());
		}
		returnMap.put("data", data_aes);
		setReturnMessage(params, returnMap, request_content, response_content, "21001", "成功请求方法");
		return returnMap;*/
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, Object> setReturnMessage(Map<String, Object> params, Map<String, Object> returnMap, String request_content, String response_content, String code, String... messages) {
		StringBuilder detailMessage = new StringBuilder();
		for (String m : messages) {
			m = m == null ? "" : m;
			detailMessage.append(m);
		}
		returnMap.put("retCode", code);
		returnMap.put("message", detailMessage);
		try {
			String request_message = JSON.toJSONString(params);
			String response_message = JSON.toJSONString(returnMap);
			log.info(response_message);
			// DaoHelper.getMysqlSpringJdbcDao().insertOrUpdate(" INSERT INTO
			// hello_xs_logs
			// (direction,request_message,response_message,create_time,request_content,response_content)
			// VALUES (?,?,?,?,?,?) ", new
			// Object[]{"xs-->hello",request_message,response_message,new
			// Date(),request_content,response_content});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnMap;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/xs/commonData/commonRequest", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody Map<String, Object> commonRequest(@RequestBody(required = false) Map<String, Object> params, HttpServletRequest request) {
		try {
			if ("true".equals(params.get("invokeMethod_need_params"))) {
				return (Map<String, Object>) InvokeMethod.invoke((String) params.get("cm"), new Class[] { Map.class }, params);
			} else {
				Object returnData = InvokeMethod.invoke((String) params.get("cm"), new Class[] {});
				params.put("data", returnData);
				return params;
			}
		} catch (Exception e) {
			e.printStackTrace();
			params.put("error", e.getMessage() + e.getLocalizedMessage() + e.getCause() + e.toString());
		}
		return params;
	}

	@RequestMapping(value = "/xs/commonRequest2", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody Map<String, Object> commonRequest3(@RequestBody(required = false) Map<String, Object> params, HttpServletRequest request) {
		String method = (String) params.get("method");
		try {/*
			Map<String, Object> data = null;
			if ("saveContract".equals(method)) {
				data = assetsDockingService.saveContract(params);
			}
			if ("asyncDeployOrder".equals(method)) {
				assetsDockingService.asyncDeployOrder();
			}
			if ("asyncReDeployOrder".equals(method)) {
				assetsDockingService.asyncReDeployOrder(params);
			}
			if ("queryOrderList".equals(method)) {
				data = assetsDockingService.queryOrderList(params);
			}
			if ("queryOrderDetails".equals(method)) {
				data = assetsDockingService.queryOrderDetails(params);
			}
			if ("searchDeployResultNotice".equals(method)) {
				data = assetsDockingService.searchDeployResult(params);
			}
			if ("queryAttachmentInfo".equals(method)) {
				data = assetsDockingService.queryAttachmentInfo(params);
			}
			if ("queryLoanNoticeInfo".equals(method)) {
				data = assetsDockingService.queryLoanNoticeInfo(params);
			}
			if ("sendPreRepaymentNotice".equals(method)) {
				assetsDockingService.earlyRepaymentNotice(params);
			}
			if ("checkDayBill".equals(method)) {
				data = assetsDockingService.checkDayBill(params);
			}
			if ("test_connect".equals(method)) {
				String method2 = "hd.borrow.account.search";
				Map<String, Object> content = new HashMap<String, Object>();
				content.put("bankUserId", "");
				Map<String, Object> result = RequestToXS.request(content, method2);
				logger.info("{}", result);
				params.put("data", result);
			}
			params.put("data", data);
		*/} catch (Exception e) {
			e.printStackTrace();
			params.put("error", e.getMessage() + e.getLocalizedMessage() + e.getCause() + e.toString());
		}
		return params;
	}


}
