package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.Employee;
import com.examly.springapp.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeServiceImpl{
    
    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo){
        this.repo = repo;
    }

    @Override
    public Employee createEmployee (Employee employee){
        return repo.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id){
        return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found with id " + id));
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee){
        employee.setId(id);
        return repo.save(employee);
    }
    
    @Override
    public List<Employee> getAllEmployees (){
        return repo.findAll();
    }
}
