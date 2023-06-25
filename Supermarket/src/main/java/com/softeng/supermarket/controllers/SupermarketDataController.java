package com.softeng.supermarket.controllers;

import com.softeng.supermarket.models.Supermarket;
import com.softeng.supermarket.repositories.SupermarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SupermarketDataController {

    @Autowired
    SupermarketRepository supermarketRepository;

    @GetMapping(path = "/getStores")
    public @ResponseBody Iterable<Supermarket> getSupermarkets(@RequestParam(value = "id", required = false) String supermarketID){
        if (supermarketID != null){
            return supermarketRepository.findById(supermarketID);
        }
        else {
            return supermarketRepository.findAll();
        }
    }
}
