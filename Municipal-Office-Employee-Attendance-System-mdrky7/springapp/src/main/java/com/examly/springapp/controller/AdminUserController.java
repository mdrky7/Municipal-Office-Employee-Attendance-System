package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.AdminUser;
import com.examly.springapp.service.AdminUserService;

@RequestMapping("/admin")
@RestController
public class AdminUserController {

    private final AdminUserService service;

    public AdminUserController(AdminUserService service){
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<AdminUser> addAdminUser(@RequestBody AdminUser adminUser){
        return ResponseEntity.status(HttpStatus.OK).body(service.addAdminUser(adminUser));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminUser> getAdminById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAdminById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminUser> updateAdminById(@PathVariable Long id, @RequestBody AdminUser adminUser) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateAdminById(id, adminUser));
    }
    
    @GetMapping
    public ResponseEntity<List<AdminUser>> getAllAdmins (){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllAdmins());
    }
}
