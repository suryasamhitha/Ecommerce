package com.furniture.exception;

public class StockNotAvailableException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message;
	
	public StockNotAvailableException(String message)
	{
		this.message=message;
	}

	@Override
	public String toString() {
		return "StockNotAvailableException [message=" + message + "]";
	}
}
