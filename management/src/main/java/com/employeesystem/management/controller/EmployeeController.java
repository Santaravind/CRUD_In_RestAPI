package com.employeesystem.management.controller;

import com.employeesystem.management.entity.Employee;
import com.employeesystem.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return  ResponseEntity.ok(service.getAllEmployee());
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    @PostMapping("/employees")
    public  ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(service.addEmployee(employee));
    }

    @PatchMapping("/employees/{id}")
      public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id) {

        Employee empObj=service.getEmployeeById(id);
        if (empObj !=null){
            empObj.setManager(employee.getManager());
            empObj.setName(employee.getName());
            empObj.setSalary(employee.getSalary());
        }
        return ResponseEntity.ok(service.updateEmployee(empObj));

       //return ResponseEntity.ok(service.updateEmployee(employee));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable("id") Long id) {

        Employee empObj=service.getEmployeeById(id);
        String DeleteMsg=null;
        if (empObj!=null){
            DeleteMsg=service.deleteEmployee(empObj);        }
        return ResponseEntity.ok(DeleteMsg);
    }


}
