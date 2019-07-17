package com.jian.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName:  HeartBeatUtil   
 * @Description:GRPC设备心跳处理  
 * @author: JianLinWei
 * @email: jianlinwei_dream@163.com
 * @date:   2019年2月14日 下午3:34:13   
 *
 */

public class HeartBeatUtil {
	static  Logger logger  = LoggerFactory.getLogger(HeartBeatUtil.class);
	
	static ConcurrentMap<String, Boolean >  concurrentMap  = new ConcurrentHashMap<>();
	
	
	static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
	
	
	
	public static  void  setDeviceSeril(String deviceseril){
		concurrentMap.put(deviceseril, true);
	}
	
	public static  boolean getDeivceState(String deviceseril){
		
		return concurrentMap.containsKey(deviceseril);
	}
	
	
	public  static   void  handleConcurrentMap(){
		fixedThreadPool.execute(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try{
						Thread.sleep(10000);
						concurrentMap.clear();
					}catch(Exception e){
						logger.error(e.getMessage());
					}
				}
			}
		});
	}
	
	
	
}
