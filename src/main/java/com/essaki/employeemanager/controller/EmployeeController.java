package com.essaki.employeemanager.controller;

import com.essaki.employeemanager.model.Employee;
import com.essaki.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = empService.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = empService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
        Employee employee = empService.addEmploye(emp);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateEmployee(@RequestBody Employee emp){
        Employee employee = empService.updateEmployee(emp);
        return new ResponseEntity<String>("Employee Updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        empService.deleteEmployee(id);
        return new ResponseEntity<>("Employee Deleted", HttpStatus.OK);
    }

}
