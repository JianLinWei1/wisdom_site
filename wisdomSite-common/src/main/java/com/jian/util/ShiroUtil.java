package com.jian.util;

import org.apache.shiro.SecurityUtils;


import com.jian.entity.SysAdmin;

public class ShiroUtil {

	
	
	public static SysAdmin  getSysAdmin(){
		return (SysAdmin) SecurityUtils.getSubject().getPrincipal();
	}
	
	
	public static String getToken(){
		return SecurityUtils.getSubject().getSession().getId().toString();
	}
}
