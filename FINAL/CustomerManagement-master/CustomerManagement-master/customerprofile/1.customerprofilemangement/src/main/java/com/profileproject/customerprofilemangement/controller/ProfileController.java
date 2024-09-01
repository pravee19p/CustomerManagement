package com.profileproject.customerprofilemangement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profileproject.customerprofilemangement.entity.Profile;
import com.profileproject.customerprofilemangement.service.ProfileService;
@RestController
@RequestMapping("/customer")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @PostMapping()
    public ResponseEntity<Profile> createCustomer(@RequestBody Profile profile) {
        return new ResponseEntity<>(profileService.createCustomer(profile), HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<List<Profile>> getAllCustomers() {
        return ResponseEntity.ok(profileService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getCustomerById(@PathVariable Long id) {
        Optional<Profile> customer = profileService.getCustomerById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateCustomer(@PathVariable Long id, @RequestBody Profile profile) {
        Profile updatedCustomer = profileService.updateCustomer(id, profile);
        return updatedCustomer != null ? ResponseEntity.ok(updatedCustomer) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        profileService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}