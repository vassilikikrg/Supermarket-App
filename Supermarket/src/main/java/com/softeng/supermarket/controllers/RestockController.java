package com.softeng.supermarket.controllers;

import com.softeng.supermarket.foreign_keys.SupermarketProductKey;
import com.softeng.supermarket.models.Product;
import com.softeng.supermarket.models.Stock;
import com.softeng.supermarket.repositories.ProductRepository;
import com.softeng.supermarket.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Optional;

@Controller

public class RestockController {
    @Autowired
    public ProductRepository productRepository;
    @Autowired
    public StockRepository stockRepository;
    @GetMapping("/admin/restock")
    public String showAdminRestockPanel(Model model) {
        model.addAttribute("product", new Product());
        return "restock";
    }
    @PostMapping("/admin/performRestock")
    public String restockProduct(@ModelAttribute Product product,@ModelAttribute("storeId") Long storeId,@ModelAttribute("quantity") int quantity) {
        SupermarketProductKey key = new SupermarketProductKey(storeId, product.getId());
        Optional<Stock> s = stockRepository.findById(key);
        Iterable<Stock> stocks = Collections.singletonList(s.orElse(null));
        stocks.forEach(stock -> {s.get().setQuantity(10);stockRepository.save(s.get());});
        return "redirect:/home"; // IRO, THANK YOU NEXT!
    }

    @GetMapping("/admin/add")
    public String showAdminAddPanel(Model model) {
        model.addAttribute("product", new Product());
        return "addnewproduct";
    }
}
