package com.furniture.exception;

public class InvalidDetailsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public InvalidDetailsException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "InvalidDetailsException [message=" + message + "]";
	}

}
