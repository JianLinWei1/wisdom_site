package com.jian.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 工人注册
 * @author JianLinWei
 * @date: 2019年7月11日下午4:22:53
 */
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jian.entity.LjCardInfo;
import com.jian.entity.LjWorkType;
import com.jian.entity.LjWorkerInfo;
import com.jian.service.WorkerService;
import com.jian.util.FileUtil;
import com.jian.util.ResultUtil;
@Controller
@RequestMapping("/worker")
public class WokerRegisterController {
	@Autowired
	private WorkerService   workerSer;
	
	
	@RequestMapping(value="/insertWorkType" , method = RequestMethod.POST)
	@ResponseBody
	public ResultUtil insertWorkType(@RequestBody LjWorkType workType){
		return workerSer.insertWorkType(workType);
	}
	
	@RequestMapping(value="/getWorkTypes" , method = RequestMethod.GET)
	@ResponseBody
	public ResultUtil getWorkTypes(int page , int  limit){
		return workerSer.listWorkType(page, limit);
	}
	
	@RequestMapping(value="/delWorkTypeById" , method = RequestMethod.POST)
	@ResponseBody
	public ResultUtil delWorkTypeById(String id){
		return workerSer.delWorkType(id);
	}
	
	@RequestMapping(value="/updateWorkType" , method = RequestMethod.POST)
	@ResponseBody
	public ResultUtil updateWorkType(@RequestBody LjWorkType workType){
		return workerSer.updateWorkType(workType);
	}
	
	@RequestMapping(value="/getWorkTypeALL" , method = RequestMethod.GET)
	@ResponseBody
	public ResultUtil getWorkTypeALL(){
		return workerSer.listWorkTypeAll();
	}
	
	@RequestMapping(value="/uploadIDcardImg" , method = RequestMethod.POST)
	@ResponseBody
	public ResultUtil uploadIDcardImg(@RequestBody String data){
		JSONObject jsonObject = JSONObject.parseObject(data);
		String frontImg = FileUtil.getInstance().Base642NoHead(jsonObject.getString("frontImg"));
		String backImg = FileUtil.getInstance().Base642NoHead(jsonObject.getString("backImg"));
		return workerSer.uploadIdCardImg(frontImg, backImg);
	}
	
	@RequestMapping(value="/addWorkerInfo" , method = RequestMethod.POST)
	@ResponseBody
	public ResultUtil addWorkerInfo( @RequestBody LjWorkerInfo info2){
		LjCardInfo cardInfo = info2;
		
		return workerSer.insertWorkerInfo(info2, cardInfo);
	}
	
	@RequestMapping(value="/getWokerInfos" , method = RequestMethod.GET)
	@ResponseBody
	public  ResultUtil getWokerInfos(int page ,int limit){
		return workerSer.listWorkerInfo(page, limit);
	}
	
	@RequestMapping(value="/getWokerInfosReload" , method = RequestMethod.GET)
	@ResponseBody
	public ResultUtil getWokerInfosReload(String key , String value  , int page , int limit){
		if(StringUtils.equals("idCard", key))
			return workerSer.listWokerInfoByIdcard(value, page, limit);
		if(StringUtils.equals("name", key))
			return workerSer.listWokerInfoByName(value, page, limit);
		return null;
	}
	
	@RequestMapping(value= "/delWokerInfoByIdcard" , method = RequestMethod.POST)
	@ResponseBody
	public ResultUtil delWokerInfoByIdcard(String idCard){
		return workerSer.delWokerInfoByIdCard(idCard);
	}

}
