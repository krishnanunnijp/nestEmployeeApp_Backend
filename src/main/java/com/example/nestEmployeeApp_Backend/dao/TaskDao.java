package com.example.nestEmployeeApp_Backend.dao;

import com.example.nestEmployeeApp_Backend.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;


public interface TaskDao extends CrudRepository<Task,Integer> {

    @Query(value = "SELECT  e.employee_code,e.`designation`, e.`name`, t.task_name,t.due_date,t.task_status FROM `employee` e JOIN task t ON e.employee_code = t.employee_code",nativeQuery = true)
    List<Map<String,String>> findTask();

}
