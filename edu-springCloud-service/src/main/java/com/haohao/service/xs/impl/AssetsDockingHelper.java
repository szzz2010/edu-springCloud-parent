package com.haohao.service.xs.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
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

public class AssetsDockingHelper {

	private static final Logger log = LoggerFactory.getLogger(AssetsDockingHelper.class);

	@Autowired
	protected MysqlSpringJdbcDao mysqlSpringJdbcDao;
	
	public static final BigDecimal zero = new BigDecimal("0.00");
	public static final String handle_type_auto = "automatic";
	public static final String handle_type_manu = "manual";
	public static final String pre_pay_success = "pre_pay_success";

	
	public static final String goods_brand = "品牌";
	public static final String goods_guige = "显示器屏幕规格";
	public static final String goods_model = "型号";
	public static final String goods_price = "价格";
	
	
	public Map<String, Object> getTBSuccess() {
		Map<String, Object> resp = new HashMap<>();
		resp.put("status", "2");
		resp.put("classType", "cardList");
		return resp;
	}

	public Map<String, Object> getTBFail() {
		Map<String, Object> resp = new HashMap<>();
		resp.put("status", "1");
		resp.put("msg", "请求失败，稍后再试");
		return resp;
	}

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
	
	  //防止重复刷新提交     返回  true通过 ，  false  拒绝
    protected synchronized boolean validateRefreshSubmit(Date date){
    	int operation = TimeHelper.transDateToTimeStamp(date);
    	int now = TimeHelper.getCurrentTimestamp();
    	if(now - operation>3*60){
    		return true;
    	}
    	return false;
    }
    
	
	// 开户绑卡
	protected synchronized boolean createBankAccount(Map<String, Object> params) {
		int company_id = (int) params.get("company_id");
		String bank_company_id = (String) params.get("bank_company_id");
		String id_card = (String) params.get("id_card");// 身份证号
		String card_num = (String) params.get("card_num");// 明文卡号
		String card_mobile = (String) params.get("card_mobile");
		String start_card_num = (String) params.get("start_card_num");// 加密卡号
		String bank_name = (String) params.get("bank_name");
		// 1.先查本库中是否有账户
		Map<String, Object> bankAccountMap = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_account where company_id = ? and id_card = ? ", company_id, id_card);
		if (!ObjectUtils.isEmpty(bankAccountMap)) {
			// 已经开户成功了----一般不存在此情况
			return true;
		}
		// 不存在户则保存
		Map<String, Object> account = new HashMap<>();
		account.put("company_id", company_id);
		account.put("bank_company_id", bank_company_id);
		account.put("id_card", id_card);
		account.put("create_time", new Date());
		Number addAndGetId = mysqlSpringJdbcDao.addSelectiveAndGetId("ac_xs_company_bank_account", account);

		// 更新银行卡信息
		int is_same = isSameCard(card_num, start_card_num)?1:0;
		Map<String, Object> bankCard = new HashMap<>();
		bankCard.put("card_num", card_num);
		bankCard.put("bank_name", bank_name);
		bankCard.put("card_mobile", card_mobile);
		bankCard.put("start_card_num", start_card_num);
		bankCard.put("is_temp", 0);
		bankCard.put("is_same", is_same);

		Map<String, Object> where = new HashMap<>();
		where.put("company_id", company_id);
		where.put("is_temp", 1);
		mysqlSpringJdbcDao.Update(bankCard, "ac_xs_company_bank_card", where);

		return true;
	}

	// 银行绑卡
	protected synchronized boolean saveBankCard(Map<String, Object> params) {

		int company_id = (int) params.get("company_id");
		// String id_card = (String) params.get("id_card");//身份证号
		String card_num = (String) params.get("card_num");// 明文卡号
		String card_mobile = (String) params.get("card_mobile");
		String start_card_num = (String) params.get("start_card_num");// 加密卡号
		String bank_name = (String) params.get("bank_name");// TODO

		// 更新银行卡信息
		int is_same = isSameCard(card_num, start_card_num)?1:0;
		Map<String, Object> bankCard = new HashMap<>();
		bankCard.put("card_num", card_num);
		bankCard.put("bank_name", bank_name);
		bankCard.put("card_mobile", card_mobile);
		bankCard.put("start_card_num", start_card_num);
		bankCard.put("is_same", is_same);
		bankCard.put("is_temp", 0);

		Map<String, Object> where = new HashMap<>();
		where.put("company_id", company_id);
		where.put("is_temp", 1);
		int update = mysqlSpringJdbcDao.Update(bankCard, "ac_xs_company_bank_card", where);
		return true;
	}

