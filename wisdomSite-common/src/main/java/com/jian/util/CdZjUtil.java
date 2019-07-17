package com.jian.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import java.util.ArrayList;

import java.util.List;



import org.apache.http.Consts;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.jian.entity.LjWorkerInfo;


public class CdZjUtil {
      private Logger logger = LoggerFactory.getLogger(CdZjUtil.class);
      private static CdZjUtil cdZjUtil;
      private CdZjUtil(){
    	  
      }
      public static synchronized CdZjUtil getInstance(){
    	  if(cdZjUtil == null)
    		  return new CdZjUtil();
    	  return cdZjUtil;
      }
      
      String REGISTURI = "http://118.122.92.139:6961/Regist.Asfx";
      String TEST_DEVMAC_1 ="aaa-001"; //采集设备测试
      String TEST_DEVMAC_2 ="";//进场设备
      
      
      RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(60 * 1000)
  			.setConnectionRequestTimeout(60 * 1000).setSocketTimeout(60 * 1000).setRedirectsEnabled(true).build();

      
      public boolean Regist(LjWorkerInfo info) throws UnsupportedEncodingException{
    	  CloseableHttpClient client = HttpClients.createDefault();
    	  HttpPost post = new HttpPost(REGISTURI);
    	  post.setConfig(requestConfig);
    	  post.setHeader("Content-Type", ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
    	 
    	  List<BasicNameValuePair>  parameters = new ArrayList<>();
    	  
    	 String  idPhoto = URLEncoder.encode((FileUtil.getInstance().Base642NoHead(info.getIdPhoto())) ,"UTF-8" ); 
    	 String  photo  = URLEncoder.encode((FileUtil.getInstance().Base642NoHead(info.getVisiblePhoto())) ,"UTF-8" );
    	
    	  parameters.add(new BasicNameValuePair("Idno", info.getIdCard()));
    	  parameters.add(new BasicNameValuePair("Name", info.getName().replace("[\\s*\t\n\r]", "")));
    	  parameters.add(new BasicNameValuePair("gender", String.valueOf(info.getGender())));
    	  parameters.add(new BasicNameValuePair("nation", info.getNation()));
    	  parameters.add(new BasicNameValuePair("birthday", formatBirth(info.getBirthday())));
    	  parameters.add(new BasicNameValuePair("address", info.getAddress()));
    	  parameters.add(new BasicNameValuePair("idissue", info.getIdissue()));
     	  parameters.add(new BasicNameValuePair("idperiod", FileUtil.getInstance().stringFormat(info.getIdBeginDate(), info.getIdEndDate())));
    	  parameters.add(new BasicNameValuePair("idphoto", idPhoto));
    	  parameters.add(new BasicNameValuePair("photo",   photo));
    	  parameters.add(new BasicNameValuePair("userType", String.valueOf(1)));
    	  parameters.add(new BasicNameValuePair("dev_mac", TEST_DEVMAC_1));
    	  parameters.add(new BasicNameValuePair("RegType", String.valueOf(3)));
    	  
    	  
    	  try {
    		  UrlEncodedFormEntity entity =new UrlEncodedFormEntity(parameters, Consts.UTF_8);
    		  post.setEntity( new StringEntity(EntityUtils.toString(entity).replaceAll("[\\s*\t\n\r]", "")));
    		 
			CloseableHttpResponse response = client.execute(post);
			String str = EntityUtils.toString(response.getEntity());
			logger.info(response.getStatusLine().getStatusCode() + str );
			
			JSONObject json = JSONObject.parseObject(str);
			response.close();
			if(json.getIntValue("errcode") == 0)
				return true;
			
		} catch (ClientProtocolException e) {
			logger.error(e.getLocalizedMessage(), e);
			
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return false;
    	  
      }
      
      
     public String   formatBirth(String str){
    	 StringBuffer buffer = new StringBuffer(str);
    	 buffer.insert(4, "-");
    	 buffer.insert(7, "-");
    	 return buffer.toString();
     }
     
     
    
   
}
