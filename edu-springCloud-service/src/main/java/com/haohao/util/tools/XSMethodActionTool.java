package com.haohao.util.tools;

import java.util.HashMap;
import java.util.Map;

public class XSMethodActionTool {
	
	
	
	
	// 银行H5交互类开始-------------------------------------------------------------------------------------------

	// 同步通知
	/** 开户绑卡 */
	public static final String acctCreate = "acctCreate";
	/** 2.0 绑定银行卡 */
	public static final String bankcardBind = "borrowerBankcardBind";
	/** 2.0 解除银行卡 */
	public static final String bankcardUnbind = "borrowerBankcardUnbind";
	/** 2.0 更换银行卡 */
	public static final String bankcardChange = "borrowerBankcardChange";
	/** 修改交易密码 */
	public static final String updateDealpwd = "borrowerUpdateDealpwd";
	/** 重置交易密码 */
	public static final String resetDealpwd = "borrowerResetDealpwd";
	/** 修改预留手机号 */
	public static final String modifyPhoneNum = "borrowerModifyPhoneNum";
	/**设置授权信息**/
	public static final String setAuthor = "borrowerSetAuthor";
	/** 提现 */
	public static final String accountWithdraw = "borrowAccountWithdraw";

	public static String getXsH5ReturnUrlByMethod(String methodName) {
		return XsConfig.web_domain+"/xs/syncNotice/" + methodName + "H5";
	}

	// 获取异步通知类
	public static String getActionByMethodName(String methodName) {
		Map<String, String> method_action = new HashMap<>();
		// 2.0  开户
		method_action.put(BORROWER_ACCT_CREATE, acctCreate);
		// 2.0  绑定银行卡
		method_action.put(BORROWER_BANKCARD_BIND, bankcardBind);
		// 2.0  解除银行卡
		method_action.put(BORROWER_BANKCARD_UNBIND, bankcardUnbind);
		// 2.0  更换银行卡
		method_action.put(BORROWER_BANKCARD_CHANGE, bankcardChange);
		// 2.0 修改预留手机
		method_action.put(BORROWER_MODIFY_PHONENUM, modifyPhoneNum);
		// 2.0 设置交易密码
		method_action.put(BORROWER_UPDATE_DEALPWD, updateDealpwd);
		// 2.0 重置交易密码
		method_action.put(BORROWER_RESET_DEALPWD, resetDealpwd);
		// 2.0 设置授权信息
		method_action.put(BORROWER_SET_AUTHOR, setAuthor);
		// 2.0 借款人费用
		method_action.put(BORROW_ACCOUNT_WITHDRAW, "borrowAccountWithdraw");
		return method_action.get(methodName);
	}
	// 银行H5交互类结束-------------------------------------------------------------------------------------------

	// 资产对接类开始-包括直连接收common通知--------------------------------------------------------------------------------------------

	public static final String xs_method_prefix = XsConfig.xs_method_prefix+".";
	
	//进件校验  
	public static final String LOAN_ENABLE_CHECK = xs_method_prefix+"loan.enable.check";
	//自动推送进件  
	public static final String LOAN_AUTO_ENTRY = xs_method_prefix+"enterprise.loan.auto.entry";
	
	//大众自动推送进件  
	public static final String JZ_LOAN_AUTO_ENTRY = xs_method_prefix+"jz.enterprise.loan.auto.entry";
	
	// 额度申请 1.0|2.0
	public static final String LOAN_QUOTA_APPLY = xs_method_prefix+"loan.quota.apply";
	// 校验借款人是否已开户2.0
	public static final String BORROWER_EXISTS_CHECK = xs_method_prefix+"borrower.exists.check";
	// 进件调配通知 1.0|2.0
	public static final String LOAN_ALLOCATION_FINISH = xs_method_prefix+"loan.allocation.finish";
	// 查询进件列表1.0|2.0
	public static final String LOAN_BASE_SEARCH = xs_method_prefix+"loan.base.search";
	// 查询进件详细信息1.0|2.0
	public static final String LOAN_DETAIL_SEARCH = xs_method_prefix+"loan.detail.search";
	// 查询附件信息1.0|2.0
	public static final String LOAN_ATTACH_SEARCH = xs_method_prefix+"loan.attach.search";
	
	
	// 放款提现查询
	public static final String BORROW_ACCOUNT_WITHDRAWALS_SEARCH = xs_method_prefix+"borrow.account.withdrawals.search";
	// 放款提现通知
	public static final String BORROW_ACCOUNT_WITHDRAWALS_NOTICE = xs_method_prefix+"borrow.account.withdrawals.notice";
	// 进件结果通知
	public static final String LOAN_RESULT_NOTICE = xs_method_prefix+"loan.result.notice";
	// 查询进件结果
	public static final String LOAN_RESULT_SEARCH = xs_method_prefix+"loan.result.search";
	// 借款人划扣接口
	public static final String BORROWER_DEDUCT_APPLY = xs_method_prefix+"borrower.deduct.apply";
	// 借款人划扣查询接口
	public static final String BORROWER_DEDUCT_QUERY = xs_method_prefix+"borrower.deduct.query";
	// 2.0贷款审批通知接口
	public static final String LOAN_AUDIT_RESULT = xs_method_prefix+"loan.audit.result";
	// 2.0查询贷款审批结果
	public static final String LOAN_AUDIT_SEARCH = xs_method_prefix+"loan.audit.search";
	// 2.0 放款通知
	public static final String LOAN_LOAN_RESULT = xs_method_prefix+"loan.loan.result";
	// 2.0 放款通知
	public static final String BORROW_ACCOUNT_LOAN_NOTICE = xs_method_prefix+"borrow.account.loan.notice";
	// 2.0 查询放款结果
	public static final String LOAN_LOAN_SEARCH = xs_method_prefix+"loan.loan.search";
	

