package com.coki.employeemanager.service;

import com.coki.employeemanager.domain.Employee;
import com.coki.employeemanager.exception.UserNotFoundExcepion;
import com.coki.employeemanager.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return  employeeRepository.save(employee);
    }
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public void deleteEmployee(Long id){
        Employee employee=employeeRepository.findEmployeeById(id)
                .orElseThrow(() ->new UserNotFoundExcepion("User by id " + id + " was not found"));
        employeeRepository.delete(employee);
    }
    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() ->new UserNotFoundExcepion("User by id " + id + " was not found"));
    }

}
