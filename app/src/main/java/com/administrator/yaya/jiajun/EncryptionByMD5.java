package com.administrator.yaya.jiajun;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionByMD5 {
	//(1)
	public static String getMD5(byte[] source) {
		String s = null;
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };// 用来将字节转换成16进制表示的字符
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(source);
			byte tmp[] = md.digest();// MD5 的计算结果是一个 128 位的长整数，
			// 用字节表示就是 16 个字节
			char str[] = new char[16 * 2];// 每个字节用 16 进制表示的话，使用两个字符， 所以表示成 16
			// 进制需要 32 个字符
			int k = 0;// 表示转换结果中对应的字符位置
			for (int i = 0; i < 16; i++) {// 从第一个字节开始，对 MD5 的每一个字节// 转换成 16
				// 进制字符的转换
				byte byte0 = tmp[i];// 取第 i 个字节
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];// 取字节中高 4 位的数字转换,// >>>
				// 为逻辑右移，将符号位一起右移
				str[k++] = hexDigits[byte0 & 0xf];// 取字节中低 4 位的数字转换

			}
			s = new String(str);// 换后的结果转换为字符串

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	public static void main(String[] args) {

		String test = EncryptionByMD5.getMD5("beijing".getBytes());
		System.out.println(test);

	}

	//md5 加密算法(2)
	public static String md5(String text) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("md5");
			// 数组 byte[] result -> digest.digest( );  文本 text.getBytes();
			byte[] result = digest.digest(text.getBytes());
			//创建StringBuilder对象 然后建议StringBuffer，安全性高
			//StringBuilder sb = new StringBuilder();
			StringBuffer sb = new StringBuffer();
			// result数组，digest.digest ( ); -> text.getBytes();
			// for 循环数组byte[] result;
			for (byte b : result){
				// 0xff 为16进制
				int number = b & 0xff;
				// number值 转换 字符串 Integer.toHexString( );
				String hex = Integer.toHexString(number);
				if (hex.length() == 1){
					sb.append("0"+hex);
				}else {
					sb.append(hex);
				}
			}
			//sb StringBuffer sb = new StringBuffer();对象实例化
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			//发送异常return空字符串
			return "";
		}
	}
}
