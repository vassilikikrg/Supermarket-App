package com.softeng.supermarket.services;

import com.softeng.supermarket.models.Customer;
import com.softeng.supermarket.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public CustomerService(CustomerRepository customerRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.customerRepository = customerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Customer findCustomerByUsername(String username){
        return customerRepository.findByUsername(username);
    }
    /*
    public Customer findCustomerByPhone(String phone){
        return customerRepository.findByPhone(phone);
    }*/
    public Customer saveCustomer(Customer customer){
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

}
