package com.example.employee.repository;

import java.util.ArrayList;
import com.example.employee.model.Employee;

public interface EmployeeRepository {
    public ArrayList<Employee> getAllEmployees();
    public Employee getEmployeeById(Integer employeeId);
    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(Integer employeeId, Employee employee);
    public void deleteEmployee(Integer employeeId);
}