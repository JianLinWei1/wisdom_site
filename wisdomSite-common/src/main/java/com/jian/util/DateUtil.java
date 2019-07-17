package com.jian.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	static  SimpleDateFormat  yyyyMMddHHmmss =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static SimpleDateFormat  yyyyMMdd  = new SimpleDateFormat("yyyy-MM-dd");
	
	
	public  static  Date String2Date(String date  , String str) throws ParseException{
		SimpleDateFormat  format  =  new SimpleDateFormat(str);
		return format.parse(date);
	}
	
	
	public static String Long2DateStr(Long  date , String str)  {
		SimpleDateFormat  format  =  new SimpleDateFormat(str);
		return format.format(date);
	}

	public static Date Long2Date(Long date , String str) throws ParseException{
		SimpleDateFormat  format  =  new SimpleDateFormat(str);
		return format.parse(format.format(date));
	}
	
	public static String  Date2yMdHms(Date  date){
		
		return yyyyMMddHHmmss.format(date);
	}
	
	public static String String2yyyyMMdd(String str){
		return yyyyMMdd.format(str);
	}
}
