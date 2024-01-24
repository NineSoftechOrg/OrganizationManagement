package com.nineSoftech.Controller;

import java.util.List;


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

import com.nineSoftech.Entity.Management;
import com.nineSoftech.Service.ManagementService;

@RestController
@RequestMapping("/management")
public class ManagementController {
	
	
    @Autowired
    private ManagementService managementService;

    @GetMapping("/all")
    public ResponseEntity<List<Management>> getAllManagementes() {
        List<Management> managementes = managementService.getAllManagementes();
        return new ResponseEntity<>(managementes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Management> getManagementById(@PathVariable Long id) {
        Management management = managementService.getManagementById(id);
        if (management != null) {
            return new ResponseEntity<>(management, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<Management> createManagement(@RequestBody Management management) {
        Management createdManagement = managementService.createManagement(management);
        return new ResponseEntity<>(createdManagement, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Management> updateManagement(@PathVariable Long id, @RequestBody Management management) {
        Management updatedManagement = managementService.updateManagement(id, management);
        if (updatedManagement != null) {
            return new ResponseEntity<>(updatedManagement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManagement(@PathVariable Long id) {
        managementService.deleteManagement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
