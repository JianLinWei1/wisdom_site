package com.jian.util;

public enum ActionUtil {
	
	insert(1 , "insert"),
	update(2 , "update"),
	delete(-1, "delete");

	private  Integer  code;
	
	private  String  value;
	
     ActionUtil(Integer code , String value) {
		this.code  = code;
		this.value  = value;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	
	
}
