package com.softeng.supermarket.models;

public class Product {
    private String Id;
    private String Name;
    private String Description;
    private String CategoryID;
    private String Price;
    private String ImageSource;

    public Product(String id, String name, String description, String categoryID, String price, String imageSource) {
        Id = id;
        Name = name;
        Description = description;
        CategoryID = categoryID;
        Price = price;
        ImageSource = imageSource;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
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
