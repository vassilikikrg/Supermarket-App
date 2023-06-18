package com.softeng.supermarket.controllers;

import ch.qos.logback.core.model.Model;
import com.softeng.supermarket.models.Product;
import com.softeng.supermarket.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @GetMapping("/product")
    public String productPage(Model model){
        //model.addAttribute("product",new Product());
        return "productPage";
    }

    // For testing
    // curl http://localhost:8080/add -d name=Γαλα -d desc=Γαλα ελληνικό -d catID=Γαλακτοκομικά -d price=3
    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewProduct (@RequestParam String name, @RequestParam String desc, @RequestParam String catID, @RequestParam String price) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Product p = new Product();
        p.setName(name);
        p.setDescription(desc);
        p.setCategoryID(catID);
        p.setPrice(price);
        productRepository.save(p);
        return "Saved";
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Product> getAllUsers() {
        // This returns a JSON or XML with the users
        return productRepository.findAll();
    }
}
