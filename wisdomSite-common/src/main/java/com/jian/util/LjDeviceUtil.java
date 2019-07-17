package com.jian.util;

public enum LjDeviceUtil {
    /**
     * 未知设备
     */
	lj_0(0 , "未知设备"),
	/**
	 * 大门闸机
	 */
	lj_1(1,"大门闸机"),
	/**
	 * 考勤机
	 */
	lj_2(2,"考勤机"),
	/**
	 * 访客机
	 */
	lj_3(3,"访客机"),
	/**
	 * 人证机
	 */
	lj_4(4 ,"人证机"),
	/**
	 * 单元门
	 */
	lj_5(5,"单元门"),
	/**
	 * 人脸摄像机
	 */
	lj_6(6,"人脸摄像机");
	
	private LjDeviceUtil(int deviceTypeNum , String deviceTypeStr) {
		this.deviceTypeNum = deviceTypeNum;
		this.deviceTypeStr = deviceTypeStr;
	}
	
	private  Integer  deviceTypeNum;
	
	private  String  deviceTypeStr ;

	public Integer getDeviceTypeNum() {
		return deviceTypeNum;
	}

	public void setDeviceTypeNum(Integer deviceTypeNum) {
		this.deviceTypeNum = deviceTypeNum;
	}

	public String getDeviceTypeStr() {
		return deviceTypeStr;
	}

	public void setDeviceTypeStr(String deviceTypeStr) {
		this.deviceTypeStr = deviceTypeStr;
	}
	
	
	
}
