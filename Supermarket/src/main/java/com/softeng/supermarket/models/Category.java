package com.softeng.supermarket.models;

public class Category {
    private String Id;
    private String Name;
    private String Description;

    public Category(String id, String name, String description) {
        Id = id;
        Name = name;
        Description = description;
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
}
