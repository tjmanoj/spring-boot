package com.example.employee.model;

public class Employee {
    private Integer employeeId;
    private String employeeName;
    private String email;
    private String department;

    public Employee(int employeeId,String employeeName,String employeeEmail,String department){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = employeeEmail;
        this.department = department;
    }

    //setters
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    //getters
    public Integer getEmployeeId() {
        return employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public String getEmail() {
        return email;
    }
    public String getDepartment() {
        return department;
    }
}