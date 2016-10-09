package com.datapromise.common;

public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int code = 0;
	private String message;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AppException(int code, String message)
	{		
		super(message);
	
		this.code = code;
		this.message = message;
	}
	
	public AppException(Exception ex)
	{
		super(ex);
		
		this.message = ex.getMessage();
	}
}
