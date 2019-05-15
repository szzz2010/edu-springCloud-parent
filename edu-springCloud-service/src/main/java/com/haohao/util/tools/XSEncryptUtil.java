package com.haohao.util.tools;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class XSEncryptUtil {


	// 编码类型
	private static Charset charset = Charset.forName("UTF-8");
//
//	// MD5加密的key
//	private String md5Key;
//
//	// AES加密的KEY
//	private String aesKey;

	// 方便加密的密文查看
	private static Base64 base64 = new Base64();
	
//	/**
//	 * 构造函数
//	 *
//	 * @param md5Key MD5加密的KEY
//	 * @param aesKey AES加密的KEY
//	 */
//	public XSEncryptUtil(String md5Key, String aesKey) {
//		this.md5Key = md5Key;
//		this.aesKey = aesKey;
//	}
	
	/**
	 * AES加密
	 * 
	 * @param content 加密明文
	 * @return 返回base64编码
	 */
	public static String encrypt(String content,String aesKey) throws Exception {
		Cipher aesECB = Cipher.getInstance("AES/ECB/PKCS5Padding");
		SecretKeySpec key = new SecretKeySpec(aesKey.getBytes(charset), "AES");
		aesECB.init(Cipher.ENCRYPT_MODE, key);
		byte[] result = aesECB.doFinal(content.getBytes(charset));
		return base64.encodeToString(result);
	}

	/**
	 * AES解密
	 * 
	 * @param content 需要解密的密文
	 * @return 解密之后的内容
	 */
	public static String decrypt(String content,String aesKey) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// 创建密码器
		SecretKeySpec key = new SecretKeySpec(aesKey.getBytes(charset), "AES");
		cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
		byte[] result = Base64.decodeBase64(content);
		return new String(cipher.doFinal(result), charset); // 解密
	}

	/**
	 * 对传入参数进行加密
	 * 
	 * @param param 为排序参数
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public static String md5(Map<String, String> param,String md5Key) throws NoSuchAlgorithmException {
		if (param == null || param.size() == 0) {
			return null;
		}
		String msg = null;
		
		Set<Map.Entry<String, String>> set = param.entrySet();
		List<Map.Entry<String, String>> list = new ArrayList<>(set);
		
		// 对传入参数排序
		list.sort(Comparator.comparing(Map.Entry::getKey));
		
		// 对传入参数拼接字符串
		StringBuilder sb = new StringBuilder();
		Map.Entry<String, String> entry;
		for (int i=0, j=list.size(); i<j; i++) {
			entry = list.get(i);
			sb.append(entry.getKey()).append(entry.getValue());
		}
		
		// 加入MD5KEY
		sb.append(md5Key);
		
		msg = sb.toString();

		return md5(msg);
	}
	
	/**
	 * md5加密
	 * 
	 * @param inputText
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public static String md5(String inputText) throws NoSuchAlgorithmException {
		return md5Encrypt(inputText, "md5");
	}
	
	/**
	 * md5或者sha-1加密
	 * 
	 * @param inputText 要加密的内容
	 * @param algorithmName 加密算法名称：md5或者sha-1，不区分大小写
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	private static String md5Encrypt(String inputText, String algorithmName) throws NoSuchAlgorithmException {
		if (inputText == null || "".equals(inputText.trim())) {
			throw new IllegalArgumentException("请输入要加密的内容");
		}
		if (algorithmName == null || "".equals(algorithmName.trim())) {
			algorithmName = "md5";
		}
		MessageDigest m = MessageDigest.getInstance(algorithmName);
		m.update(inputText.getBytes(charset));
		byte s[] = m.digest();
		return hex(s);
	}

	/**
	 * 返回十六进制字符串
	 * 
	 * @param arr
	 * @return
	 */
	private static String hex(byte[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; ++i) {
			sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString();
	}

//	public static void main(String[] args) throws Exception {
//		// md5Key=md5KeyTest, aesKey=aesKeyTest123456, app_id=appTest
//		String md5Key = "md5KeyTest";
//		String aesKey = "aesKeyTest123456";
//
//		// app_id
//		String appId = "appTest";
//		// method
//		String method = "open.debtor.upload";
//		// timestamp
//		String timestamp = "2015-04-15 16:56:12";
//		// version
//		String version = "1.0";
//		// content
//		String contentTemp = "{prodId:\"fa123456\",[{name:\"张三\",age:35},{name:\"李四\",age:41}]}";
//		String content;
//
//		XSEncryptUtil crypt = new XSEncryptUtil(md5Key, aesKey);
//		// 给请求正文AES加密
//		content = crypt.encrypt(contentTemp);
//		System.out.println("明文：" + contentTemp);
//		System.out.println("请求加密后: " + content);
//
//		// 将参数放入map
//		Map<String, String> param = new HashMap<String, String>();
//		param.put("appId", appId);
//		param.put("method", method);
//		param.put("timestamp", timestamp);
//		param.put("version", version);
//		param.put("content", content);
//
//		// 所有请求参数生成签名
//		String md5 = crypt.md5(param);
//		System.out.println("签名：" + md5);
//
//		// 对加密信息进行解密
//		String result = crypt.decrypt(content);
//		System.out.println("解密后的信息：" + result);
//	}

}
