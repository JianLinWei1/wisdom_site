package com.jian.service;

import com.ha.facecamera.configserver.pojo.CaptureCompareData;
import com.jian.entity.LjCardInfo;
import com.jian.entity.LjStrangerCapture;
import com.jian.entity.LjWorkType;
import com.jian.entity.LjWorkerCapture;
import com.jian.entity.LjWorkerInfo;
import com.jian.util.ResultUtil;
/**
 * 工地工人
 * @author JianLinWei
 * @date: 2019年7月11日下午4:27:01
 */
public interface WorkerService {
    
	  /**
	   * 增加工种
	   * @Description:
	   * @auther:JianLinwei
	   * @date:2019年7月11日下午4:27:17
	   * @param workType
	   * @return
	   */
	 ResultUtil  insertWorkType(LjWorkType workType);
	 
	 /**
	  * 获取类型列表
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月11日下午5:34:33
	  * @return
	  */
	 ResultUtil  listWorkType(int page , int limit);
	 /**
	  * 获取全部工种类型
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月12日下午5:41:46
	  * @return
	  */
	 ResultUtil listWorkTypeAll();
	 
	 /**
	  * 更新工种类型
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月11日下午5:41:01
	  * @param workType
	  * @return
	  */
	 ResultUtil updateWorkType(LjWorkType workType);
	 /**
	  * 删除工种类型
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月11日下午5:43:09
	  * @param id
	  * @return
	  */
	 ResultUtil delWorkType(String id);
	 /**
	  * 添加工人信息
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月11日下午5:55:40
	  * @param info
	  * @param info2
	  * @return
	  */
	 ResultUtil insertWorkerInfo(LjWorkerInfo info ,LjCardInfo info2);
	 /**
	  * ocr身份证识别
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月15日下午2:51:28
	  * @param fontImg
	  * @param backImg
	  * @return
	  */
	 ResultUtil uploadIdCardImg(String fontImg , String backImg);
	 /**
	  * 添加工人信息到设备
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月16日上午11:28:18
	  * @param info
	  * @return
	  */
	 ResultUtil  addWokerInfoToCamrea(LjWorkerInfo info);
	 
	 /**
	  * 获取员工信息 分页
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月17日下午1:15:21
	  * @param page
	  * @param limit
	  * @return
	  */
	 ResultUtil  listWorkerInfo(int page , int limit);
	 /**
	  * 根据身份证号查询人员 模糊
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月17日下午4:58:15
	  * @param idcard
	  * @param page
	  * @param limit
	  * @return
	  */
	 ResultUtil  listWokerInfoByIdcard(String idcard , int page , int limit);
	 /**
	  * 根据姓名查询人员 模糊
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月17日下午4:58:49
	  * @param idcard
	  * @param page
	  * @param limit
	  * @return
	  */
	 ResultUtil  listWokerInfoByName(String name , int page , int limit);
	 
	 /**
	  * 删除人员信息 伪
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月17日下午5:35:49
	  * @param idCard
	  * @return
	  */
	 ResultUtil  delWokerInfoByIdCard(String idCard);
	 
	 /**
	  * 插入工人抓拍记录
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月18日上午10:24:12
	  * @param capture
	  * @return
	  */
	 ResultUtil  insertCaptureInfo(CaptureCompareData  data ,String belongId);
	 /**
	  * 插入陌生人抓拍记录
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月18日上午10:30:23
	  * @param capture
	  * @return
	  */
	 ResultUtil insertStrangerInfo(CaptureCompareData  data,String belongId);
	 
	 /**
	  * 获取抓拍记录
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月18日下午12:03:52
	  * @param page
	  * @param limit
	  * @return
	  */
	 ResultUtil listCaptureInfos(int page , int limit);
	 
	 /**
	  * BY 身份证重载抓拍记录
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月18日下午2:40:36
	  * @param idCard
	  * @param page
	  * @param limit
	  * @return
	  */
	 ResultUtil listCaptureInfosReloadByIdcard(String idCard , int page ,int limit);
	 
	 /**
	  * BY 姓名重载抓拍记录
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月18日下午2:40:36
	  * @param idCard
	  * @param page
	  * @param limit
	  * @return
	  */
	 ResultUtil listCaptureInfosReloadByName(String name , int page ,int limit);
	 
	 /**
	  * 删除抓拍记录
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月18日下午3:27:39
	  * @param uuid
	  * @return
	  */
	 ResultUtil delCaptureInfoByUUID(String uuid);
	 
	 /**
	  * 陌生人抓拍记录
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月18日下午3:43:08
	  * @param page
	  * @param limt
	  * @return
	  */
	 ResultUtil listStrangerCaptures(int page , int limt);
	 
	 /**
	  * 删除陌生人抓拍记录
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月18日下午3:53:39
	  * @param uuid
	  * @return
	  */
	 ResultUtil delStrangerCaptureByUUID(String uuid);
	 
	 /**
	  * 成都市平台下发人员
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月22日下午12:15:44
	  * @param info
	  * @return
	  */
	 ResultUtil insertWorkerInfoCd(LjWorkerInfo info , LjCardInfo info2 ,String device);
	 
	 ResultUtil addWorkerInfoToCamCd(LjWorkerInfo info ,String device);
	 
	 /**
	  * 成都市平台删除
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月22日下午4:30:03
	  * @param device
	  * @param uerid
	  * @return
	  */
	 ResultUtil delWorkerInfoCd(String device , String uerid);
	 /**
	  * 通过userId查询
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月22日下午5:15:05
	  * @param userid
	  * @return
	  */
	 LjWorkerInfo  getLjWorkerInfoByUserId(String userid);
	 
	 /**
	  * 用姓名查询身份信息
	  * @Description:
	  * @auther:JianLinwei
	  * @date:2019年7月23日上午10:33:45
	  * @param name
	  * @return
	  */
	 LjCardInfo   getLjCardInfoByName(String  name);
}
