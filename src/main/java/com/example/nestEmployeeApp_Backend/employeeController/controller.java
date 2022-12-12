package com.example.nestEmployeeApp_Backend.employeeController;


import com.example.nestEmployeeApp_Backend.dao.EmployeeDao;
import com.example.nestEmployeeApp_Backend.dao.TaskDao;
import com.example.nestEmployeeApp_Backend.model.Employee;
import com.example.nestEmployeeApp_Backend.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class controller {
    @Autowired
    EmployeeDao dao;
    @Autowired
    TaskDao dao2;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> add(@RequestBody Employee e){
        HashMap<String,String> map = new HashMap<>();
        dao.save(e);
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path="/",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> AddTask(@RequestBody Task t){
        HashMap<String, String> map = new HashMap<>();
        t.setTaskStatus("task assigned");
        dao2.save(t);
        map.put("status","success");
        return map;

    }
    @CrossOrigin(origins = "*")
    @GetMapping( "/tasks")
    public List<Map<String,String>> viewTask(){
        return dao2.findTask();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewEmp", consumes = "application/json", produces = "application/json")
    public List<Map<String, String>> viewEmpTask(@RequestBody Employee employee) {
        return dao2.findEmpTask(employee.getEmployeeCode());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/update",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> updateEmployee(@RequestBody Task t){
        HashMap<String, String> map = new HashMap<String, String>();
        System.out.println(String.valueOf(t.getId()));
        System.out.println(String.valueOf(String.valueOf(t.getTaskStatus())));
        dao2.updateTask(t.getTaskStatus(),t.getId());
        map.put("status","success");
        return map;

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> login(@RequestBody Employee e){
        HashMap<String, String> map = new HashMap<String, String>();
        List<Employee> emp= dao.passwordCheck(e.getUserName(),e.getPassword());
        if (emp.size() != 0) {
            map.put("id",String.valueOf( emp.get(0).getId()));
            map.put("status","success");
            map.put("employeeCode",String.valueOf( emp.get(0).getEmployeeCode()));
        }else {
            map.put("status","failed");
        }
        return map;
    }


}
