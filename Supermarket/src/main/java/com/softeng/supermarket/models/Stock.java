package com.softeng.supermarket.models;

import com.softeng.supermarket.foreign_keys.SupermarketProductKey;
import jakarta.persistence.*;

@Entity
@Table(name = "supermarket_products")
public class Stock {
    @EmbeddedId
    private SupermarketProductKey id;

    @ManyToOne
    @MapsId("supermarketId")
    private Supermarket supermarket;

    private int quantity;

    public SupermarketProductKey getId() {
        return id;
    }

    public void setId(SupermarketProductKey id) {
        this.id = id;
    }

    public Supermarket getSupermarket() {
        return supermarket;
    }

    public void setSupermarket(Supermarket supermarket) {
        this.supermarket = supermarket;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

