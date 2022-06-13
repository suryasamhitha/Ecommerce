package com.furniture.exception;

public class OrderNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public OrderNotFoundException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "OrderNotFoundException [message=" + message + "]";
	}
	
}
