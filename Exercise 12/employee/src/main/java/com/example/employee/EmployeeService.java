package com.example.employee;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.*;

// Do not modify the below code

public class EmployeeService implements EmployeeRepository {

    private static HashMap<Integer, Employee> employeeList = new HashMap<>();
    private int employeeUniqueCount = 7;
    public EmployeeService() {
        employeeList.put(1, new Employee(1, "John Doe", "johndoe@example.com", "Marketing"));
        employeeList.put(2, new Employee(2, "Jane Smith", "janesmith@example.com", "Human Resources"));
        employeeList.put(3, new Employee(3, "Bob Johnson", "bjohnson@example.com", "Sales"));
        employeeList.put(4, new Employee(4, "Alice Lee", "alee@example.com", "IT"));
        employeeList.put(5, new Employee(5, "Mike Brown", "mbrown@example.com", "Finance"));
        employeeList.put(6, new Employee(6, "Sara Lee", "slee@example.com", "Operations"));

    }

    // Do not modify the above code

    // Write your code here@Override
    public ArrayList<Employee> getAllEmployees() {
        Collection<Employee> employees = employeeList.values();
        return new ArrayList<>(employees);
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        if (employeeList.get(employeeId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return employeeList.get(employeeId);
        }
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeId(employeeUniqueCount++);
        employeeList.put(employee.getEmployeeId(), employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(int employeeId, Employee employee) {
        Employee oldEmployee = employeeList.get(employeeId);
        if (oldEmployee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (employee.getEmployeeName() != null) {
            oldEmployee.setEmployeeName(employee.getEmployeeName());
        }

        if (employee.getEmail() != null) {
            oldEmployee.setEmail(employee.getEmail());
        }

        if (employee.getDepartment() != null) {
            oldEmployee.setDepartment(employee.getDepartment());
        }
        return oldEmployee;

    }

    @Override
    public void deleteEmployee(int employeeId) {
        if (employeeList.get(employeeId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            employeeList.remove(employeeId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}