	protected boolean isSameCard(String card_num,String start_card_num){
		String a1 = card_num.substring(0, 6);
		String a2 = card_num.substring(card_num.length()-4, card_num.length());
		String b1 = start_card_num.substring(0, 6);
		String b2 = start_card_num.substring(start_card_num.length()-4, start_card_num.length());
		String a = a1+a2;
		String b = b1+b2;
		if(a.equals(b)){
			return true;
		}else{
			return false;
		}
	}
	
	// 银行换卡
	protected synchronized boolean changeBankCard(Map<String, Object> params) {

		int company_id = (int) params.get("company_id");
		String card_num = (String) params.get("card_num");// 明文卡号
		String card_mobile = (String) params.get("card_mobile");
		String start_card_num = (String) params.get("start_card_num");// 加密卡号
		String bank_name = (String) params.get("bank_name");// TODO
		
		//现行获取旧的银行卡
		Map<String,Object> oldBankCard = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_card  where company_id = ? and is_temp = 0 and card_status = 1 order by create_time desc limit 1 ", company_id);
		
		int old_id = (int) oldBankCard.get("id");
		
		// 更新银行卡信息
		int is_same = isSameCard(card_num, start_card_num)?1:0;
		Map<String, Object> bankCard = new HashMap<>();
		bankCard.put("card_num", card_num);
		bankCard.put("bank_name", bank_name);
		bankCard.put("card_mobile", card_mobile);
		bankCard.put("start_card_num", start_card_num);
		bankCard.put("is_temp", 0);
		bankCard.put("is_same", is_same);
		
		Map<String, Object> where = new HashMap<>();
		where.put("company_id", company_id);
		where.put("is_temp", 1);
		int update = mysqlSpringJdbcDao.Update(bankCard, "ac_xs_company_bank_card", where);
		if(update>0){
			mysqlSpringJdbcDao.Update(new Object[][]{{"card_status",0}}, "ac_xs_company_bank_card", new Object[][]{{"id",old_id}} );
			log.info("更换银行卡成功！company_id=[{}]",company_id);
		}
		return true;
	}

	
	// 保存授权信息
	protected synchronized boolean saveAuthorInfo(Map<String, Object> params) {
		String busOrderId = (String) params.get("busOrderId");//业务流水号
		int company_id = XsOrderUtil.getCompanyIdByBusOrderId(busOrderId);
		
		//校验 订单  状态  是否存在
		//TODO
		Map<String, Object> order = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id =? ",company_id);
		if(ObjectUtils.isEmpty(order)){
			log.info("没有找 到需要授权的订单,返回。company_id=[{}]",company_id);
			return false;
			
		}
		String order_no = (String) order.get("loan_number");
		int order_id = company_id;
		int count = (int) mysqlSpringJdbcDao.queryForObject("select count(*) from ac_xs_author where order_id = ? and order_no = ? ", Integer.class, order_id,order_no);
		if(count>0){
			log.info("订单存在授权记录，授权成功！orderId=[{}],company_id=[{}]",order_id,company_id);
			return true;
		}
		
		String third_no = (String) params.get("orderid");//三方授权流水号
		String end_date = TimeHelper.transTimeByFormat((String) params.get("endDate"), TimeHelper.YYYYMMDD, TimeHelper.YYYY_MM_DD);
		String start_date =TimeHelper.transTimeByFormat((String) params.get("startDate"), TimeHelper.YYYYMMDD, TimeHelper.YYYY_MM_DD);
		BigDecimal start_amt = new BigDecimal((String)params.get("amtStart")) ;
		BigDecimal end_amt = new BigDecimal((String)params.get("amtEnd")) ;
		
		Map<String,Object> author = new HashMap<>();
		author.put("company_id", company_id);
		author.put("start_date",start_date );
		author.put("end_date", end_date);
		author.put("start_amt", start_amt);
		author.put("end_amt", end_amt);
		author.put("third_no", third_no);
		author.put("order_id", order_id);
		author.put("order_no", order_no);
		author.put("create_time",TimeHelper.getCurrentTime() );
		Number id = mysqlSpringJdbcDao.addSelectiveAndGetId("ac_xs_author", author);
		if(id.intValue()>0){
			//更改订单状态  为完成授权
			//TODO//mysqlSpringJdbcDao.Update(new Object[][]{{"status",OrderStatusEnums.PINGAN_AUTH_CONFIRM.name()}}, "ac_company_order",new Object[][]{{"id",order_id}} );
			log.info("授权成功,保存授权记录，更改订单状态成功！orderId=[{}],company_id=[{}]",order_id,company_id);
			return true;
		}
		return false ;
	}
	
