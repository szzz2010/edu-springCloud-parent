package com.haohao.util.encrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.util.Base64Utils;

public class AES {
	/**
	 * 分组模式：
	 * 	1.EBC模式：简单；有利于并行计算；误差不会被传送；不能隐藏明文；可能对明文进行主动攻击
	 *  2.CBC模式：不容易主动攻击,安全性好于ECB,适合传输长度长的报文,是SSL、IPSec的标准。不利于并行计算；误差传递；需要初始化向量IV
	 *  3.CFB模式：隐藏了明文；分组密码转化为流模式；可以及时加密传送小于分组的数据；不利于并行计算；误差传送：一个明文单元损坏影响多个单元；唯一的IV
	 *  4.OFB模式，OFB模式又称输出反馈模式：隐藏了明文；分组密码转化为流模式；可以及时加密传送小于分组的数据；不利于并行计算；对明文的主动攻击是可能的；误差传送：一个明文单元损坏影响多个单元。
	 *  5.CTR模式：CTR 模式被广泛用于 ATM 网络安全和 IPSec应用中，能有效利于硬件性能，简单，不要求实现解密，无填充，可以高效地作为流式加密使用
	 * 填充模式：NoPadding（不填充），ZerosPadding（零填充）， PKCS5Padding（总字节数填充）
	 * 初始化向量：
	 */
	private static final String algorithm = "AES";
    private static final String transform = "AES/CBC/PKCS5Padding";
    private static final byte[] iv = "99EFED63A78E3B75".getBytes();
    private static final String passKey = "AF87BF3D3754B16305A71EFEDE3803D5";

	public static byte[] encrypt(byte[] input, String key) throws Exception {
		key = key == null ? passKey : key;
		// 判断Key是否为16位
		if (key.length() % 16 != 0) {
			throw new RuntimeException("加密密钥必须为16的倍数！");
		}
		Cipher cipher = Cipher.getInstance(transform);
		SecretKey secretKey = new SecretKeySpec(key.getBytes("UTF-8"), algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
		return Base64Utils.encode(cipher.doFinal(input));
	}

	public static byte[] decrypt(byte[] src, String key) throws Exception {
		key = key == null ? passKey : key;
		byte[] input = Base64Utils.decode(src);
		SecretKey securekey = new SecretKeySpec(key.getBytes("UTF-8"), algorithm);
		Cipher cipher = Cipher.getInstance(transform);
		cipher.init(Cipher.DECRYPT_MODE, securekey, new IvParameterSpec(iv));
		return cipher.doFinal(input);
	}
}
