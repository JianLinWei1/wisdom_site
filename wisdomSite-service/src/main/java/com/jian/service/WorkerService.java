package com.jian.service;

import com.jian.entity.LjCardInfo;
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
	 
	 
	 ResultUtil  insertCaptureInfo(LjWorkerCapture  capture);
}
