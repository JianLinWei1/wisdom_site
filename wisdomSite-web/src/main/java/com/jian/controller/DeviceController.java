package com.jian.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jian.service.LjDeviceService;
import com.jian.service.facecam.FaceCamreaUtil;
import com.jian.util.ResultUtil;

/**
 * 
 * @author JianLinWei
 * @date: 2019年7月18日下午12:36:58
 */
@RequestMapping("/device")
@RestController()
public class DeviceController {
	@Autowired
	private LjDeviceService deviceSer;
	
	@GetMapping("/getStatus")
	public ResultUtil  getStatus(String deviceseril){
		if(FaceCamreaUtil.getInstance().isOnline(deviceseril)){
			return ResultUtil.ok();
		}
		return ResultUtil.error();
	}
	
	
	@GetMapping("/getDevices")
	public  ResultUtil getDevices(int page , int limit){
		return deviceSer.listDevices(page, limit);
	}
	
	@GetMapping("/getDevicesReload")
	public ResultUtil getDevicesReload(String key , String value ,int page, int limit){
		if(StringUtils.equals(key, "deviceseril"))
			return deviceSer.listDevicesByDeviceSeril(value, page, limit);
		if(StringUtils.equals(key, "devicename"))
			return deviceSer.listDevicesByDeviceName(value, page, limit);
		return ResultUtil.ok();
	}

}
