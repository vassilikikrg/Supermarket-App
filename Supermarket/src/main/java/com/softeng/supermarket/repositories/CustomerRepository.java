package com.softeng.supermarket.repositories;

import com.softeng.supermarket.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
                                                            // TYPE  //  PK TYPE
public interface CustomerRepository  extends CrudRepository<Customer, String> {
    List<Customer> findByUsername(String name);
    List<Customer> findByPhone(String phone);
}
