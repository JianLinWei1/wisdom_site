package com.jian.service;

import com.jian.entity.SysAdmin;
/**
 * 系统用户
 * @ClassName:  SysAdminService   
 * @Description:TODO   
 * @author: JianLinWei
 * @email: jianlinwei_dream@163.com
 * @date:   2019年1月10日 下午3:45:35   
 *
 */
import com.jian.util.ResultUtil;
public interface SysAdminService {

	/**
	 * 获取用户根据用户名
	 */
	SysAdmin   getSysAdminByUsername(String username);
	
	/**
	 * 前端登录
	 */
	ResultUtil  login(SysAdmin admin);
	
	/**
	 *获取用户信息
	 */
	ResultUtil  getUserInfo();
	
	/**
	 *获取角色权限
	 */
	ResultUtil getRoleList(int page , int limit);
	
	/**
	 *获取管理员列表
	 */
	ResultUtil getAdminList(int page ,int limit);
	
	/**
	 *编辑管理员
	 */
	ResultUtil editAdmin(SysAdmin sa);
	/**
	 * 人脸登录
	 */
	ResultUtil faceLogin(String str);
	
	/**
	 * 设备登录
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月15日下午3:51:29
	 * @param admin
	 * @return
	 */
	boolean deviceLogin(SysAdmin admin);
}
