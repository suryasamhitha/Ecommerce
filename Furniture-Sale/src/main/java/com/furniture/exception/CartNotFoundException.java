package com.furniture.exception;

public class CartNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public CartNotFoundException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "EmptyOrderException [message=" + message + "]";
	}

}
