package com.furniture.exception;

public class UserAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message;
	
	public UserAlreadyExistsException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "UserAlreadyExistException [message=" + message + "]";
	}
	
}
