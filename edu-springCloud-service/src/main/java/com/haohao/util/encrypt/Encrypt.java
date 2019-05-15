package com.haohao.util.encrypt;

import java.nio.charset.Charset;

import org.apache.commons.lang3.StringUtils;

public class Encrypt {
	public static String MD5(String input) {
		return MD5.md5(input, Charset.defaultCharset());
	}

	public static String MD5(String input, String charset) {
		return MD5.md5(input, Charset.forName(charset));
	}
	
	public static String encryptDES(String input, String key) {
		try {
			return Byte.byte2hex(Des.encrypt(input.getBytes("UTF-8"),
					key.getBytes()));
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		return null;
	}

	public static String decryptDES(String input, String key) {
		try {
			return new String(Des.decrypt(Byte.hex2byte(input.getBytes()),
					key.getBytes()), "UTF-8");
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		return null;
	}
	
	public static String encrypt3DES(String input, String key) {
		try {
			return new String(Des.encrypt3Des(input.getBytes("UTF-8"), key.getBytes()));
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		return null;
	}

	public static String decrypt3DES(String input, String key) {
		try {
			return new String(Des.decrypt3Des(input.getBytes("UTF-8"), key.getBytes()));
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		return null;
	}

	public static String encryptAES(String input) throws Exception{
		if(StringUtils.isBlank(input)){
			return null;
		}
		return new String((AES.encrypt(input.getBytes("UTF-8"), null)));
	}
	
	public static String encryptAES(String input, String key) throws Exception{
		if(StringUtils.isBlank(input)){
			return null;
		}
		if(StringUtils.isBlank(key)){
			throw new RuntimeException("密钥不能为空"); 
		}
		return new String((AES.encrypt(input.getBytes("UTF-8"), key)));
	}

	/**
	 * 解密方法
	 * @param input 加密串
	 * @return String 解密串
	 * @throws Exception 异常
	 */
	public static String decryptAES(String input) throws Exception{
		return new String(AES.decrypt(input.getBytes("UTF-8"), null),"UTF-8");
	}
	
	public static String decryptAES(String input, String key) throws Exception{
		if(StringUtils.isBlank(input)){
			throw new RuntimeException("解密字符串与密钥不能为空"); 
		}
		return new String(AES.decrypt(input.getBytes("UTF-8"), key),"UTF-8");
	}
	 
}