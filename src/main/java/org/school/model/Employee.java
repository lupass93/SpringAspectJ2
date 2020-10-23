package org.school.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.PositiveOrZero;

/**
 * 
 * This Class represent a Employee
 * 
 * @author lupass93
 *
 */
public final class Employee {
	
	@NotNull
	@PositiveOrZero
	private long id;
	
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	
	@NotNull
	@Email
	private String email;
	
	
	public Employee(long id, String firstName, String lastName, String email) {
		
		super();
		
		this.id=id;
		
		this.firstName=firstName;
		
		this.lastName=lastName;
		
		this.email=email;
	}
	
	
	public long getId() {
		
		return this.id;
	}
	
	public String getFirstName() {
		
		return this.firstName;
	}
	
	public String getLastName() {
		
		return this.lastName;
		
	}
	
	public String getEmail() {
		
		return this.email;
	}

}
