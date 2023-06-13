package com.softeng.supermarket.repositories;

import com.softeng.supermarket.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {
    List<User> findByUsername(String name);
    //List<User> findByPhone(String phone);
}
