package com.haohao.service.xs.impl_v1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import com.alibaba.fastjson.JSON;
import com.haohao.constant.InterestConfig;
import com.haohao.constant.OrderStatusEnums;
import com.haohao.util.springTools.springJdbc.MysqlSpringJdbcDao;
import com.haohao.util.springTools.springJdbc.helper.SqlHelper;
import com.haohao.util.springTools.springJdbc.helper.TimeHelper;
import com.haohao.util.tools.RequestToXS;
import com.haohao.util.tools.XSMethodActionTool;
import com.haohao.util.tools.XsConfig;
import com.haohao.util.tools.XsOrderUtil;

public class AssetsDockingHelper_v1 {
	private static final Logger log = LoggerFactory.getLogger(AssetsDockingHelper_v1.class);

	public static final BigDecimal zero = new BigDecimal("0.00");
	public static final String handle_type_auto = "automatic";
	public static final String handle_type_manu = "manual";
	public static final String pre_pay = "[pre_pay]";
	
	
	public static final String goods_brand = "品牌";
	public static final String goods_guige = "显示器屏幕规格";
	public static final String goods_model = "型号";
	public static final String goods_price = "价格";
	
	
	@Autowired
	protected MysqlSpringJdbcDao mysqlSpringJdbcDao;
	
	@Autowired
	XsService_v1 xsService_v1;
	
	public Map<String, Object> getSuccess() {
		Map<String, Object> resp = new HashMap<>();
		resp.put("result", "0000");
		resp.put("message", "成功");
		return resp;
	}

	public Map<String, Object> getFailed(String message) {
		Map<String, Object> resp = new HashMap<>();
		resp.put("result", "9999");
		resp.put("message", message);
		return resp;
	}
	
	//保存账户信息
	protected boolean saveAccountInfo(Map<String, Object> params) {
		int company_id = Integer.parseInt(String.valueOf(params.get("company_id")));
		String bankUserId = (String) params.get("bankUserId"); // bankUserId 银行子账户 VARCHAR(32)
		String id_card = (String) params.get("id_card"); // idCard 证件号 VARCHAR(32)
		String name = (String) params.get("name"); // name 姓名 VARCHAR(32)
		String mobile = (String) params.get("mobile"); // mobile 手机号 VARCHAR(32)
		String card_num = (String) params.get("bankCard"); // bankNum 银行卡 VARCHAR(32)
		String bankName = (String) params.get("bankName"); // bankName 银行名称 VARCHAR(20)

		Map<String, Object> account = new HashMap<>();
		account.put("company_id", company_id);
		account.put("bank_company_id", bankUserId);
		account.put("id_card", id_card);
		account.put("create_time", new Date());
		Number i = mysqlSpringJdbcDao.addSelectiveAndGetId("jz_ac_xs_company_bank_account", account);
		if(i.intValue()>0){
			log.info("保存账户成功  company_id = [{}]", company_id);
			Map<String, Object> bankCard = new HashMap<>();
			bankCard.put("company_id", company_id);
			bankCard.put("card_num", card_num);
			bankCard.put("start_card_num", card_num);
			bankCard.put("bank_name", bankName);
			bankCard.put("card_mobile", mobile);
			bankCard.put("is_temp", 0);
			bankCard.put("is_same", 1);
			bankCard.put("create_time", new Date());
			Number j = mysqlSpringJdbcDao.addSelectiveAndGetId("jz_ac_xs_company_bank_card", bankCard);
			if(j.intValue()>0){
				log.info("保存银行卡信息成功  company_id = [{}]", company_id);
				return true;
			}
		}else{
			log.info("保存账户失败  company_id = [{}]", company_id);
		}
		return false;
	}
	
	//查询账户信息
	protected Map<String,Object> searchAccountInfoByBankCompanyId(String bank_company_id){
		log.info("开始查询平安银行账户信息");
		Map<String,Object> sendMap = new HashMap<>();
		sendMap.put("bankUserId", bank_company_id);
		Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.BORROW_ACCOUNT_SEARCH);
		
		//   客户号ID	bankUserId	VARCHAR(32)	必填	返回客户在存管银行的唯一标示
		//   银行卡号	bankCard	VARCHAR(32)	必填	借款人开户绑定的银行卡号
		//   银行名称	bankName	VARCHAR(12)	必填	借款人开户绑定的银行名称
		//   账户名	userName	VARCHAR(50)	必填	借款人开户绑定的银行账户名
		//   账户余额	amount	NUMBER(18,2)	必填	借款人账户余额
		//   手机号	mobile	VARCHAR(50)	必填	借款人开户手机号
		//   身份证号	idCardNo	VARCHAR(50)	必填	借款人开户身份证号
		//   返回结果	result	VARCHAR(12)	必填	0000：成功       9999：失败
		//   返回信息	message	VARCHAR(50)	非必填	如果失败，需要返回失败信息。
		
