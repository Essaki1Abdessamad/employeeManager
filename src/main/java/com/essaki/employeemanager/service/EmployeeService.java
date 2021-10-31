package com.essaki.employeemanager.service;

import com.essaki.employeemanager.model.Employee;
import com.essaki.employeemanager.repository.EmployeeRepo;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {


    final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmploye(Employee emp){
        emp.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(emp);
    }

    public List<Employee> getEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee emp){
        /*Employee oldEmp = employeeRepo.;
        oldEmp.setName(emp.getName());
        oldEmp.setEmail(emp.getEmail());
        oldEmp.setJobTitle(emp.getJobTitle());
        oldEmp.setPhone(emp.getPhone());
        oldEmp.setImgUrl(emp.getImgUrl());*/
        return employeeRepo.save(emp);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findById(id).orElse(null);
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }
}
