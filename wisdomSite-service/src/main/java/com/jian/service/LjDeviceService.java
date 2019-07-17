package com.jian.service;

import com.jian.entity.LjDevice;
import com.jian.util.ResultUtil;

public interface LjDeviceService {
	 
	LjDevice getDeviceBySeril(String  deviceseril);
	
	ResultUtil updateDevice(LjDevice device);
	
	ResultUtil insertDevice(LjDevice device);
	
	LjDevice getDeviceByNo(String deviceNo);

}
