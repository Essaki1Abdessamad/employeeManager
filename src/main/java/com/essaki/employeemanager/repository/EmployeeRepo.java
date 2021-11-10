package com.essaki.employeemanager.repository;

import com.essaki.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findByNameContaining(String name);
}
