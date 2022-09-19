package com.vti.responobject;

import lombok.Data;

@Data
public class ResponseObj {

	private String status;
	private String message;
	private Object data;
	
	public ResponseObj() {
		
	}
	
	public ResponseObj(String status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}


	
	
	
}
