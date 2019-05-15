package com.haohao.pojo.vo;

/**
 * 好好借道返回Vo
 * 
 * @ClassName: TianTianResVo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author rienchou
 * @date 2018年4月30日
 *
 */
public class TianTianResVo extends BaseVo {
	private static final long serialVersionUID = 1L;
	private String code;
	private String msg;
	private Object data;

	public String getCode() {
		return code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "TianTianResVo [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
}
