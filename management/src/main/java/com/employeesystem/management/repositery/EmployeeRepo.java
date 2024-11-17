package com.employeesystem.management.repositery;

import com.employeesystem.management.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo
extends CrudRepository<Employee,Long> {
}