package com.example.nestEmployeeApp_Backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue()
    private int id;
    private int employeeCode;
    private String taskName;
    private String dueDate;
    private String taskStatus="task assigned";

    public Task(int id, int employeeCode, String taskName, String dueDate, String taskStatus) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.taskStatus = taskStatus;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
