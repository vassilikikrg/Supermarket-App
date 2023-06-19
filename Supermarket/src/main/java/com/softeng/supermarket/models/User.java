package com.softeng.supermarket.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class User {
    @Id
    @NotBlank(message = "Username is required")
    @Size(min=5,max=15,message = "Username must be between 5 and 15 characters")
    private String username;
    @Column
    @NotBlank(message = "Password is required")
    private String password;
    @Column(nullable = false)
    private String email;
    @Column
    private String phone;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { this.password = password; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}

