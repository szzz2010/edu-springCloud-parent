package com.haohao.service.xs;

import java.util.Map;

import com.haohao.util.springTools.springJdbc.helper.AnnotationHelper.AnnotationJump;
import com.haohao.util.tools.XSMethodActionTool;

public interface AssetsDockingService_v1 {

	// web 请求交互类 --------------------------------------------------------------------
	Boolean hasOpenAccount(int company_id, String mobile);

	/**此接口 1.0  不使用***/
	boolean isXsFinancialMan(int company_id, String mobile);

	Map<String, Object> getAccountInfoByCompanyId(int company_id);

	boolean sendPingAnMobileCode(int company_id, String mobile, String cardNum, String bankName);

	boolean openAccount(Map<String, Object> params);

	/**手动触发还款**/
	Boolean manualRepaymentNotice(int order_id) throws Exception;

	Map<String, Object> saveContract(Map<String, Object> params) throws Exception;
	
	// 资产对接 直连 交互类 xs->pc -------------------------------------------------------------------
	@AnnotationJump(value = XSMethodActionTool.LOAN_ATTACH_SEARCH)
	Map<String, Object> queryAttachmentInfo(Map<String, Object> params);

	@AnnotationJump(value = XSMethodActionTool.LOAN_RESULT_NOTICE)
	Map<String, Object> deployResultNotice(Map<String, Object> params);

	@AnnotationJump(value = XSMethodActionTool.LOAN_AUDIT_RESULT)
	Map<String, Object> loanAuditNotice(Map<String, Object> params);

	// 放款结果通知1.0
	@AnnotationJump(value = XSMethodActionTool.LOAN_LOAN_RESULT_V1)
	Map<String, Object> loanLoanResultNotice(Map<String, Object> params);

	// 提现结果通知1.0
	@AnnotationJump(value = XSMethodActionTool.BORROW_ACCOUNT_WITHDRAWALS_NOTICE_V1)
	Map<String, Object> drawResultNoticeFromXS(Map<String, Object> params);

	
	// 定时任务类----------------------------------------------------
	void autoDeployOrder();

	void searchDeployResult();

	void searchLoanAuditResult();

	// 放款结果查询1.0
	void searchLoanResult();

	// 提现结果查询1.0
	void searchTiXianResult();

	//定时还款1.0
	void automaticRepaymentNotice();

	


	

	
	
	
}
