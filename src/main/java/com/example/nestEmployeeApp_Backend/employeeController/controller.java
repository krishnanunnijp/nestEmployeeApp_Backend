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
        dao2.save(t);
        map.put("status","success");
        return map;

    }
    @CrossOrigin(origins = "*")
    @GetMapping( "/tasks")
    public List<Map<String,String>> viewTask(){
        return dao2.findTask();
    }

}
