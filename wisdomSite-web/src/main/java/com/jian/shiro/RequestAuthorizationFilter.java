package com.jian.shiro;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import com.jian.dao.SysMerchantMapper;
import com.jian.entity.SysMerchant;
import com.jian.util.ErrorEnum;
import com.jian.util.ResultUtil;
/**
 * 对请求进行拦截 并返回json
 * @ClassName:  RequestAuthorizationFilter   
 * @Description:TODO   
 * @author: JianLinWei
 * @email: jianlinwei_dream@163.com
 * @date:   2019年1月7日 上午11:15:14   
 *
 */
@SuppressWarnings("static-access")
@Component
public class RequestAuthorizationFilter  extends FormAuthenticationFilter {
	private  Logger  logger =  LoggerFactory.getLogger(RequestAuthorizationFilter.class);
	
	private static SysMerchantMapper  sysMerchantMapper;
	
	
	
	@Autowired
	public void  init(SysMerchantMapper  sysMerchantMapper){
		this.sysMerchantMapper = sysMerchantMapper;
	}
	
	
	@Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		if(ApiFilter(request, response))
			return true;
		PrintWriter out = null;
        HttpServletResponse res = (HttpServletResponse) response;
        try {
            res.setCharacterEncoding("UTF-8");
            res.setContentType("application/json");
            out = response.getWriter();
            out.println(JSON.toJSONString(new ResultUtil(50014, "登录过期,拒绝访问")));
        } catch (Exception e) {
        } finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }
		
		return  false;
	}
	
	
	/**
	 * 自定义
	 * @Title: ApiFilter   
	 * @Description: TODO   
	 * @param: @param request
	 * @param: @param response
	 * @param: @return 
	 * @author: JianLinWei     
	 * @return: boolean      
	 * @throws
	 */
	public   boolean   ApiFilter(ServletRequest request, ServletResponse response){
		ResultUtil  resultUtil = new ResultUtil();
		HttpServletRequest  request2  = (HttpServletRequest) request;
		String appid =  request2.getHeader("appid");
		String sign  =  request2.getHeader("sign");
		if(StringUtils.isEmpty(appid) || StringUtils.isEmpty(sign))
			return false;
        SysMerchant  merchant  = sysMerchantMapper.selectByPrimaryKey(appid);
        if(merchant != null){
        	String sign_md5 = new Md5Hash(appid, "jlw").toString();
        	if(StringUtils.equals(sign, sign_md5)){
        		logger.error(appid+"通过ApiFilter");
        		return true;
        	}else{
        		resultUtil.setCode(ErrorEnum.E_500.getErrorCode());
        		resultUtil.setMsg("签名错误");
        	}
        }else{
        	resultUtil.setCode(ErrorEnum.E_500.getErrorCode());
        	resultUtil.setMsg("appid错误");
        }
        PrintWriter out = null;
        HttpServletResponse res = (HttpServletResponse) response;
        try {
        	
            res.setCharacterEncoding("UTF-8");
            res.setContentType("application/json");
            out = response.getWriter();
            out.println(JSON.toJSONString(resultUtil));
        } catch (Exception e) {
        } finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }
		return false;
	}

}
