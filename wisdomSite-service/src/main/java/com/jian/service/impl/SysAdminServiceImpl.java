package com.jian.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jian.dao.SysAdminMapper;
import com.jian.dao.SysMenusMapper;
import com.jian.dao.SysRoleMenusMapper;
import com.jian.dao.SysRolesMapper;
import com.jian.entity.SysAdmin;
import com.jian.entity.SysAdminExample;
import com.jian.entity.SysMenus;
import com.jian.entity.SysMenusExample;
import com.jian.entity.SysMenusExample.Criteria;
import com.jian.entity.SysRoles;
import com.jian.entity.SysRolesExample;
import com.jian.service.SysAdminService;
import com.jian.util.FileUtil;
import com.jian.util.HwUtil;
import com.jian.util.MD5Util;
import com.jian.util.ResultUtil;
import com.jian.util.ShiroUtil;
/**
 * 
 * @ClassName:  SysAdminServiceImpl   
 * @Description:TODO   
 * @author: JianLinWei
 * @email: jianlinwei_dream@163.com
 * @date:   2019年1月10日 下午3:47:01   
 *
 */
@Service
public class SysAdminServiceImpl  implements SysAdminService{
	private  Logger  logger = LoggerFactory.getLogger(SysAdminServiceImpl.class);
     @Resource
     SysAdminMapper  sysAdminMapper;
     @Resource
     SysRoleMenusMapper sysRoleMenusMapper;
     @Resource
     SysRolesMapper   sysRolesMapper;
     @Resource
     SysMenusMapper   sysMenusMapper;
     
	@Override
	public SysAdmin getSysAdminByUsername(String username) {
		
		return sysAdminMapper.selectByPrimaryKey(username);
	}


	@Override
	public ResultUtil login(SysAdmin admin) {
		try{
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken  token = new UsernamePasswordToken(admin.getUserName() ,admin.getPassword());
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
			}catch(Exception e){
				return ResultUtil.error(e.getMessage());
			}
		
		return new ResultUtil(0, ShiroUtil.getToken());
	}


	@Override
	public ResultUtil getUserInfo() {
		SysAdmin  admin  = ShiroUtil.getSysAdmin();
	    List<Integer>  integers =	sysRoleMenusMapper.selectMenusByRoleId(admin.getRoleId());
	    SysMenusExample  example  =  new SysMenusExample();
	    Criteria  criteria  = example.createCriteria();
	    criteria.andMenuIdIn(integers);
	    List<SysMenus>  menus  = sysMenusMapper.selectByExample(example);
	    
		return ResultUtil.ok();
	}


	@Override
	public ResultUtil getRoleList(int page , int limit) {
		SysAdmin  admin  =ShiroUtil.getSysAdmin();
		PageHelper.startPage(page, limit);
		SysRolesExample  example = new SysRolesExample();
		example.createCriteria().andBelongIdEqualTo(admin.getBelongId());
		List<SysRoles> roles  = sysRolesMapper.selectByExample(example);
		PageInfo<SysRoles>  pageInfo = new PageInfo<>(roles);
		ResultUtil util = new ResultUtil();
		util.setCode(0);
		util.setCount((int)pageInfo.getTotal());
		util.setData(roles);
		
		return util;
	}


	@Override
	public ResultUtil getAdminList(int page, int limit) {
		SysAdmin admin =  ShiroUtil.getSysAdmin();
	    PageHelper.startPage(page, limit);
	    SysAdminExample example = new SysAdminExample();
	    example.createCriteria().andBelongIdEqualTo(admin.getBelongId());
	    List<SysAdmin>  admins = sysAdminMapper.selectByExample(example);
	    for(SysAdmin sa : admins){
	    	sa.setSalt(null);
	    	sa.setBelongId(null);
	    	sa.setRole(sysRolesMapper.selectByPrimaryKey(sa.getRoleId()).getRoleName());
	    }
	    PageInfo<SysAdmin>  info = new PageInfo<>(admins);
	    ResultUtil util = new  ResultUtil();
	    util.setCode(0);
	    util.setCount((int)info.getTotal());
	    util.setData(admins);
		
		return util;
	}


	@Override
	public ResultUtil editAdmin(SysAdmin sa) {
		try{
		if(StringUtils.isNotEmpty(sa.getPassword())){
			sa.setSalt(MD5Util.getInstance().getSalt());
		    String pwd_md5  = new Md5Hash(sa.getPassword(), sa.getSalt()).toHex();
		    sa.setSalt(pwd_md5);
		}
		String base64Img  = FileUtil.getInstance().Base642NoHead(sa.getFaceImg());
		ResultUtil util = HwUtil.getInstance().HwFaceDetect(base64Img);
		if(util.getCode() != 0)
			return util;
		ResultUtil util2 = HwUtil.getInstance().HwAddFaceToLibrary(base64Img, sa.getUserName());
		if(util2.getCode() != 0)
			return util2;
	    
		byte[] faceImg = FileUtil.getInstance().Base642Byte(sa.getFaceImg());
		sa.setFaceImg(FileUtil.getInstance().addPicture2Midkirs(faceImg, sa.getUserName(), "images/"));
		
		int update = sysAdminMapper.updateByPrimaryKeySelective(sa);
		if(update == 1)
			return ResultUtil.ok();
		
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			return ResultUtil.error();
		}
		return null;
	}


	@Override
	public ResultUtil faceLogin(String str) {
		JSONObject json  = JSONObject.parseObject(str);
		str = json.getString("str");
		str = str.substring(str.indexOf(",")+1);
		ResultUtil util =  HwUtil.getInstance().HwLiveDetect(str);
		if(util.getCode()  !=  0)
			return util;
		ResultUtil util2 = HwUtil.getInstance().HwGetFaceByImg(util.getMsg());
		if(util2.getCode() != 0)
			return util2;
		String  username = util2.getMsg();
		SysAdmin admin = sysAdminMapper.selectByPrimaryKey(username);
		try{
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken  token = new UsernamePasswordToken(username,admin.getPassword(),"face");
			
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
			}catch(Exception e){
				return ResultUtil.error(e.getMessage());
			}
		return new ResultUtil(0, ShiroUtil.getToken());
	}


	@Override
	public boolean deviceLogin(SysAdmin admin) {
		SysAdmin admin2 = getSysAdminByUsername(admin.getUserName());
				if(admin2 != null){
					String pw  =  new Md5Hash(admin.getPassword() , admin2.getSalt()).toHex();
					
					if(StringUtils.equals(pw, admin2.getPassword()))
						return true;
					else
						return false;
				}
				return false;
	}


	

}
