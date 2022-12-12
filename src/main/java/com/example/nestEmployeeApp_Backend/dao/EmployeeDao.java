package com.example.nestEmployeeApp_Backend.dao;

import com.example.nestEmployeeApp_Backend.model.Employee;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    @Query(value = "SELECT `id`,`designation`, `employee_code`, `mobile_number`, `name`, `password`, `salary`, `user_name` FROM `employee` WHERE `user_name`=:user_name AND `password`=:password",nativeQuery = true)
    List<Employee> passwordCheck(@Param("user_name") String user_name, @Param("password") String password);
}
