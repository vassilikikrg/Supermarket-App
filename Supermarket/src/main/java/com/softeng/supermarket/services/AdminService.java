package com.softeng.supermarket.services;

import com.softeng.supermarket.models.Admin;
import com.softeng.supermarket.repositories.AdminRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private AdminRepository adminRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AdminService(AdminRepository adminRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.adminRepository = adminRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Admin findCustomerByUsername(String username){
        return adminRepository.findByUsername(username);
    }
    /*
    public Customer findCustomerByPhone(String phone){
        return customerRepository.findByPhone(phone);
    }*/
    public Admin saveAdmin(Admin admin){
        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }
}
