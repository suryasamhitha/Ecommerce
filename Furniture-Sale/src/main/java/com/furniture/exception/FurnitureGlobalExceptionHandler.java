package com.furniture.exception;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@ControllerAdvice
public class FurnitureGlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request)
			throws Exception {

		FurnitureExceptionResponse resp = new FurnitureExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getContextPath(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<Object> handleHelpdeskQueryNotFoundException(OrderNotFoundException ex, WebRequest request)
			throws Exception {

		FurnitureExceptionResponse resp = new FurnitureExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getContextPath(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Object> handleHelpdeskQueryNotFoundException(ProductNotFoundException ex, WebRequest request)
			throws Exception {

		FurnitureExceptionResponse resp = new FurnitureExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getContextPath(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(InvalidDetailsException.class)
	public ResponseEntity<Object> handleInvalidDocumentException(InvalidDetailsException ex, WebRequest request)
			throws Exception {

		FurnitureExceptionResponse resp = new FurnitureExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getContextPath(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(EmptyOrderException.class)
	public ResponseEntity<Object> handleVisaApplicationAlreadyExistException(EmptyOrderException ex, WebRequest request)
			throws Exception {

		FurnitureExceptionResponse resp = new FurnitureExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getContextPath(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(StockNotAvailableException.class)
	public ResponseEntity<Object> handleUserAlreadyExistException(StockNotAvailableException ex, WebRequest request)
			throws Exception {

		FurnitureExceptionResponse resp = new FurnitureExceptionResponse(new Date(System.currentTimeMillis()), ex.toString(),
				request.getContextPath(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);

	}
	
}


