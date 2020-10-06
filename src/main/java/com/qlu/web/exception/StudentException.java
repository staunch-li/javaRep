package com.qlu.web.exception;

public class StudentException extends Exception{

	private static final long serialVersionUID = -2972195106013447608L;

	private String code;
	private String message;
	
	public StudentException() {
		// TODO Auto-generated constructor stub
	}

	

	public StudentException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
