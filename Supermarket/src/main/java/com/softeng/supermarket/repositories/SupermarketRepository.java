package com.softeng.supermarket.repositories;

import com.softeng.supermarket.models.Supermarket;
import org.springframework.data.repository.CrudRepository;

public interface SupermarketRepository extends CrudRepository<Supermarket, Long> {

    Iterable<Supermarket> findById(String id);

}
