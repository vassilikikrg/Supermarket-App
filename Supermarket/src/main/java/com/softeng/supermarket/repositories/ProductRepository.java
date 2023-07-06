package com.softeng.supermarket.repositories;

import com.softeng.supermarket.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Iterable<Product> findByCategoryID(String catID);

    Iterable<Product> findById(String id);

    Iterable<Product> findByPriceLessThanEqual(String price);

    Product findByName(String name);


}
