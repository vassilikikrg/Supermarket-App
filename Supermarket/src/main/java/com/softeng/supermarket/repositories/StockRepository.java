package com.softeng.supermarket.repositories;

import com.softeng.supermarket.models.Stock;
import com.softeng.supermarket.foreign_keys.SupermarketProductKey;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StockRepository extends CrudRepository<Stock, SupermarketProductKey> {

}
