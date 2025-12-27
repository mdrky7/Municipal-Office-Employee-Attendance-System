package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.AdminUser;
import com.examly.springapp.repository.AdminUserRepository;

@Service
public class AdminUserService {
    private final AdminUserRepository repo;

    public AdminUserService(AdminUserRepository repo){
        this.repo = repo;
    }

    public AdminUser addAdminUser(AdminUser adminUser){
        return repo.save(adminUser);
    }

    public AdminUser getAdminById(Long id){
        return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Admin user not found with id: " + id));
    }

    public AdminUser updateAdminById(Long id, AdminUser adminUser){
        adminUser.setId(id);
        return repo.save(adminUser);
    }

    public List<AdminUser> getAllAdmins(){
        List<AdminUser> lau = repo.findAll();
        if(lau.isEmpty()){
            throw new ResourceNotFoundException("No admin users found");
        }
        return lau;
    }
}
