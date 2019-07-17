package com.jian.util;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;


/**
 * 
 * @ClassName:  HttpRequestUtil   
 * @Description:TODO   
 * @author: JianLinWei
 * @date:   2018年11月21日 下午6:35:19   
 *
 */
public class HttpRequestUtil {
          public static  String get(String url){
        	  String str ="";
        	  CloseableHttpClient httpClient = HttpClients.createDefault();
      		HttpGet  hp = new HttpGet(url);
      		
      		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(59 * 1000)
      				.setConnectionRequestTimeout(59 * 1000).setSocketTimeout(59 * 1000).setRedirectsEnabled(true)
      				.build();
      		
      		hp.setConfig(requestConfig);
      		hp.setHeader("Content-Type", "application/json");
      		
              
      		
              try {
            	  
      			CloseableHttpResponse  response = httpClient.execute(hp);
      			StatusLine statusline = response.getStatusLine();
      			int responsecode = statusline.getStatusCode();
      			if(responsecode == 200){
      				HttpEntity he = response.getEntity();
      				 str = EntityUtils.toString(he, "UTF-8");
      				
      			}else{
      				return  str ;
      			}
      			
      			response.close();
      			httpClient.close();
      			return str ;
      		} catch (ClientProtocolException e) {
      			return e.getMessage();
      		} catch (IOException e) {
      			
      			return e.getMessage();
      		}
        	  
        	  
          }
          
          
          public static String  post(String  url , String strPost){
        	  String str ="";
        	  CloseableHttpClient httpClient = HttpClients.createDefault();
      		HttpPost  hp = new HttpPost(url);
      		
      		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(590 * 1000)
      				.setConnectionRequestTimeout(590 * 1000).setSocketTimeout(590 * 1000).setRedirectsEnabled(true)
      				.build();
      		
      		hp.setConfig(requestConfig);
      		hp.setHeader("Content-Type", "application/json");
              
      	  hp.setEntity(new StringEntity(strPost, Charset.forName("UTF-8")));
              try {
      			CloseableHttpResponse  response = httpClient.execute(hp);
      			StatusLine statusline = response.getStatusLine();
      			int responsecode = statusline.getStatusCode();
      			if(responsecode == 200 || responsecode == 201){
      				HttpEntity he = response.getEntity();
      				 str = EntityUtils.toString(he, "UTF-8");
      				
      			}else{
      				return  str ;
      			}
      			
      			response.close();
      			httpClient.close();
      			return str ;
      		} catch (ClientProtocolException e) {
      			return e.getMessage();
      		} catch (IOException e) {
      			
      			return e.getMessage();
      		}
        	  
        	  
          }
          
          public  static String  test(){
        	  String str ="";
        	  CloseableHttpClient httpClient = HttpClients.createDefault();
      		HttpPost  hp = new HttpPost("https://open.njcgs.com/api/get_access_token");
      		
      		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(590 * 1000)
      				.setConnectionRequestTimeout(590 * 1000).setSocketTimeout(590 * 1000).setRedirectsEnabled(true)
      				.build();
      		
      		hp.setConfig(requestConfig);
      		hp.setHeader("Content-Type", "application/json");
      		
      		JSONObject jsonObject  = new JSONObject();
      		jsonObject.put("app_id", "lgjyzj");
      		jsonObject.put("timestamp", System.currentTimeMillis());
      		
              
      	  hp.setEntity(new StringEntity(jsonObject.toString(), Charset.forName("UTF-8")));
              try {
      			CloseableHttpResponse  response = httpClient.execute(hp);
      			StatusLine statusline = response.getStatusLine();
      			int responsecode = statusline.getStatusCode();
      			if(responsecode == 200){
      				HttpEntity he = response.getEntity();
      				 str = EntityUtils.toString(he, "UTF-8");
      				
      			}else{
      				return  str ;
      			}
      			
      			response.close();
      			httpClient.close();
      			return str ;
      		} catch (ClientProtocolException e) {
      			return e.getMessage();
      		} catch (IOException e) {
      			
      			return e.getMessage();
      		}
        	  
          }
}
