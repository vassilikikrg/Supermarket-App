package com.softeng.supermarket.models;

public class CartItem extends Product {
    private Integer quantity;

    public CartItem(Product product, Integer quantity) {
        super(product.getId(),product.getName(), product.getDescription(), product.getCategoryID(), product.getPrice(), product.getImageSource());
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
