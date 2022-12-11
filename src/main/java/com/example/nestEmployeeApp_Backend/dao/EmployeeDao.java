package com.example.nestEmployeeApp_Backend.dao;

import com.example.nestEmployeeApp_Backend.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}
