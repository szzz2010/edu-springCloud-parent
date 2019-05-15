package com.haohao.asset.utils;

import java.util.List;

public class Result{

	private Integer code;

	private String msg;

	private Object data;

	private Integer count;

	private boolean success;

	public static Result success(List list) {
		return new Result()
				.setCode(0)
				.setMsg("success")
				.setSuccess(true)
				.setData(list)
				.setCount(list.size());
	}

	public static Result success(Object list) {
		return new Result()
				.setCode(0)
				.setMsg("success")
				.setSuccess(true)
				.setData(list);
	}

	public static Result success() {
		return new Result().setCode(0).setSuccess(true).setMsg("成功");
	}

	public static Result error(String msg) {
		return new Result()
				.setCode(500)
				.setSuccess(false)
				.setMsg(msg);
	}
	public static Result error(Integer code, String msg) {
		return new Result()
				.setCode(code)
				.setSuccess(false)
				.setMsg(msg);
	}

	public Result setData(Object data) {
		this.data = data;
		return this;
	}

	public Result setCode(Integer code) {
		this.code = code;
		return this;
	}

	public Result setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Result setCount(Integer count) {
		this.count = count;
		return this;
	}

	public Result setSuccess(boolean success) {
		this.success = success;
		return this;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public Object getData() {
		return data;
	}

	public Integer getCount() {
		return count;
	}

	public boolean isSuccess() {
		return success;
	}
}
