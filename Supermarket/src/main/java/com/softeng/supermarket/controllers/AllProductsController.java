package com.softeng.supermarket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllProductsController {

    @GetMapping("/products")
    public String home(){

        return "allProducts.html";
    }
}
