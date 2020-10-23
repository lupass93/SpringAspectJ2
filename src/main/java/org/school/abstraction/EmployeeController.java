package org.school.abstraction;

import javax.validation.Valid;

import org.school.exception.ResourceNotFoundException;
import org.school.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface EmployeeController {
	
	public ResponseEntity<?> getEmployee(@RequestParam(value = "id") Long id) throws ResourceNotFoundException;
	
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee);
	
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee) throws ResourceNotFoundException;
	
	public ResponseEntity<Employee> deleteEmployee(@RequestParam(value = "id") Long id) throws ResourceNotFoundException;
}
