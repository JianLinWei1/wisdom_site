package com.jian.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jian.dao.LjDeviceMapper;
import com.jian.entity.LjDevice;
import com.jian.entity.LjDeviceExample;
import com.jian.service.LjDeviceService;
import com.jian.util.ResultUtil;

/**
 * 
 * @author JianLinWei
 * @date: 2019年7月15日下午3:59:20
 */
@Service
public class LjDeviceServiceImpl implements  LjDeviceService{
	@Resource
	private LjDeviceMapper ljdeviceMapper;

	@Override
	public LjDevice getDeviceBySeril(String deviceseril) {
		
		return ljdeviceMapper.selectByPrimaryKey(deviceseril);
	}

	@Override
	public ResultUtil updateDevice(LjDevice device) {
		ljdeviceMapper.updateByPrimaryKey(device);
		
		return ResultUtil.ok();
	}

	@Override
	public ResultUtil insertDevice(LjDevice device) {
		ljdeviceMapper.insert(device);
		return ResultUtil.ok();
	}

	@Override
	public LjDevice getDeviceByNo(String deviceNo) {
		LjDeviceExample example = new LjDeviceExample();
		example.createCriteria().andDeviceNoEqualTo(deviceNo);
		List<LjDevice>  devices = ljdeviceMapper.selectByExample(example);
		if(devices.size() > 0){
			return devices.get(0);
		}
		return null;
	}

}
