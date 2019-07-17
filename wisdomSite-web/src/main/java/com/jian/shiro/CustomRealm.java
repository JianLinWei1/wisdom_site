package com.jian.shiro;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.ByteSource.Util;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jian.dao.SysAdminMapper;
import com.jian.dao.SysMenusMapper;

import com.jian.entity.SysAdmin;
import com.jian.entity.SysMenus;
/**
 * 
 * @ClassName:  CustomRealm   
 * @Description:TODO   
 * @author: JianLinWei
 * @email: jianlinwei_dream@163.com
 * @date:   2019年1月7日 上午11:37:23   
 *
 */
public class CustomRealm extends AuthorizingRealm {
	@Autowired
	private SysAdminMapper  sysAdminMapper;
	@Autowired
	private SysMenusMapper  sysMenusMapper;
   
	/**
	 * 权限认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SysAdmin   admin  = (SysAdmin) principals.getPrimaryPrincipal();
		List<SysMenus>  menus  = sysMenusMapper.selectMenusByRoleId(admin.getRoleId());
		List<String>  list = new ArrayList<>();
		for(SysMenus  sm :  menus){
			list.add(sm.getPermission());
		}
		
		
		SimpleAuthorizationInfo  info = new SimpleAuthorizationInfo();
		info.setStringPermissions((Set<String>) list);
		
		return info;
	}

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upt = (UsernamePasswordToken) token;
		String userName = (String) upt.getPrincipal();
		String Pwd = new String((char[])upt.getCredentials());
		String host = upt.getHost();
		SysAdmin  admin = sysAdminMapper.selectByPrimaryKey(userName);
		if(admin == null)
			throw new UnknownAccountException("账号不存在");
		String pwd_md5 = "";
		if(!StringUtils.equals(host, "face")){
		 pwd_md5  = new Md5Hash(Pwd, admin.getSalt()).toHex();
		}else {
			pwd_md5 = Pwd;
		}
		if(!StringUtils.equals(pwd_md5, admin.getPassword()))
			throw new IncorrectCredentialsException("账号或密码不正确!");
		if(admin.getRoleId() == null)
			throw new UnknownAccountException("账号未分配角色!");
		/*new ByteSource.Util();*/
		ByteSource byteSource = Util.bytes(admin.getSalt());
		SecurityUtils.getSubject().getSession().setTimeout(30*60*1000);
		SimpleAuthenticationInfo  simpleAuthenticationInfo = new SimpleAuthenticationInfo(admin, Pwd, byteSource, this.getName());
		return simpleAuthenticationInfo;
	}

	/*public static void main(String[] args) {
		String s  = ShiroUtil.getSalt();
		System.out.println(s);
		System.out.println(new Md5Hash("admin123", s).toHex());
	}*/
}
