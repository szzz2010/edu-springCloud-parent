package com.haohao.pojo.enums;

public enum TianTianSmsTypeEnums {

	// 取值1或者2；1：验证码  2：其他
	VALIDCODE("验证码", 1), OTHER("其他", 2);

	private String name;
	private int index;

	public static boolean contains(String type) {
		for (TianTianSmsTypeEnums typeEnum : TianTianSmsTypeEnums.values()) {
			if (typeEnum.name().equals(type)) {
				return true;
			}
		}
		return false;
	}

	private TianTianSmsTypeEnums(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
