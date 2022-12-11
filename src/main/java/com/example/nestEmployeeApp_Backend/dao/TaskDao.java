package com.example.nestEmployeeApp_Backend.dao;

import com.example.nestEmployeeApp_Backend.model.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;


public interface TaskDao extends CrudRepository<Task,Integer> {

    @Query(value = "SELECT  e.employee_code,e.`designation`, e.`name`, t.task_name,t.due_date,t.task_status FROM `employee` e JOIN task t ON e.employee_code = t.employee_code",nativeQuery = true)
    List<Map<String,String>> findTask();

    @Query(value = "SELECT t.id, e.`designation`, e.`name`, t.task_name,t.due_date,t.task_status FROM `employee` e JOIN task t ON e.employee_code = t.employee_code where e.employee_code=:employee_code",nativeQuery = true)
    List<Map<String,String>> findEmpTask(@Param("employee_code") Integer employee_code);


    @Modifying
    @Transactional
    @Query(value = "UPDATE `task` SET `task_status`=:task_status WHERE `id` =:id",nativeQuery = true)
    void updateTask(@Param("task_status") String task_status,@Param("id") Integer id );

}
