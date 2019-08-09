package com.jian.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 系统管理
 * @ClassName:  SysAdminController   
 * @Description:TODO   
 * @author: JianLinWei
 * @email: jianlinwei_dream@163.com
 * @date:   2019年1月18日 下午4:10:29   
 *
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jian.entity.SysAdmin;
import com.jian.service.SysAdminService;
import com.jian.util.ResultUtil;
@RestController
@RequestMapping("/sys")
public class SysAdminController {
	@Autowired
	SysAdminService  sas;
	
	
	
	@PostMapping("/login")
	public  ResultUtil  login( @RequestBody SysAdmin admin){
		if(StringUtils.isEmpty(admin.getUserName()) || StringUtils.isEmpty(admin.getPassword()))
			return new ResultUtil(-1, "用户名/密码不能为空");
		return  sas.login(admin);
	}
	
	
//	@PostMapping("/getUserInfo")
//	public  ResultUtil  getUserInfo(){
////		/*JSONObject object = new JSONObject();
////		object.put("0", "admin");
////		JSONArray array = new JSONArray();
////		array.add(object);*/
////		String[] s  =  {"admin"};
////		ResultUtil  util = new ResultUtil();
////		util.setCode(0);
////		util.setData(s);
//		return sas.getUserInfo();
//	}
	
	
	
	@PostMapping("/getUserInfo")
	public  ResultUtil  getUserInfo(){
		
		return sas.getUserInfo();
	}

	@GetMapping("/logout")
	public ResultUtil logout(){
		SecurityUtils.getSubject().logout();
		return ResultUtil.ok();
	}
	/**
	 *角色列表 
	 * @Title: getRoleList   
	 * @Description: TODO   
	 * @param: @param page
	 * @param: @param limit
	 * @param: @return 
	 * @author: JianLinWei     
	 * @return: ResultUtil      
	 * @throws
	 */
	@GetMapping("/getRoleList")
	public ResultUtil getRoleList(int page  , int limit){
		return sas.getRoleList(page, limit);
	}
	
	/**
	 * 管理员列表
	 * @Title: getAdminList   
	 * @Description: TODO   
	 * @param: @param page
	 * @param: @param limit
	 * @param: @return 
	 * @author: JianLinWei     
	 * @return: ResultUtil      
	 * @throws
	 */
	@GetMapping("/getAdminList")
	public ResultUtil getAdminList(int page ,int limit){
	     return sas.getAdminList(page, limit);	
	}
	
	
	/**
	 * 编辑管理员
	 * @Title: editAdmin   
	 * @Description: TODO   
	 * @param: @param sa
	 * @param: @return 
	 * @author: JianLinWei     
	 * @return: ResultUtil      
	 * @throws
	 */
	@PostMapping("/editAdmin")
	public ResultUtil editAdmin(@RequestBody SysAdmin sa){
		return sas.editAdmin(sa);
	}
	
	@PostMapping("/faceLogin")
	public ResultUtil  faceLogin(@RequestBody String  str){
		return sas.faceLogin(str);
	}
	
	@PostMapping("/test")
	public ResultUtil  test(){
		return ResultUtil.ok();
	}
}
