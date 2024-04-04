package com.example.Demo.Project.controller;

import com.example.Demo.Project.entity.Employee;
import com.example.Demo.Project.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll(); // Using findAll() provided by Spring Data JPA
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
        Optional<Employee> employeeOptional = employeeRepo.findById(id); // Using findById() provided by Spring Data JPA
        if (employeeOptional.isPresent()) {
            return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeRepo.save(employee); // Using save() provided by Spring Data JPA
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

@PutMapping("/{id}")
public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee updatedEmployee) {
    Optional<Employee> employeeOptional = employeeRepo.findById(id); // Using findById() provided by Spring Data JPA
    if (employeeOptional.isPresent()) {
        Employee employee = employeeOptional.get();
        employee.setEname(updatedEmployee.getEname());
        employee.setEadress(updatedEmployee.getEadress());
        employee.setEsalary(updatedEmployee.getEsalary());
        employeeRepo.save(employee); // Using save() provided by Spring Data JPA
        return new ResponseEntity<>(employee, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

@PatchMapping("/{id}")
public ResponseEntity<Employee> partialUpdateEmployee(@PathVariable("id") int id, @RequestBody Employee updatedEmployee) {
    Optional<Employee> employeeOptional = employeeRepo.findById(id); // Using findById() provided by Spring Data JPA
    if (employeeOptional.isPresent()) {
        Employee employee = employeeOptional.get();
        if (updatedEmployee.getEname() != null) {
            employee.setEname(updatedEmployee.getEname());
        }
        if (updatedEmployee.getEadress() != null) {
            employee.setEadress(updatedEmployee.getEadress());
        }
        if (updatedEmployee.getEsalary() != 0) {
            employee.setEsalary(updatedEmployee.getEsalary());
        }
        employeeRepo.save(employee); // Using save() provided by Spring Data JPA
        return new ResponseEntity<>(employee, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id) {
    Optional<Employee> employeeOptional = employeeRepo.findById(id); // Using findById() provided by Spring Data JPA
    if (employeeOptional.isPresent()) {
        employeeRepo.deleteById(id); // Using deleteById() provided by Spring Data JPA
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
}

