package com.javatechie.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javatechie.jpa.model.*;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    // Additional custom queries can be added here if needed
}