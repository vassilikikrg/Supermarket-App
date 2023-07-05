package com.softeng.supermarket.controllers;

import com.softeng.supermarket.models.Product;
import com.softeng.supermarket.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class RestockController {
    @Autowired
    public ProductRepository productRepository;
    @GetMapping("/admin/restock")
    public String showAdminPanel(Model model) {
        model.addAttribute("product", new Product());
        return "restock";
    }
    @PostMapping("/admin/performRestock")
    public String restockProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/home";
    }
}
