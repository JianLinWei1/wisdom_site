package com.jian.util;

import java.util.UUID;

public class UuidUtil {

	
	public  static  synchronized String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
