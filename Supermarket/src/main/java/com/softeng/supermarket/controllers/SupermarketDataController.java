package com.softeng.supermarket.controllers;

import com.softeng.supermarket.models.Supermarket;
import com.softeng.supermarket.repositories.SupermarketRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

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

    @PostMapping(path = "/setStore", produces = "application/json")
    public String setSelectedStore(@RequestParam(value = "id", required = true) Long productId, @RequestParam(value = "supermarket_id", required = true) Long supermarketId, HttpSession session) {
        if(session.getAttribute("store")==null) {
            session.setAttribute("store", supermarketId);
            Optional<Supermarket> supermarket = supermarketRepository.findById(supermarketId);
            if (supermarket.isPresent()) {
                session.setAttribute("storeName", supermarket.get().getName());
            }
        }
        return "redirect:/productPage?id=" + productId; // Redirect to a success page
    }

}