	//自动进件----------------------------------------------
	protected synchronized void doDeploy(Map<String, Object> order) {
		// 获取表对象
		int order_id = (int) order.get("id");
		int company_id = order_id;
		String order_no = (String) order.get("loan_number");
		
		BigDecimal actual_money = (BigDecimal) order.get("loan_contract_amt");// 实际借款金额
		// 查询当前合适的额度包  
		Map<String, Object> contract = mysqlSpringJdbcDao.queryForMap(getApplySql(), actual_money);
		if (ObjectUtils.isEmpty(contract)) {
			log.info("自动推 送进件：order_id=[{}],没有合适的额度包。",order_id);
			return ;
		}
		Map<String, Object> company = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id = ? ", company_id);
		Map<String, Object> bankCard = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_card where company_id = ? and card_status = 1 and is_temp = 0 and del_flg = 0  order by create_time desc limit 1 ", company_id);
		Map<String, Object> auth = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_author where company_id = ? and order_no = ? order by create_time desc limit 1   ", order_id,order_no);

		
		// 获取数据
		String batch_code = XsOrderUtil.getSPBDateUuidCode();
		BigDecimal orderMoney = actual_money.setScale(2, BigDecimal.ROUND_HALF_UP); // '确认借款金额(货物入库后，评估出的借款金额)',
		BigDecimal fee = getFee(orderMoney);  //服务费  月利率*订单金额
		BigDecimal loanMoney = orderMoney; // '实际到账金额(1.0  不需要前置扣费)',
		BigDecimal interest = getOrderInterest(orderMoney);  //学习理财人的利率  11.04
		
		// '应还总额【本金+利息+借款服务费】',
		BigDecimal refund_total = orderMoney.add(interest).add(fee);
		
		
		Map<String, Object> loanInfo = new HashMap<>();
		loanInfo.put("batchNo", batch_code); // 必填 批次号 VARCHAR(50)
		loanInfo.put("name", company.get("loan_company_name")); // 必填 企业名字 VARCHAR(50)
		loanInfo.put("IdCardType", "73"); // 必填 证件类型 VARCHAR(18) 73 统一社会信用代码
		loanInfo.put("idCardNo", company.get("loan_company_id_card")); // 必填 证件号码 VARCHAR(11)
		loanInfo.put("loanBankNum", bankCard.get("card_num")); // 必填 放款银行卡号 VARCHAR(2)
		loanInfo.put("loanBankName", bankCard.get("bank_name")); // 必填 放款银行卡号 VARCHAR(2)
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
		loanInfo.put("loanTerms", order.get("loan_terms")); // 必填 借款期限 天 NUMBER(3)
		loanInfo.put("riskLevel", "A"); // 必填 风控等级 VARCHAR(20) TODO
		loanInfo.put("agencyCode", XsConfig.jz_agency_code); // 必填 机构编码 VARCHAR(20)
		loanInfo.put("quota", new BigDecimal("1000000.00")); // 必填 机构编码 VARCHAR(20)
		
		String company_address = (String) company.get("company_address");
		loanInfo.put("enterpriseAddr", StringUtils.isBlank(company_address)?"西雅图东城":company_address); // 选填  企业经营注册地址  VARCHAR(20)
		loanInfo.put("authOrderId", auth.get("third_no")); // 1.0  非必填 授权流水号 VARCHAR(50)
		
		//----------------------------------------------------------------------------------------------------------------------------------
		//法人和经办人实体对象
		Map<String, Object> handler = new HashMap<>();  
		handler.put("handler", company.get("handle_name")); // 姓名
		handler.put("duty", "007"); // 公司职务
		handler.put("idCard", company.get("handle_id_card")); // 身份证号
		handler.put("mobile", company.get("handle_mobile")); // 手机号
		
		handler.put("corporationName", company.get("legal_name")); // 法定代表人
		handler.put("corporationIdCard", company.get("legal_id_card")); // 法定身份证号
		handler.put("corporationMobile", company.get("legal_mobile")); // 法定手机号
		
		Map<String, Object> baseInfo = new HashMap<>();  
		baseInfo.put("nature", "nature");
		baseInfo.put("referProvince", "referProvince");
		baseInfo.put("referCity", "referCity");
		baseInfo.put("placeProvince", "placeProvince");
		baseInfo.put("placeCity", "placeCity");
		baseInfo.put("companySealName", "companySealName");
		baseInfo.put("sealType", "sealType");
		baseInfo.put("sealCode", "sealCode");
		baseInfo.put("advanceRepayType", "advanceRepayType");
		baseInfo.put("repaySource", "repaySource");
		baseInfo.put("industry", "industry");
		baseInfo.put("operatingState", "operatingState");
		baseInfo.put("revenue", "revenue");
		baseInfo.put("liabilities", "liabilities");
		baseInfo.put("foundedDate", "foundedDate");
		baseInfo.put("businessStartDate", "businessStartDate");
		baseInfo.put("businessEndDate", "businessEndDate");
		baseInfo.put("registerAmt", "registerAmt");
		baseInfo.put("registerOrg", "registerOrg");
		baseInfo.put("scope", "scope");
		baseInfo.put("finance", "finance");
		baseInfo.put("repayAbility", "repayAbility");
		baseInfo.put("isInvolvedAppeal", "isInvolvedAppeal");
		baseInfo.put("isAdministrationPunish", "isAdministrationPunish");
		baseInfo.put("borrowCapitalUse", "borrowCapitalUse");
		baseInfo.put("isOverdue", "isOverdue");
		baseInfo.put("isCorporationAttach", "isCorporationAttach");
		baseInfo.put("isFinanceAttach", "isFinanceAttach");
		baseInfo.put("isGuaranteeAttach", "isGuaranteeAttach");
		baseInfo.put("isCreditAttach", "isCreditAttach");
		
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

		Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.LOAN_AUTO_ENTRY);
		if (ObjectUtils.isEmpty(resultMap)) {
			log.info("进件调配：  请求学习   返回 为空，order_id=[{}]，resultMap = [{}]", order_id, resultMap);
			return;
		}
		String result = (String) resultMap.get("result");
		// 测试 结果 用 result = "0000";
		if ("0000".equals(result)) {
			log.info("推送进件：成功");
			// 扣减额度
			BigDecimal remain_money = (BigDecimal) contract.get("remain_money");
			remain_money = remain_money.subtract(orderMoney);
			int update = mysqlSpringJdbcDao.Update(new Object[][] { { "remain_money", remain_money } }, "ac_xs_contract", new Object[][] { { "id", contract.get("id") } });
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
					Number batch_id = mysqlSpringJdbcDao.addSelectiveAndGetId("ac_xs_batch", batch);
					log.info("自动推送进件：成功生成批次");
					// 插入批次订单表
					Map<String, Object> batch_order = new HashMap<>();
					batch_order.put("batch_id", batch_id.intValue());
					batch_order.put("batch_code", batch_code);
					batch_order.put("order_id", order.get("id"));
					batch_order.put("order_no", order.get("order_no"));
					batch_order.put("deploy_status", 0);
					batch_order.put("deploy_message", "初始进件状态");
					batch_order.put("create_time", TimeHelper.getCurrentTime());
					mysqlSpringJdbcDao.addSelectiveAndGetId("ac_xs_batch_order", batch_order);
					log.info("自动推送进件：成功生成批次订单表");
					// 更改订单状态 为打款中

					mysqlSpringJdbcDao.Update(new Object[][] {{ "loan_status", 2 } }, "ac_company_order", new Object[][] { { "id", order_id } });
					log.info("进件调配：成功 ！订单orderId:{}", order_id);
					log.info("进件调配：订单进入查询进件队列[初始进件状态]，等待进件结果查询");
				} catch (Exception e) {
					e.printStackTrace();
					remain_money = remain_money.add(orderMoney);
					mysqlSpringJdbcDao.Update(new Object[][] { { "remain_money", remain_money } }, "ac_xs_contract", new Object[][] { { "id", contract.get("id") } });
					log.info("进件调配 ：更新批次订单等操作异常，已经恢复额度包 ！订单orderId:{}", order_id);
				}
			} else {
				log.info("进件调配：扣减额度包失败,下次重试order_id=[{}]", order_id);
			}
		} else {
			log.info("自动推送进件：进件推动失败order_id=[{}]", order_id);
		}
	}

	
	private BigDecimal getFee(BigDecimal orderMoney) {
		BigDecimal fee = orderMoney.multiply(InterestConfig.INTEREST_SERVICE).setScale(2, BigDecimal.ROUND_HALF_UP);
		return fee;
	}

	private static String getApplySql() {
		StringBuilder sb = new StringBuilder();
		sb.append(" select * from ac_xs_contract  ");
		sb.append(" where  1=1  ");
		sb.append(" and del_flg = 0   ");
		sb.append(" and ? <= remain_money  ");
		sb.append(" AND CURDATE() >=   start_date  ");
		sb.append(" AND CURDATE() <=  invalid_date ");
		sb.append(" order BY create_time asc limit 1  ");
		return sb.toString();
	}

	//自动进件----------------------------------------------
	
	//处理进件结果
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
				int update = mysqlSpringJdbcDao.Update(new Object[][]{{"deploy_status",2},{"deploy_message","[进件失败]"+message}}, "ac_xs_batch_order", new Object[][]{{"id",batch_order_id},{"deploy_status",0}});
				if(update>0){
					// 进件失败 订单 状态改为  进件失败
					mysqlSpringJdbcDao.Update(new Object[][]{{"status",OrderStatusEnums.ASSET_PUSH_FAILED.name()}}, "ac_company_order", new Object[][]{{"id",orderId},{"status",OrderStatusEnums.ASSET_PUSHED.name()}});
				}
			} else if (BooleanUtils.isTrue(flag)) {
				log.info("进件结果查询：进件成功orderId=[{}]", orderId);
				// 进件推送成功 更新    当且仅当 初始进件状态0 的单子    更新成功后将单子放入 查询贷款审批的队列中
				String sql = " update ac_xs_batch_order set deploy_status = 1 , deploy_message = ? where id = ? and deploy_status in ('0','2') ";
				String paramSql = SqlHelper.getParamSql(sql, "[进件成功]"+message,batch_order_id);
				int update = mysqlSpringJdbcDao.insertOrUpdate(paramSql);
				if (update>0) {
					// 将订单放入 
					log.info("进件结果查询：进件成功！等待审批结果查询,orderId=[{}]", orderId);
					// 进件成功    订单 状态改为  进件成功
					mysqlSpringJdbcDao.Update(new Object[][]{{"status",OrderStatusEnums.ASSET_PUSH_SUCCESS.name()}}, "ac_company_order", new Object[][]{{"id",orderId}});
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
				
				int update = mysqlSpringJdbcDao.Update(new Object[][]{{"deploy_status",4},{"deploy_message","[审批失败]"+message}}, "ac_xs_batch_order", new Object[][]{{"id",batch_order_id},{"deploy_status",1}});
				if(update>0){
					// 审批失败 订单 状态改为  打款失败
					mysqlSpringJdbcDao.Update(new Object[][]{{"status",OrderStatusEnums.ASSET_AUTH_FAILED.name()}}, "ac_company_order", new Object[][]{{"id",orderId},{"status",OrderStatusEnums.ASSET_PUSH_SUCCESS.name()}});
				}
			} else if (BooleanUtils.isTrue(flag)) {
				log.info("贷款审批结果：审批成功，orderId=[{}]", orderId);
				// 贷款审批成功 更新    当且仅当 初始进件状态1 的单子    更新成功后将单子放入 查询放款 的队列中
				String sql = " update ac_xs_batch_order set deploy_status = 3 , deploy_message = ? where id = ? and deploy_status in ('1','4') ";
				int update = mysqlSpringJdbcDao.insertOrUpdate(sql,"[审批成功]"+message,batch_order_id);
				if (update>0) {
					// 将订单放入 
					log.info("贷款审批结果：审批成功！订单进入查询放款结果队列，等待放款结果查询,orderId=[{}]", orderId);
					mysqlSpringJdbcDao.Update(new Object[][]{{"status",OrderStatusEnums.ASSET_AUTH_SUCCESS.name()}}, "ac_company_order", new Object[][]{{"id",orderId}});
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
    
    //处理放款结果
    @SuppressWarnings("unchecked")
   	protected synchronized Boolean handleLoanLoanResult(Map<String,Object>params){
       	try{
       		Map<String,Object> order = (Map<String, Object>) params.get("order");
       		Map<String,Object> company = (Map<String, Object>) params.get("company");		
       		Object[] noticeResult = (Object[]) params.get("noticeResult");
       		
       		int order_id = (int) order.get("id");
       		int loan_status = (int) order.get("loan_status");
       		if(2!= loan_status){
       			log.info("单子状态不为不为审批成功或者放款失败！无效通知orderId={}",order_id);
       			return false;
       		}
       		Boolean flag = (Boolean) noticeResult[0];
   			String message = (String) noticeResult[1]==null?"":(String) noticeResult[1];  //放款失败 ，需要返回原因
   			String endTime = (String)noticeResult[2];   //放款成功  此项有值
       		int company_id = (int) company.get("id");
   			if(BooleanUtils.isTrue(flag)){
   				//更新进件状态 进件状态:0初始，1成功，2失败，3审批成功，4审批失败，5放款成功，6放款失败',
   				String sql = " update ac_xs_batch_order set deploy_status = 5 , deploy_message = ? where order_id = ? and deploy_status in ('3','6') ";
				int update = mysqlSpringJdbcDao.insertOrUpdate(sql,"[放款成功]"+message,order_id);
   				if(update!=1){
   					return false  ;
   				}
   				//'放款成功  更新订单状态  保存放款时间  保存应还利息
   				int life_of_loan = (int) order.get("life_of_loan");
   				String order_deadline = getOrderDeadLine(endTime, life_of_loan);
   				BigDecimal orderMoney = (BigDecimal) order.get("actual_money");   //'确认借款金额(货物入库后,评估出的借款金额,实际本金)',
   				BigDecimal refund_interest = getOrderInterest(orderMoney);
   				mysqlSpringJdbcDao.Update(new Object[][]{{"status",OrderStatusEnums.LOAN_SUCCESS.name()},{"pay_time",endTime},{"refund_interest",refund_interest},{"order_deadline",order_deadline}}, "ac_company_order", new Object[][]{{"id",order_id}});
   				log.info("放款成功！更新订单状态成功！company_id=[{}],orderId=[{}]",company_id,order_id);
   				return true;
   			}else if(BooleanUtils.isFalse(flag)){
   				log.info("放款失败   company_id=【{}】，orderId=[{}]", company_id, order_id);
   				int update = mysqlSpringJdbcDao.Update(new Object[][]{{"deploy_status",6},{"deploy_message","[放款失败]"+message}}, "ac_xs_batch_order", new Object[][]{{"order_id",order_id},{"deploy_status",3}});
				if(update>0){
					// 放款失败 订单 状态改为  打款失败
					mysqlSpringJdbcDao.Update(new Object[][]{{"status",OrderStatusEnums.LOAN_FAILED.name()}}, "ac_company_order", new Object[][]{{"id",order_id}});
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
    
    //查询电子签章工具
    protected boolean doSearchElectSign(Map<String,Object>batch_order){
    	int order_id = (int) batch_order.get("order_id");
		try {
			Map<String, Object> order = mysqlSpringJdbcDao.queryForMap(" select * from ac_company_order where id = ? ", order_id);
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
    
    // 处理提现记录通知--------------------------------------
	protected synchronized Boolean handleTiXianLog(Map<String,Object>params){
		try {
			String busOrderId = (String) params.get("busOrderId");
			String withDrawId = (String) params.get("withDrawId");
			//提现失败的单 和成功的单 都不处理
			int i = mysqlSpringJdbcDao.Update(new Object[][]{{"withdraw_no",withDrawId},{"is_temp",0}}, "ac_xs_withdraw_records", new Object[][]{{"bus_order_id",busOrderId},{"status",0},{"is_temp",1}});
			if(i>0){
				log.info("发起提现：更新提现记录为有效,，请等待提现结果查询。busOrderId=【{}】",busOrderId);
				if(busOrderId.contains("D")){
					int order_id = XsOrderUtil.getOrderIdByBusOrderId(busOrderId);
					mysqlSpringJdbcDao.insertOrUpdate(" update ac_xs_batch_order set withdraw_status = 3 where order_id = ? and withdraw_status in (0,2) ",order_id);
				}
				return true;
			}
			log.info("发起提现：处理提现申请返回消息失败。busOrderId=【{}】",busOrderId);
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			log.info("发起提现：处理提现申请返回消息失败。params=[{}]",params);
			return false;
		}
	}
    
    
    //查询账户信息
    public Map<String,Object> getAccountInfoByCompanyId(int company_id){
    	//查询  银行账户
    	log.info("查询平安银行账户信息company_id=[{}]",company_id);
		Map<String, Object> bankAccount = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_company_bank_account where company_id = ? order by create_time desc limit 1 ", company_id);
		if(ObjectUtils.isEmpty(bankAccount)){
			log.info("没有在本库中查到相关的银行账户信息 bankAccount=[{}]",bankAccount);
			return null;
		}
		String bank_company_id = (String) bankAccount.get("bank_company_id");
		
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
    
    
	//还款类开始------------------------------------------------------------
    
    protected synchronized String getPaymentSql(Integer order_id){
		StringBuilder sb = new StringBuilder();
		sb.append("  SELECT  ");
		sb.append("  ac_xs_batch_order.deploy_status,  ");
		sb.append("  ac_xs_batch_order.repay_status,  ");
		sb.append("  datediff(now(), ac_company_order.pay_time) AS real_loan_days,   ");
		sb.append("  ac_company_order.*  ");
		sb.append("  FROM  ");
		sb.append("  ac_xs_batch_order  ");
		sb.append("  INNER JOIN ac_company_order ON ac_company_order.id = ac_xs_batch_order.order_id  ");
		sb.append("  where deploy_status = 5   ");
		sb.append("  and repay_status != 1    ");
		if(ObjectUtils.isEmpty(order_id)){
			//定时任务 正常还款
			sb.append("  and datediff(now(), ac_company_order.pay_time) = life_of_loan  ");
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
    	
    	//测试还款用
//    	benjin = zero;
//    	lixi = zero;
    	
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
    	//检测账户余额是否充足
    	Map<String, Object> bankAccount = getAccountInfoByCompanyId(company_id);
    	if(ObjectUtils.isEmpty(bankAccount)){
    		return null;
    	}
    	//账户余额	amount	NUMBER(18,2)	必填	借款人账户余额
    	BigDecimal amount = new BigDecimal(String.valueOf(bankAccount.get("amount")));
		if(amount.floatValue()<total.floatValue()){
			log.info("还款失败,余额不足。账户余额amount=[{}],应还金额total=[{}]",amount,total);
			return null;
    	}
		
		Map<String,Object> sendMap = new HashMap<>(); 
		sendMap.put("loanNumber", order.get("order_no"));    // 借款编号   必填  VARCHAR(64)
		sendMap.put("loanTerms", 1);     // 当前期数   必填  NUMBER(4)
		sendMap.put("repayDate", repayDate);     // 还款日     必填  Date
		sendMap.put("realBase", benjin);      // 实还本金   必填  NUMBER(18,2)
		sendMap.put("realInst", lixi);      // 实还利息   必填  NUMBER(18,2)
		sendMap.put("realPenalty", faxi);   // 实还罚息   必填  NUMBER(18,2)
		sendMap.put("realDefault", weiyuejin);   // 实还违约金 必填  NUMBER(18,2)
		sendMap.put("thisRepaySum", total);  // 月还金额   必填  NUMBER(18,2)
		sendMap.put("mustBase", benjin);      // 应还本金   必填  NUMBER(18,2)
		sendMap.put("mustInst", lixi);      // 应还利息   必填  NUMBER(18,2)
		sendMap.put("mustPenalty", faxi);   // 应还罚息   必填  NUMBER(18,2)
		sendMap.put("mustDefault", weiyuejin);   // 应还违约金 必填  NUMBER(18,2)
		sendMap.put("advanceAmount", total); // 提前结清实还必填 NUMBER(18,2)
		sendMap.put("cutBase", zero);       // 减免本金   必填  NUMBER(18,2)
		sendMap.put("cutInst", zero);       // 减免利息   必填  NUMBER(18,2)
		sendMap.put("cutPenalty", zero);    // 减免罚息   必填  NUMBER(18,2)
		sendMap.put("cutDefault", zero);    // 减免违约金 必填  NUMBER(18,2)
		sendMap.put("conCut", zero);        // 合同减免   必填  NUMBER(18,2)
		sendMap.put("policyCut", zero);     // 政策性减免 必填  NUMBER(18,2)
		sendMap.put("specialCut", zero);    // 特殊减免   必填  NUMBER(18,2)
		sendMap.put("repayScene", type);    // 还款场景   必填  VARCHAR(10)   1正常月还,2逾期月还,3提前结清,4逾期提前结清,5月还减免,6信用保证金结转
		sendMap.put("thirdLogNo", thirdLogNo);    // 交易流水号 必填  VARCHAR(100)
		
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
		
		Map<String,Object> dataMap = new HashMap<>();
		dataMap.put("sendMap", sendMap);
		dataMap.put("record", record);
		
		if("3".equals(type)){
			log.info("进入手动提前还款！");
			//更新批次表  `is_pre_pay` int(1) DEFAULT '0' COMMENT '是否是提前还款：0否，1是',
			int i = mysqlSpringJdbcDao.insertOrUpdate(" update ac_xs_batch_order set is_pre_pay = 1 where order_id = ? and order_no = ? and deploy_status = 5 and  repay_status != 1 and is_pre_pay = 0  ", order_id,order_no);
			if(i>0){
				log.info("开始还款成功后续操作。order_no=[{}] ,order_id=[{}],company_id=[{}]",order_no,order_id,company_id);
				BigDecimal refund_penal = faxi.add(weiyuejin);//'应还违约金(逾期罚息+催收费) 在订单结清之后更新该字段',
				String voucher_code = thirdLogNo;//'提货凭证码'
				//新增学习还款记录表
				record.put("is_pay_success",1);
				record.put("message",pre_pay_success);
				mysqlSpringJdbcDao.addSelectiveAndGetId("sp_xs_repay_records", record);
				//更新订单表
				mysqlSpringJdbcDao.Update(new Object[][]{{"refund_penal",refund_penal},{"status",OrderStatusEnums.REFUND_SUCCESS.name()},{"voucher_code",voucher_code},{"clearing_time",TimeHelper.getCurrentTime()}}, "ac_company_order", new Object[][]{{"order_no",order_no}});
				log.info(">>>>>>>>>>>手动提前还款成功。插入还款记录，更新订单成功，请等待自动还款。 order_id=[{}],company_id=[{}]",order_id,company_id);
				dataMap.clear();
				dataMap.put(pre_pay_success, "手动提前还款成功，返回。");
				log.info("手动提前还款成功，返回。");
				return dataMap;
			}
		}
		return dataMap;
	}
    
    @SuppressWarnings("unchecked")
	protected synchronized Boolean doRepayOrder(Map<String,Object> dataMap){
    	if(ObjectUtils.isEmpty(dataMap)){
    		return false;
    	}
    	if(dataMap.containsKey(pre_pay_success)){
    		log.info("手动提前还款成功，返回。");
    		return true;
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
			Map<String,Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.REPAYMENT_DETAIL_NOTICE);
			
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
		if(success){
			BigDecimal faxi = (BigDecimal) record.get("realPenalty");
			BigDecimal weiyuejin = (BigDecimal) record.get("realDefault");
			BigDecimal refund_penal = faxi.add(weiyuejin);//'应还违约金(逾期罚息+催收费) 在订单结清之后更新该字段',
			String voucher_code = (String) record.get("thirdLogNo");//'提货凭证码',
			log.info("开始还款成功后续操作。order_no=[{}] ,order_id=[{}],company_id=[{}]",order_no,order_id,company_id);
			
			//校验是否提前  还过款
			Map<String, Object> ac_xs_batch_order = mysqlSpringJdbcDao.queryForMap(" select * from ac_xs_batch_order where order_id = ? and order_no = ? and deploy_status = 5 and  repay_status <> 1  ", order_id,order_no  );
			int is_pre_pay = (int) ac_xs_batch_order.get("is_pre_pay");
			
			//更新批次表  `repay_status` int(1) DEFAULT '0' COMMENT '0未还款，1还款成功，2还款失败',
			int i = mysqlSpringJdbcDao.insertOrUpdate(" update ac_xs_batch_order set repay_status = 1 where order_id = ? and order_no = ? and deploy_status = 5 and  repay_status <> 1 ", order_id,order_no);
			if(i>0){
				//新增学习还款记录表
				mysqlSpringJdbcDao.addSelectiveAndGetId("sp_xs_repay_records", record);
				//更新订单表
				if(is_pre_pay==1){
					log.info("订单提前还过款，无需更改订单状态。 order_id=[{}],company_id=[{}]",order_id,company_id);
					return ;
				}else{
					mysqlSpringJdbcDao.Update(new Object[][]{{"refund_penal",refund_penal},{"status",OrderStatusEnums.REFUND_SUCCESS.name()},{"voucher_code",voucher_code},{"clearing_time",TimeHelper.getCurrentTime()}}, "ac_company_order", new Object[][]{{"order_no",order_no}});
				}
				log.info(">>>>>>>>>>>还款成功。插入还款记录，更新订单成功。 order_id=[{}],company_id=[{}]",order_id,company_id);
			}
		}else{
			log.info("开始还款失败后续操作。order_no=[{}] ,order_id=[{}],company_id=[{}]",order_no,order_id,company_id);
			//更新批次表  `repay_status` int(1) DEFAULT '0' COMMENT '0未还款，1还款成功，2还款失败',
			int i = mysqlSpringJdbcDao.Update(new Object[][]{{"repay_status",2}},"ac_xs_batch_order",new Object[][]{{"order_no",order_no}});
			if(i>0){
				//新增学习还款记录表
				mysqlSpringJdbcDao.addSelectiveAndGetId("sp_xs_repay_records", record);
				log.info(">>>>>>>>>>>还款失败。插入还款记录，更新批次成功。 order_id=[{}],company_id=[{}]",order_id,company_id);
				
				//更新订单表
				mysqlSpringJdbcDao.Update(new Object[][]{{"status",OrderStatusEnums.REFUND_FAILED.name()}}, "ac_company_order", new Object[][]{{"order_no",order_no}});
				log.info(">>>>>>>>>>>还款失败。更新订单状态成功。 order_id=[{}],company_id=[{}]",order_id,company_id);
			}
		}
	}
    //还款工具类---------------------------------------------------------------------
    
	
}
