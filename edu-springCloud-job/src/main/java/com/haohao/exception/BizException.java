package com.haohao.exception;

/**
 * 业务异常基类，所有业务异常都必须继承于此异常 .
 * 
 * @author Herry
 * @since 1.1
 *
 */
public class BizException extends RuntimeException {

	private static final long serialVersionUID = -5875371379845226068L;

	/** 具体异常码 */
	protected int code;

	/** 异常信息 */
	protected String msg;

	public BizException(int code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}

	public BizException(int code, String msg, Throwable cause) {
		super(msg, cause);
		this.code = code;
		this.msg = msg;
	}

	protected BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	protected BizException(String message, Throwable cause) {
		super(message, cause);
	}

	protected BizException(String message) {
		super(message);
	}

	protected BizException(Throwable cause) {
		super(cause);
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
