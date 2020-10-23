package org.school.abstraction;

import org.school.exception.ResourceNotFoundException;
import org.school.model.Employee;


public interface RepositoryForEmployee {
	
	
	public Employee save(Employee employee);
	
	public Employee update(Employee employee) throws ResourceNotFoundException;
	
	public Employee get(Long id) throws ResourceNotFoundException;
	
	public Employee delete(Long id) throws ResourceNotFoundException;
	
	

}
