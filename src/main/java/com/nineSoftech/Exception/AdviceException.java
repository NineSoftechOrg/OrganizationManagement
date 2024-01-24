package com.nineSoftech.Exception;

import org.springframework.http.HttpStatus; 	

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AdviceException {
	
	
	@ExceptionHandler(ProductNotFound.class)
	public ResponseEntity<Object> handleExceptions(ProductNotFound notFound , WebRequest webRequest){
		
		ErrorResponse ei = new ErrorResponse();
		
		ei.setErrorCode(notFound.getMessage());
		ei.setErrorMessage("result not found");
		
		ResponseEntity<Object> entity = new ResponseEntity<Object>(ei, HttpStatus.NOT_FOUND);
		return entity;
	}
	
	
	   @ExceptionHandler({PostNotFoundException.class})
	    public ResponseEntity<Object> handlePostNotFoundException(PostNotFoundException exception) {
	        return ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(exception.getMessage());
	    }
	   
	   @ExceptionHandler(DeleteApiException.class)
	   public ResponseEntity<Object> handleDeleteApiException(DeleteApiException apiException) {
		   
		   return  ResponseEntity
				   .status(HttpStatus.INTERNAL_SERVER_ERROR)
				   .body(apiException.getMessage());
	   }

}
