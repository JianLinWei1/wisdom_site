package com.jian.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @ClassName:  MD5Util   
 * @Description:MD5 ���ܹ�����  
 * @author: jianlinwei
 * @date:   2018��2��4�� ����3:27:00   
 *
 */
public class MD5Util {
	private static MD5Util md5Util;
	
	private  MD5Util(){
		
	}
	
	public static synchronized MD5Util getInstance(){
		if(md5Util == null)
			return new MD5Util();
		return md5Util;
	}

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f"};
	
	private final static String[]  saltChar = {"Q", "B", "T", "D",
            "E", "Y","G","H","I","J"};
	
/**
 * @throws UnsupportedEncodingException 
 * 
 * @Title: md5   
 * @Description: ���ܷ���   
 * @param: @param change_befer ����ǰԭ�ַ���
 * @param: @param encoding     ��������
 * @param: @return 
 * @author: jianlinwei     
 * @return: String      
 * @throws
 */
	public  String  md5(String  change_befer  , String  encoding ) throws UnsupportedEncodingException{
		String  result = null ;
		
		//���MD5ժҪ����
		try {
			result = change_befer ;
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			 // ʹ��ָ�����ֽ��������ժҪ��Ϣ
            messageDigest.update(result.getBytes(encoding));
            // messageDigest.digest()���16λ����
            result = byteArrayToHexString(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		
		return result  ;
	}
	  /**
     * ת���ֽ�����Ϊ16�����ַ���
     * 
     * @param bytes
     *            �ֽ�����
     * @return
     */
    public  String byteArrayToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte tem : bytes) {
            stringBuilder.append(byteToHexString(tem));
        }
        return stringBuilder.toString();
    }
    /**
     * ת��byte��16����
     * 
     * @param b
     *            Ҫת����byte
     * @return 16���ƶ�Ӧ���ַ�
     */
    private  String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    
    /**
     * 
     * @Title: getSalt   
     * @Description: TODO   
     * @param: @return 
     * @author: jianlinwei     
     * @return: String      
     * @throws
     */
    public  String getSalt(){
    	String str =null;
    	for(int i = 0 ; i<6 ; i++ ){
    		String s = saltChar[(int) (Math.random()*10)];
    		if(str==null){
    			str = s ;
    		}else{
    		str = str +s ;
    		}
    	}
    	
    	return str;
    }
}
