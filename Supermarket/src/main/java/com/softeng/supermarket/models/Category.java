package com.softeng.supermarket.models;

import java.util.List;

public class Category {
    private String Id;
    private String Name;
    private List<SubCategory> categoryList;

    public Category(String id, String name, String description) {
        Id = id;
        Name = name;
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

    public List<SubCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<SubCategory> categoryList) {
        this.categoryList = categoryList;
    }
}
