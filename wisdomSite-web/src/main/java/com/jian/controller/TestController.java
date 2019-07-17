package com.jian.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.jian.util.ResultUtil;

@RestController
public class TestController {
  private   Logger logger  = LoggerFactory.getLogger(TestController.class);
	
	
	@RequestMapping(value="/login" ,method =RequestMethod.GET  )
	public  ResultUtil test(String  username  , String password){
		System.out.println("hhh");
		logger.error("测试");
		try{
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken  token = new UsernamePasswordToken(username ,password);
			subject.login(token);
			}catch (UnknownAccountException e) {
				return ResultUtil.error("账户不存在");
			}catch (IncorrectCredentialsException e) {
				System.out.println(e.getMessage());
				return ResultUtil.error("密码错误");
			}catch (LockedAccountException e) {
				return ResultUtil.error("账号被锁定");
			}catch (AuthenticationException e) {
				return ResultUtil.error("账户验证失败");
			}
		return new ResultUtil(0, "登录成功");
	}
}
