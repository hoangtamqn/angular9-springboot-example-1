package com.example.tam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tam.entities.Employee;
import com.example.tam.exeption.ResourceNotFoundExeption;
import com.example.tam.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployees() {
		return (List<Employee>)employeeService.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeId(@PathVariable(name = "id") long id) throws ResourceNotFoundExeption {
		Employee employee = employeeService.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeption("Employee not found!"));
		return ResponseEntity.ok().body(employee);
	}
	
	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmployeeId(@RequestBody Employee employeeDetail, @PathVariable(name = "id") long id) throws ResourceNotFoundExeption{
		Employee employee = employeeService.findById(id)
				.orElseThrow(()-> new ResourceNotFoundExeption("Employee not found!"));
		
		employee.setFirstName(employeeDetail.getFirstName());
		employee.setLastName(employeeDetail.getLastName());
		employee.setEmailId(employeeDetail.getEmailId());
		
		return employeeService.save(employee);
	}
	
	@DeleteMapping("employee/{id}")
	public Map<String, Boolean> deleteEmployeeId(@PathVariable Long id) throws ResourceNotFoundExeption{
		Employee employee = employeeService.findById(id)
				.orElseThrow(()->new ResourceNotFoundExeption("Employee is not found!"));
		
		employeeService.delete(employee);
		
		Map<String, Boolean> map = new HashMap<>();
		map.put("deleted", Boolean.TRUE);
		
		return map;
	}
}
