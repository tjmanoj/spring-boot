package com.example.employee;

import java.util.ArrayList;

public interface EmployeeRepository {
    public ArrayList<Employee> getAllEmployees();
    public Employee getEmployeeById(int employeeId);
    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(int employeeId, Employee employee);
    public void deleteEmployee(int employeeId);
}
