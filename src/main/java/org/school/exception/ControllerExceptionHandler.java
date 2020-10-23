package org.school.exception;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public final class ControllerExceptionHandler {
	
	private Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);
	
	
	@ExceptionHandler(ResourceNotFoundException.class) 
	public ResponseEntity<ExceptionDetails> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request)  {
		
		log.info("Method Exception Handler for Resource Not Found Has Been Started");

		
		ExceptionDetails exDetails = new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(true));
		
		return new ResponseEntity<ExceptionDetails>(exDetails, HttpStatus.NOT_FOUND);
		
		
	}

}
