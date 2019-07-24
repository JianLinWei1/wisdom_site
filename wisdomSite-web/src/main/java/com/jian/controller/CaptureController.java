package com.jian.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 抓拍记录
 * @author JianLinWei
 * @date: 2019年7月18日下午12:10:36
 */
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jian.service.WorkerService;
import com.jian.util.ResultUtil;
@RequestMapping(value ="/capture")
@Controller
public class CaptureController {
	
	@Autowired
	private WorkerService  workerSer;
	
	@RequestMapping(value ="/getWorkerCaptureInfos" , method = RequestMethod.GET)
	@ResponseBody
	public ResultUtil  getWorkerCaptureInfos(int page ,int limit){
		return workerSer.listCaptureInfos(page, limit);
	}
	
	@RequestMapping(value = "/getWorkerCaptureInfosReload" , method = RequestMethod.GET)
	@ResponseBody
	public ResultUtil getWorkerCaptureInfosReload(String key , String value , int page , int limit){
		if(StringUtils.equals(key, "idCard"))
			return workerSer.listCaptureInfosReloadByIdcard(value, page, limit);
		if(StringUtils.equals(key, "name"))
			return workerSer.listCaptureInfosReloadByName(value, page, limit);
		return ResultUtil.ok();
	}

	
	@RequestMapping(value="/delWorkerCaptureInfosByUUID" ,method = RequestMethod.POST)
	@ResponseBody
	public ResultUtil  delWorkerCaptureInfosByUUID(String uuid){
		return workerSer.delCaptureInfoByUUID(uuid);
	}
	
	@RequestMapping(value ="/getStrangerCaptures" , method = RequestMethod.GET)
	@ResponseBody
	public ResultUtil getStrangerCaptures(int page , int limit){
		return workerSer.listStrangerCaptures(page, limit);
	}
	
	@RequestMapping(value="/delStrangerCaptureById" , method = RequestMethod.POST)
	@ResponseBody
	public ResultUtil delStrangerCaptureById(String  uuid){
		return workerSer.delStrangerCaptureByUUID(uuid);
	}
}