		if("0000".equals(resultMap.get("result"))){
			log.info("查询到平安银行账户信息resultMap=[{}]",resultMap);
			return resultMap;
		}else{
			log.info("没有查到平安银行账户信息 resultMap=[{}]",resultMap);
			return null;
		}
	}
	
	//自动进件---------------------------------------------------------
	protected synchronized void doDeploy(Map<String, Object> order) {
		// 获取表对象
		int company_id = (int) order.get("company_id");
		int order_id = (int) order.get("id");
		String order_no = (String) order.get("order_no");
		
		BigDecimal actual_money = (BigDecimal) order.get("actual_money");// 实际借款金额
		// 查询当前合适的额度包  
		Map<String, Object> contract = mysqlSpringJdbcDao.queryForMap(getApplySql(), actual_money);
		if (ObjectUtils.isEmpty(contract)) {
			log.info("自动推送进件：order_id=[{}],没有合适的额度包。",order_id);
			return ;
		}
		Map<String, Object> company = xsService_v1.getCompanyById(company_id);
		Map<String, Object> bankCard = xsService_v1.getAbleNewestBankCardByCompanyId(company_id);
		
		// 获取数据
		String batch_code = XsOrderUtil.getSPBDateUuidCode();
		BigDecimal orderMoney = ((BigDecimal) order.get("actual_money")).setScale(2, BigDecimal.ROUND_HALF_UP); // '确认借款金额(货物入库后，评估出的借款金额)',
		BigDecimal fee = getFee(orderMoney);  //服务费  月利率*订单金额
		BigDecimal loanMoney = orderMoney; // '实际到账金额(1.0  不需要前置扣费)',
		BigDecimal interest = getOrderInterest(orderMoney);  //学习理财人的利率  11.04
		
		// '应还总额【本金+利息+借款服务费】',
		BigDecimal refund_total = orderMoney.add(interest).add(fee);
		
		//更新初始化基本金额
		int update2 = mysqlSpringJdbcDao.Update(new Object[][]{{"refund_total",refund_total},{"refund_principal",loanMoney},{"refund_interest",interest}}, "jz_ac_company_order", new Object[][]{{"order_no",order_no},{"id",order_id}});
		if(update2!=1){
			log.info("自动推送进件：order_id=[{}],更新初始化基本金额未生效。",order_id);
			return;
		}
		
		Map<String, Object> loanInfo = new HashMap<>();
		loanInfo.put("batchNo", batch_code); // 必填 批次号 VARCHAR(50)
//		loanInfo.put("authOrderId", auth.get("third_no")); // 1.0  非必填 授权流水号 VARCHAR(50)
		loanInfo.put("name", company.get("name")); // 必填 企业名字 VARCHAR(50)
		loanInfo.put("IdCardType", "73"); // 必填 证件类型 VARCHAR(18) 73 统一社会信用代码
		loanInfo.put("idCardNo", company.get("loan_company_id_card")); // 必填 证件号码 VARCHAR(11)
		
		loanInfo.put("cellPhone", bankCard.get("card_mobile")); // 必填 手机号码 VARCHAR(2)
		loanInfo.put("contractAmt", orderMoney); // 必填 合同金额 NUMBER(18,2)
		loanInfo.put("consultAmt", new BigDecimal("0.00")); // 必填 借款服务费 NUMBER(18,2)
		loanInfo.put("loanAmt", orderMoney); // 必填 放款金额 NUMBER(18,2)
		loanInfo.put("riskAmt", zero); // 必填  平台手续费 NUMBER(18,2)  1.0无需前置扣费了
		loanInfo.put("repayType", "RT04"); // 非必填 还款方式 VARCHAR(4) //RT01：等额本息 RT02：先息后本 RT04：到期本息
		loanInfo.put("creditDeposit", new BigDecimal("0.00")); // 非必填 信用保证金 NUMBER(18,2)
		loanInfo.put("premium", new BigDecimal("0.00")); // 必填 保险费 NUMBER(18,2)
		loanInfo.put("rate", XsOrderUtil.transXsRate()); // 必填 借款利率（%）NUMBER(7,4)
		loanInfo.put("productCode", "02"); // 必填 产品类型 VARCHAR(2) 01：信用贷 02：抵押贷
		loanInfo.put("loanPurpose", "1"); // 必填 借款用途 VARCHAR(2) 1：资金周转
		loanInfo.put("loanTerms", order.get("life_of_loan")); // 必填 借款期限 天 NUMBER(3)
		loanInfo.put("riskLevel", order.get("risk_level")); // 必填 风控等级 VARCHAR(20) TODO
		loanInfo.put("agencyCode", XsConfig.xs_agency_code); // 必填 机构编码 VARCHAR(20)
		
		loanInfo.put("enterpriseAddr", company.get("enterprise_address")); // 选填  企业经营注册地址  VARCHAR(20)
		loanInfo.put("loanBankNum", bankCard.get("card_num")); // 必填 放款银行卡号 VARCHAR(2)
		loanInfo.put("loanBankName", bankCard.get("bank_name")); // 必填 放款银行名称   VARCHAR(2)
		loanInfo.put("quota", company.get("quota")); // 必填 放款银行名称   VARCHAR(2)
		
		//----------------------------------------------------------------------------------------------------------------------------------
		//法人和经办人实体对象
		Map<String, Object> handler = new HashMap<>();  
		handler.put("handler", company.get("handler_name")); // 姓名
		handler.put("duty", company.get("handler_duty")); // 公司职务
		handler.put("idCard", company.get("handler_id_card")); // 身份证号
		handler.put("mobile", company.get("handler_phone")); // 手机号
		
		handler.put("corporationName", company.get("legal_name")); // 法定代表人
		handler.put("corporationIdCard", company.get("legal_id_card")); // 法定身份证号
		handler.put("corporationMobile", company.get("legal_phone")); // 法定手机号
		
		//企业基本信息
		Map<String,Object> baseInfo = new HashMap<>();
		baseInfo.put("nature", company.get("nature"));	// 企业性质		
		baseInfo.put("referProvince", company.get("refer_province")); // 贷款提交省
		baseInfo.put("referCity",  company.get("refer_city")); // 贷款提交市
		baseInfo.put("placeProvince",  company.get("place_province")); // 企业所在省
		baseInfo.put("placeCity",  company.get("place_city")); // 企业所在市
		baseInfo.put("companySealName",  company.get("company_seal_name")); // 公司章名称
		baseInfo.put("sealType",  company.get("seal_type")); // 公司章类型
		baseInfo.put("sealCode",  company.get("seal_code")); // 公司章编码
		
		baseInfo.put("advanceRepayType",  company.get("advance_repay_type")); //  VARCHAR(200)  提前还款方式 
		baseInfo.put("repaySource",  company.get("repay_source")); //  VARCHAR(50)  还款来源 
		baseInfo.put("industry",  company.get("industry")); //  VARCHAR(50)  所属行业 
		baseInfo.put("operatingState",  company.get("operating_state")); //  VARCHAR(200)  经营状态 
		baseInfo.put("revenue",  company.get("revenue")); //  VARCHAR(50)  企业年营业收入 
		baseInfo.put("liabilities",  company.get("liabilities")); //  VARCHAR(50)  企业负债金额 
		baseInfo.put("foundedDate",  company.get("founded_date")); //  VARCHAR(20)  成立日期 
		baseInfo.put("businessStartDate",  company.get("business_start_date")); //  VARCHAR(20)  营业期限（起） 
		baseInfo.put("businessEndDate",  company.get("business_end_date")); //  VARCHAR(20)  营业期限（止）  
		baseInfo.put("registerAmt",  company.get("register_amt")); //  VARCHAR(50)  注册资本 
		baseInfo.put("registerOrg",  company.get("register_org")); //  VARCHAR(100)  登记机关 
		baseInfo.put("scope",  company.get("scope")); //  VARCHAR(50)  经营范围 
		baseInfo.put("finance",  company.get("finance")); //  VARCHAR(20)  企业经营财务情况 
		baseInfo.put("repayAbility",  company.get("repay_ability")); //  VARCHAR(50)  企业还款能力变化情况 
		baseInfo.put("isInvolvedAppeal",  company.get("is_involved_appeal")); //  VARCHAR(10)  企业是否涉诉      1：是、2：否、9：未知
		baseInfo.put("isAdministrationPunish",  company.get("is_administration_punish")); //  VARCHAR(10)  企业是否受行政处罚   1：是、2：否、9：未知
		baseInfo.put("borrowCapitalUse",  company.get("borrow_capital_use")); //  VARCHAR(50)  企业借款资金运用情况 
		baseInfo.put("isOverdue",  company.get("is_overdue")); //  VARCHAR(10)  企业是否逾期 
		
		baseInfo.put("isCorporationAttach",  company.get("is_corporation_attach")); //  VARCHAR(10)  1：是、0：否   是否上传法人身份证 
		baseInfo.put("isFinanceAttach",  company.get("is_finance_attach")); //  VARCHAR(10)  1：是、0：否   是否上传财务报表 
		baseInfo.put("isGuaranteeAttach",  company.get("is_guarantee_attach")); //  VARCHAR(10)  1：是、0：否   是否上传担保函 
		baseInfo.put("isCreditAttach",  company.get("is_credit_attach"));  //  VARCHAR(10)  1：是、0：否   是否上传征信报告 
		
		
		
		
		
	
		Map<String, Object> detail = new HashMap<>();
		detail.put("handler", handler); // 经办人信息
		detail.put("baseInfo", baseInfo); //
		//----------------------------------------------------------------------------------------------------------------------------------------
		Map<String, Object> sendMap = new HashMap<>();
		sendMap.put("loanNumber", order_no);
		sendMap.put("loaninfo", loanInfo);
		sendMap.put("detail", detail);

		log.info("自动进件：order_no=[{}],order_id=[{}]",order_no,order_id);
		log.info("推动进件json=[{}]",JSON.toJSONString(sendMap));
		
		Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.JZ_LOAN_AUTO_ENTRY);
		if (ObjectUtils.isEmpty(resultMap)) {    
			log.info("进件调配： 请求学习   返回 为空，order_id=[{}]，resultMap = [{}]。", order_id, resultMap); 
			return;
		}
		String result = (String) resultMap.get("result");
		// 测试 结果 用 result = "0000";
		if ("0000".equals(result)) {
			log.info("推送进件：成功");    
			// 扣减额度
			BigDecimal remain_money = (BigDecimal) contract.get("remain_money");
			remain_money = remain_money.subtract(orderMoney);
			int update = mysqlSpringJdbcDao.Update(new Object[][] { { "remain_money", remain_money } }, "jz_ac_xs_contract", new Object[][] { { "id", contract.get("id") } });
			if (update > 0) {
				try {
					log.info("自动推送进件：成功扣减额度包");
					// 插入批次
					Map<String, Object> batch = new HashMap<>();
					batch.put("apply_code", contract.get("apply_code"));
					batch.put("batch_code", batch_code);
					batch.put("inlet_count", 1);
					batch.put("contract_amount", orderMoney);
					batch.put("create_time", TimeHelper.getCurrentTime());
					Number batch_id = mysqlSpringJdbcDao.addSelectiveAndGetId("jz_ac_xs_batch", batch);
					log.info("自动推送进件：成功生成批次");
					// 插入批次订单表
					Map<String, Object> batch_order = new HashMap<>();
					batch_order.put("batch_id", batch_id.intValue());
					batch_order.put("order_id", order.get("id"));
					batch_order.put("order_no", order.get("order_no"));
					batch_order.put("deploy_status", 0);
					batch_order.put("deploy_message", "初始进件状态");
					batch_order.put("create_time", TimeHelper.getCurrentTime());
					mysqlSpringJdbcDao.addSelectiveAndGetId("jz_ac_xs_batch_order", batch_order);
					log.info("自动推送进件：成功生成批次订单表");
					// 更改订单状态 为打款中

					mysqlSpringJdbcDao.Update(new Object[][] { {"refund_principal",loanMoney},{ "status", OrderStatusEnums.ASSET_PUSHED.name() } }, "jz_ac_company_order", new Object[][] { { "id", order_id } });
					log.info("进件调配：成功 ！订单orderId:{}", order_id);
					log.info("进件调配：订单进入查询进件队列[初始进件状态]，等待进件结果查询");
				} catch (Exception e) {
					e.printStackTrace();
					remain_money = remain_money.add(orderMoney);
					mysqlSpringJdbcDao.Update(new Object[][] { { "remain_money", remain_money } }, "jz_ac_xs_contract", new Object[][] { { "id", contract.get("id") } });
					log.info("进件调配 ：更新批次订单等操作异常，已经恢复额度包 ！订单orderId:{}", order_id);

				}
			} else {
				log.info("进件调配：扣减额度包失败,下次重试order_id=[{}]", order_id);
			}
		} else {
			log.info("自动推送进件：进件推动失败order_id=[{}]", order_id);
		}
	}

	private BigDecimal getFee(BigDecimal orderMoney){
		BigDecimal fee = orderMoney.multiply(InterestConfig.INTEREST_SERVICE).setScale(2,BigDecimal.ROUND_HALF_UP);
		return fee;
	}
	
	private static String getApplySql() {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from jz_ac_xs_contract  ");
		sb.append(" where  1=1  ");
		sb.append(" and del_flg = 0   ");
		sb.append(" and ? <= remain_money  ");
		sb.append(" AND CURDATE() >=   start_date  ");
		sb.append(" AND CURDATE() <=  invalid_date ");
		sb.append(" order BY create_time asc limit 1  ");
		return sb.toString();
	}
	//自动进件---------------------------------------------------------
	
	//处理进件结果---------------------------------
    @SuppressWarnings("unchecked")
    protected synchronized Boolean handleDeployResult(Map<String,Object>params){
    	try {
    		Map<String,Object> batch_order = (Map<String, Object>) params.get("batch_order");
			Object[] noticeResult = (Object[]) params.get("noticeResult");
			Map<String,Object> order = (Map<String, Object>) params.get("order");
			Boolean flag = (Boolean) noticeResult[0];
			String message = (String) noticeResult[1]==null?"":(String) noticeResult[1];
			int orderId = (int) order.get("id");
			int batch_order_id = (int) batch_order.get("id");
			if (BooleanUtils.isFalse(flag)) {
				log.info("进件结果查询：进件失败，orderId=[{}],message=[{}]", orderId, message);
				// 保存失败信息   '进件状态:0初始，1成功，2失败，3审批成功，4审批失败',
				int update = mysqlSpringJdbcDao.Update(new Object[][]{{"deploy_status",2},{"deploy_message","[进件失败]"+message}}, "jz_ac_xs_batch_order", new Object[][]{{"id",batch_order_id},{"deploy_status",0}});
				if(update>0){
					// 进件失败 订单 状态改为  进件失败
					mysqlSpringJdbcDao.Update(new Object[][]{{"status",OrderStatusEnums.ASSET_PUSH_FAILED.name()}}, "jz_ac_company_order", new Object[][]{{"id",orderId},{"status",OrderStatusEnums.ASSET_PUSHED.name()}});
				}
			} else if (BooleanUtils.isTrue(flag)) {
				log.info("进件结果查询：进件成功orderId=[{}]", orderId);
				// 进件推送成功 更新    当且仅当 初始进件状态0 的单子    更新成功后将单子放入 查询贷款审批的队列中
				String sql = " update jz_ac_xs_batch_order set deploy_status = 1 , deploy_message = ? where id = ? and deploy_status in ('0','2') ";
				String paramSql = SqlHelper.getParamSql(sql, "[进件成功]"+message,batch_order_id);
				int update = mysqlSpringJdbcDao.insertOrUpdate(paramSql);
				if (update>0) {
					// 将订单放入 
					log.info("进件结果查询：进件成功！等待审批结果查询,orderId=[{}]", orderId);
					// 进件成功    订单 状态改为  进件成功
					mysqlSpringJdbcDao.Update(new Object[][]{{"status",OrderStatusEnums.ASSET_PUSH_SUCCESS.name()}}, "jz_ac_company_order", new Object[][]{{"id",orderId}});
				}
			}else{
			    //未有查到有效的进件结果    无法处理  返回失败
				return false;
			 }
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false; 
		}
    }
	
	//处理审批结果通知
    @SuppressWarnings("unchecked")
    protected synchronized Boolean handleLoanAuditResult(Map<String,Object>params){
    	try {
    		Map<String,Object> batch_order = (Map<String, Object>) params.get("batch_order");
			Object[] noticeResult = (Object[]) params.get("noticeResult");
			Map<String,Object> order = (Map<String,Object>) params.get("order");
			Boolean flag = (Boolean) noticeResult[0];
			String message = (String) noticeResult[1]==null?"":(String) noticeResult[1];
			int orderId = (int) order.get("id");
			int batch_order_id = (int) batch_order.get("id");
			if (BooleanUtils.isFalse(flag)) {
				log.info("贷款审批结果：审批失败，orderId=[{}],message=[{}]", orderId, message);
				// 保存失败信息   '进件状态:0初始，1成功，2失败，3审批成功，4审批失败',
				
				int update = mysqlSpringJdbcDao.Update(new Object[][]{{"deploy_status",4},{"deploy_message","[审批失败]"+message}}, "jz_ac_xs_batch_order", new Object[][]{{"id",batch_order_id},{"deploy_status",1}});
				if(update>0){
					// 审批失败 订单 状态改为  打款失败
					mysqlSpringJdbcDao.Update(new Object[][]{{"status",OrderStatusEnums.ASSET_AUTH_FAILED.name()}}, "jz_ac_company_order", new Object[][]{{"id",orderId},{"status",OrderStatusEnums.ASSET_PUSH_SUCCESS.name()}});
				}
			} else if (BooleanUtils.isTrue(flag)) {
				log.info("贷款审批结果：审批成功，orderId=[{}]", orderId);
				// 贷款审批成功 更新    当且仅当 初始进件状态1 的单子    更新成功后将单子放入 查询放款 的队列中
				String sql = " update jz_ac_xs_batch_order set deploy_status = 3 , deploy_message = ? where id = ? and deploy_status in ('1','4') ";
				int update = mysqlSpringJdbcDao.insertOrUpdate(sql,"[审批成功]"+message,batch_order_id);
				if (update>0) {
					// 将订单放入 
					log.info("贷款审批结果：审批成功！订单进入查询放款结果队列，等待放款结果查询,orderId=[{}]", orderId);
					mysqlSpringJdbcDao.Update(new Object[][]{{"status",OrderStatusEnums.ASSET_AUTH_SUCCESS.name()}}, "jz_ac_company_order", new Object[][]{{"id",orderId}});
				}
			}else{
			    log.info("未有有效的审批结果    无法处理  返回失败");
				return false;
			 }
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
    
    // 放款结果处理 --------------------------------------------------
    @SuppressWarnings("unchecked")
   	protected synchronized Boolean handleLoanLoanResult(Map<String,Object>params){
       	try{
       		Map<String,Object> order = (Map<String, Object>) params.get("order");
       		Map<String,Object> company = (Map<String, Object>) params.get("company");		
       		Object[] noticeResult = (Object[]) params.get("noticeResult");
       		
       		int order_id = (int) order.get("id");
       		if(!OrderStatusEnums.ASSET_AUTH_SUCCESS.name().equals(order.get("status"))&&!OrderStatusEnums.LOAN_FAILED.name().equals(order.get("status"))){
       			log.info("单子状态不为不为审批成功或者放款失败！无效通知orderId={}",order_id);
       			return false;
       		}
       		Boolean flag = (Boolean) noticeResult[0];
   			String message = (String) noticeResult[1]==null?"":(String) noticeResult[1];  //放款失败 ，需要返回原因
   			String endTime = (String)noticeResult[2];   //放款成功  此项有值
       		int company_id = (int) company.get("id");
   			if(BooleanUtils.isTrue(flag)){
   				//更新进件状态 进件状态:0初始，1成功，2失败，3审批成功，4审批失败，5放款成功，6放款失败',
   				String sql = " update jz_ac_xs_batch_order set deploy_status = 5 , deploy_message = ? where order_id = ? and deploy_status in ('3','6') ";
				int update = mysqlSpringJdbcDao.insertOrUpdate(sql,"[放款成功]"+message,order_id);
   				if(update!=1){
   					return false  ;
   				}
   				//'放款成功  更新订单状态  保存放款时间  保存应还利息
   				int life_of_loan = (int) order.get("life_of_loan");
   				String order_deadline = getOrderDeadLine(endTime, life_of_loan);
   				BigDecimal orderMoney = (BigDecimal) order.get("actual_money");   //'确认借款金额(货物入库后,评估出的借款金额,实际本金)',
   				BigDecimal refund_interest = getOrderInterest(orderMoney);
   				mysqlSpringJdbcDao.Update(new Object[][]{{"status",OrderStatusEnums.LOAN_SUCCESS.name()},{"pay_time",endTime},{"refund_interest",refund_interest},{"order_deadline",order_deadline}}, "jz_ac_company_order", new Object[][]{{"id",order_id}});
   				log.info("放款成功！更新订单状态成功！company_id=[{}],orderId=[{}]",company_id,order_id);
   				return true;
   			}else if(BooleanUtils.isFalse(flag)){
   				log.info("放款失败   company_id=【{}】，orderId=[{}]", company_id, order_id);
   				int update = mysqlSpringJdbcDao.Update(new Object[][]{{"deploy_status",6},{"deploy_message","[放款失败]"+message}}, "jz_ac_xs_batch_order", new Object[][]{{"order_id",order_id},{"deploy_status",3}});
				if(update>0){
					// 放款失败 订单 状态改为  打款失败
					mysqlSpringJdbcDao.Update(new Object[][]{{"status",OrderStatusEnums.LOAN_FAILED.name()}}, "jz_ac_company_order", new Object[][]{{"id",order_id}});
				}
   				return true;
   			}else{
   				log.info("无效的放款通知   company_id=【{}】，orderId=[{}],noticeResult=[{}]",company_id,order_id,noticeResult);
   				return false;
   			}
       	}catch(Exception e){
       		log.info("{}",e);
       		return false;
       	}
       }
    
    public static String getOrderDeadLine(String payTime,int days) throws Exception {
    	Date date = TimeHelper.transTimeToDate(payTime);
		Date afterDate = TimeHelper.getAfterDate(date, days);
		String order_deadline = TimeHelper.transTimeByFormat(afterDate, TimeHelper.YYYY_MM_DD+" 23:59:59");
    	return order_deadline;
	}
    
    private static BigDecimal getOrderInterest(BigDecimal orderMoney){
    	//订单金额  *  月利率 
    	BigDecimal interest =  orderMoney.multiply(InterestConfig.INTEREST_ACTUAL).setScale(2, BigDecimal.ROUND_HALF_UP);
    	return interest;
    }
    
    // 放款结果处理 --------------------------------------------------
   
    //提现结果处理----------------------------------------------------
    @SuppressWarnings("unchecked")
   	protected synchronized Boolean handleWithdrawResult(Map<String,Object>params){
       	try{
       		Map<String,Object> order = (Map<String, Object>) params.get("order");
       		Map<String,Object> company = (Map<String, Object>) params.get("company");		
       		Object[] noticeResult = (Object[]) params.get("noticeResult");
       		
       		int order_id = (int) order.get("id");
       		if(!OrderStatusEnums.LOAN_SUCCESS.name().equals(order.get("status"))&&!OrderStatusEnums.WITHDRAW_FAILED.name().equals(order.get("status"))){
       			log.info("单子状态不为不为放款成功或者提现失败！无效通知orderId={}",order_id);
       			return false;
       		}
       		Boolean flag = (Boolean) noticeResult[0];
       		
   			String message = (String) noticeResult[1]==null?"":(String) noticeResult[1];  //放款失败 ，需要返回原因
   			
       		
   			int company_id = (int) company.get("id");
   			if(BooleanUtils.isTrue(flag)){
   				String withdrawTime = (String)noticeResult[2];   //提现成功  此项有值
   	   			BigDecimal drawAmount = (BigDecimal)noticeResult[3];   //提现成功  此项有值
   				//更新 提现状态（0初始，1提现成功，2提现失败，3提现中）',
				int update = mysqlSpringJdbcDao.insertOrUpdate("   update jz_ac_xs_batch_order set withdraw_status = 1 where order_id = ? and deploy_status = 5  ",order_id);
   				if(update!=1){
   					return false  ;
   				}
   				//'提现成功  更新订单状态 
   				mysqlSpringJdbcDao.Update(new Object[][]{{"status",OrderStatusEnums.WITHDRAW_SUCCESS.name()}}, "jz_ac_company_order", new Object[][]{{"id",order_id}});
   				log.info("提现成功！更新订单状态成功！company_id=[{}],orderId=[{}]",company_id,order_id);
   				return true;
   			}else if(BooleanUtils.isFalse(flag)){
   				log.info("提现失败   company_id=【{}】，orderId=[{}]", company_id, order_id);
   				//更新 提现状态（0初始，1提现成功，2提现失败，3提现中）',
				int update = mysqlSpringJdbcDao.insertOrUpdate("   update jz_ac_xs_batch_order set withdraw_status = 2  where order_id = ? and deploy_status = 5  and withdraw_status in (0,3)  ",order_id);
   				if(update!=1){
   					return false  ;
   				}
   				//'提现失败  更新订单状态 
   				mysqlSpringJdbcDao.Update(new Object[][]{{"status",OrderStatusEnums.WITHDRAW_FAILED.name()}}, "jz_ac_company_order", new Object[][]{{"id",order_id}});
   				return true;
   			}else{
   				log.info("无效的提现通知   company_id=【{}】，orderId=[{}],noticeResult=[{}]",company_id,order_id,noticeResult);
   				return false;
   			}
       	}catch(Exception e){
       		log.info("{}",e);
       		return false;
       	}
     }
    
    //提现结果处理----------------------------------------------------
    
    //查询电子签章工具
    protected boolean doSearchElectSign(Map<String,Object>batch_order){
    	int order_id = (int) batch_order.get("order_id");
		try {
			Map<String, Object> order = mysqlSpringJdbcDao.queryForMap(" select * from jz_ac_company_order where id = ? ", order_id);
			if(ObjectUtils.isEmpty(order)){
				log.info("订单异常 : 未找到订单 ，order_id=[{}]",order_id);
				return false;
			}
			String order_no = (String) order.get("order_no");
			Map<String,Object> sendMap = new HashMap<>();
			sendMap.put("loanNumber", order_no);
			Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.E_SIGNATURE_SEARCH);
			log.info("查询电子签章：order_id=[{}],学习返回resulMap=[{}]",order_id,resultMap);
			if("0000".equals(resultMap.get("result"))){
				log.info("查询电子签章：order_id=[{}],查到电子签章返回结果，开始解析路径，读取文件。",order_id);
				String filePath = (String) resultMap.get("filePath");
				
				return true;
			}else{
				log.info("查询电子签章：order_id=[{}],没查到电子签章",order_id);
				return false;
			}
		} catch (Exception e) {
			log.info("订单异常  ，order_id=[{}]",order_id);
			e.printStackTrace();
			return false;
		}
    	
    }
	
//还款类开始------------------------------------------------------------
    
    protected synchronized String getPaymentSql(Integer order_id){
		StringBuilder sb = new StringBuilder();
		sb.append("  SELECT  ");
		sb.append("  jz_ac_xs_batch_order.deploy_status,  ");
		sb.append("  jz_ac_xs_batch_order.repay_status,  ");
		sb.append("  datediff(now(), jz_ac_company_order.pay_time) AS real_loan_days,   ");
		sb.append("  jz_ac_company_order.*  ");
		sb.append("  FROM  ");
		sb.append("  jz_ac_xs_batch_order  ");
		sb.append("  INNER JOIN jz_ac_company_order ON jz_ac_company_order.id = jz_ac_xs_batch_order.order_id  ");
		sb.append("  where deploy_status = 5   ");
		sb.append("  and repay_status != 1    ");
		if(ObjectUtils.isEmpty(order_id)){
			//定时任务 正常还款
			sb.append("  and datediff(now(), jz_ac_company_order.pay_time) = life_of_loan  ");
		}else{
			// 提前  或 逾期
			sb.append("  and order_id = '"+order_id+"'  ");
		}
		return sb.toString();
	}
    
    protected synchronized Map<String,Object> getDataMap(Map<String,Object> order,String handleType){
    	if(ObjectUtils.isEmpty(order)){
    		log.info("订单查出来为空，订单错误！");
    		return null;
    	}
    	
    	int company_id = (int) order.get("company_id");
    	int order_id = (int) order.get("id");
    	String order_no = (String) order.get("order_no");
    	
		String thirdLogNo = XsOrderUtil.getHKDateUuidCode();
		String repayDate = TimeHelper.getCurrentDate();
    	
    	//获取已经借款的天数
    	long real_loan_days =(long) order.get("real_loan_days");
    	BigDecimal benjin = (BigDecimal) order.get("actual_money"); //应还本金   NUMBER(18,2)   必填
    	
		BigDecimal lixi = (BigDecimal) order.get("refund_interest"); //应还利息   NUMBER(18,2)   必填
    	BigDecimal faxi = zero;	// 应还罚息   NUMBER(18,2)   必填
    	BigDecimal weiyuejin = zero;	// 应还违约金 NUMBER(18,2)   必填
    	
    	/*//每期逾期了，都要交催收费。催收费=期数*200元
		weiyuejin = new BigDecimal(real_loan_days).divide(new BigDecimal(30)).setScale(0, BigDecimal.ROUND_DOWN).multiply(new BigDecimal("200"));*/
    	String type = ""; //还款场景   VARCHAR(10)    必填  // 1正常月还,2逾期月还,3提前结清,4逾期提前结清,5月还减免,6信用保证金结转
    	if(real_loan_days<30){
    		type = "3";//提前还款
    	}else if(real_loan_days == 30){
    		type = "1";//正常月还
    	}else if(real_loan_days > 30){
    		type = "2";//逾期还款
    		// 本金X天数X千分之一
    		faxi = benjin.multiply(InterestConfig.INTEREST_OVERDUE).multiply(new BigDecimal(real_loan_days-30));
    		//违约金 200
    		weiyuejin = new BigDecimal("200");
    	}
    	BigDecimal total = benjin.add(lixi).add(faxi).add(weiyuejin);
    	
		
		Map<String,Object> sendMap = new HashMap<>(); 
			sendMap.put("loanNumber", order_no); // 必填  VARCHAR(64) 借款编号
			sendMap.put("loanTerms", 1); // 必填  NUMBER(4)  当前期数
			sendMap.put("paymentDate", repayDate); // 必填  Date 当期还款日
			sendMap.put("mustAmount", benjin); // 必填  NUMBER(18,2) 应还本金
			sendMap.put("mustAccrual", lixi); // 必填  NUMBER(18,2) 应还利息
			sendMap.put("thisRepaySum", total); // 必填  NUMBER(18,2) 月还金额
			
			if("3".equals(type)){
				sendMap.put("advanceAmount", total); // 选填  NUMBER(18,2) 提前结清剩余本息和
			}
			if("2".equals(type)){
				sendMap.put("overdueAmount", zero); // 选填  NUMBER(18,2) 逾期罚息
			}
		
		Map<String,Object> record = new HashMap<String,Object>();
		record.put("order_id", order.get("id"));
		record.put("company_id", order.get("company_id"));
		record.put("order_no", order.get("order_no"));
		record.put("thirdLogNo", thirdLogNo);
		record.put("repayScene", type);
		record.put("repayDate", repayDate);
		record.put("realBase", benjin);
		record.put("realInst", lixi);
		record.put("realPenalty", faxi);
		record.put("realDefault", weiyuejin);
		record.put("thisRepaySum", total);
		record.put("loanTerms", 1);
		record.put("create_time", TimeHelper.getCurrentTime());
		
		if("3".equals(type)){
			log.info("进入手动提前还款！");
			record.put("is_pre_pay", 1);
		}
		
		Map<String,Object> dataMap = new HashMap<>();
		dataMap.put("sendMap", sendMap);
		dataMap.put("record", record);
		
		
		return dataMap;
	}
    
    @SuppressWarnings("unchecked")
	protected synchronized Boolean doRepayOrder(Map<String,Object> dataMap){
    	if(ObjectUtils.isEmpty(dataMap)){
    		return false;
    	}
    	Map<String,Object> sendMap = (Map<String, Object>) dataMap.get("sendMap");
    	Map<String,Object> record = (Map<String, Object>) dataMap.get("record");
    	if(ObjectUtils.isEmpty(sendMap)){
    		log.info("还款通知构造的sendMap不能为空！");
			return false;
		}if(ObjectUtils.isEmpty(record)){
    		log.info("还款通知构造的record不能为空！");
			return false;
		}
    	String order_no = (String) record.get("order_no");
    	int order_id =  (int) record.get("order_id");
    	int company_id =  (int) record.get("company_id");
		try {
			Map<String,Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.REPAYMENT_NOTICE_V1);
			
//			测试数据
//			resultMap = new HashMap<>();
//			resultMap.put("result", "0000");
//			resultMap.put("message", "操作完成");
			
			//0000：成功 ,9999：失败
			if("0000".equals(resultMap.get("result"))){
				record.put("is_pay_success",1 );
				record.put("message","[还款成功]"+(String)resultMap.get("message"));
				doUpdateAfterRepay(record,true);
				return true;
			}else if ("9999".equals(resultMap.get("result"))){
				record.put("is_pay_success",0 );
				record.put("message","[还款失败]"+(String)resultMap.get("message"));
				doUpdateAfterRepay(record,false);
				return false;
			}
		} catch (Exception e) {
			log.info("还款出现异常order_no=[{}] ,order_id=[{}],company_id=[{}]  e=[{}]",order_no,order_id,company_id,e.getMessage()+e.getCause());
			return false;
		}
		return false;
	}
	
	private void doUpdateAfterRepay(Map<String,Object>record,boolean success) throws Exception{
		log.info("进入还款后操作");
		String order_no = (String) record.get("order_no");
		int order_id = (int) record.get("order_id");
		int company_id = (int) record.get("company_id");
		int is_pre_pay = 0 ;
		if(record.containsKey("is_pre_pay")){
			record.remove("is_pre_pay");
			String message = (String) record.get("message");
			record.put("message", pre_pay+message);
			is_pre_pay = 1 ;
		}
		if(success){
			BigDecimal faxi = (BigDecimal) record.get("realPenalty");
			BigDecimal weiyuejin = (BigDecimal) record.get("realDefault");
			BigDecimal refund_penal = faxi.add(weiyuejin);//'应还违约金(逾期罚息+催收费) 在订单结清之后更新该字段',
//			String voucher_code = (String) record.get("thirdLogNo");//'提货凭证码',
			log.info("开始还款成功后续操作。order_no=[{}] ,order_id=[{}],company_id=[{}]",order_no,order_id,company_id);
			
			//更新批次表  `repay_status` int(1) DEFAULT '0' COMMENT '0未还款，1还款成功，2还款失败',
			int i = mysqlSpringJdbcDao.insertOrUpdate(" update jz_ac_xs_batch_order set repay_status = 1 ,is_pre_pay = ? where order_id = ? and order_no = ? and deploy_status = 5 and  repay_status <> 1 ",is_pre_pay, order_id,order_no);
			if(i>0){
				//新增学习还款记录表
				mysqlSpringJdbcDao.addSelectiveAndGetId("jz_sp_xs_repay_records", record);
				//更新订单表
				mysqlSpringJdbcDao.Update(new Object[][]{{"refund_penal",refund_penal},{"status",OrderStatusEnums.REFUND_SUCCESS.name()},{"clearing_time",TimeHelper.getCurrentTime()}}, "jz_ac_company_order", new Object[][]{{"order_no",order_no}});
				log.info(">>>>>>>>>>>还款成功。插入还款记录，更新订单成功。 order_id=[{}],company_id=[{}]",order_id,company_id);
			}
		}else{
			log.info("开始还款失败后续操作。order_no=[{}] ,order_id=[{}],company_id=[{}]",order_no,order_id,company_id);
			//更新批次表  `repay_status` int(1) DEFAULT '0' COMMENT '0未还款，1还款成功，2还款失败',
			int i = mysqlSpringJdbcDao.Update(new Object[][]{{"repay_status",2},{"is_pre_pay",is_pre_pay}},"jz_ac_xs_batch_order",new Object[][]{{"order_no",order_no}});
			if(i>0){
				//新增学习还款记录表
				mysqlSpringJdbcDao.addSelectiveAndGetId("jz_sp_xs_repay_records", record);
				log.info(">>>>>>>>>>>还款失败。插入还款记录，更新批次成功。 order_id=[{}],company_id=[{}]",order_id,company_id);
				
				//更新订单表
				mysqlSpringJdbcDao.Update(new Object[][]{{"status",OrderStatusEnums.REFUND_FAILED.name()}}, "jz_ac_company_order", new Object[][]{{"order_no",order_no}});
				log.info(">>>>>>>>>>>还款失败。更新订单状态成功。 order_id=[{}],company_id=[{}]",order_id,company_id);
			}
		}
	}
    //还款工具类---------------------------------------------------------------------
    
	
}
