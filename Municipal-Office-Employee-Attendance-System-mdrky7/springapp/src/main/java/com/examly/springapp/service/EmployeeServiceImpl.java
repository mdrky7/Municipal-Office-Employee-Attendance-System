package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Employee;

public interface EmployeeServiceImpl {
    public Employee createEmployee(Employee employee);
    public Employee getEmployeeById(Long id);
    public Employee updateEmployee(Long id, Employee employee);
    public List<Employee> getAllEmployees ();
}
