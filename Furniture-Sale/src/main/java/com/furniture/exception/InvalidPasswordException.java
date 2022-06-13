package com.furniture.exception;

public class InvalidPasswordException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message;
	
	public InvalidPasswordException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "InvalidPasswordException [message=" + message + "]";
	}
	
}
