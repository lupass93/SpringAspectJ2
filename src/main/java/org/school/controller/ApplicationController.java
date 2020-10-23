package org.school.controller;

import org.school.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import org.school.abstraction.EmployeeController;
import org.school.abstraction.RepositoryForEmployee;
import org.school.exception.ResourceNotFoundException;
import org.school.model.Employee;

@RestController
@RequestMapping("/application")
public final class ApplicationController implements EmployeeController {
	
	@Autowired 
	private RepositoryForEmployee employeesRepository;
	
	
	@GetMapping("/getEmployee")
	public ResponseEntity<?> getEmployee(@RequestParam(value = "id") Long id) throws ResourceNotFoundException {
		
		Employee employee = null;

		employee = this.employeesRepository.get(id);
	
		
		return ResponseEntity.status(HttpStatus.OK).body(employee);
		
	}
	
	@PostMapping("/newEmployee")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		
		Employee employeeSaved = this.employeesRepository.save(employee);
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeSaved);
		
		
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee) throws ResourceNotFoundException {
		
		Employee employeeUpdated = null;

		employeeUpdated = this.employeesRepository.update(employee);
	
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeUpdated);
		
		
	}
	
	@DeleteMapping("/deleteEmployee")
	public ResponseEntity<Employee> deleteEmployee(@RequestParam(value = "id") Long id) throws ResourceNotFoundException {
		
		Employee employeeDeleted = null;
	
		employeeDeleted = this.employeesRepository.delete(id);
	
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeDeleted);
		
	}
	
	
	
	

}
