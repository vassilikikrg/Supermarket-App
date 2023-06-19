package com.softeng.supermarket.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "customer")
public class Customer extends User{
    public Customer() {}

    public Customer(String username, String password, String email, String phone, String firstname, String lastname) {
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setPhone(phone);
        this.setFirstname(firstname);
        this.setLastname(lastname);
    }
}
