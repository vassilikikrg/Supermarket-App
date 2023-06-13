package com.softeng.supermarket.models;

import jakarta.persistence.Entity;

@Entity
public class Admin extends User{
    public Admin() {}

    public Admin(String username, String password, String email, String phone, String firstname, String lastname) {
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setPhone(phone);
        this.setFirstname(firstname);
        this.setLastname(lastname);
    }
}
