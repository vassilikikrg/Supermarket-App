package com.softeng.supermarket.controllers;

import com.softeng.supermarket.foreign_keys.SupermarketProductKey;
import com.softeng.supermarket.models.Product;
import com.softeng.supermarket.models.Stock;
import com.softeng.supermarket.models.Supermarket;
import com.softeng.supermarket.repositories.ProductRepository;
import com.softeng.supermarket.repositories.StockRepository;
import com.softeng.supermarket.repositories.SupermarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.Optional;

@Controller

public class RestockController {
    @Autowired
    public ProductRepository productRepository;
    @Autowired
    public StockRepository stockRepository;
    @Autowired
    public SupermarketRepository supermarketRepository;
    @GetMapping("/admin/restock")
    public String showAdminRestockPanel(Model model) {
        model.addAttribute("product", new Product());
        return "restock";
    }
    @PostMapping(path="/admin/performRestock", produces = "application/json")
    public String restockProduct(@RequestParam("productId") long productId, @RequestParam("storeId") long storeId, @RequestParam("quantity") int quantity, RedirectAttributes redirectAttributes) throws Exception {
        try {
            SupermarketProductKey key = new SupermarketProductKey(storeId, productId);
            Optional<Stock> s = stockRepository.findById(key);
            if (s.isPresent()) {
                Iterable<Stock> stocks = Collections.singletonList(s.orElse(null));
                stocks.forEach(stock -> {
                    int existingQuantity=s.get().getQuantity();
                    s.get().setQuantity(quantity+existingQuantity);
                    stockRepository.save(s.get());
                });
            } else {
                Optional<Supermarket> smarket=supermarketRepository.findById(storeId);
                if(smarket.isPresent()){
                    Stock stock = new Stock();
                    stock.setId(key); // Set the SupermarketProductKey property
                    stock.setSupermarket(smarket.get());
                    stock.setQuantity(quantity);
                    stockRepository.save(stock);
                }
            }

            redirectAttributes.addFlashAttribute("successMessage", "Restock completed successfully");
            return "redirect:/admin/restock"; // Redirect to the restock panel page // IRO, THANK YOU NEXT!
        }
        catch (Exception e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "An error has occured during restock process...please try again");
            return "redirect:/admin/restock";
        }

    }

    @GetMapping("/admin/add")
    public String showAdminAddPanel(Model model) {
        model.addAttribute("product", new Product());
        return "addnewproduct";
    }

    @PostMapping("/admin/performAdd")
    public String addNewProduct(@ModelAttribute Product product,Model model) {
        Product productExists=productRepository.findByName(product.getName());
        if(productExists!=null){
            model.addAttribute("error","A product with the same name already exists in the system!");
            return "addnewproduct";
        }
        else {
            productRepository.save(product);
            return "add_product_complete";
        }
    }
}
