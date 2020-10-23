package org.school.repository;


import java.util.HashMap;
import java.util.Map;

import org.school.abstraction.RepositoryForEmployee;
import org.school.exception.ResourceNotFoundException;
import org.school.model.Employee;

/**
 * 
 * This Class represent a Repository of Employees
 * 
 * @author lupass93
 *
 */


public final class EmployeesRepository  implements RepositoryForEmployee {
	
	private static EmployeesRepository instance;
	
	private Map<Long,Employee> db;
	
	
	private EmployeesRepository() {
		
		this.db = new HashMap<Long,Employee>();
		
	}
	
	
	
	public static EmployeesRepository getInstance() {
		
		if (EmployeesRepository.instance==null) {
			
			EmployeesRepository.instance = new EmployeesRepository();
			
		}
		
		return EmployeesRepository.instance;
	}

	
	public Employee save(Employee employee)  {
		
		this.db.put(employee.getId(), employee);
		
		return employee;
		
	}
	
	
	public Employee update(Employee employee) throws ResourceNotFoundException {
		
		
		Long id = employee.getId();
		
		if (this.db.containsKey(id)) {
		
		this.db.replace(id, employee);
		
		return db.get(id);
		
		} else {
			
			throw new ResourceNotFoundException("The Resource with id: +"+ id + " not found.");
			
		}
		
	}
	
	
	public Employee get(Long id) throws ResourceNotFoundException {
		
		
		Employee employee = this.db.get(id);
		
		if (employee==null) {
			
			throw new ResourceNotFoundException("The Resource with id: +"+ id + " not found.");
		}
		
		return employee;
	
	}
	
	public Employee delete(Long id) throws ResourceNotFoundException {
		
		Employee employee = this.db.remove(id);
		
		if (employee==null) {
			
			throw new ResourceNotFoundException("The Resource with id: +"+ id + " not found.");

		}
		
		return employee;
	}
}
