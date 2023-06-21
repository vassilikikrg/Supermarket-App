package com.softeng.supermarket.repositories;

import com.softeng.supermarket.models.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
                                                        // TYPE  //  PK TYPE
public interface AdminRepository  extends CrudRepository<Admin, String> {
    @Query("SELECT a FROM Admin a WHERE a.username = ?1")
    Admin findByUsername(String name);
    List<Admin> findByPhone(String phone);
}
