package com.softeng.supermarket.repositories;

import com.softeng.supermarket.models.Product;
import com.softeng.supermarket.models.Stock;
import com.softeng.supermarket.foreign_keys.SupermarketProductKey;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockRepository extends CrudRepository<Stock, SupermarketProductKey> {
    List<Stock> findAllById_ProductId(Long productId);
}
