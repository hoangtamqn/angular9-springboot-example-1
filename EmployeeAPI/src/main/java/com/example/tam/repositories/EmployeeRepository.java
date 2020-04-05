package com.example.tam.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.tam.entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
