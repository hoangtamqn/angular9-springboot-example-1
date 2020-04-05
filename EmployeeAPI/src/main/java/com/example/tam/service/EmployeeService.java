package com.example.tam.service;

import java.util.Optional;

import com.example.tam.entities.Employee;

public interface EmployeeService {

	void deleteAll();

	void deleteAll(Iterable<Employee> entities);

	void delete(Employee entity);

	void deleteById(Long id);

	long count();

	Iterable<Employee> findAllById(Iterable<Long> ids);

	Iterable<Employee> findAll();

	boolean existsById(Long id);

	Optional<Employee> findById(Long id);

	Iterable<Employee> saveAll(Iterable<Employee> entities);

	Employee save(Employee entity);

}
