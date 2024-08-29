package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.model.EmployeeRowMapper;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class EmployeeH2Service implements EmployeeRepository{
    @Autowired
    private JdbcTemplate db;
    @Override
    public ArrayList<Employee> getAllEmployees() {
        List<Employee> employees = db.query("SELECT * FROM EMPLOYEELIST",new EmployeeRowMapper());
        return new ArrayList<>(employees);
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        try{
            return db.queryForObject("SELECT * FROM EMPLOYEELIST WHERE employeeId =?",new EmployeeRowMapper(),employeeId);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Employee addEmployee(Employee employee) {
        db.update("INSERT INTO EMPLOYEELIST(employeeName,email,department) VALUES(?,?,?)",employee.getEmployeeName(),employee.getEmail(),employee.getDepartment());
        Employee savedEmployee = db.queryForObject("select * from EMPLOYEELIST where employeeName = ?",new EmployeeRowMapper(),employee.getEmployeeName());
        return savedEmployee;
    }

    @Override
    public Employee updateEmployee(Integer employeeId, Employee employee) {
        try{
            if(employee.getEmployeeName() != null){
                db.update("Update EMPLOYEELIST set employeeName = ? where employeeId=?",employee.getEmployeeName(),employeeId);
            }
            if(employee.getEmail() != null){
                db.update("Update EMPLOYEELIST set email =? where employeeId=?",employee.getEmail(),employeeId);
            }
            if(employee.getDepartment() != null){
                db.update("Update EMPLOYEELIST set department =? where employeeId=?",employee.getDepartment(),employeeId);
            }
            return getEmployeeById(employeeId);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        try{
            db.update("DELETE FROM EMPLOYEELIST WHERE employeeId =?",employeeId);
            throw new ResponseStatusException(HttpStatus.OK);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.OK);
        }
    }
}