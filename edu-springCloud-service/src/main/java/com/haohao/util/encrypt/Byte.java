package com.haohao.util.encrypt;

public class Byte {
	public static boolean Compare(byte[] input1, byte[] input2) {
		if (input1 == null || input2 == null) {
			return false;
		}
		if (input1.length != input2.length) {
			return false;
		}
		for (int i = 0; i < input1.length; i++) {
			if (input1[i] != input2[i]) {
				return false;
			}
		}
		return true;
	}

	public static String byte2hex(byte[] buffer) {
		String str1 = "";
		for (int i = 0; i < buffer.length; i++) {
			String str2 = Integer.toHexString(buffer[i] & 0xFF);
			if (str2.length() == 1){
				str1 = str1 + "0" + str2;
			}else{
				str1 = str1 + str2;
			}
		}
		return str1.toUpperCase();
	}

	public static byte[] hex2byte(byte[] buffer) {
		if (buffer.length % 2 != 0){
			throw new IllegalArgumentException("长度不是偶数");
		}
		byte[] arrayOfByte = new byte[buffer.length / 2];
		for (int i = 0; i < buffer.length; i += 2) {
			String str = new String(buffer, i, 2);
			arrayOfByte[(i / 2)] = (byte) Integer.parseInt(str, 16);
		}
		return arrayOfByte;
	}
}