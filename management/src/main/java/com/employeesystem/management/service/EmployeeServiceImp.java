package com.employeesystem.management.service;

import com.employeesystem.management.entity.Employee;
import com.employeesystem.management.repositery.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements  EmployeeService{

    @Autowired
   private EmployeeRepo repo;

    @Override
    public List<Employee> getAllEmployee() {
        return (List<Employee>) repo.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return   repo.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public String deleteEmployee(Employee employee) {
        repo.delete(employee);
        return "Deletion is succesfully completed!!!"+employee.getId();
    }
}
