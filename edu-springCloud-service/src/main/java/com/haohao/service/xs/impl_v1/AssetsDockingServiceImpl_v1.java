package com.haohao.service.xs.impl_v1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
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
import com.haohao.service.xs.AssetsDockingService_v1;
import com.haohao.service.xs.impl.AssetsDockingServiceImpl;
import com.haohao.util.springTools.springJdbc.helper.TimeHelper;
import com.haohao.util.tools.RequestToXS;
import com.haohao.util.tools.XSMethodActionTool;
import com.haohao.util.tools.XsConfig;
import com.haohao.util.tools.XsFileToZipUtil;
import com.haohao.util.tools.XsFtpClientUtil;
import com.haohao.util.tools.XsOrderUtil;

@Service
public class AssetsDockingServiceImpl_v1 extends AssetsDockingHelper_v1 implements AssetsDockingService_v1 {

	private static final Logger log = LoggerFactory.getLogger(AssetsDockingServiceImpl.class);
	
	//是否开户-------------------------------------------------------
	@Override
	public Boolean hasOpenAccount(int company_id,String mobile){
		//先查本库中是否有账户
		Map<String, Object> ac_company_orderMap = xsService_v1.getCompanyById(company_id);
		String id_card = (String) ac_company_orderMap.get("loan_company_id_card");
		Map<String, Object> bankAccountMap = xsService_v1.getBankAccountByCompanyIdAndIdCard(company_id, id_card);
		if (ObjectUtils.isEmpty(bankAccountMap)) {
			// 2.如果本库中没有，再查学习
			Map<String, Object> sendMap = new HashMap<>();
			sendMap.put("name", ac_company_orderMap.get("name"));
			sendMap.put("mobile", mobile);
			Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.BORROW_USER_ACCOUNT_CHECK);
			
			// 0000：成功。 9999: 校验传参不通过
			String result = (String) resultMap.get("result"); 
			if ("0000".equals(result)) {
				// 是否开户 hasAccount  VARCHAR   1：未开户，0：已开户；
				String hasAccount = (String) resultMap.get("hasAccount");
				if ("1".equals(hasAccount)) {
					log.info(">>>>>学习开户查询：未开户");
					return false;
				} else if ("0".equals(hasAccount)) {
					log.info(">>>>>学习开户查询：已开户   将自动保存开户信息");
					String bank_company_id = (String) resultMap.get("bankUserId");
					Map<String,Object> account = searchAccountInfoByBankCompanyId(bank_company_id);
					if(ObjectUtils.isEmpty(account)){
						return false;
					}
					account.put("company_id", company_id);
					account.put("id_card", account.remove("idCardNo"));
					account.put("name", account.remove("userName"));
					saveAccountInfo(account);
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
			log.info(">>>>>学习开户查询：本库中查到开户信息.");
			return true;
		}
	}
	//是否开户-----------------------------------------------------------------
	
	//校验是否学习理财人----------------------------------------------------------
	//此接口1.0不使用
	@Override
	public boolean isXsFinancialMan(int company_id ,String mobile){
		try {
			Map<String, Object> ac_company_orderMap = xsService_v1.getCompanyById(company_id);
			String id_card = (String) ac_company_orderMap.get("loan_company_id_card");
			Map<String,Object> sendMap = new HashMap<>();
//			sendMap.put("idCardNo", id_card);   //String(30)	 Y idCardNo 身份证号码
			sendMap.put("mobile", mobile);   //String(50)	 N mobile 用户手机号
		
			Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.BORROW_USER_CHECK);
			//0000  和  1  表示 不是理财人，  其他情况 可能是理财人，可能是接口异常
			if("0000".equals(resultMap.get("result"))&&"1".equals(resultMap.get("isLendUser"))){
				return false;
			}
			log.info("用户为  学习理财人 company_id = {}",company_id);
			return true;
		} catch (Exception e) {
			log.info("学习理财人  校验异常company_id = {}",company_id);
			log.info("{}",e);
			return true;
		}
	}
	//校验是否学习理财人-----------------------------------------------------------------------------------------
	
	//查询账户信息-----------------------------------------------------------------------------
	@Override
    public Map<String,Object> getAccountInfoByCompanyId(int company_id){
		//查询  银行账户
    	log.info("查询平安银行账户信息company_id=[{}]",company_id);
		Map<String, Object> bankAccount = xsService_v1.getNewestBankAccountByCompanyId(company_id);
		if(ObjectUtils.isEmpty(bankAccount)){
			log.info("没有在本库中查到相关的银行账户信息 bankAccount=[{}]",bankAccount);
			return null;
		}
		String bank_company_id = (String) bankAccount.get("bank_company_id");
		return searchAccountInfoByBankCompanyId(bank_company_id);
    }
    
