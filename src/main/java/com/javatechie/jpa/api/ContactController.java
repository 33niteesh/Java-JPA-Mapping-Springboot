package com.javatechie.jpa.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.javatechie.jpa.model.*;
import com.javatechie.jpa.repo.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactRepo contactrepo;

    @Autowired
    public ContactController(ContactRepo contactrepo) {
        this.contactrepo = contactrepo;
    }

    @GetMapping
    public List<Contact> getAllAddresses() {
        return contactrepo.findAll();
    }

    @GetMapping("/{id}")
    public Contact getAddressById(@PathVariable Long id) {
        return contactrepo.findById(id).orElse(null);
    }

    @PostMapping
    public Contact createAddress(@RequestBody Contact contact) {
        return contactrepo.save(contact);
    }

    @PutMapping("/{id}")
    public Contact updateAddress(@PathVariable Long id, @RequestBody Contact updateContact) {
        Contact existingAddress = contactrepo.findById(id).orElse(null);
        if (existingAddress != null) {
            return contactrepo.save(existingAddress);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
    	contactrepo.deleteById(id);
    }
}