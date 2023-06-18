package com.softeng.supermarket.repositories;

import com.softeng.supermarket.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {
    Product findById(long id);
}