	//查询账户信息-----------------------------------------------------------------------------
	
	//发送平安开户短信验证码----------------------------------------------------------------------
	@Override
	public boolean sendPingAnMobileCode(int company_id,String mobile,String cardNum,String bankName){
		try {
			log.info(">>>>>>>>>>>>>>发送开户短信验证码company_id=[{}]",company_id);
			Map<String, Object> ac_company_orderMap =xsService_v1.getCompanyById(company_id);
			String id_card = (String) ac_company_orderMap.get("loan_company_id_card");
			String name = (String) ac_company_orderMap.get("name");
			Map<String,Object> sendMap = new HashMap<>();
			sendMap.put("sendType", "2"); //  发送类型    String(1)   1=个人开户      2=企业开户
			sendMap.put("mobile", mobile); //  用户手机号    String(30)  企业开户必填 
			sendMap.put("idCardType", "73"); //  证件类型    String(1)   企业： 组织机构代码证 52        社会信用代码证送73
			sendMap.put("idCardNo", id_card); //  证件号码    String(30)   企业开户必填
			sendMap.put("bankCard", cardNum); //  银行卡号    String(30)   企业开户必填
			sendMap.put("userName", name); //  账户名称    String（100）   企业开户必填
			sendMap.put("bankName", bankName); //  银行名称  String   企业开户必填
			
			Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.SEND_MESSAGE);
			
			if("0000".equals(resultMap.get("result"))){
				String sms_id = (String) resultMap.get("smsId");
				String user_no = (String) resultMap.get("userNo");
				if(saveOrUpdateMobileCode(company_id, mobile, sms_id, user_no)){
					log.info(">>>>>>>>>>>>>>发送保存开户短信验证码成功！company_id=[{}]",company_id);
					return true;
				}
				log.info(">>>>>>>>>>>>>>保存开户短信验证码失败！");
				return false;
			}else{
				log.info(">>>>>>>>>>>>>>出错：发送开户短信验证码");
				return false;
			}
		} catch (Exception e) {
			log.info("{}",e);
			log.info(">>>>>>>>>>>>>>出错：发送开户短信验证码");
			return false;
		}
	}
	
	private boolean saveOrUpdateMobileCode(int company_id,String mobile,String sms_id,String user_no){
		Map<String, Object> company_mobile_code = xsService_v1.getNewestCompanyMobileCodeByCompanyIdAndMobile(company_id, mobile);
		if(ObjectUtils.isEmpty(company_mobile_code)){
			//新增
			Map<String,Object> save = new HashMap<>();
			save.put("company_id", company_id);
			save.put("mobile", mobile);
			save.put("sms_id", sms_id);
			save.put("user_no", user_no);
			save.put("create_time", TimeHelper.getCurrentTime());
			Number addSelectiveAndGetId = mysqlSpringJdbcDao.addSelectiveAndGetId("jz_ac_xs_company_mobile_code", save);
			if(addSelectiveAndGetId.intValue()>0){
				log.info("新增发送短信验证码记录成功！compan_id=[{}]",company_id);
				return true;
			}
		}else{
			//更新
			int update = mysqlSpringJdbcDao.Update(new Object[][]{{"sms_id",sms_id},{"user_no",user_no}}, "jz_ac_xs_company_mobile_code", new Object[][]{{"company_id",company_id},{"mobile",mobile}});
			if(update>0){
				log.info("更新发送短信验证码记录成功！compan_id=[{}]",company_id);
				return true;
			}
		}
		return false;
	}
	
	//发送平安开户短信验证码----------------------------------------------------------------------

	//开户------------------------------------------------
	@Override
	public boolean openAccount(Map<String,Object>params){
		
		Integer company_id = Integer.parseInt(String.valueOf(params.get("company_id")));
		String mobile = (String) params.get("mobile");
		String bankCard = (String) params.get("bankCard");
		String bankName = (String) params.get("bankName");
		String bankCity = (String) params.get("bankCity");
		String bankProvince = (String) params.get("bankProvince");
		String superBankCode = (String) params.get("superBankCode");
		String smsCode = (String) params.get("smsCode");
		
		Map<String, Object> ac_company_orderMap = xsService_v1.getCompanyById(company_id);
		String id_card = (String) ac_company_orderMap.get("loan_company_id_card");
		
		 Map<String, Object> company_mobile_code = xsService_v1.getNewestCompanyMobileCodeByCompanyIdAndMobile(company_id, mobile);
		 if(ObjectUtils.isEmpty(company_mobile_code)){
			 log.info("开户：未查询到短信验证码记录。company_id=[{}],mobile=[{mobile}]",company_id,mobile);
			 return false;
		 }
		 String sms_id = (String) company_mobile_code.get("sms_id");
		 String user_no = (String) company_mobile_code.get("user_no");
		 
		Map<String,Object> sendMap = new HashMap<>();
		sendMap.put("idCardType", 73);  // 必填   Number(2)    证件类型    组织机构代码证 52    社会信用代码证送73
		sendMap.put("userName", ac_company_orderMap.get("name"));  // 必填   String(20)    用户姓名 
		sendMap.put("idCardNo", id_card);  // 必填   String(30)    证件号码 
		sendMap.put("mobile", mobile);  // 必填   String(30)    用户手机 号
		sendMap.put("bankCard", bankCard);  // 必填   String(20)    银行卡号 
		sendMap.put("bankType", bankName.contains("平安")?1:2);  // 必填   Number(1)    银行卡类 型   1：平安银行、2：其他银行
		sendMap.put("bankName", bankName);  // 必填   String(20)    开户行名 称	
		sendMap.put("bankProvince", bankProvince);  // 必填   String(20)    开户行省 
		sendMap.put("bankCity", bankCity);  // 必填   String(20)    开户行市 
		sendMap.put("smsId", sms_id);  // 必填   String(20)    短信识别 码
		sendMap.put("smsCode", smsCode);  // 必填   String(20)    短信验证 码
		sendMap.put("userNo", user_no);  // 必填   String(20)    用户编号 
		sendMap.put("superBankCode", superBankCode);  // 必填   String(32)    超级网银 行号
		
		Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.ENTERPRISE_ACCOUNT_CREATE);
		String result = (String) resultMap.get("result");
		if("0000".equals(result)){
			log.info("企业开户： 开户成功！");
			String bankUserId = (String) resultMap.get("bankUserId");
			params.put("bankUserId", bankUserId);
			params.put("id_card", id_card);
			boolean saveAccountInfo = saveAccountInfo(params);
			if(saveAccountInfo){
				return true;
			}
		}
		return false;
	}

	//开户------------------------------------------------
	
	// 保存额度-----------------------------------------------------
	@Override
	public Map<String, Object> saveContract(Map<String, Object> params) throws Exception {
		log.info("资产对接AssetsDockingServiceImpl_v1：saveContract");

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

		mysqlSpringJdbcDao.addSelectiveAndGetId("jz_ac_xs_contract", ac_xs_contract);

		returnMap.put("id", apply_code);
		returnMap.put("code", "0000");
		returnMap.put("msg", "操作成功");
		return returnMap;
	}
	
	// 自动推送进件-------------------------------------------------

		@Override
		public void autoDeployOrder() {
			log.info("自动推送进件...开始");
			// 1.查询所有需要推送的订单
			List<Map<String, Object>> orderList = xsService_v1.getNeedDeployOrders();
			if (ObjectUtils.isEmpty(orderList )) {
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
					log.info("自动进件：进件出现异常order_id=[{}]",order_id);
					continue;
				}
			}
		}
		// 自动推送进件-------------------------------------------------

		// 附件查询----------------------------------------------------
		@Override
		public Map<String, Object> queryAttachmentInfo(Map<String, Object> params) {
			String loanNumber = (String) params.get("loanNumber");
			Map<String, Object> order = xsService_v1.getOrderByOrderNo(loanNumber);
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
				Map<String, Object> company = xsService_v1.getCompanyById(company_id);
				String LEGAL_CARD_TOP = (String)company.get("legal_card_face");
				String LEGAL_CARD_BOT = (String)company.get("legal_card_back");
				if (ObjectUtils.isEmpty(LEGAL_CARD_TOP)||ObjectUtils.isEmpty(LEGAL_CARD_BOT)) {
					log.info("idCardFacePath  为空！");
					return false;
				}
				String[] split = StringUtils.split(LEGAL_CARD_TOP, "/");
				String[] split2 = StringUtils.split(LEGAL_CARD_BOT, "/");
				// 企业法人的身份证
				// /xs/haohao/data/qiye/jz/20180619/201b05a7-dbbd-4e82-96f7-a4d34886dd16.png
			
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
			Map<String, Object> batch_order = xsService_v1.getNewestBatchOrderByDeployStatusAndOrderNo(0, order_no);
			if (ObjectUtils.isEmpty(batch_order)) {
				return getFailed("进件结果通知:借款编号对应的批次订单不存在。或状态不为初始状态");
			}
			Map<String, Object> order = xsService_v1.getOrderByOrderNo(order_no);
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
			List<Map<String, Object>> batch_orderList = xsService_v1.getBatchOrdersByDeployStatus(0);
			if (ObjectUtils.isEmpty(batch_orderList)) {
				log.info("进件结果查询：没有需要查询进件结果的单子了。");
				return;
			}
			for (Map<String, Object> batch_order : batch_orderList) {
				try {
					String order_no = (String) batch_order.get("order_no");
					Map<String, Object> order = xsService_v1.getOrderByOrderNo(order_no);
					if (!OrderStatusEnums.ASSET_PUSHED.name().equals(order.get("status"))&&!OrderStatusEnums.ASSET_PUSH_FAILED.name().equals(order.get("status"))) {
						log.info("进件结果查询：订单状态已经不是进件初始状态或者进件失败状态,无效操作状态,status={}", order.get("status"));
						continue;
					}
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
			
			//查询进件成功的  单子
			int deploy_status = 1 ;
			Map<String, Object> batch_order = xsService_v1.getNewestBatchOrderByDeployStatusAndOrderNo(deploy_status, loanNumber);

			if (ObjectUtils.isEmpty(batch_order)) {
				log.info("不存在该批次的订单,或批次订单状态不为待审核。  orderNo={}", loanNumber);
				return getAuditFailed(loanNumber, "不存在该批次的订单,或批次订单状态不为待审核。 ");
			}
			
			Map<String, Object> order = xsService_v1.getOrderByOrderNo(loanNumber);
			
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
			List<Map<String, Object>> batch_orderList =xsService_v1.getBatchOrdersByDeployStatus(1);
			if (ObjectUtils.isEmpty(batch_orderList)) {
				log.info("审批结果查询：没有需要查询审批结果的单子了。");
				return;
			}
			for (Map<String, Object> batch_order : batch_orderList) {
				try {
					String order_no = (String) batch_order.get("order_no");
					Map<String, Object> order = xsService_v1.getOrderByOrderNo(order_no);
					if (!OrderStatusEnums.ASSET_PUSH_SUCCESS.name().equals(order.get("status"))&&!OrderStatusEnums.ASSET_AUTH_FAILED.name().equals(order.get("status"))) {
						log.info("审批结果查询：订单状态不是进件成功或者审批失败,status={},无效操作状态", order.get("status"));
						continue ;
					}
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

	//查询放款结果----------------------------------------------------------------------------	
    @Override
    public void searchLoanResult() {
    	// 查询所有需要 查询放款结果的订单
		log.info("放款结果查询...");
		// 查询所有deploy状态为3的单子
		List<Map<String, Object>> batch_orderList = xsService_v1.getBatchOrdersByDeployStatus(3);
		if (ObjectUtils.isEmpty(batch_orderList)) {
			log.info("放款结果查询：没有需要查询放款结果的单子了。");
			return;
		}
		for (Map<String, Object> batch_order : batch_orderList) {
			String order_no = (String) batch_order.get("order_no");
			try {
				Map<String, Object> order = xsService_v1.getOrderByOrderNo(order_no);
				if(ObjectUtils.isEmpty(order)){
					log.info("订单异常 : 未找到订单 ，order_no=[{}]",order_no);
					continue;
				}
				if (!OrderStatusEnums.ASSET_AUTH_SUCCESS.name().equals(order.get("status")) && !OrderStatusEnums.LOAN_FAILED.name().equals(order.get("status"))) {
					log.info("单子状态不为不为审批成功或者放款失败！无效查询order_no={}", order_no);
					continue;
				}
				Object[] noticeResult = searchLoanLoanResult(order_no);
				int company_id =  (int) order.get("company_id");
				Map<String, Object> company = xsService_v1.getCompanyById(company_id);
				Map<String, Object> sendMap = new HashMap<>();
				sendMap.put("company", company);
				sendMap.put("noticeResult", noticeResult);
				sendMap.put("order", order);
				handleLoanLoanResult(sendMap);
			} catch (Exception e) {
				log.info("订单异常  ，order_no=[{}]",order_no);
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
 			Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.LOAN_LOAN_SEARCH_V1);
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
  //查询放款结果----------------------------------------------------------------------------	
    
 	//放款结果通知-----------------------------------------------------------------------
 	@Override
	public Map<String, Object> loanLoanResultNotice(Map<String, Object> params) {
		String loanNumber = (String) params.get("loanNumber");
		String result = (String) params.get("result");
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
		Map<String, Object> order = xsService_v1.getOrderByOrderNo(loanNumber);
		if (!OrderStatusEnums.ASSET_AUTH_SUCCESS.name().equals(order.get("status")) && !OrderStatusEnums.LOAN_FAILED.name().equals(order.get("status")) ) {
			log.info("不存在此单号的订单loanNumber={},或者订单状态不为审批成功或者打款失败", loanNumber);
			return getLoanFailed("没有找到此单号对应的订单，或者订单状态不为审批成功或者打款失败 ");
		}
		Boolean resultFlag = null;
		String message = (String) params.get("message");
		// 04：放款成功 , 05：放款失败,99：放款中
		if ("04".equals(result)) {
			log.info("放款成功  orderNo={}", loanNumber);
			resultFlag = true;
		} else if ("05".equals(result)) {
			log.info("放款失败  orderNo={}", loanNumber);
			resultFlag = false;
		} else {
			log.info("无效的放款通知  orderNo={}", loanNumber);
			return getFailed("无效的放款通知");
			
		}
		Object[] noticeResult = new Object[] { resultFlag, message, endTime };
		int company_id =  (int) order.get("company_id");
		Map<String, Object> company = xsService_v1.getCompanyById(company_id);
		Map<String, Object> sendMap = new HashMap<>();
		sendMap.put("company", company);
		sendMap.put("noticeResult", noticeResult);
		sendMap.put("order", order);
		Boolean flag = handleLoanLoanResult(sendMap);
		if (BooleanUtils.isTrue(flag)) {
			return getLoanSuccess(loanNumber);
		} else {
			return getLoanFailed("处理异常");
		}
	}
	// 放款结果通知--------------------------------------------------------------------
    
    //查询提现结果----------------------------------------------------------------------------
    @Override
    public void searchTiXianResult() {
    	// 查询所有需要 查询提现结果的订单
		log.info("提现结果查询...");
		// 查询所有deploy状态为 5 的单子
		List<Map<String, Object>> batch_orderList = mysqlSpringJdbcDao.queryForList(" select * from jz_ac_xs_batch_order where deploy_status = 5 and withdraw_status in (0,3)  order by id asc limit 10  ");
		if (ObjectUtils.isEmpty(batch_orderList)) {
			log.info("提现结果查询：没有需要查询提现结果的单子了。");
			return;
		}
		for (Map<String, Object> batch_order : batch_orderList) {
			String order_no = (String) batch_order.get("order_no");
			try {
				Map<String, Object> order = xsService_v1.getOrderByOrderNo(order_no);
				if(ObjectUtils.isEmpty(order)){
					log.info("订单异常 : 未找到订单 ，order_no=[{}]",order_no);
					continue;
				}
				if (!OrderStatusEnums.LOAN_SUCCESS.name().equals(order.get("status")) && !OrderStatusEnums.WITHDRAW_FAILED.name().equals(order.get("status"))) {
					log.info("单子状态不为不为放款成功或者提现失败！无效查询order_no={}", order_no);
					continue;
				}
				
				Object[] noticeResult = searchWithdrawResult2Xs(order_no);
				Map<String, Object> company = xsService_v1.getCompanyById((int) order.get("company_id"));
				Map<String, Object> sendMap = new HashMap<>();
				sendMap.put("company", company);
				sendMap.put("noticeResult", noticeResult);
				sendMap.put("order", order);
				handleWithdrawResult(sendMap);
			} catch (Exception e) {
				log.info("订单异常  ，order_no=[{}]",order_no);
				e.printStackTrace();
				continue;
			}
		}
    }
   
  	private Object[] searchWithdrawResult2Xs(String orderNo) {
  		try {
  			Map<String, Object> sendMap = new HashMap<>();
  			sendMap.put("loanNumber", orderNo);
  			Map<String, Object> resultMap = RequestToXS.request(sendMap, XSMethodActionTool.BORROW_ACCOUNT_WITHDRAWALS_SEARCH_V1);
  			String result = (String) resultMap.get("result");
  			String message = (String) resultMap.get("message");// 放款失败 ，需要返回原因
  			String status = (String) resultMap.get("status");
  			// 0000 提现成功，   9999 提现失败
  			if ("0000".equals(result)) {
  				String withdrawTime = (String) resultMap.get("withdrawTime");// 
  	  			BigDecimal drawAmount = new BigDecimal((String)resultMap.get("drawAmount")) ;// 
  				log.info("提现成功！orderNo=[{}],resultMap=[{}]", orderNo, resultMap);
  				return new Object[] { true, message, withdrawTime,drawAmount };
  			} else if ("9999".equals(result)) {
  				if("1".equals(status)){
  					log.info("提现失败！orderNo=[{}],resultMap=[{}]", orderNo, resultMap);
  	  				return new Object[] { false, message, null };
  				}else{
  					log.info("未查询到有效的提现状态！orderNo=[{}],resultMap=[{}]", orderNo, resultMap);
  	  				return new Object[] { null, message, null };
  				}
  			} else {
  				log.info("未查询到有效的提现状态！orderNo=[{}],resultMap=[{}]", orderNo, resultMap);
  				return new Object[] { null, message, null };
  			}
  		} catch (Exception e) {
  			log.info("{}", e);
  			return new Object[] { null, null, null };
  		}
  	}
    //查询提现结果----------------------------------------------------------------------------
    
    //提现结果通知---------------------------------------------------
    @Override
    public Map<String, Object> drawResultNoticeFromXS(Map<String, Object> params) {
    	String loanNumber = (String) params.get("loanNumber");
		String result = (String) params.get("result");
		String endTime = (String) params.get("endTime");
		BigDecimal withdrawAmount = new BigDecimal((String) params.get("withdrawAmount"));

		if (loanNumber == null || loanNumber.length() == 0) {
			return getLoanFailed("loanNumber 订单号不能为空");
		}
		if (result == null || result.length() == 0) {
			return getLoanFailed("result 状态不能为空");
		}
		if (endTime == null || !TimeHelper.isDate(endTime, TimeHelper.YYYY_MM_DD_HH_MM_SS)) {
			return getLoanFailed("endTime 完成时间错误");
		}
		if (ObjectUtils.isEmpty(withdrawAmount)) {
			return getLoanFailed("体现通知金额 withdrawAmount 不正确");
		}

		Map<String, Object> order = mysqlSpringJdbcDao.queryForMap(" select * from jz_ac_company_order where order_no = ? and status in (?,?) order by create_time desc limit 1 ", loanNumber, OrderStatusEnums.LOAN_SUCCESS.name(),OrderStatusEnums.WITHDRAW_FAILED.name());
		if (ObjectUtils.isEmpty(order)) {
			log.info("不存在此单号的订单loanNumber={},或者订单状态不为放款成功或者提现失败", loanNumber);
			return getLoanFailed("没有找到此单号对应的订单，或者订单状态不为放款成功或者提现失败 ");
		}

		Boolean resultFlag = null;
		String message = (String) params.get("message");
		// 0000：放款提现成功；9999：放款提现失败
		if ("0000".equals(result)) {
			log.info("放款成功  orderNo={}", loanNumber);
			resultFlag = true;
		} else if ("9999".equals(result)) {
			log.info("放款失败  orderNo={}", loanNumber);
			resultFlag = false;
		} else {
			log.info("无效的放款通知  orderNo={}", loanNumber);
			return getFailed("无效的放款通知");
		}
		
		Object[] noticeResult = new Object[] { resultFlag, message, endTime ,withdrawAmount};
		Map<String, Object> company = xsService_v1.getCompanyById((int) order.get("company_id"));
		Map<String, Object> sendMap = new HashMap<>();
		sendMap.put("company", company);
		sendMap.put("noticeResult", noticeResult);
		sendMap.put("order", order);
		Boolean flag = handleWithdrawResult(sendMap);
		if (BooleanUtils.isTrue(flag)) {
			return getLoanSuccess(loanNumber);
		} else {
			return getLoanFailed("处理异常");
		}
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
    
	//提现结果通知---------------------------------------------------
    
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
 	public Boolean manualRepaymentNotice(int order_id) throws Exception {
 		log.info("手动触发还款：order_id=[{}]",order_id);
 		Map<String, Object> bigOrder = mysqlSpringJdbcDao.queryForMap(getPaymentSql(order_id));
 		Map<String, Object> dataMap = getDataMap(bigOrder, handle_type_manu);
 		return doRepayOrder(dataMap);
 	}
 	// 手动还款--------------------------------------------------------------
    
    
}