	// 2.0 借款人开户
	public static final String BORROWER_ACCT_CREATE = xs_method_prefix+"borrower.acct.create";
	// 2.0 借款人账户信息查询
	public static final String BORROW_ACCOUNT_SEARCH = xs_method_prefix+"borrow.account.search";
	//2.0 担保人账户查询
	public static final String ASSURE_ACCOUNT_SEARCH = xs_method_prefix+"assu.account.search";
	// 2.0 绑定银行卡
	public static final String BORROWER_BANKCARD_BIND = xs_method_prefix+"borrower.bankcard.bind";
	// 2.0  解除银行卡
	public static final String BORROWER_BANKCARD_UNBIND = xs_method_prefix+"borrower.bankcard.unbind";
	// 2.0  更换银行卡
	public static final String BORROWER_BANKCARD_CHANGE = xs_method_prefix+"borrower.bankcard.change";
	// 2.0 修改预留手机号码
	public static final String BORROWER_MODIFY_PHONENUM = xs_method_prefix+"borrower.modify.phoneNum";
	// 2.0 是否设置交易密码
	public static final String BORROWER_DEALPWD_SEARCH = xs_method_prefix+"borrower.dealpwd.search";
	// 2.0 设置交易密码
	public static final String BORROWER_UPDATE_DEALPWD = xs_method_prefix+"borrower.update.dealpwd";
	// 2.0 重置交易密码
	public static final String BORROWER_RESET_DEALPWD = xs_method_prefix+"borrower.reset.dealpwd";
	// 2.0 设置授权信息
	public static final String BORROWER_SET_AUTHOR = xs_method_prefix+"borrower.set.author";
	// 2.0 借款人费用提现
	public static final String BORROW_ACCOUNT_WITHDRAW = xs_method_prefix+"borrow.account.withdraw";
	// 2.0 根据busorderid查询提现信息   查询提现动作结果
	public static final String WITHDRAW_DEAL_SEARCH = xs_method_prefix+"withdraw.deal.search";
	
	// 2.0 根据提现流水号查询提现信息   查询提现结果
	public static final String ACCOUNT_WITHDRAW_SEARCH = xs_method_prefix+"account.withdraw.search";
	
	//查询对账文件
	public static final String BALANCE_ATTACH_SEARCH = xs_method_prefix+"balance.attach.search";
	
	// 还款通知1.0|2.0
	public static final String REPAYMENT_NOTICE = xs_method_prefix+"repayment.notice";
	
	//企业还款明细通知2.0
	public static final String  REPAYMENT_DETAIL_NOTICE = xs_method_prefix+"repayment.detail.notice";
	
	//企业借款 垫资 申请2.0
	public static final String DZ_APPLY = xs_method_prefix+"repayment.advance.notice";
	
	//企业借款 垫资 结果通知2.0
	public static final String DZ_APPLY_RESULT_NOTICE = xs_method_prefix+"repayment.advance.result.notice";
	
	//查询电子签章
	public static final String E_SIGNATURE_SEARCH = xs_method_prefix+"loan.signature.search";
	
	//1.0特殊接口>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// 借款人更换银行卡1.0
	public static final String BORROW_BANK_BIND = xs_method_prefix+"borrow.bank.bind";
	// 发送短信验证码1.0
	public static final String SEND_MESSAGE = xs_method_prefix+"send.message";
	// 开户1.0
	public static final String ENTERPRISE_ACCOUNT_CREATE = xs_method_prefix+"enterprise.account.create";
	// 校验是发是理财人1.0
	public static final String BORROW_USER_CHECK = xs_method_prefix+"borrow.user.check";
	// 校验是否开过户1.0
	public static final String BORROW_USER_ACCOUNT_CHECK = xs_method_prefix+"borrow.user.account.check";

	// 放款结果通知1.0
	public static final String LOAN_LOAN_RESULT_V1 = xs_method_prefix + "loan.loan.result";
	// 放款结果查询1.0
	public static final String LOAN_LOAN_SEARCH_V1 = xs_method_prefix + "loan.loan.search";
	// 提现结果通知1.0
	public static final String BORROW_ACCOUNT_WITHDRAWALS_NOTICE_V1 = xs_method_prefix + "borrow.account.withdrawals.notice";
	// 提现结果查询1.0
	public static final String BORROW_ACCOUNT_WITHDRAWALS_SEARCH_V1 = xs_method_prefix + "borrow.account.withdrawals.search";
	//还款通知1.0
	public static final String REPAYMENT_NOTICE_V1 = xs_method_prefix + "repayment.notice";

	// 资产对接类结束---------------------------------------------------------------------------------------------
}
