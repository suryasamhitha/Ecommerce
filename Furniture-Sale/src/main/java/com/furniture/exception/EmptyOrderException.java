package com.furniture.exception;

public class EmptyOrderException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public EmptyOrderException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "EmptyOrderException [message=" + message + "]";
	}

}
