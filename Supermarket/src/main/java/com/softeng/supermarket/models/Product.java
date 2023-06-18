package com.softeng.supermarket.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long Id;
    private String Name;
    private String Description;
    private String CategoryID;
    private String Price;
    private String ImageSource;

    public Product() {
    }

    public Product(long id, String name, String description, String categoryID, String price, String imageSource) {
        Id = id;
        Name = name;
        Description = description;
        CategoryID = categoryID;
        Price = price;
        ImageSource = imageSource;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getImageSource() {
        return ImageSource;
    }

    public void setImageSource(String imageSource) {
        ImageSource = imageSource;
    }
}
