package com.jian.service;

import java.util.List;

import com.jian.entity.LjDevice;
import com.jian.util.ResultUtil;

public interface LjDeviceService {
	 
	/**
	 * 设备序列号 获取设备
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月18日下午4:49:25
	 * @param deviceseril
	 * @return
	 */
	LjDevice getDeviceBySeril(String  deviceseril);
	
	/**
	 * 更新设备信息
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月18日下午4:49:43
	 * @param device
	 * @return
	 */
	ResultUtil updateDevice(LjDevice device);
	/**
	 * 插入新设备
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月18日下午4:50:01
	 * @param device
	 * @return
	 */
	ResultUtil insertDevice(LjDevice device);
	
	/**
	 * 通过自定义设备号获取
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月18日下午4:50:10
	 * @param deviceNo
	 * @return
	 */
	LjDevice getDeviceByNo(String deviceNo);
	
	/**
	 * 设备列表分页
	 * @Description:
	 * @auther:JianLinwei
	 * @date:2019年7月18日下午4:50:23
	 * @param page
	 * @param limit
	 * @return
	 */
	ResultUtil listDevices(int page , int limit);
	
	ResultUtil  listDevicesByDeviceSeril(String seril ,int apge , int limit);

	ResultUtil  listDevicesByDeviceName(String name ,int page , int limit);
	
	List<LjDevice>  getDevices();
}
