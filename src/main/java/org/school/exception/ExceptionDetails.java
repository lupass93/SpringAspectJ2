package org.school.exception;

import java.util.Date;

public final class ExceptionDetails {
	
	private Date timestamp;
	
	private String message;
	
	private String details;
	
	
	public ExceptionDetails(Date date, String message, String details) {
		
		this.timestamp=date;
		
		this.message=message;
		
		this.details=details;
		
	
	}
	
	public String getDate() {
		
		return this.timestamp.toString();
	}
	
	public String getMessage() {
		
		return this.message;
	
	}
	
	public String getDetails() {
		
		return this.details;
		
	}

}
