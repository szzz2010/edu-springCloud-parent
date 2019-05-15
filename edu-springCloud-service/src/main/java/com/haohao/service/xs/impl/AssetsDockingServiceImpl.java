package com.haohao.service.xs.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.haohao.constant.OrderStatusEnums;
import com.haohao.service.xs.AssetsDockingService;
import com.haohao.util.springTools.springJdbc.helper.MapObjHelper;
import com.haohao.util.springTools.springJdbc.helper.SqlHelper;
import com.haohao.util.springTools.springJdbc.helper.TimeHelper;
import com.haohao.util.tools.RequestToXS;
import com.haohao.util.tools.XSMethodActionTool;
import com.haohao.util.tools.XsCodeMessageTool;
import com.haohao.util.tools.XsConfig;
import com.haohao.util.tools.XsFileToZipUtil;
import com.haohao.util.tools.XsFtpClientUtil;
import com.haohao.util.tools.XsOrderUtil;
import com.haohao.util.tools.XsCodeMessageTool.CodeMessage;

@Service
public class AssetsDockingServiceImpl extends AssetsDockingHelper implements AssetsDockingService {

	private static final Logger log = LoggerFactory.getLogger(AssetsDockingServiceImpl.class);

	// 查询开户 开始----------------------------------------------------------------
	@Override
	public Boolean hasOpenAcount(Map<String, Object> params) throws Exception {
		// 获取参数
		int company_id = Integer.parseInt(String.valueOf(params.get("company_id")));
		Map<String, Object> ac_company_orderMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id = ? ", company_id);
		String id_card = (String) ac_company_orderMap.get("loan_company_id_card");
		// 1.先查本库中是否有账户
		Map<String, Object> bankAccountMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_account where company_id = ? and id_card = ? ", company_id, id_card);
		if (ObjectUtils.isEmpty(bankAccountMap)) {
			// 2.如果本库中没有，再查学习
			Map<String, Object> sendMap = new HashMap<>();
			sendMap.put("idCard", id_card);
			Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.BORROWER_EXISTS_CHECK);

			// 测试数据
			// resultMap = new HashMap<>();
			// resultMap.put("result", "0000");
			// resultMap.put("hasAcct", "1");
			// resultMap.put("bankUserId", "001");
			// resultMap.put("idCard", "002");

			// 返回结果 result VARCHAR(12) "0000：成功 ,9999：失败" N
			String result = (String) resultMap.get("result");
			if ("0000".equals(result)) {
				// 是否开户 hasAcct VARCHAR(10) Y 0：未开户，1：已开户；
				int hasAcct = (int) resultMap.get("hasAcct");
				if (0 == hasAcct) {
					log.info(">>>>>学习开户查询：未开户");
					return false;
				} else if (1 == hasAcct) {
					log.info(">>>>>学习开户查询：已开户   将自动保存开户信息");
					resultMap.put("company_id", company_id);
					saveAccountInfo(resultMap);
					return true;
				} else {
					log.info(">>>>>学习开户查询：未查询到确定的开户状态");
					return null;
				}
			} else {
				log.info(">>>>>学习开户查询：未查询到确定的开户状态");
				return null;
			}
		} else {
			// 本库中有 则返回有户
			log.info(">>>>>学习开户查询：本库中查到开户信息");
			return true;
		}
	}

	private void saveAccountInfo(Map<String, Object> params) {
		int company_id = (int) params.get("company_id");
		String bankUserId = (String) params.get("bankUserId"); // bankUserId 银行子账户 VARCHAR(32)
		String idCard = (String) params.get("idCard"); // idCard 证件号 VARCHAR(32)
		String name = (String) params.get("name"); // name 姓名 VARCHAR(32)
		String mobile = (String) params.get("mobile"); // mobile 手机号 VARCHAR(32)
		String bankNum = (String) params.get("bankNum"); // bankNum 银行卡 VARCHAR(32)
		String start_card_num = (String) params.get("bankBindNo"); // bankNum 银行卡 VARCHAR(32)
		String bankName = (String) params.get("bankName"); // bankName 银行名称 VARCHAR(20)

		Map<String, Object> account = new HashMap<>();
		account.put("company_id", company_id);
		account.put("bank_company_id", bankUserId);
		account.put("id_card", idCard);
		account.put("create_time", new Date());
		Number i = mysqlSpringJdbcDao.addSelectiveAndGetId("ac_xs_company_bank_account", account);
		if(i.intValue()>0){
			log.info("保存账户成功  company_id = [{}]", company_id);
		}else{
			log.info("保存账户失败  company_id = [{}]", company_id);
		}
		if (StringUtils.isNotBlank(bankNum)) {
			// 有户有卡 保存卡信息
			log.info("有户有卡  保存卡信息  company_id = [{}]", company_id);
			Map<String, Object> bankCard = new HashMap<>();
			bankCard.put("company_id", company_id);
			bankCard.put("card_num", bankNum);
			bankCard.put("start_card_num", start_card_num);
			bankCard.put("bank_name", bankName);
			bankCard.put("card_mobile", mobile);
			bankCard.put("is_temp", 0);
			bankCard.put("create_time", new Date());
			mysqlSpringJdbcDao.addSelectiveAndGetId("ac_xs_company_bank_card", bankCard);
		}

	}
	// 查询开户 结束----------------------------------------------------------------

	// 开户绑卡开始----------------------------------------------------------------
	@Override
	public Map<String, Object> cardSet(Map<String, Object> params) throws Exception {
		int company_id = Integer.parseInt(String.valueOf(params.get("company_id")));
		String mobile = (String) params.get("mobile");
		String cardNum = (String) params.get("cardNum");
		String bankName = (String) params.get("bankName");
		// 检测是否有可用卡
		List<Map<String, Object>> bandCardList = mysqlSpringJdbcDao.queryForList(" select * from ac_xs_company_bank_card where company_id = ? and card_status = 1 and is_temp=0 ", company_id);
		if (!ObjectUtils.isEmpty(bandCardList)) {
			Map<String, Object> returnMap = new HashMap<>();
			returnMap.put("code", "9999");
			returnMap.put("msg", "存在可用银行卡，无需绑定");
			log.info("用户已存在可用银行卡，无需绑定，company_id:" + company_id);
			return returnMap;
		}

		// 现行处理银行卡信息
		preHandleCardInfo(params);

		// 检测开户未绑卡
		Boolean hasOpenAcount = hasOpenAcount(params);

		Map<String, Object> ac_company_orderMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id = ? ", company_id);
		String id_card = (String) ac_company_orderMap.get("loan_company_id_card");
		Map<String, Object> bankAccountMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_account where company_id = ? and id_card = ? ", company_id, id_card);

		String name = (String) ac_company_orderMap.get("loan_company_name");
		params.put("id_card", id_card);
		params.put("name", name);

		if (BooleanUtils.isTrue(hasOpenAcount)) {
			log.info("已经开户，检测库中是否有可用卡");
			List<Map<String, Object>> CardList = mysqlSpringJdbcDao.queryForList(" select * from ac_xs_company_bank_card where company_id = ? and card_status = 1 and is_temp=0 ", company_id);
			if (!ObjectUtils.isEmpty(CardList)) {
				Map<String, Object> returnMap = new HashMap<>();
				returnMap.put("code", "9999");
				returnMap.put("msg", "存在可用银行卡，无需绑定");
				log.info("用户已存在可用银行卡，无需绑定，company_id:" + company_id);
				return returnMap;
			}
			log.info("已经开户，未绑卡，走绑卡通道");
			return buildBankCardBindPara(params);
		}
		log.info("未有开户记录,走开户绑卡");
		return buildAcctCreatePara(params);
	}

	private void preHandleCardInfo(Map<String, Object> params) {
		int company_id = (int) params.get("company_id");
		String card_mobile = (String) params.get("mobile");
		String card_num = (String) params.get("cardNum");
		String bank_name = (String) params.get("bankName");

		Map<String, Object> bankCard = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_card where company_id = ? and is_temp = 1 order by create_time desc limit 1 ", company_id);
		if (ObjectUtils.isEmpty(bankCard)) {
			mysqlSpringJdbcDao.insertOrUpdate("  INSERT INTO ac_xs_company_bank_card (company_id, card_num, bank_name, card_mobile,is_temp , create_time) VALUES (?,?,?,?,?,?);  ", company_id, card_num, bank_name, card_mobile, 1,
					new Date());
		} else {
			int id = (int) bankCard.get("id");
			mysqlSpringJdbcDao.insertOrUpdate("  update ac_xs_company_bank_card set card_num=?, bank_name=?, card_mobile=? where id = ? ", card_num, bank_name, card_mobile, id);
		}
	}

	
	// 开户绑卡参数
	private Map<String, Object> buildAcctCreatePara(Map<String, Object> params) throws Exception {

		String name = (String) params.get("name");
		String idNo = (String) params.get("id_card");
		String accNo = (String) params.get("cardNum");
		int company_id = (int) params.get("company_id");
		String mobile = (String) params.get("mobile");
		Map<String, Object> sendMap = MapObjHelper.getMapSortedUpByKey();
		sendMap.put("timestamp", TimeHelper.getCurrentTimeByFormat(TimeHelper.YYYYMMDDHHMMSS)); // 交易时间 datetime 必填
		sendMap.put("busOrderId", XsOrderUtil.createBusOrderId(company_id)); // 三方业务流水号 varchar(30) 必填
		sendMap.put("tranCode", "NETL01"); // 交易码 varchar(10) 必填 固定值： NETL01
		sendMap.put("hyType", "1"); // 用户类型 varchar(1) 必填 1： 企业 ，2： 个人
		sendMap.put("role", "2"); // 用户角色 varchar(1) 必填 1：出借人， 2： 借款人 ，3：担保人
		sendMap.put("name", name); // 用户名称 varchar（100）必填 个人为姓名，法人为公司名称
		sendMap.put("idType", "73"); // 用户证件类型 varchar(3) 必填 3 统一社会信用代码（传数字）
		sendMap.put("idNo", idNo); // 用户证件号码 varchar(30) 必填
		sendMap.put("accNo", accNo); // 银行卡号/账号 varchar(30) 必填 （20180315监管整改不再取该字段而是让客户在银行界面输入，但不能为空）
		// sendMap.put("type","2"); //银行卡类型 varchar(1) 非必填 1：本行（平安银行） 2：他行
		sendMap.put("mobile", mobile); // 手机号 varchar(11) 必填 在银行界面反显，可修改
		sendMap.put("channelType", "P");// 交易渠道 varchar(1) 非必填 P：PC M：手机等移动端（纯H5） 非必输，不输默认为P
		sendMap.put("returnUrl", XSMethodActionTool.getXsH5ReturnUrlByMethod(XSMethodActionTool.acctCreate)); // 前端地址 varchar（100）必填

		Map<String, Object> returnMap = RequestToXS.createH5Body(sendMap);
		return returnMap;
	}

	// 直接绑卡参数
	private Map<String, Object> buildBankCardBindPara(Map<String, Object> params) throws Exception {

		String name = (String) params.get("name");
		String idNo = (String) params.get("id_card");
		String accNo = (String) params.get("cardNum");
		int company_id = (int) params.get("company_id");

		Map<String, Object> sendMap = MapObjHelper.getMapSortedUpByKey();
		sendMap.put("timestamp", TimeHelper.getCurrentTimeByFormat(TimeHelper.YYYYMMDDHHMMSS)); // 交易时间 datetime 必填
		sendMap.put("busOrderId", XsOrderUtil.createBusOrderId(company_id)); // 三方业务流水号  String(30) 必填
		sendMap.put("tranCode", "NETL05"); // 交易码 String(10) 必填 固定值为 NETL05
		sendMap.put("hyType", "1"); // 用户类型 String(10) 必填
		sendMap.put("name", name); // 用户名称 String（100）必填 个人为姓名，法人为公司名称
		sendMap.put("idType", "73"); // 用户证件类型String(3) 必填 73 统一社会信用代码（传数字）
		sendMap.put("idNo", idNo); // 用户证件号 String(30) 必填
		sendMap.put("accNo", accNo); // 银行卡号 String(30) 必填
		// treeMap.put("type",""); // 银行卡类型 String(1) 非必填 1：本行（平安银行） 2：他行
		sendMap.put("channelType", "P");// 交易渠道 String(1) 非必填 P：PC M：手机等移动端 非必输，不输默认为P
		sendMap.put("returnUrl", XSMethodActionTool.getXsH5ReturnUrlByMethod(XSMethodActionTool.bankcardBind)); // 前端地址 String（100）必填

		Map<String, Object> returnMap = RequestToXS.createH5Body(sendMap);
		return returnMap;
	}
	// 开户绑卡结束----------------------------------------------------------------

	//开户绑卡异步通知
	@Override
	public void openAccount(Map<String, Object> params) {
		log.info("开户绑卡异步通知params=[{}]", params);
		String result = (String) params.get("result");
		if (!"0000".equals(result)) {
			return ;// 异步通知不需要返回值
		}
		String busOrderId = (String) params.get("busOrderId");

		Integer company_id = XsOrderUtil.getCompanyIdByBusOrderId(busOrderId);
		String bank_company_id = (String) params.get("bankUserId");
		String id_card = (String) params.get("idNo");// 身份证号
		String card_num = (String) params.get("accNo");// 明文卡号
		String card_mobile = (String) params.get("mobile");
		String start_card_num = (String) params.get("bankCard");// 加密卡号
		String bank_name = (String) params.get("bankName");

		Map<String, Object> bankCardMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_card where company_id = ? and is_temp=1 order by create_time desc limit 1 ", company_id);
		if (ObjectUtils.isEmpty(bankCardMap)) {
			// 同步通知已经调用
			log.info("开户绑卡异步通知：同步已经调用了，即将保存明文卡号。");
			Map<String, Object> bankCardMap2 = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_card where company_id = ? and is_temp=0 order by create_time desc limit 1 ", company_id);
			
			//获取同步存储的  星号卡
			String start_card_num2 = (String) bankCardMap2.get("start_card_num");
			int is_same = isSameCard(card_num, start_card_num2)?1:0;
			int i = mysqlSpringJdbcDao.insertOrUpdate(" update ac_xs_company_bank_card set is_same= ? , card_num = ? where company_id = ? and is_temp = 0  ",is_same, card_num,company_id);
			if(i>0){
				log.info("开户绑卡异步通知：保存明文卡号成功。");
			}
			return ;
		}
		Map<String, Object> sendMap = new HashMap<>();
		sendMap.put("company_id", company_id);
		sendMap.put("bank_company_id", bank_company_id);
		sendMap.put("id_card", id_card);
		sendMap.put("card_num", card_num);
		sendMap.put("card_mobile", card_mobile);
		sendMap.put("start_card_num", start_card_num);
		sendMap.put("bank_name", bank_name);

		createBankAccount(sendMap);
		// 异步通知不需要返回值
		return ;
	}

	// 开户绑卡同步通知
	@Override
	public Map<String, Object> openAccountH5(Map<String, Object> params) {
		log.info("开户绑卡同步通知params=[{}]", params);
		try {
			String errorCode = (String) params.get("errorCode");
			if (!"000000".equals(errorCode)) {
				log.info("h5请求非成功结果");
				return XsCodeMessageTool.getFailedMessage(CodeMessage.open_pingAn_account_failed);
			}
			String busOrderId = (String) params.get("busOrderId");// 业务流水号

			Integer company_id = XsOrderUtil.getCompanyIdByBusOrderId(busOrderId);
			String start_card_num = (String) params.get("accNo");// 带*号的银行卡号
			String bank_company_id = (String) params.get("custAccId");
			String card_mobile = (String) params.get("mobile");
			String bank_name = (String) params.get("bankName");

			Map<String, Object> ac_company_orderMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id = ? ", company_id);
			String id_card = (String) ac_company_orderMap.get("loan_company_id_card");// 身份证号

			Map<String, Object> bankCardMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_card where company_id = ? and is_temp=1 order by create_time desc limit 1 ", company_id);
			if (ObjectUtils.isEmpty(bankCardMap)) {
				// 异步已经调用 
				log.info("开户绑卡同步通知：  异步已经调用，同步不用操作了。");
				return XsCodeMessageTool.getSuccessMessage(CodeMessage.open_pingAn_account_success);
			}
			String card_num = (String) bankCardMap.get("card_num");// 明文卡号
			Map<String, Object> sendMap = new HashMap<>();
			sendMap.put("company_id", company_id);
			sendMap.put("bank_company_id", bank_company_id);
			sendMap.put("id_card", id_card);
			sendMap.put("card_num", card_num);
			sendMap.put("card_mobile", card_mobile);
			sendMap.put("start_card_num", start_card_num);
			sendMap.put("bank_name", bank_name);
			createBankAccount(sendMap);
			return XsCodeMessageTool.getSuccessMessage(CodeMessage.open_pingAn_account_success);
		} catch (Exception e) {
			log.info("开户绑定出现异常");
			e.printStackTrace();
			return XsCodeMessageTool.getFailedMessage(CodeMessage.open_pingAn_account_failed);
		}
	}

	// 绑卡异步通知
	@Override
	public void bankCardBind(Map<String, Object> params) {
		String result = (String) params.get("result");
		if (!"0000".equals(result)) {
			return ;// 异步通知不需要返回值
		}
		String busOrderId = (String) params.get("burOrderId");

		Integer company_id = XsOrderUtil.getCompanyIdByBusOrderId(busOrderId);
		String id_card = (String) params.get("idNo");// 身份证号
		String card_num = (String) params.get("accNo");// 明文卡号
		String card_mobile = (String) params.get("mobile");
		String start_card_num = (String) params.get("bankCard");// 加密卡号
		String bank_name = (String) params.get("bankName");// TODO

		Map<String, Object> bankCardMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_card where company_id = ? and is_temp=1 order by create_time desc limit 1 ", company_id);
		if (ObjectUtils.isEmpty(bankCardMap)) {
			// 同步通知已经调用
			log.info("绑卡异步通知：同步已经调用了，即将保存明文卡号。");
			Map<String, Object> bankCardMap2 = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_card where company_id = ? and is_temp=0 order by create_time desc limit 1 ", company_id);
			
			//获取同步存储的  星号卡
			String start_card_num2 = (String) bankCardMap2.get("start_card_num");
			int is_same = isSameCard(card_num, start_card_num2)?1:0;
			int i = mysqlSpringJdbcDao.insertOrUpdate(" update ac_xs_company_bank_card set is_same= ? , card_num = ? where company_id = ? and is_temp = 0  ",is_same, card_num,company_id);
			if(i>0){
				log.info("绑卡异步通知：保存明文卡号成功。");
			}
			return ;
		}
		
		Map<String, Object> sendMap = new HashMap<>();
		sendMap.put("company_id", company_id);
		sendMap.put("id_card", id_card);
		sendMap.put("card_num", card_num);
		sendMap.put("card_mobile", card_mobile);
		sendMap.put("start_card_num", start_card_num);
		sendMap.put("bank_name", bank_name);
		saveBankCard(sendMap);
		return ;
	}

	// 绑卡同步通知
	@Override
	public Map<String, Object> bankCardBindH5(Map<String, Object> params) {
		log.info("绑卡同步通知params=[{}]", params);
		try {
			String errorCode = (String) params.get("errorCode");
			if (!"000000".equals(errorCode)) {
				log.info("h5请求非成功结果");
				return XsCodeMessageTool.getFailedMessage(CodeMessage.bank_card_bind_failed);
			}
			String busOrderId = (String) params.get("busOrderId");// 业务流水号
			Integer company_id = XsOrderUtil.getCompanyIdByBusOrderId(busOrderId);
			String start_card_num = (String) params.get("accNo");// 带*号的银行卡号
			String bank_company_id = (String) params.get("custAccId");
			String card_mobile = (String) params.get("mobile");
			String bank_name = (String) params.get("bankName");

			Map<String, Object> bankCardMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_card where company_id = ? and is_temp=1 order by create_time desc limit 1 ", company_id);
			if (ObjectUtils.isEmpty(bankCardMap)) {
				// 异步已经调用 
				log.info("绑卡同步通知：  异步已经调用，同步不用操作了。");
				return XsCodeMessageTool.getSuccessMessage(CodeMessage.bank_card_bind_success);
			}
		
			String card_num = (String) bankCardMap.get("card_num");// 明文卡号
			Map<String, Object> sendMap = new HashMap<>();
			sendMap.put("company_id", company_id);
			sendMap.put("bank_company_id", bank_company_id);
			sendMap.put("card_num", card_num);
			sendMap.put("card_mobile", card_mobile);
			sendMap.put("start_card_num", start_card_num);
			sendMap.put("bank_name", bank_name);
			saveBankCard(sendMap);
			return XsCodeMessageTool.getSuccessMessage(CodeMessage.bank_card_bind_success);
		} catch (Exception e) {
			log.info("绑卡同步通知异常");
			e.printStackTrace();
			return XsCodeMessageTool.getFailedMessage(CodeMessage.bank_card_bind_failed);
		}
	}

	// 更换银行卡--------------------------------------------------------------------------------
	@Override
	public Map<String, Object> cardChange(Map<String, Object> params) throws Exception {
		Map<String, Object> returnMap = new HashMap<>();
		// 现行处理银行卡信息
		preHandleCardInfo(params);
		int company_id = Integer.parseInt(String.valueOf(params.get("company_id")));

		Map<String, Object> ac_company_orderMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id = ? ", company_id);
		String id_card = (String) ac_company_orderMap.get("loan_company_id_card");
		String name = (String) ac_company_orderMap.get("loan_company_name");
		Map<String, Object> bankCard = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_card where  company_id = ? and card_status = 1 and is_temp = 0  ", company_id);
		if (ObjectUtils.isEmpty(bankCard)) {
			log.info("没有可用银行卡更换，请走绑卡通道");
			returnMap.put("code", "9999");
			returnMap.put("msg", "没有可用银行卡更换，请走绑卡通道");
			return returnMap;
		}
		
		String card_num = (String) params.get("cardNum");
		String oldAccNo = (String) bankCard.get("card_num");

		Map<String, Object> sendMap = MapObjHelper.getMapSortedUpByKey();
		sendMap.put("timestamp", TimeHelper.getCurrentTimeByFormat(TimeHelper.YYYYMMDDHHMMSS)); // 交易时间 datetime 必填
		sendMap.put("busOrderId", XsOrderUtil.createBusOrderId(company_id)); // 三方业务流水号String(30)
		sendMap.put("tranCode", "NETL27"); // 交易码 String(10) 必填 固定值为 NETL27
		sendMap.put("hyType", "1"); // 用户类型 String(1) 必填 1 企业 2 个人
		sendMap.put("name", name); // 用户名称 String（100）必填
		sendMap.put("idType", "73"); // 用户证件类型 String(3) 必填 73 统一社会信用代码
		sendMap.put("idNo", id_card); // 用户证件号码 String(30) 必填
		sendMap.put("accNo", card_num); // 用户证件号码 String(30) 必填
		sendMap.put("OldRelatedAcctId", oldAccNo); // 原绑定提现账号String(30) 必填 前后四位明文中间*屏蔽的银行卡/账户，银行进行匹配识别
		sendMap.put("channelType", "P"); // 交易渠道 String(1) 非必填
		sendMap.put("returnUrl", XSMethodActionTool.getXsH5ReturnUrlByMethod(XSMethodActionTool.bankcardChange)); // 前端地址 String（100）必填
		returnMap = RequestToXS.createH5Body(sendMap);
		return returnMap;
	}

	// 更换银行卡--------------------------------------------------------------------------------

	// 换卡异步通知
	@Override
	public void bankcardChange(Map<String, Object> params) {
		String result = (String) params.get("result");
		if (!"0000".equals(result)) {
			return ;// 异步通知不需要返回值
		}
		String busOrderId = (String) params.get("burOrderId");

		Integer company_id = XsOrderUtil.getCompanyIdByBusOrderId(busOrderId);
		String id_card = (String) params.get("idNo");// 身份证号
		String card_num = (String) params.get("accNo");// 明文卡号
		String card_mobile = (String) params.get("mobile");
		String start_card_num = (String) params.get("bankCard");// 加密卡号
		String bank_name = (String) params.get("bankName");

		Map<String, Object> bankCardMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_card where company_id = ? and is_temp=1 order by create_time desc limit 1 ", company_id);
		if (ObjectUtils.isEmpty(bankCardMap)) {
			// 同步通知已经调用
			log.info("换卡异步通知：同步已经调用了，即将保存明文卡号。");
			Map<String, Object> bankCardMap2 = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_card where company_id = ? and is_temp=0 and card_status = 1 order by create_time desc limit 1 ", company_id);
			
			//获取同步存储的  星号卡
			String start_card_num2 = (String) bankCardMap2.get("start_card_num");
			int is_same = isSameCard(card_num, start_card_num2)?1:0;
			int i = mysqlSpringJdbcDao.insertOrUpdate(" update ac_xs_company_bank_card set is_same= ? , card_num = ? where company_id = ? and is_temp = 0 and card_status = 1 ",is_same, card_num,company_id);
			if(i>0){
				log.info("绑卡异步通知：保存明文卡号成功。");
			}
			return ;
		}
		
		Map<String, Object> sendMap = new HashMap<>();
		sendMap.put("company_id", company_id);
		sendMap.put("id_card", id_card);
		sendMap.put("card_num", card_num);
		sendMap.put("card_mobile", card_mobile);
		sendMap.put("start_card_num", start_card_num);
		sendMap.put("bank_name", bank_name);
		changeBankCard(sendMap);
		return ;
	}

	// 换卡同步通知
	@Override
	public Map<String, Object> bankcardChangeH5(Map<String, Object> params) {
		log.info("绑卡同步通知params=[{}]", params);

		try {
			String errorCode = (String) params.get("errorCode");
			if (!"000000".equals(errorCode)) {
				log.info("h5请求非成功结果");
				return XsCodeMessageTool.getFailedMessage(CodeMessage.bank_card_change_failed);
			}
			String busOrderId = (String) params.get("busOrderId");// 业务流水号
			Integer company_id = XsOrderUtil.getCompanyIdByBusOrderId(busOrderId);
			String start_card_num = (String) params.get("accNo");// 带*号的银行卡号
			String bank_company_id = (String) params.get("custAccId");
			String card_mobile = (String) params.get("mobile"); // 存管银行预留手机号
			String bank_name = (String) params.get("BankName");
			Map<String, Object> bankCardMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_card where company_id = ? and is_temp=1 order by create_time desc limit 1 ", company_id);
			if (ObjectUtils.isEmpty(bankCardMap)) {
				// 异步已经调用 
				log.info("换卡同步通知：  异步已经调用，同步不用操作了。");
				return XsCodeMessageTool.getSuccessMessage(CodeMessage.bank_card_change_success);
			}
			String card_num = (String) bankCardMap.get("card_num");// 明文卡号

			Map<String, Object> sendMap = new HashMap<>();
			sendMap.put("company_id", company_id);
			sendMap.put("bank_company_id", bank_company_id);
			sendMap.put("card_num", card_num);
			sendMap.put("card_mobile", card_mobile);
			sendMap.put("start_card_num", start_card_num);
			sendMap.put("bank_name", bank_name);
			changeBankCard(sendMap);
			return XsCodeMessageTool.getSuccessMessage(CodeMessage.bank_card_change_success);
		} catch (Exception e) {
			log.info("换卡同步通知异常");
			e.printStackTrace();
			return XsCodeMessageTool.getFailedMessage(CodeMessage.bank_card_change_failed);
		}
	}

	// 修改预留手机号开始----------------------------------------------------------------------------
	@Override
	public Map<String, Object> upCardMobile(Map<String, Object> params) throws Exception {
		// 检测开户未绑卡
		Integer company_id = Integer.parseInt(String.valueOf(params.get("company_id")));
		Map<String, Object> ac_company_orderMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id = ? ", company_id);
		String id_card = (String) ac_company_orderMap.get("loan_company_id_card");
		Map<String, Object> bankAccountMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_account where company_id = ? and id_card = ? ", company_id, id_card);

		String name = (String) ac_company_orderMap.get("loan_company_name");
		params.put("id_card", id_card);
		params.put("name", name);

		if (ObjectUtils.isEmpty(bankAccountMap)) {
			// 未开户，不可设置
			Map<String, Object> map = new HashMap<>();
			map.put("code", "9999");
			map.put("msg", "不可操作");
			log.info("用户还未开通存管，company_id:" + company_id);
			return map;
		}

		Map<String, Object> bankCard = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_card where company_id = ? and card_status = 1  and is_temp = 0 order by create_time desc limit 1 ", company_id);
		if (ObjectUtils.isEmpty(bankCard)) {
			// 未开户，不可设置
			Map<String, Object> map = new HashMap<>();
			map.put("code", "9999");
			map.put("msg", "不可操作");
			log.info("用户未绑卡，没有预留手机号需要修改，company_id:" + company_id);
			return map;
		}

		params.put("oldMobile", bankCard.get("card_mobile"));
		return buildModifyPhoneNum(params);
	}

	// 构造修改预留手机号参数
	private Map<String, Object> buildModifyPhoneNum(Map<String, Object> params) throws Exception {

		Integer company_id = Integer.parseInt(String.valueOf(params.get("company_id")));
		String name = (String) params.get("name");
		String id_card = (String) params.get("id_card");
		String newMobile = (String) params.get("mobile");
		String oldMobile = (String) params.get("oldMobile");

		Map<String, Object> sendMap = MapObjHelper.getMapSortedUpByKey();
		sendMap.put("timestamp", TimeHelper.getCurrentTimeByFormat(TimeHelper.YYYYMMDDHHMMSS));// 交易时间 必填 datetime
		sendMap.put("busOrderId", XsOrderUtil.createBusOrderId(company_id));// 交易业务流水号 必填 String(30)
		sendMap.put("tranCode", "NETL19");// 交易码 必填 String(10)
		sendMap.put("name", name);// 用户名称 必填 String(100)
		sendMap.put("idNo", id_card);// 用户证件号码 必填 String(30)
		sendMap.put("channelType", "P");// 交易渠道 必填 String（10）
		sendMap.put("returnUrl", XSMethodActionTool.getXsH5ReturnUrlByMethod(XSMethodActionTool.modifyPhoneNum));// 前端地址 必填  String（100）

		sendMap.put("mobile0", oldMobile);// 原手机号 必填 String(30)
		sendMap.put("mobile", newMobile);// 新手机号 必填 String(30)
		sendMap.put("flag", "Y");// 原手机号是否可以收到验证码 Y:能， N:不能

		return RequestToXS.createH5Body(sendMap);
	}
	// 修改预留手机号
	// 结束----------------------------------------------------------------------------

	// 异步修改手机号
	@Override
	public Map<String, Object> modifyPhoneNum(Map<String, Object> params) {
		log.info("修改手机号异步通知，params=[{}]", params);
		String result = (String) params.get("result");
		if (!"0000".equals(result)) {
			return null;// 异步通知不需要返回值
		}
		String busOrderId = (String) params.get("busOrderId");
		Integer company_id = XsOrderUtil.getCompanyIdByBusOrderId(busOrderId);
		String card_mobile = (String) params.get("mobile");
		mysqlSpringJdbcDao.insertOrUpdate(" update ac_xs_company_bank_card set card_mobile = ? where company_id = ? and card_status = 1 and is_temp = 0 ", card_mobile, company_id);
		return null;

	}

	// 修改手机号同步通知
	@Override
	public Map<String, Object> modifyPhoneNumH5(Map<String, Object> params) {
		log.info("修改手机号同步通知，params=[{}]", params);
		try {
			String errorCode = (String) params.get("errorCode");
			if (!"000000".equals(errorCode)) {
				log.info("h5请求非成功结果");
				return XsCodeMessageTool.getFailedMessage(CodeMessage.modify_mobile_failed);
			}
			String busOrderId = (String) params.get("busOrderId");// 业务流水号
			Integer company_id = XsOrderUtil.getCompanyIdByBusOrderId(busOrderId);
			String card_mobile = (String) params.get("mobile");
			mysqlSpringJdbcDao.insertOrUpdate(" update ac_xs_company_bank_card set card_mobile = ? where company_id = ? and card_status = 1 and is_temp = 0 ", card_mobile, company_id);
			return XsCodeMessageTool.getSuccessMessage(CodeMessage.modify_mobile_success);
		} catch (Exception e) {
			log.info("修改预留手机号同步通知异常");
			e.printStackTrace();
			return XsCodeMessageTool.getFailedMessage(CodeMessage.modify_mobile_failed);
		}
	}

	// 重置交易密码开始-----------------------------------------------------------------------
	@Override
	public Map<String, Object> resetPwd(Map<String, Object> params) throws Exception {
		// 检测开户未绑卡
		int company_id = Integer.parseInt(String.valueOf(params.get("company_id")));
		Map<String, Object> ac_company_orderMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id = ? ", company_id);
		String id_card = (String) ac_company_orderMap.get("loan_company_id_card");
		Map<String, Object> bankAccountMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_account where company_id = ? and id_card = ? ", company_id, id_card);

		String name = (String) ac_company_orderMap.get("loan_company_name");
		params.put("id_card", id_card);
		params.put("name", name);

		if (ObjectUtils.isEmpty(bankAccountMap)) {
			// 未开户，不可设置
			Map<String, Object> map = new HashMap<>();
			map.put("code", "9999");
			map.put("msg", "不可操作");
			log.info("用户还未开通存管，company_id:" + company_id);
			return map;
		}
		return buildResetDealpwd(params);
	}

	// 构造重置交易密码参数
	private Map<String, Object> buildResetDealpwd(Map<String, Object> params) throws Exception {
		int company_id = Integer.parseInt(String.valueOf(params.get("company_id")));
		String name = (String) params.get("name");
		String id_card = (String) params.get("id_card");
		Map<String, Object> sendMap = MapObjHelper.getMapSortedUpByKey();
		sendMap.put("timestamp", TimeHelper.getCurrentTimeByFormat(TimeHelper.YYYYMMDDHHMMSS));// 交易时间 必填 datetime
		sendMap.put("busOrderId", XsOrderUtil.createBusOrderId(company_id));// 交易业务流水号 必填 String(30)
		sendMap.put("tranCode", "NETL21");// 交易码 必填 String(10)
		sendMap.put("idNo", id_card);// 用户证件号码 必填 String(30)
		sendMap.put("role", "2");// 用户角色 必填 String(1) 1出借人，2借款人，3担保人
		// sendMap.put("custAccId", "");// 银行子账号 非必填 String(30)
		sendMap.put("name", name);// 用户名称 必填 String(100)
		sendMap.put("channelType", "P");// 交易渠道 必填 String（10）
		sendMap.put("returnUrl", XSMethodActionTool.getXsH5ReturnUrlByMethod(XSMethodActionTool.resetDealpwd));// 前端地址 必填 String（100）

		return RequestToXS.createH5Body(sendMap);
	}
	// 重置交易密码结束-----------------------------------------------------------------------

	// 重置交易密码同步通知
	@Override
	public Map<String, Object> resetDealpwdH5(Map<String, Object> params) {
		log.info("重置交易密码同步通知，params=[{}]", params);
		String errorCode = (String) params.get("errorCode");
		if (!"000000".equals(errorCode)) {
			log.info("h5请求非成功结果");
			return XsCodeMessageTool.getFailedMessage(CodeMessage.reset_pingAn_pwd_failed);
		}
		return XsCodeMessageTool.getSuccessMessage(CodeMessage.reset_pingAn_pwd_success);
	}

	//查询是否设置交易密码----------------------------------------------
	@Override
	public Boolean hasSetPwd(int company_id){
		Map<String, Object> ac_company_orderMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id = ? ", company_id);
		String id_card = (String) ac_company_orderMap.get("loan_company_id_card");
		
		Map<String,Object> sendMap = new HashMap<>();
		sendMap.put("idCard", id_card);
		Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.BORROWER_DEALPWD_SEARCH);
		log.info("设置交易密码返回参数： resultMap={}",resultMap);
		String isPwd = "";
		try {
			isPwd = (String) resultMap.get("isPwd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if("0".equals(isPwd)){
			return false;
		}
		if("1".equals(isPwd)){
			return true;
		}
		if("2".equals(isPwd)){
			return false;
		}
		if("3".equals(isPwd)){
			return true;
		}
		return null;
	}
	
	
	// 修改交易密码开始------------------------------------------------------------------------
	@Override
	public Map<String, Object> upPwd(Map<String, Object> params) throws Exception {
		// 检测开户未绑卡
		int company_id = (int) params.get("company_id");
		Map<String, Object> ac_company_orderMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id = ? ", company_id);
		String id_card = (String) ac_company_orderMap.get("loan_company_id_card");
		Map<String, Object> bankAccountMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_account where company_id = ? and id_card = ? ", company_id, id_card);

		String name = (String) ac_company_orderMap.get("name");
		params.put("id_card", id_card);
		params.put("name", name);

		if (ObjectUtils.isEmpty(bankAccountMap)) {
			// 未开户，不可设置
			Map<String, Object> map = new HashMap<>();
			map.put("code", "9999");
			map.put("msg", "不可操作");
			log.info("用户还未开通存管，company_id:" + company_id);
			return map;
		}
		return buildUpdateDealpwd(params);
	}

	// 构造修改交易密码的参数
	private Map<String, Object> buildUpdateDealpwd(Map<String, Object> params) throws Exception {
		int company_id = (int) params.get("company_id");
		String name = (String) params.get("name");
		String id_card = (String) params.get("id_card");
		Map<String, Object> sendMap = MapObjHelper.getMapSortedUpByKey();
		sendMap.put("timestamp", TimeHelper.getCurrentTimeByFormat(TimeHelper.YYYYMMDDHHMMSS));// 交易时间 必填 datetime
		sendMap.put("busOrderId", XsOrderUtil.createBusOrderId(company_id));// 交易业务流水号 必填  String(30)
		sendMap.put("tranCode", "NETL20");// 交易码 必填 String(10)
		sendMap.put("idNo", id_card);// 用户证件号码 必填 String(30)
		sendMap.put("role", "2");// 用户角色 必填 String(1) 1出借人，2借款人，3担保人
		// sendMap.put("custAccId", "");// 银行子账号 非必填 String(30)
		sendMap.put("name", name);// 用户名称 必填 String(100)
		sendMap.put("channelType", "P");// 交易渠道 必填 String（10）
		sendMap.put("returnUrl", XSMethodActionTool.getXsH5ReturnUrlByMethod(XSMethodActionTool.updateDealpwd));// 前端地址 必填  String（100）

		return RequestToXS.createH5Body(sendMap);
	}
	// 修改交易密码结束-----------------------------------------------------------------------------------

	// 修改交易密码同步通知
	@Override
	public Map<String, Object> updateDealpwdH5(Map<String, Object> params) {
		log.info("修改交易密码同步通知，params=[{}]", params);
		String errorCode = (String) params.get("errorCode");
		if (!"000000".equals(errorCode)) {
			log.info("h5请求非成功结果");
			return XsCodeMessageTool.getFailedMessage(CodeMessage.modify_pingAn_pwd_failed);
		}
		return XsCodeMessageTool.getSuccessMessage(CodeMessage.modify_pingAn_pwd_success);
	}

	// 设置授权信息开始-------------------------------------------------------------------------------
	@Override
	public Map<String, Object> doAuth(Map<String, Object> params) throws Exception {
		// 检测开户未绑卡
		int company_id = Integer.parseInt(String.valueOf(params.get("company_id")));
		Map<String, Object> ac_company_orderMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id = ? ", company_id);
		String id_card = (String) ac_company_orderMap.get("loan_company_id_card");
		Map<String, Object> bankAccountMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_account where company_id = ? and id_card = ? ", company_id, id_card);

		if (ObjectUtils.isEmpty(bankAccountMap)) {
			// 未开户，不可设置
			Map<String, Object> map = new HashMap<>();
			map.put("msg", "不可操作");
			map.put("code", "9999");
			log.info("用户还未开通存管，company_id:" + company_id);
			return map;
		}

		String custAccId = (String) bankAccountMap.get("bank_company_id");

		Map<String, Object> sendMap = MapObjHelper.getMapSortedUpByKey();
		sendMap.put("timestamp", TimeHelper.getCurrentTimeByFormat(TimeHelper.YYYYMMDDHHMMSS));// 交易时间 必填  datetime
		sendMap.put("busOrderId", XsOrderUtil.createBusOrderId(company_id));// 交易业务流水号 必填 String(30)
		sendMap.put("tranCode", "NETL17"); // N String(10) 交易码
		sendMap.put("idNo", id_card); // N String(30) 用户证件号码
		sendMap.put("custAccId", custAccId); // 银行会员子账号 custAccId String(30) 必填
		sendMap.put("type", "010010"); // N String(6) 授权类型
		// treeMap.put("startDate", ""); //Y String(8) 授权起始日期
		// treeMap.put("endDate", ""); //Y String(8) 授权终止日期
		// treeMap.put("amtStart", ""); //Y number(12,2) 授权起始金额
		// treeMap.put("amtEnd", ""); //Y number(12,2) 授权金额上限
		sendMap.put("channelType", "P"); // N String（10） 交易渠道
		sendMap.put("returnUrl", XSMethodActionTool.getXsH5ReturnUrlByMethod(XSMethodActionTool.setAuthor));// 前端地址  必填 String（100）
		return RequestToXS.createH5Body(sendMap);
	}
	// 设置授权信息结束------------------------------------------------------------------------------

	// 设置授权信息异步通知
	@Override
	public Map<String, Object> borrowSetAuthor(Map<String, Object> params) {
		log.info("设置授权信息异步通知，params=[{}]", params);
		String result = (String) params.get("result");
		if (!"0000".equals(result)) {
			return null; // 异步通知 不需要返回
		}
		try {
			String orderid = (String) params.get("authOrderId");
			params.put("orderid", orderid);
			saveAuthorInfo(params);
		} catch (Exception e) {
			log.info("", e);
			return null; // 异步通知 不需要返回
		}
		return null; // 异步通知 不需要返回
	}

	// 设置授权信息同步通知
	@Override
	public Map<String, Object> borrowSetAuthorH5(Map<String, Object> params) {
		log.info("设置 授权信息 同步通知 params=[{}]", params);
		try {
			String errorCode = (String) params.get("errorCode");
			if (!"000000".equals(errorCode)) {
				return XsCodeMessageTool.getFailedMessage(CodeMessage.set_authInfo_failed);
			}
			boolean saveAuthorInfo = saveAuthorInfo(params);
			if(saveAuthorInfo){
				return XsCodeMessageTool.getSuccessMessage(CodeMessage.set_authInfo_success);
			}else{
				return XsCodeMessageTool.getFailedMessage(CodeMessage.set_authInfo_failed);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("设置授权信息同步通知异常");
			return XsCodeMessageTool.getFailedMessage(CodeMessage.set_authInfo_failed);
		}

	}

	// 保存额度-----------------------------------------------------
	@Override
	public Map<String, Object> saveContract(Map<String, Object> params) throws Exception {
		log.info("资产对接AssetsDockingServiceImpl：saveContract");

		BigDecimal apply_money = new BigDecimal(String.valueOf(params.get("quotaSum")));// 文档叫 quotaSum
		String start_date = (String) params.get("startDate");
		String invalid_date = (String) params.get("invalidDate");

		Map<String, Object> returnMap = new HashMap<>();
		String contract_code = "XS-DKZC";
		String apply_code = XsOrderUtil.getSPADateUuidCode();
		BigDecimal remain_money = apply_money;

		Map<String, Object> ac_xs_contract = new HashMap<String, Object>();
		ac_xs_contract.put("contract_code", contract_code); // '合约编号',
		ac_xs_contract.put("apply_code", apply_code); // 申请编号
		ac_xs_contract.put("apply_money", apply_money); //
		ac_xs_contract.put("remain_money", remain_money); //
		ac_xs_contract.put("start_date", start_date); //
		ac_xs_contract.put("invalid_date", invalid_date); //
		ac_xs_contract.put("create_time", TimeHelper.getCurrentTime());

		mysqlSpringJdbcDao.addSelectiveAndGetId("ac_xs_contract", ac_xs_contract);

		returnMap.put("id", apply_code);
		returnMap.put("code", "0000");
		returnMap.put("msg", "操作成功");
		return returnMap;
	}
	
	//校验是否可以设置进件----------------------------------------------
	@Override
	public Boolean isAbleToDeployOrder(int company_id){
		Map<String, Object> ac_company_orderMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id = ? ", company_id);
		String id_card = (String) ac_company_orderMap.get("loan_company_id_card");
		
		Map<String,Object> sendMap = new HashMap<>();
		sendMap.put("idCardNo", id_card);
		Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.LOAN_ENABLE_CHECK);
		log.info("校验是否可以进件: resultMap={}",resultMap);
		String isLoan = "";
		try {
			isLoan = (String) resultMap.get("isLoan");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if("0".equals(isLoan)){
			return false;
		}
		if("1".equals(isLoan)){
			return true;
		}
		return null;
	}
	
	// 自动推送进件-------------------------------------------------

	@Override
	public void autoDeployOrder() {
		log.info("自动推送进件...开始");
		// 1.查询所有需要推送的订单
		List<Map<String, Object>> orderList = mysqlSpringJdbcDao.queryForList(" select * from ac_company_order where loan_status = 1 ");
		if (ObjectUtils.isEmpty(orderList)) {
			log.info("自动推送进件：没有需要推送的单子了。");
			return;
		}
		for (Map<String, Object> order : orderList) {
			int order_id = (int) order.get("id");
			try {
				log.info("自动进件：开始进件order_id=[{}]",order_id);
				doDeploy(order);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("自动进件：进件出现异 常order_id=[{}]",order_id);
				continue;
			}
		}
	}
	// 自动推送进件-------------------------------------------------

	// 附件查询----------------------------------------------------
	@Override
	public Map<String, Object> queryAttachmentInfo(Map<String, Object> params) {
		String loanNumber = (String) params.get("loanNumber");
		Map<String, Object> order = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where order_no = ? ", loanNumber);
		if (ObjectUtils.isEmpty(order)) {
			return getAttachmentFailed(loanNumber, "合同编号没找到对应的订单");
		}
		// 上传附件
		boolean ftpResult = uploadAttachment(order);
		if (!ftpResult) { 
			log.info("上传附件失败，loanNumber={}" + loanNumber);
			return getAttachmentFailed(loanNumber, "上传附件失败");
		}
		return getAttchmentSuccess(loanNumber);
	}

	private boolean uploadAttachment(Map<String, Object> order) {
		try {
			int orderId = (int) order.get("id");
			String order_no = (String) order.get("order_no");
			int company_id = (int) order.get("company_id");
			String LEGAL_CARD_TOP = (String) mysqlSpringJdbcDao.queryForObject(" select doc_url from sp_credit where company_id = ? and credit_type = 'LEGAL_CARD_TOP' order by create_time desc limit 1 ",String.class, company_id);
			String LEGAL_CARD_BOT = (String) mysqlSpringJdbcDao.queryForObject(" select doc_url from sp_credit where company_id = ? and credit_type = 'LEGAL_CARD_BOT' order by create_time desc limit 1 ",String.class, company_id);
			if (ObjectUtils.isEmpty(LEGAL_CARD_TOP)||ObjectUtils.isEmpty(LEGAL_CARD_BOT)) {
				log.info("idCardFacePath  为空！");
				return false;
			}
			String[] split = StringUtils.split(LEGAL_CARD_TOP, "/");
			String[] split2 = StringUtils.split(LEGAL_CARD_BOT, "/");
			// 企业法人的身份证
			// /xs/haohao/data/qiye/sp/20180619/201b05a7-dbbd-4e82-96f7-a4d34886dd16.png
		
			// 1.压缩zip文件，并按照某种规则命名
			String sourceFilePath = "/" + split[0] + "/" + split[1] + "/" + split[2] + "/" + split[3] + "/"+ split[4] + "/"+ split[5] + "/";
			String zipFileName = order_no + ".zip";
			boolean flag = XsFileToZipUtil.fileToZip(sourceFilePath, sourceFilePath, zipFileName,new String[][]{{split[6],"idCardPhotoFront"},{split2[6],"idCardPhotoBack"}});
			if (!flag) {
				log.info("查询附件：orderId:" + orderId + " 附件压缩失败。");
				return false;
			}
			log.info("进件调配：orderId:" + orderId + " 已经准备好附件");
			// 2.上传附件,到远程ftp服务器 "/data/ftp/tt_xs/attachment"
			String remoteFilePath = XsConfig.xs_ftp_filePath + "/";
			XsFtpClientUtil ftpClientUtil = new XsFtpClientUtil(XsConfig.xs_ftp_host, Integer.parseInt(XsConfig.xs_ftp_port), XsConfig.xs_ftp_username, XsConfig.xs_ftp_password);
			return ftpClientUtil.put2(remoteFilePath, zipFileName, sourceFilePath + zipFileName, true);
		} catch (Exception e) {
			log.info("LoanAllocationTask.error={}", e);
		}
		return false;
	}

	private Map<String, Object> getAttchmentSuccess(String loanNumber) {
		String remoteFilePath = XsConfig.xs_ftp_filePath + "/";
		String zipFileName = loanNumber + ".zip";
		Map<String, Object> resp = new HashMap<>();
		resp.put("id", loanNumber);
		resp.put("result", "0000");
		resp.put("message", "成功");
		resp.put("filePath", remoteFilePath + zipFileName); // remoteFilePath+zipFileName
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> file = new HashMap<String, Object>();
		file.put("fileName", "B1_01.jpg");
		file.put("fileRealName", "idCardPhotoFront.png");
		file.put("fileCategory", "身份证");
		file.put("fileType", 1);
		Map<String, Object> file2 = new HashMap<String, Object>();
		file2.put("fileName", "B1_02.jpg");
		file2.put("fileRealName", "idCardPhotoBack.png");
		file2.put("fileCategory", "身份证");
		file2.put("fileType", 1);
		list.add(file);
		list.add(file2);
		resp.put("file", list);
		return resp;
	}

	private Map<String, Object> getAttachmentFailed(String loanNumber, String message) {
		Map<String, Object> resp = new HashMap<>();
		resp.put("id", loanNumber);
		resp.put("result", "9999");
		resp.put("message", message);
		resp.put("filePath", "");
		resp.put("file", Collections.emptyList());
		return resp;
	}
	// 附件查询------------------------------------------------------

	// 进件结果通知---------------------------------------------------------------
	@Override
	public Map<String, Object> deployResultNotice(Map<String, Object> params) {
		log.info(">>>>>>>>>>>>>>>>>>>>>>接收到进件结果通知");
		String order_no = (String) params.get("loanNumber");
		String status = (String) params.get("status"); // 进件结果（0：失败, 1：成功）
		Map<String, Object> batch_order = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_batch_order where order_no = ? and deploy_status = 0 order by create_time desc limit 1 ", order_no);
		if (ObjectUtils.isEmpty(batch_order)) {
			return getFailed("进件结果通知:借款编号对应的批次订单不存在。或状态不为初始状态");
		}
		Map<String, Object> order = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where order_no = ?  order by create_time desc limit 1 ", order_no);
		Boolean resultFlag = null;
		String message = null; // 如果失败，则返回失败原因
		if ("0".equals(status)) {
			log.info("进件结果通知:进件失败");
			message = (String) params.get("message") + "status=" + status;
			resultFlag = false;
		} else if ("1".equals(status)) {
			log.info("进件结果通知:进件成功");
			message = "进件成功";
			resultFlag = true;
		} else {
			log.info("无效的进件结果通知  orderNo={}", order_no);
			return getFailed("无效的进件结果通知" + order_no);
		}
		Object[] noticeResult = new Object[] { resultFlag, message };
		Map<String, Object> sendMap = new HashMap<>();
		sendMap.put("batch_order", batch_order);
		sendMap.put("noticeResult", noticeResult);
		sendMap.put("order", order);
		Boolean flag = handleDeployResult(sendMap);
		if (BooleanUtils.isTrue(flag)) {
			return getSuccess();
		} else {
			return getFailed("失败");
		}
	}
	// 进件结果通知----------------------------------------------------------------

	// 进件结果查询----------------------------------------------------------------
	@Override
	public void searchDeployResult() {
		// 查询所有需要 查询进件结果的订单
		log.info("进件结果查询...");
		// 查询所有3天内deploy状态为0的单子
		List<Map<String, Object>> batch_orderList = mysqlSpringJdbcDao.queryForList(" select * from ac_xs_batch_order where deploy_status = 0 order by create_time asc limit 10  ");
		if (ObjectUtils.isEmpty(batch_orderList)) {
			log.info("进件结果查询：没有需要查询进件结果的单子了。");
			return;
		}
		for (Map<String, Object> batch_order : batch_orderList) {
			try {
				int order_id = (int) batch_order.get("order_id");
				Map<String, Object> order = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id = ? ", order_id);
				int loan_status = (int) order.get("loan_status");
				if (loan_status != 2 ) {
					log.info("进件结果查询：订单状态已经不是进件初始状态或者进件失败状态,无效操作状态,status={}", order.get("status"));
					continue;
				}
				String order_no = (String) order.get("order_no");
				Object[] noticeResult = searchDeployResult(order_no);

				Map<String, Object> sendMap = new HashMap<>();
				sendMap.put("batch_order", batch_order);
				sendMap.put("noticeResult", noticeResult);
				sendMap.put("order", order);
				handleDeployResult(sendMap);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
	}

	// 查询进件结果
	public Object[] searchDeployResult(String orderNo) {
		try {
			Map<String, Object> sendMap = new HashMap<>();
			sendMap.put("loanNumber", orderNo);
			Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.LOAN_RESULT_SEARCH);
			String message = (String) resultMap.get("message");
			if ("0000".equals(resultMap.get("result"))) {
				if ("1".equals(resultMap.get("status"))) {
					return new Object[] { true, message };
				} else if ("0".equals(resultMap.get("status"))) {
					return new Object[] { false, message };
				} else {
					return new Object[] { null, message };
				}
			} else {
				log.info("{}", message);
				return new Object[] { null, message };
			}
		} catch (Exception e) {
			log.info("{}", e);
			return new Object[] { null, null };
		}
	}

	// 进件结果查询----------------------------------------------------------------

	// 贷款审批通知----------------------------------------------------------------
	@Override
	public Map<String, Object> loanAuditNotice(Map<String, Object> params) {
		log.info(">>>>>>>>>>接收到贷款审批通知");
		String loanNumber = (String) params.get("loanNumber");// 合约编号
		String result = (String) params.get("result");// 00：审批中 02：审批通过 03：审批拒绝
		String loanAmount = (String) params.get("loanAmount");// 审批金额
		String endTime = (String) params.get("endTime");// 审批完成时间

		Map<String, Object> batch_order = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_batch_order where order_no = ? and deploy_status = 1 order by create_time desc limit 1 ", loanNumber);

		if (ObjectUtils.isEmpty(batch_order)) {
			log.info("不存在该批次的订单,或批次订单状态不为待审核。  orderNo={}", loanNumber);
			return getAuditFailed(loanNumber, "不存在该批次的订单,或批次订单状态不为待审核。 ");
		}
		Map<String, Object> order = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where order_no = ?  order by create_time desc limit 1 ", loanNumber);
		Boolean resultFlag = null;
		String message = null;
		// result 00：审批中 02：审批通过 03：审批拒绝
		if ("02".equals(result)) {
			log.info("审批通过  orderNo={}", loanNumber);
			resultFlag = true;
		} else if ("03".equals(result)) {
			log.info("审批拒绝  orderNo={}", loanNumber);
			resultFlag = false;
		} else {
			log.info("无效的审批通知  orderNo={}", loanNumber);
			return getAuditFailed(loanNumber, "无效的审批通知");
		}
		Object[] noticeResult = new Object[] { resultFlag, message };
		Map<String, Object> sendMap = new HashMap<>();
		sendMap.put("batch_order", batch_order);
		sendMap.put("noticeResult", noticeResult);
		sendMap.put("order", order);
		Boolean flag = handleLoanAuditResult(sendMap);
		if (BooleanUtils.isTrue(flag)) {
			return getAuditSuccess(loanNumber);
		} else {
			return getAuditFailed(loanNumber, "操作失败");
		}
	}

	private Map<String, Object> getAuditSuccess(String loanNumber) {
		Map<String, Object> resp = new HashMap<>();
		resp.put("result", "0000");
		resp.put("message", "成功");
		resp.put("id", loanNumber);
		return resp;
	}

	private Map<String, Object> getAuditFailed(String loanNumber, String message) {
		Map<String, Object> resp = new HashMap<>();
		resp.put("result", "9999");
		resp.put("message", "失败:" + message);
		resp.put("id", loanNumber);
		return resp;
	}
	// 贷款审批通知--------------------------------------------------------------------------

	// 贷款审批结果查询------------------------------------------------------------------------
	@Override
	public void searchLoanAuditResult() {
		// 查询所有需要 查询审批结果的订单
		log.info("审批结果查询...");
		// 查询所有deploy状态为1的单子
		List<Map<String, Object>> batch_orderList = mysqlSpringJdbcDao.queryForList(" select * from ac_xs_batch_order where deploy_status = 1 order by create_time asc limit 10  ");
		if (ObjectUtils.isEmpty(batch_orderList)) {
			log.info("审批结果查询：没有需要查询审批结果的单子了。");
			return ;
		}
		for (Map<String, Object> batch_order : batch_orderList) {
			try {
				int order_id = (int) batch_order.get("order_id");
				Map<String, Object> order = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id = ? ", order_id);
				if (!OrderStatusEnums.ASSET_PUSH_SUCCESS.name().equals(order.get("status"))&&!OrderStatusEnums.ASSET_AUTH_FAILED.name().equals(order.get("status"))) {
					log.info("审批结果查询：订单状态不是进件成功或者审批失败,status={},无效操作状态", order.get("status"));
					continue ;
				}
				String order_no = (String) order.get("order_no");
				Object[] noticeResult = queryLoanAuditInfo(order_no);

				Map<String, Object> sendMap = new HashMap<>();
				sendMap.put("batch_order", batch_order);
				sendMap.put("noticeResult", noticeResult);
				sendMap.put("order", order);
				handleLoanAuditResult(sendMap);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
	}

	// 查询贷款审批结果
	private Object[] queryLoanAuditInfo(String orderNo) {
		try {
			Map<String, Object> sendMap = new HashMap<>();
			sendMap.put("loanNumber", orderNo);
			Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.LOAN_AUDIT_SEARCH);
			String message = (String) resultMap.get("message");
			String result = (String) resultMap.get("result");
			// 00：审批中，02：审批通过，03：审批拒绝，99：审批异常
			if ("02".equals(result)) {
				return new Object[] { true, message };
			} else if ("03".equals(result)) {
				return new Object[] { false, message };
			} else {
				return new Object[] { null, message };
			}
		} catch (Exception e) {
			log.info("{}", e);
			return new Object[] { null, null };
		}
	}
	// 贷款审批结果查询----------------------------------------------------------------------

	// 放款结果通知--------------------------------------------------------------------
	@Override
	public Map<String, Object> loanLoanResultNotice(Map<String, Object> params) {
		//{"endTime":"2019-01-14 18:51:38","loanAmount":"1000.000000","loanNumber":"test004","result":"04"}
		String loanNumber = (String) params.get("loanNumber");
		return getLoanSuccess(loanNumber);
		/*String result = (String) params.get("result");
		String endTime = (String) params.get("endTime");
		BigDecimal loanAmount = new BigDecimal((String) params.get("loanAmount"));

		if (loanNumber == null || loanNumber.length() == 0) {
			return getLoanFailed("loanNumber 订单号不能为空");
			
		}
		if (result == null || result.length() == 0) {
			return getLoanFailed("result 状态不能为空");
		}
		if (endTime == null || !TimeHelper.isDate(endTime, TimeHelper.YYYY_MM_DD_HH_MM_SS)) {
			return getLoanFailed("endTime 完成时间错误");
		}
		if (ObjectUtils.isEmpty(loanAmount)) {
			return getLoanFailed("放款金额 loanAmount 不正确");
		}

		Map<String, Object> order = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where loan_number = ? and loan_status = 2 ",loanNumber);
		if (ObjectUtils.isEmpty(order)) {
			log.info("不存在此单号的订单loanNumber={},或者订单状态不为审批成功或者打款失败", loanNumber);
			return getLoanFailed("没有找到此单号对应的订单，或者订单状态不为审批成功或者打款失败 ");
		}

		Boolean resultFlag = null;
		String message = (String) params.get("message");
		// 04：放款成功 , 05：放款失败,00：放款中
		if ("04".equals(result)) {
			log.info("放款成功  orderNo={}", loanNumber);
			resultFlag = true;
		} else if ("05".equals(result)) {
			log.info("放款失败  orderNo={}", loanNumber);
			resultFlag = false;
		} else {
			log.info("无效的放款通知  orderNo={}", loanNumber);
			// return getFailed("无效的放款通知");
			return getLoanSuccess(loanNumber);
		}

		Object[] noticeResult = new Object[] { resultFlag, message, endTime };
		Map<String, Object> company = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id = ? ", order.get("company_id"));
		Map<String, Object> sendMap = new HashMap<>();
		sendMap.put("company", company);
		sendMap.put("noticeResult", noticeResult);
		sendMap.put("order", order);
		Boolean flag = handleLoanLoanResult(sendMap);
		if (BooleanUtils.isTrue(flag)) {
			return getLoanSuccess(loanNumber);
		} else {
			return getLoanFailed("处理异常");
		}*/
	}

	private Map<String, Object> getLoanFailed(String message) {
		Map<String, Object> resp = new HashMap<>();
		resp.put("result", "9999");
		resp.put("message", message);
		return resp;
	}

	private Map<String, Object> getLoanSuccess(String loanNumber) {
		Map<String, Object> resp = new HashMap<>();
		resp.put("result", "0000");
		resp.put("message", "成功");
		resp.put("id", loanNumber);// 进件合同编号，如果成功，需要有值。
		return resp;
	}
	// 放款结果通知--------------------------------------------------------------------

	// 放款结果查询--------------------------------------------------------------------
	@Override
	public void searchLoanResult() {
		// 查询所有需要 查询放款结果的订单
		log.info("放款结果查询...");
		// 查询所有deploy状态为1的单子
		List<Map<String, Object>> batch_orderList = mysqlSpringJdbcDao.queryForList(" select * from ac_xs_batch_order where deploy_status = 3 order by create_time asc limit 10  ");
		if (ObjectUtils.isEmpty(batch_orderList)) {
			log.info("放款结果查询：没有需要查询放款结果的单子了。");
			return;
		}
		for (Map<String, Object> batch_order : batch_orderList) {
			int order_id = (int) batch_order.get("order_id");
			try {
				Map<String, Object> order = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id = ? ", order_id);
				if(ObjectUtils.isEmpty(order)){
					log.info("订单异常 : 未找到订单 ，order_id=[{}]",order_id);
					continue;
				}
				if (!OrderStatusEnums.ASSET_AUTH_SUCCESS.name().equals(order.get("status")) && !OrderStatusEnums.LOAN_FAILED.name().equals(order.get("status"))) {
					log.info("单子状态不为不为审批成功或者放款失败！无效查询orderId={}", order_id);
					continue;
				}
				String order_no = (String) order.get("order_no");
				Object[] noticeResult = searchLoanLoanResult(order_no);
				Map<String, Object> company = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id = ? ", order.get("company_id"));
				Map<String, Object> sendMap = new HashMap<>();
				sendMap.put("company", company);
				sendMap.put("noticeResult", noticeResult);
				sendMap.put("order", order);
				handleLoanLoanResult(sendMap);
			} catch (Exception e) {
				log.info("订单异常  ，order_id=[{}]",order_id);
				e.printStackTrace();
				continue;
			}
		}

	}

	// 查询放款结果
	private Object[] searchLoanLoanResult(String orderNo) {
		try {
			Map<String, Object> sendMap = new HashMap<>();
			sendMap.put("loanNumber", orderNo);
			Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.LOAN_LOAN_SEARCH);
			String result = (String) resultMap.get("result");
			String message = (String) resultMap.get("message");// 放款失败 ，需要返回原因
			String endTime = (String) resultMap.get("endTime");// 放款成功 此项有值
			// 00：放款中，04：放款成功 ，05：放款失败，99：放款异常
			if ("04".equals(result)) {
				log.info("放款成功！orderNo=[{}],resultMap=[{}]", orderNo, resultMap);
				return new Object[] { true, message, endTime, };
			} else if ("05".equals(result)) {
				log.info("放款失败！orderNo=[{}],resultMap=[{}]", orderNo, resultMap);
				return new Object[] { false, message, null };
			} else {
				log.info("未查询到有效的放款状态！orderNo=[{}],resultMap=[{}]", orderNo, resultMap);
				return new Object[] { null, message, null };
			}
		} catch (Exception e) {
			log.info("{}", e);
			return new Object[] { null, null, null };
		}
	}
	// 放款结果查询--------------------------------------------------------------------

	// 查询电子签章--------------------------------------------------------------------
	@Override
	public void searchElectronicSignature() {
		// 查询所有需要 查询电子签章的订单
		log.info("电子签章查询...");
		// 查询所有  deploy=5     dzqz_status=0   的单子
		List<Map<String, Object>> batch_orderList = mysqlSpringJdbcDao.queryForList(" select * from ac_xs_batch_order where deploy_status = 5 and dzqz_status in (0,2) order by create_time asc limit 10  ");
		if (ObjectUtils.isEmpty(batch_orderList)) {
			log.info("电子签章查询：没有需要查询电子签章的单子了。");
		}
		for (Map<String, Object> batch_order : batch_orderList) {
			doSearchElectSign(batch_order);
		}
	}
	
	@Override
	public boolean searchElectronicSignatureByOrderId(int order_id) {
		log.info("手动电子签章查询...");
		// 查询所有  deploy=5     dzqz_status=0   的单子
		Map<String, Object> batch_order = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_batch_order where deploy_status = 5 and dzqz_status in (0,2) and order_id = ? order by create_time desc limit 1  ");
		if (ObjectUtils.isEmpty(batch_order)) {
			log.info("手动电子签章查询：没有需要查询电子签章的单子了。");
		}
		return doSearchElectSign(batch_order);
	}
	
	// 查询电子签章--------------------------------------------------------------------

	// 发起订单提现--------------------
	@Override
	public Map<String, Object> moneyTixian(Map<String, Object> params) throws Exception {
		// 参数组一   客户自行提现：暂不支持    
		Integer company_id = null;
		BigDecimal money = null;

		// 参数组二  订单提现：  支持  
		Integer order_id = null;

		// 格式化参数+防止重复刷新提交
		if (params.containsKey("order_id")) {
			order_id = Integer.parseInt(String.valueOf(params.get("order_id")));
			params.put("order_id", order_id);
			String sql = SqlHelper.getParamSql(" select * from ac_xs_withdraw_records where order_id = ? and is_temp = 1 order by create_time desc limit 1  ", order_id);
			Map<String, Object> withdraw_record = mysqlSpringJdbcDao.queryForMap(sql);
			if(!ObjectUtils.isEmpty(withdraw_record)){
				//防止重复刷新提交
				Date update_time = (Date) withdraw_record.get("update_time");
				if(!validateRefreshSubmit(update_time)){
					log.info("发起提现：3分钟内已经发起过一次操作，请稍后再试，order_id = [{}]",order_id);
					Map<String, Object> map = new HashMap<>();
					map.put("code", "9999");
					map.put("data", XsCodeMessageTool.getFailedMessage(CodeMessage.order_tixian_has_submit_in_3Minutes));
					return map;
				}
				//防止发起超时提现而导致  覆盖busOrderId
				if(searchTiXianActionResult(order_id)==1){
					log.info("发起提现:该订单已经发起过成功的体现请求，请等待提现结果查询。");
					Map<String, Object> map = new HashMap<>();
					map.put("code", "9999");
					map.put("data", XsCodeMessageTool.getFailedMessage(CodeMessage.order_tixian_please_wait_result));
					return map;
				}
			}
			
		} else {
			company_id = Integer.parseInt(String.valueOf(params.get("company_id")));
			money = new BigDecimal(String.valueOf(params.get("money")));
			params.put("company_id", company_id);
			params.put("money", money);
		}
		
		// 校验提现中的记录 或者订单提现中，成功的单子
		Map<String, Object> withdraw_record = null;
		if (ObjectUtils.isEmpty(order_id)) {
			String sql = SqlHelper.getParamSql(" select * from ac_xs_withdraw_records where company_id = ? and is_temp = 0 and status = 0 and order_no='' order by create_time desc limit 1  ", company_id);
			withdraw_record = mysqlSpringJdbcDao.queryForMap(sql);
			if (!ObjectUtils.isEmpty(withdraw_record)) {
				log.info("提现中，请等待提现结果查询   params=[{}]", params);
				Map<String, Object> map = new HashMap<>();
				map.put("code", "9999");
				map.put("data",XsCodeMessageTool.getFailedMessage(CodeMessage.order_tixian_please_wait_result) );
				return map;
			}
		} else {
			String sql = SqlHelper.getParamSql(" select * from ac_xs_withdraw_records where order_id = ? and is_temp = 0 and status in(0,1) order by create_time desc limit 1 ", order_id);
			withdraw_record = mysqlSpringJdbcDao.queryForMap(sql);
			if (!ObjectUtils.isEmpty(withdraw_record)) {
				log.info("该订单已经提过现了   params=[{}]", params);
				Map<String, Object> map = new HashMap<>();
				map.put("code", "9999");
				map.put("data", XsCodeMessageTool.getFailedMessage(CodeMessage.order_tixian_has_not_available_money));
				return map;
			}
		}
		// 只剩下 提现失败 或者没有提现的 重新发起提现
		return buildAccountWithdraw(params);
	}

	// 构造提现参数
	private Map<String, Object> buildAccountWithdraw(Map<String, Object> params) throws Exception {

		int order_id = (int) params.get("order_id");

		Integer company_id = null;
		BigDecimal money = null;
		String order_no = "";
		String busOrderId = "";
		if (ObjectUtils.isEmpty(order_id)) {
			company_id = (Integer) params.get("company_id");
			money = (BigDecimal) params.get("money");
			busOrderId = XsOrderUtil.createBusOrderId(company_id);
			order_id = -1;

		} else {
			Map<String, Object> order = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id = ?  ", order_id);
			order_no = (String) order.get("loan_number");
			company_id = (Integer) order.get("id");
			money = (BigDecimal) order.get("loan_contract_amt");
			busOrderId = XsOrderUtil.createBusOrderIdDDD(order_id);
		}

		Map<String, Object> ac_company_orderMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id = ? ", company_id);
		String name = (String) ac_company_orderMap.get("loan_company_name");
		String idNo = (String) ac_company_orderMap.get("loan_company_id_card");
		Map<String, Object> bankCard = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_card where company_id = ? and card_status = 1  and is_temp = 0 order by create_time desc limit 1 ", company_id);

		int is_same = (int) bankCard.get("is_same");
		String card_num = (String) bankCard.get("card_num");
		String start_card_num = (String) bankCard.get("start_card_num");
		
		String accNo = 1 == is_same ?  card_num : start_card_num;
		if(ObjectUtils.isEmpty(accNo)){
			accNo = card_num;
		}
		
		String accName = name;
		Map<String, Object> sendMap = MapObjHelper.getMapSortedUpByKey();
		sendMap.put("timestamp", TimeHelper.getCurrentTimeByFormat(TimeHelper.YYYYMMDDHHMMSS)); // 交易时间 datetime 必填
		sendMap.put("busOrderId", busOrderId); // 交易业务流水号 String(30) 必填
		sendMap.put("tranCode", "NETL12"); // 交易码 String(10) 必填
		if (!ObjectUtils.isEmpty(order_no)) {
			sendMap.put("loanNumber", order_no); // 合同编号 String(32) 非必填
		}
		sendMap.put("idNo", idNo); // 用户证件号码 String(30) 必填
		sendMap.put("name", name); // 用户名称 String（100）必填
		sendMap.put("accNo", accNo); // 银行卡号/账号 String(30) 必填
		sendMap.put("accName", accName); // 持卡人姓名/账户名称 String(100) 必填
		sendMap.put("CcyCode", "RMB"); // 币种 String(3) 必填
		sendMap.put("tranAmt", money.toString()); // 提现金额 number(12,2) 必填
		sendMap.put("chargeFee", "0.00"); // 提现手续费 number(12,2) 非必填
		sendMap.put("totalAmount", money.toString()); // 总扣费金额 number(12,2) 必填
		sendMap.put("Note", "企业资金周转"); // 备注/用途 String(100) 非必填
		sendMap.put("flag", "N"); // 是否紧急提现 String(1) 必填
		sendMap.put("channelType", "P"); // 交易渠道 String(1) 非必填
		sendMap.put("returnUrl", XSMethodActionTool.getXsH5ReturnUrlByMethod(XSMethodActionTool.accountWithdraw)); // 前端地址
																													// String（100）必填

		// 查询是否有 临时提现记录
		Map<String, Object> ac_xs_withdraw_records = null;
		if (order_id == -1) {
			ac_xs_withdraw_records = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_withdraw_records where company_id = ? and is_temp = 1 and order_no = '' and order_id = -1 ", company_id);
		} else {
			ac_xs_withdraw_records = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_withdraw_records where order_id = ? and is_temp = 1 ", order_id);
		}

		if (ObjectUtils.isEmpty(ac_xs_withdraw_records)) {
			// 没有临时记录 新增
			mysqlSpringJdbcDao.insertOrUpdate(" insert into ac_xs_withdraw_records set company_id = ? , order_id=? ,order_no=? , bus_order_id = ? ,money = ? ,create_time = ? ", company_id, order_id, order_no, busOrderId, money, new Date());
		} else {
			// 有临时记录更新
			if (order_id == -1) {
				mysqlSpringJdbcDao.insertOrUpdate(" update ac_xs_withdraw_records set bus_order_id = ? , money = ?  where company_id = ? and is_temp = 1 and order_no = '' and order_id = -1 ", busOrderId, money, company_id);
			} else {
				mysqlSpringJdbcDao.insertOrUpdate(" update ac_xs_withdraw_records set bus_order_id = ? , money = ? where order_id = ? and is_temp = 1  ", busOrderId, money, order_id);
			}
		}

		return RequestToXS.createH5Body(sendMap);
	}

	// 发起提现异步通知
	@Override
	public Map<String, Object> borrowAccountWithdraw(Map<String, Object> params) {
		log.info("发起提现：收到提现申请返回异步通知result=[{}]", params);
		String result = (String) params.get("result");
		if (!"0000".equals(result)) {
			return null;// 异步通知不需要返回值
		}
		// String busOrderId = (String) params.get("busOrderId");
		// String withDrawId = (String) params.get("withDrawId");
		handleTiXianLog(params);
		return null;
	}

	// 发起提现同步通知
	@Override
	public Map<String, Object> borrowAccountWithdrawH5(Map<String, Object> params) {
		log.info("发起提现：收到提现申请返回同步通知result=[{}]", params);
		try {
			String errorCode = (String) params.get("errorCode"); // 000000为交易成功，其他为交易异常，
			String transState = (String) params.get("transState"); // S成功 F失败 I待确认
			if (!"000000".equals(errorCode) || !("S").equals(transState)) {
				return XsCodeMessageTool.getFailedMessage(CodeMessage.order_start_tixian_failed);
			}
			String busOrderId = (String) params.get("busOrderId");// 业务流水号
			String withDrawId = (String) params.get("orderid");// 业务流水号
			Map<String, Object> sendMap = new HashMap<>();
			sendMap.put("busOrderId", busOrderId);
			sendMap.put("withDrawId", withDrawId);
			if (handleTiXianLog(sendMap)) {
				return XsCodeMessageTool.getSuccessMessage(CodeMessage.order_start_tixian_success);
			}
			return XsCodeMessageTool.getFailedMessage(CodeMessage.order_start_tixian_failed);
		} catch (Exception e) {
			log.info("发起提现同步通知异常");
			e.printStackTrace();
			return XsCodeMessageTool.getFailedMessage(CodeMessage.order_start_tixian_failed);
		}
	}

	//提现动作查询----------------------------------------------------------------
	/**
	 *  result：0不存在提现操作记录，1提现动作成功，2提现动作失败
	 */
	@Override
	public int searchTiXianActionResult(int order_id) throws Exception {
		Map<String,Object> record = mysqlSpringJdbcDao.queryForMap(" select * from  ac_xs_withdraw_records where order_id = ? and bus_order_id <> '' order by create_time desc limit 1  ", order_id);
		if(ObjectUtils.isEmpty(record)){
			return 0;
		}
		log.info("查询提现动作order_id=[{}]",order_id);
		String bus_order_id = (String) record.get("bus_order_id");
		Map<String,Object> sendMap = new HashMap<>();
		sendMap.put("searchType", "1"); // 必填  String(30) 1=当日、2=历史
		sendMap.put("busOrderId", bus_order_id); // 必填  String(30)  提现时的业务流水号
		Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.WITHDRAW_DEAL_SEARCH);
		
		String exsit = (String) resultMap.get("exists");    //VARCHAR(50)	必填	0：存在；1：不存在
		String status = (String) resultMap.get("status");   //VARCHAR(50)	必填	0：成功；1：失败
		if("0".equals(exsit)){
			if("0".equals(status)){
				String withdrawNo = (String) resultMap.get("withdrawNo");
				String order_no = (String) resultMap.get("loanNumber");
				//任何状态的单子 都可以来查询  提现信息，但是只有  没有更新提现流水号的单子，才需要更新提现流水号
				//没有更新提现流水号  肯定   is_temp = 1  ，更新完提现流水号  is_temp = 0 
				int update = mysqlSpringJdbcDao.Update(new Object[][]{{"withdraw_no",withdrawNo},{"is_temp",0}}, "ac_xs_withdraw_records", new Object[][]{{"bus_order_id",bus_order_id},{"status",0},{"is_temp",1}}) ;
				if(update>0){
					log.info("提现信息查询：发起提现成功！查询到提现流水号，更新流水号成功，请等待提现结果查询。order_id=[{}],order_no=[{}]",order_id,order_no);
				}
				return 1;
			}else{
				return 2;
			}
		}else{
			return 0 ;
		}
		
	}
	
	
	// 提现结果查询---------------------------------------------------------------
	@Override
	public void searchTiXianResult() {
		List<Map<String, Object>> list = mysqlSpringJdbcDao.queryForList(" select * from ac_xs_withdraw_records where status = 0 and is_temp=0 order by create_time desc ");
		if (ObjectUtils.isEmpty(list)) {
			log.info("没有需要查询提现结果的单子了。");
			return;
		}
		for (Map<String, Object> ac_xs_withdraw_records : list) {

			int company_id = (int) ac_xs_withdraw_records.get("company_id");
			int order_id = -1;
			String bus_order_id = (String) ac_xs_withdraw_records.get("bus_order_id");
			if (bus_order_id.contains("D")) {
				order_id = XsOrderUtil.getOrderIdByBusOrderId(bus_order_id);
				//现行查询  提现动作  更新提现流水号
				try {
					searchTiXianActionResult(order_id);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			String withdraw_no = (String) ac_xs_withdraw_records.get("withdraw_no");
			Map<String, Object> sendMap = new HashMap<>();
			sendMap.put("searchType", "1");
			sendMap.put("withdrawNo", withdraw_no);

			try {
				Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.ACCOUNT_WITHDRAW_SEARCH);
				String result = (String) resultMap.get("result");
				// 提现交易存在0000，提现交易不存在 9999
				if ("0000".equals(result)) {
					// withdrawStatus 1=成功、2=失败、4=处理中（提现交易存在即result=0000时）
					Integer withdrawStatus = (Integer) resultMap.get("withdrawStatus");
					String message = (String) resultMap.get("message");
					if (1 == withdrawStatus) {
						message = "[提现成功]" + message + ",withdrawStatus=" + withdrawStatus;
						if (order_id == -1) {
							// `status` int(1) DEFAULT '0' COMMENT
							// '提现状态（0:提现中，1提现成功，2提现失败）',
							mysqlSpringJdbcDao.Update(new Object[][] { { "status", 1 }, { "message", message } }, "ac_xs_withdraw_records",
									new Object[][] { { "withdraw_no", withdraw_no }, { "bus_order_id", bus_order_id }, { "status", 0 } });
						} else {
							// 更改订单状态
							int i = mysqlSpringJdbcDao.insertOrUpdate(" update ac_company_order set loan_status = 9 where id = ? ",order_id);
							if (i > 0) {
								log.info("订单提现成功！company_id=[{}],order_id=[{}]", company_id, order_id);
								// `status` int(1) DEFAULT '0' COMMENT
								// '提现状态（0:提现中，1提现成功，2提现失败）',
								mysqlSpringJdbcDao.Update(new Object[][] { { "status", 1 }, { "message", message } }, "ac_xs_withdraw_records",
										new Object[][] { { "withdraw_no", withdraw_no }, { "bus_order_id", bus_order_id }, { "status", 0 } });
								mysqlSpringJdbcDao.Update(new Object[][] { { "withdraw_status", 1 } }, "ac_xs_batch_order", new Object[][] { { "order_id", order_id } });
							}
						}
					} else if (2 == withdrawStatus) {
						message = "[提现失败]" + message + ",withdrawStatus=" + withdrawStatus;
						if (order_id == -1) {
							// `status` int(1) DEFAULT '0' COMMENT
							// '提现状态（0:提现中，1提现成功，2提现失败）',
							mysqlSpringJdbcDao.Update(new Object[][] { { "status", 2 }, { "message", message } }, "ac_xs_withdraw_records",
									new Object[][] { { "withdraw_no", withdraw_no }, { "bus_order_id", bus_order_id }, { "status", 0 } });
						} else {
							// 更改订单状态
							int i = mysqlSpringJdbcDao.insertOrUpdate(" update ac_company_order set status = ? where id = ? and status = ?   ", OrderStatusEnums.WITHDRAW_FAILED.name(), order_id, OrderStatusEnums.LOAN_SUCCESS.name());
							if (i > 0) {
								log.info("提现失败！company_id=[{}],order_id=[{}]", company_id, order_id);
								// `status` int(1) DEFAULT '0' COMMENT
								// '提现状态（0:提现中，1提现成功，2提现失败）',
								mysqlSpringJdbcDao.Update(new Object[][] { { "status", 2 }, { "message", message } }, "ac_xs_withdraw_records",
										new Object[][] { { "withdraw_no", withdraw_no }, { "bus_order_id", bus_order_id }, { "status", 0 } });
								mysqlSpringJdbcDao.Update(new Object[][] { { "withdraw_status", 2 } }, "ac_xs_batch_order", new Object[][] { { "order_id", order_id } });
							}
						}
					} else if (4 == withdrawStatus) {
						log.info("提现处理中！company_id=[{}],order_id=[{}],resultMap=[{}]", company_id, order_id, resultMap);
						continue;
					}
				}
			} catch (Exception e) {
				log.error("根据提现流水号查询提现结果出现异常withdrawNo：" + withdraw_no, e);
				continue;
			}
		}
	}
	// 提现结果查询---------------------------------------------------------------

	// 查询账户信息---------------------------------------------------------------
	@Override
	public Map<String, Object> getAccountInfo(Map<String, Object> params) throws Exception {
		int company_id = Integer.parseInt(String.valueOf(params.get("company_id")));
		return getAccountInfoByCompanyId(company_id);
	}
	// 查询账户信息---------------------------------------------------------------

	//担保人账户查询---------------------
	@Override
	public Map<String,Object> getAssureAccountInfo(String bankUserId){
		Map<String,Object> sendMap = new HashMap<>();
		sendMap.put("bankUserId", bankUserId);
		Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.ASSURE_ACCOUNT_SEARCH);
		return resultMap;
		
	}
	
	
	
	// 定时任务：自动还款-----------------------------------------------------------
	@Override
	public void automaticRepaymentNotice() {
		log.info(">>>>>>>>>>>>>>>>>>定时任务正常还款开始");
		// 查询 今天需要还款的单子
		List<Map<String, Object>> orderList = mysqlSpringJdbcDao.queryForList(getPaymentSql(null));
		if (ObjectUtils.isEmpty(orderList)) {
			log.info("资产对接--今天没有需要正常还款的单子了");
		} else {
			for (Map<String, Object> bigOrder : orderList) {
				try {
					Map<String, Object> dataMap = getDataMap(bigOrder, handle_type_auto);
					doRepayOrder(dataMap);
				} catch (Exception e) {
					continue;
				}
			}
		}
	}
	// 定时任务：正常还款-----------------------------------------------------------

	// 手动还款--------------------------------------------------------------
	@Override
	public Boolean manualRepaymentNotice(Map<String, Object> params) throws Exception {
		log.info("手动触发还款：params=[{}]",params);
		int order_id = Integer.parseInt(String.valueOf(params.get("order_id")));
		Map<String, Object> bigOrder = mysqlSpringJdbcDao.queryForMap(getPaymentSql(order_id));
		Map<String, Object> dataMap = getDataMap(bigOrder, handle_type_manu);
		return doRepayOrder(dataMap);
	}
	// 手动还款--------------------------------------------------------------

	
	// 申请垫资--------------------------------------------------------------
	@Override
	public boolean dzApply(Map<String, Object> params) throws Exception {
		int order_id = Integer.parseInt(String.valueOf(params.get("order_id")));
		String sql = SqlHelper.getParamSql(" select * from ac_xs_batch_order where order_id = ? and deploy_status = 5 and  repay_status in (0,2) and dz_status in (0,2)  order by create_time desc limit 1 ",order_id);
		Map<String,Object> batchOrder = mysqlSpringJdbcDao.queryForMap(sql);
		
		if(ObjectUtils.isEmpty(batchOrder)){
			log.info("垫资申请： 订单状态 不满足垫付条件！order_id=[{}] ",order_id);
			return false ;
		}
		
		Map<String,Object> order = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id = ? order by create_time desc limit 1 ", order_id) ;
		int company_id = (int) order.get("company_id");
		String order_no = (String) order.get("order_no");
		Date order_deadline = (Date) order.get("order_deadline");
		String repayDate = TimeHelper.transTimeByFormat(order_deadline, TimeHelper.YYYY_MM_DD);
		String thirdLogNo = XsOrderUtil.getDZDateUuidCode();
		
		Map<String,Object> sendMap = new HashMap<String,Object>();
		sendMap.put("loanNumber", order_no); // 债权编号  必填  VARCHAR(64)
		sendMap.put("loanTerms", 1); // 当前期次  必填  NUMBER(4)
		sendMap.put("repayDate", repayDate); // 计划还款日  必填 Date
		sendMap.put("thirdLogNo", thirdLogNo); // 交易流水号  必填 VARCHAR(100)
		Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.DZ_APPLY);
		if(ObjectUtils.isEmpty(resultMap)){
			log.info("垫资申请： 请求学习返回的结果不正确。order_id=[{}]",order_id);
			return false;
		}
		//0000：成功,  9999: 失败
		String result = (String) resultMap.get("result");
		if("0000".equals(result)){
			String sql2 = SqlHelper.getParamSql(" update ac_xs_batch_order set dz_status = 3  , dz_third_no = ? where order_id = ? and deploy_status = 5 and  repay_status in (0,2) and dz_status in (0,2) " ,thirdLogNo ,order_id);
			int i = mysqlSpringJdbcDao.insertOrUpdate(sql2);
			if(i>0){
				Map<String,Object> dzRecords = new HashMap<>();
				dzRecords.put("company_id", company_id);
				dzRecords.put("order_id", order_id);
				dzRecords.put("order_no", order_no);
				dzRecords.put("dz_third_no", thirdLogNo);
				dzRecords.put("create_time", TimeHelper.getCurrentTime());
				mysqlSpringJdbcDao.addSelectiveAndGetId("sp_xs_dz_records", dzRecords);
				log.info("垫资申请成功，请等待垫资结果通知。order_id=[{}]",order_id);
				return true;
			}else{
				log.info("垫资申请失败。order_id=[{}]",order_id);
				return false;
			}
		}else{
			log.info("垫资申请失败。order_id=[{}],message=[{}]",order_id,resultMap.get("message"));
			return false;
		}
	}
	// 申请垫资--------------------------------------------------------------

	// 垫资申请结果通知--------------------------------------------------------------
	@Override
	public Map<String, Object> dzApplyResultNotice(Map<String, Object> params) {
		Map<String,Object> returnMap = new HashMap<>();
		try{
			String loanNumber = (String) params.get("loanNumber");
			int loanTerms = Integer.parseInt( (String) params.get("loanTerms"));
			String result = (String) params.get("result");
			
			String order_no = loanNumber;
			Map<String,Object> order = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where order_no = ? order by create_time desc limit 1 ", order_no) ;
			int company_id = (int) order.get("company_id");
			int order_id = (int) order.get("id");
			
			Map<String,Object> batchOrder = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_batch_order where order_id = ? and deploy_status = 5 and  repay_status in (0,2) and dz_status=3  order by create_time desc limit 1 ",order_id);
			if(ObjectUtils.isEmpty(batchOrder)){
				log.info("垫资结果通知： 订单状态已经不为垫资中，请先重新申请垫资。");
				returnMap.put("result", "9999");
				returnMap.put("message", " 订单状态已经不为垫资中，请先重新申请垫资。");
			}
			String dz_third_no = (String) batchOrder.get("dz_third_no");
			//0000: 垫资成功   , 9999: 驳回
			if("0000".equals(result)){
				log.info("垫资结果：成功！order_no=[{}]",loanNumber);
				int i = mysqlSpringJdbcDao.insertOrUpdate(" update ac_xs_batch_order set dz_status = 1 where order_id = ? and deploy_status = 5 and  repay_status in (0,2) and dz_status=3 " ,order_id);
				if(i>0){
					String message = "[垫资成功]";
					mysqlSpringJdbcDao.Update(new Object[][]{{"dz_status",1},{"message",message}}, "sp_xs_dz_records", new Object[][]{{"dz_third_no",dz_third_no}});
				}
				
			}else if("9999".equals(result)){
				log.info("垫资结果：驳回！order_no=[{}]",loanNumber);
				int i = mysqlSpringJdbcDao.insertOrUpdate(" update ac_xs_batch_order set dz_status = 2 where order_id = ? and deploy_status = 5 and  repay_status in (0,2) and dz_status=3 " ,order_id);
				if(i>0){
					String message = "[垫资失败]"+params.get("message");
					mysqlSpringJdbcDao.Update(new Object[][]{{"dz_status",2},{"message",message}}, "sp_xs_dz_records", new Object[][]{{"dz_third_no",dz_third_no}});
				}
			}
			returnMap.put("result","0000" );
			returnMap.put("message","操作成功" );
			return returnMap;
		}catch (Exception e) {
			log.info("处理垫资结果通知异常 params = [{}]",params);
			returnMap.put("result", "9999");
			returnMap.put("message", "操作异常"+e.getCause());
			return returnMap;
		}
	}
	
	// 垫资申请结果通知--------------------------------------------------------------
	
	// 查询对账文件
	@Override
	public Map<String, Object> checkDayBill(Map<String, Object> params) {
		Map<String, Object> sendMap = new HashMap<String, Object>();
		String date = (String) params.get("date");
		sendMap.put("date", date);
		Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.BALANCE_ATTACH_SEARCH);
		return resultMap;
	}

	

	

}
