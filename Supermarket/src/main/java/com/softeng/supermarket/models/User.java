package com.softeng.supermarket.models;

public class User {

    private String Username;
    private String Password;
    private String Email;
    private String Phone;
    private String Firstname;
    private String Lastname;
    private Boolean isAdmin;

    public User() {
    }

    public User(String username, String password, String email) {
        this.Username = username;
        this.Password = password;
        this.Email = email;
    }

    public User(String username, String password, String email, String phone, String firstname, String lastname, Boolean isAdmin) {
        Username = username;
        Password = password;
        Email = email;
        Phone = phone;
        Firstname = firstname;
        Lastname = lastname;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {Username = username;}

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) { Password = password; }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}

