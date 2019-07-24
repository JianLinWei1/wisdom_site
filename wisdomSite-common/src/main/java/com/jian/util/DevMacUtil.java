package com.jian.util;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author JianLinWei
 * @date: 2019年7月23日下午12:16:45
 */
public class DevMacUtil {

	public  static  String  getSn() {
		try{
	 Process process =	Runtime.getRuntime().exec(new String[] { "C:/Windows/System32/wbem/wmic", "cpu", "get", "ProcessorId" });
	 process.getOutputStream().close();
	 Scanner scanner = new Scanner(process.getInputStream());
	 scanner.next();
	 return scanner.next();
		}catch(Exception e){
			e.printStackTrace();
			return  null;
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(getSn());
	}
}
