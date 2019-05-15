package com.haohao.asset.utils;

import java.util.List;

import com.haohao.util.paramAndDto.Pager;

/**
 * @description: 页面返回数据格式
 * @author：fanzukun
 * @date：2018-03-06 09:41:13
 */
public class R {

	private Integer code;

	private String msg;

	private List data;

	private Integer count;

	private boolean success;

	public static R success(Pager pager) {
		return new R()
				.setCode(0)
				.setMsg("success")
				.setData(pager.getRecords())
				.setCount(pager.getTotalCount());
	}

	public static R success() {
		return new R()
				.setSuccess(true)
				.setMsg("成功");
	}

	public static R error(String msg) {
		return new R()
				.setCode(500)
				.setMsg(msg);
	}

	public Integer getCode() {
		return code;
	}

	public R setCode(Integer code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public R setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Integer getCount() {
		return count;
	}

	public R setCount(Integer count) {
		this.count = count;
		return this;
	}

	public boolean isSuccess() {
		return success;
	}

	public R setSuccess(boolean success) {
		this.success = success;
		return this;
	}

	public List getData() {
		return data;
	}

	public R setData(List data) {
		this.data = data;
		return this;
	}
}
