package com.haohao.service.xs;

import java.util.Map;

import com.haohao.util.springTools.springJdbc.helper.AnnotationHelper.AnnotationJump;
import com.haohao.util.tools.XSMethodActionTool;

public interface AssetsDockingService {

	// H5 同异步 交互类-------------------------------------------------------
	@AnnotationJump(value = XSMethodActionTool.acctCreate)
	void openAccount(Map<String, Object> params);

	@AnnotationJump(value = XSMethodActionTool.acctCreate + "H5")
	Map<String, Object> openAccountH5(Map<String, Object> params);

	@AnnotationJump(value = XSMethodActionTool.bankcardBind)
	void bankCardBind(Map<String, Object> params);

	@AnnotationJump(value = XSMethodActionTool.bankcardBind + "H5")
	Map<String, Object> bankCardBindH5(Map<String, Object> params);

	@AnnotationJump(value = XSMethodActionTool.bankcardChange)
	void bankcardChange(Map<String, Object> params);

	@AnnotationJump(value = XSMethodActionTool.bankcardChange + "H5")
	Map<String, Object> bankcardChangeH5(Map<String, Object> params);

	@AnnotationJump(value = XSMethodActionTool.modifyPhoneNum)
	Map<String, Object> modifyPhoneNum(Map<String, Object> params);

	@AnnotationJump(value = XSMethodActionTool.modifyPhoneNum + "H5")
	Map<String, Object> modifyPhoneNumH5(Map<String, Object> params);

	@AnnotationJump(value = XSMethodActionTool.resetDealpwd + "H5")
	Map<String, Object> resetDealpwdH5(Map<String, Object> params);

	@AnnotationJump(value = XSMethodActionTool.updateDealpwd + "H5")
	Map<String, Object> updateDealpwdH5(Map<String, Object> params);

	@AnnotationJump(value = XSMethodActionTool.setAuthor)
	Map<String, Object> borrowSetAuthor(Map<String, Object> params);

	@AnnotationJump(value = XSMethodActionTool.setAuthor + "H5")
	Map<String, Object> borrowSetAuthorH5(Map<String, Object> params);

	@AnnotationJump(value = XSMethodActionTool.accountWithdraw)
	Map<String, Object> borrowAccountWithdraw(Map<String, Object> params);

	@AnnotationJump(value = XSMethodActionTool.accountWithdraw + "H5")
	Map<String, Object> borrowAccountWithdrawH5(Map<String, Object> params);

	// 资产对接 直连 交互类  xs->pc  -------------------------------------------------------------------
	@AnnotationJump(value = XSMethodActionTool.LOAN_ATTACH_SEARCH)
	Map<String, Object> queryAttachmentInfo(Map<String, Object> params);

	@AnnotationJump(value = XSMethodActionTool.LOAN_RESULT_NOTICE)
	Map<String, Object> deployResultNotice(Map<String, Object> params);

	@AnnotationJump(value = XSMethodActionTool.LOAN_AUDIT_RESULT)
	Map<String, Object> loanAuditNotice(Map<String, Object> params);

	@AnnotationJump(value = XSMethodActionTool.LOAN_LOAN_RESULT)
	Map<String, Object> loanLoanResultNotice(Map<String, Object> params);
	
	@AnnotationJump(value = XSMethodActionTool.DZ_APPLY_RESULT_NOTICE)
	Map<String, Object> dzApplyResultNotice(Map<String, Object> params);

	// 定时任务类----------------------------------------------------
	void autoDeployOrder();

	void searchDeployResult();

	void searchLoanAuditResult();

	void searchLoanResult();
	
	void searchElectronicSignature();

	void searchTiXianResult();

	void automaticRepaymentNotice();

	// web 请求交互类 --------------------------------------------------------------------

	Boolean hasOpenAcount(Map<String, Object> params) throws Exception;

	Map<String, Object> cardSet(Map<String, Object> params) throws Exception;

	Map<String, Object> cardChange(Map<String, Object> params) throws Exception;

	Map<String, Object> upPwd(Map<String, Object> params) throws Exception;

	Map<String, Object> resetPwd(Map<String, Object> params) throws Exception;

	Map<String, Object> upCardMobile(Map<String, Object> params) throws Exception;

	Map<String, Object> doAuth(Map<String, Object> params) throws Exception;

	Map<String, Object> saveContract(Map<String, Object> params) throws Exception;

	boolean searchElectronicSignatureByOrderId(int order_id);
	
	Map<String, Object> moneyTixian(Map<String, Object> params) throws Exception;

	/**result：0不存在提现操作记录，1提现动作成功，2提现动作失败**/
	int searchTiXianActionResult(int order_id) throws Exception;
	
	Map<String, Object> getAccountInfo(Map<String, Object> params) throws Exception;

	Boolean manualRepaymentNotice(Map<String, Object> params) throws Exception;

	boolean dzApply(Map<String, Object> params) throws Exception;
	
	Map<String, Object> checkDayBill(Map<String, Object> params);

	Boolean hasSetPwd(int company_id);

	Map<String, Object> getAssureAccountInfo(String bankUserId);

	Boolean isAbleToDeployOrder(int company_id);

	


	
	
}
