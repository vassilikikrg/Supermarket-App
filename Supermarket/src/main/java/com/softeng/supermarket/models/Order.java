package com.softeng.supermarket.models;

import java.util.List;

public class Order {
    private String Id;
    private String UserId;
    private List<Product> products;

    public Order(String id, String userId, List<Product> products) {
        Id = id;
        UserId = userId;
        this.products = products;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
