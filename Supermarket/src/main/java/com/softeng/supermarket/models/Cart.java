package com.softeng.supermarket.models;

import java.util.List;

public class Cart {
    private String Id;
    private List<Product> products;

    public Cart(String id, List<Product> products) {
        Id = id;
        this.products = products;
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
