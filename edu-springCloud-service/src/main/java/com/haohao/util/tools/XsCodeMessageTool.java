package com.haohao.util.tools;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

public class XsCodeMessageTool {

	public enum CodeMessage {
		pc_request_success(200, "请求成功"), 
		pc_request_failure(201, "请求失败"),

		/************企业1.0    资产校验120 **************/
		open_pingAn_account_no_v1(12000, "未开通过平安银行存管账户"),
		open_pingAn_account_already_v1(12001, "已经开通过平安银行存管账户"),
		xs_financial_account_v1(12002, "学习理财人，无法开通平安银行存管账户"),
		
		sending_open_account_mobile_code_success_v1(12003, "发送平安银行开户短信验证码成功"),
		sending_open_account_mobile_code_failed_v1(12004, "发送平安银行开户短信验证码失败"),
		
		open_pingAn_account_success_v1(12005, "开通平安银行存管账户成功"),
		open_pingAn_account_failed_v1(12006, "开通平安银行存管账户失败"),
		
		
		/************企业2.0    资产校验130 **************/
		account_hasNotOpenPingAnAccount_error(13001, "您还没有开通平安银行存管账户"),
		open_pingAn_account_success(13002, "开通平安银行存管账户成功"),
		open_pingAn_account_failed(13003, "开通平安银行存管账户失败"),
		bank_card_account_exist(13004, "已开户绑卡,无需再绑定"),
		bank_card_has_not_bind_error(13005, "您还没有绑定银行卡"),
		bank_card_bind_success(13006, "银行卡绑定成功"),
		bank_card_bind_failed(13007, "银行卡绑定失败"),
		bank_card_change_success(13008, "银行卡更换成功"),
		bank_card_change_failed(13009, "银行卡更换失败"),
		modify_mobile_success(13010, "修改平安银行预留手机号成功"),
		modify_mobile_failed(13011, "修改平安银行预留手机号失败"),
		
		reset_pingAn_pwd_success(13012, "重置交易密码成功"),
		reset_pingAn_pwd_failed(13013, "重置交易密码失败"),
		
		modify_pingAn_pwd_success(13014, "修改交易密码成功"),
		modify_pingAn_pwd_failed(13015, "修改交易密码失败"),
		
		set_authInfo_success(13016, "设置授权信息成功"),
		set_authInfo_failed(13017, "设置授权信息失败"),
		
		order_start_tixian_success(13018, "发起提现请求成功"),
		order_start_tixian_failed(13019, "发起提现请求失败"),
		
		order_tixian_has_submit_in_3Minutes(13020, "3分钟内有过一次提现操作，请等待结果，稍后再试"),
		order_tixian_please_wait_result(13021, "提现中，请等待结果"),
		order_tixian_has_not_available_money(13022, "该订单已经 提现成功了"),
	
		
		
		;

		private int code;
		private String msg;
		private CodeMessage(int code, String msg) {
			this.code = code;
			this.msg = msg;
		}
		public int getCode() {
			return code;
		}
		public String getMsg() {
			return msg;
		}
	}

	private static final Logger log = LoggerFactory.getLogger(XsCodeMessageTool.class);

	public static Map<String, Object> getSuccessMessage(CodeMessage cm,Object... infoData) {
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("code",CodeMessage.pc_request_success.getCode() );
		returnMap.put("message", CodeMessage.pc_request_success.getMsg());
		if(!ObjectUtils.isEmpty(cm)){
			Map<String,Object> data = new HashMap<>();
			data.put("info", cm.getMsg());
			data.put("infoCode", cm.getCode());
			if(!ObjectUtils.isEmpty(infoData)){
				data.put("infoData", infoData[0]);
			}
			returnMap.put("data", data);
		}else{
			returnMap.put("data", null);
		}
		log.info("{}", returnMap);
		return returnMap;
	}

	public static Map<String, Object> getFailedMessage(CodeMessage cm) {
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("code",CodeMessage.pc_request_failure.getCode() );
		returnMap.put("message", CodeMessage.pc_request_failure.getMsg());
		if(!ObjectUtils.isEmpty(cm)){
			Map<String,Object> data = new HashMap<>();
			data.put("info", cm.getMsg());
			data.put("infoCode", cm.getCode());
			returnMap.put("data", data);
		}else{
            returnMap.put("data", null);
        }
		log.info("{}", returnMap);
		return returnMap;
	}
	
}
