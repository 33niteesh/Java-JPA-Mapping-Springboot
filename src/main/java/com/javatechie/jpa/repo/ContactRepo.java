package com.javatechie.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javatechie.jpa.model.*;
public interface ContactRepo  extends JpaRepository<Contact, Long> {
    // Additional custom queries can be added here if needed
}
