package com.softeng.supermarket.security;


import com.softeng.supermarket.models.Admin;
import com.softeng.supermarket.models.Customer;
import com.softeng.supermarket.repositories.AdminRepository;
import com.softeng.supermarket.repositories.CustomerRepository;
import com.softeng.supermarket.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepo;
    @Autowired
    private AdminRepository adminRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // first try loading from Customer table
        Customer customer = customerRepo.findByUsername(username);
        if (customer != null) {
            return new CustomUserDetails(customer.getUsername(), customer.getPassword(), "CUSTOMER");
        } else {
            // Not found in user table, so check admin
            Admin admin = adminRepo.findByUsername(username);
            if (admin != null) {
                return new CustomUserDetails(admin.getUsername(), admin.getPassword(),"ADMIN");
            }
        }
        throw new UsernameNotFoundException("User '" + username + "' not found");
    }

}
