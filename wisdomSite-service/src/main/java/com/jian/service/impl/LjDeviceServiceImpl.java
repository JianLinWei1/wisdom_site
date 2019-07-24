package com.jian.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jian.dao.LjDeviceMapper;
import com.jian.entity.LjDevice;
import com.jian.entity.LjDeviceExample;
import com.jian.entity.LjDeviceExample.Criteria;
import com.jian.entity.SysAdmin;
import com.jian.service.LjDeviceService;
import com.jian.util.ResultUtil;
import com.jian.util.ShiroUtil;

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

	@Override
	public ResultUtil listDevices(int page, int limit) {
		SysAdmin sa = ShiroUtil.getSysAdmin();
		PageHelper.startPage(page, limit);
		LjDeviceExample example = new LjDeviceExample();
		Criteria criteria = example.createCriteria();
		criteria.andBelongIdEqualTo(sa.getBelongId());
		List<LjDevice>  devices = ljdeviceMapper.selectByExample(example);
		PageInfo<LjDevice> info = new PageInfo<>(devices);
		ResultUtil util = new ResultUtil();
		util.setCode(0);
		util.setCount((int)info.getTotal());
		util.setData(devices);
		return util;
	}

	@Override
	public ResultUtil listDevicesByDeviceSeril(String seril, int apge, int limit) {
		SysAdmin sa = ShiroUtil.getSysAdmin();
		PageHelper.startPage(apge, limit);
		LjDeviceExample example = new LjDeviceExample();
		Criteria criteria = example.createCriteria();
		criteria.andBelongIdEqualTo(sa.getBelongId());
		criteria.andDeviceSerilLike("%" + seril +"%");
		List<LjDevice>  devices = ljdeviceMapper.selectByExample(example);
		PageInfo<LjDevice>  info = new PageInfo<>(devices);
		ResultUtil util = new ResultUtil();
		util.setCode(0);
		util.setCount((int)info.getTotal());
		util.setData(devices);
		return util;
	}

	@Override
	public ResultUtil listDevicesByDeviceName(String name, int page, int limit) {
		SysAdmin sa = ShiroUtil.getSysAdmin();
		PageHelper.startPage(page, limit);
		LjDeviceExample example = new LjDeviceExample();
		Criteria criteria = example.createCriteria();
		criteria.andBelongIdEqualTo(sa.getBelongId());
		criteria.andDeviceSerilLike("%" + name+"%");
		List<LjDevice>  devices = ljdeviceMapper.selectByExample(example);
		PageInfo<LjDevice>  info = new PageInfo<>(devices);
		ResultUtil util = new ResultUtil();
		util.setCode(0);
		util.setCount((int)info.getTotal());
		util.setData(devices);
		return util;
	}

	@Override
	public List<LjDevice> getDevices() {
		LjDeviceExample example = new LjDeviceExample();
		List<LjDevice>   devices  = ljdeviceMapper.selectByExample(example);
		return devices;
	}

}
