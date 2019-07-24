package com.jian.util;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DesUtil {
	
	
	private static DesUtil desUtil;
	
	private DesUtil(){
		
	}
	
	public static synchronized DesUtil  getInstance(){
		if(desUtil == null)
			return new DesUtil();
		return desUtil;
	}
	
	/**
	 * 对给定的字符串以指定的编码方式和密钥进行加密
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月19日上午10:38:27
	 * @param srcStr
	 * @param charset
	 * @param sKey
	 * @return
	 */
   public  String encrypt(String srcStr, Charset charset, String sKey)  throws Exception {
       byte[] src = srcStr.getBytes(charset);
       byte[] buf = encrypt(src, sKey);
       return parseByte2HexStr(buf);
   }

   /**
    * 对给定的密文以指定的编码方式和密钥进行解密
    * @param hexStr 需要解密的密文
    * @param charset 字符集
    * @param sKey 密钥
    * @return 解密后的原文
    * @throws Exception
    */
   public  String decrypt(String hexStr, Charset charset, String sKey) throws Exception   {
       byte[] src = parseHexStr2Byte(hexStr);
       byte[] buf = decrypt(src, sKey);
       return new String(buf, charset);
   }

   public  byte[] encrypt(byte[] data, String sKey) throws Exception  {
 
           byte[] key = sKey.getBytes();
           byte[]  ivp = new byte[8];
           IvParameterSpec iv = new IvParameterSpec(ivp);
           DESKeySpec desKey = new DESKeySpec(key);

           SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
           SecretKey securekey = keyFactory.generateSecret(desKey);

           Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

           cipher.init(Cipher.ENCRYPT_MODE, securekey, iv);

           return cipher.doFinal(data);
      
   }

   /**
    * 解密
    * @param src
    * @param sKey
    * @return
    * @throws Exception
    */
   private  byte[] decrypt(byte[] src, String sKey) throws Exception {
       byte[] key = sKey.getBytes();
       byte[]  ivP = new byte[8];
       // 初始化向量
       IvParameterSpec iv = new IvParameterSpec(ivP);
       // 创建一个DESKeySpec对象
       DESKeySpec desKey = new DESKeySpec(key);
       // 创建一个密匙工厂
       SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
       // 将DESKeySpec对象转换成SecretKey对象
       SecretKey securekey = keyFactory.generateSecret(desKey);
       // Cipher对象实际完成解密操作
       Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
       // 用密匙初始化Cipher对象
       cipher.init(Cipher.DECRYPT_MODE, securekey, iv);
       // 真正开始解密操作
       return cipher.doFinal(src);
   }
   
   
   

   /**
    * 将二进制转换成16进制
    *
    * @param buf
    * @return
    */
   private  String parseByte2HexStr(byte buf[]) {
       StringBuffer sb = new StringBuffer();
       for (int i = 0; i < buf.length; i++) {
           String hex = Integer.toHexString(buf[i] & 0xFF);
           if (hex.length() == 1) {
               hex = '0' + hex;
           }
           sb.append(hex.toUpperCase());
       }
       return sb.toString();
   }

   /**
    * 将16进制转换为二进制
    *
    * @param hexStr
    * @return
    */
   private  byte[] parseHexStr2Byte(String hexStr) {
       if (hexStr.length() < 1) return null;
       byte[] result = new byte[hexStr.length() / 2];
       for (int i = 0; i < hexStr.length() / 2; i++) {
           int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
           int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
           result[i] = (byte) (high * 16 + low);
       }
       return result;
   }
	public static void main(String[] args) throws Exception {
		String  data = "jian";
		String key ="13245678";
		String en  = DesUtil.getInstance().encrypt(data , Charset.forName("utf-8"),key);
		System.out.println("加密："+en);
		String de = DesUtil.getInstance().decrypt(en,Charset.forName("utf-8"),key);
		System.out.println("解密："+de);
	}
}
