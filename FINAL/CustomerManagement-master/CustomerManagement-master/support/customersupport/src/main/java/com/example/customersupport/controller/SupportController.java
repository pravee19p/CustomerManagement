package com.example.customersupport.controller;
import com.example.customersupport.model.SupportRequest;
import com.example.customersupport.service.SupportRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/support-requests")

public class SupportController {
    
    @Autowired
    private SupportRequestService supportRequestService;

    @GetMapping
    public List<SupportRequest> getAllSupportRequests() {
        return supportRequestService.getAllSupportRequests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupportRequest> getSupportRequestById(@PathVariable Long id) {
        Optional<SupportRequest> supportRequest = supportRequestService.getSupportRequestById(id);
        return supportRequest.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public SupportRequest createSupportRequest(@RequestBody SupportRequest supportRequest) {
        return supportRequestService.saveSupportRequest(supportRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupportRequest> updateSupportRequest(@PathVariable Long id, @RequestBody SupportRequest supportRequest) {
        if (!supportRequestService.getSupportRequestById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        supportRequest.setRequestId(id);
        return ResponseEntity.ok(supportRequestService.saveSupportRequest(supportRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupportRequest(@PathVariable Long id) {
        if (!supportRequestService.getSupportRequestById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        supportRequestService.deleteSupportRequest(id);
        return ResponseEntity.noContent().build();
    }
}


