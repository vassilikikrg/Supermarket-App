package com.softeng.supermarket.foreign_keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public
class SupermarketProductKey implements Serializable {
    public SupermarketProductKey(Long supId, Long prodId){
        supermarketId=supId;
        productId=prodId;
    }
    public SupermarketProductKey() {
    }

    @Column(name = "supermarket_id")
    private Long supermarketId;

    @Column(name = "product_id")
    private Long productId;

    // Constructors, equals, and hashCode methods
}
