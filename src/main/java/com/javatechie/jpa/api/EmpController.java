package com.javatechie.jpa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.javatechie.jpa.model.*;
import com.javatechie.jpa.repo.*;

import java.util.*;

@RestController
@RequestMapping("/api/")
public class EmpController {

    private final EmployeeRepo empRepository;

    @Autowired
    public EmpController(EmployeeRepo empRepository) {
        this.empRepository = empRepository;
    }

    @GetMapping
    public List<Employee> getAllUsers() {
        return empRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getUserById(@PathVariable Long id) {
        return empRepository.findById(id).orElse(null);
    }

    // Endpoint to create a new user
    @PostMapping
    public Employee createUser(@RequestBody Employee emp) {
        return empRepository.save(emp);
    }

    // Endpoint to update a user
    @PutMapping("/{id}")
    public Employee updateUser(@PathVariable Long id, @RequestBody Employee updatedUser) {
        Employee existingUser = empRepository.findById(id).orElse(null);
        if (existingUser != null) {
            // Update user properties
            existingUser.setName(updatedUser.getName());
            // ... other properties
            return empRepository.save(existingUser);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
    	empRepository.deleteById(id);
    }
}
