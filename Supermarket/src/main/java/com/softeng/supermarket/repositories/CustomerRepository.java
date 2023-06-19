package com.softeng.supermarket.repositories;

import com.softeng.supermarket.models.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
                                                            // TYPE  //  PK TYPE
public interface CustomerRepository  extends CrudRepository<Customer, String> {
    @Query("SELECT q FROM Customer q WHERE q.username = ?1")
    public Customer findByUsername(String name);
    List<Customer> findByPhone(String phone);
}
