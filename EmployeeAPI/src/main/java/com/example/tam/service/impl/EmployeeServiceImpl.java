package com.example.tam.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tam.entities.Employee;
import com.example.tam.repositories.EmployeeRepository;
import com.example.tam.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee save(Employee entity) {
		return employeeRepository.save(entity);
	}

	@Override
	public Iterable<Employee> saveAll(Iterable<Employee> entities) {
		return employeeRepository.saveAll(entities);
	}

	@Override
	public Optional<Employee> findById(Long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return employeeRepository.existsById(id);
	}

	@Override
	public Iterable<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Iterable<Employee> findAllById(Iterable<Long> ids) {
		return employeeRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return employeeRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public void delete(Employee entity) {
		employeeRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<Employee> entities) {
		employeeRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		employeeRepository.deleteAll();
	}
}
