package com.softeng.supermarket.controllers;

import com.softeng.supermarket.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
    @GetMapping("/payment")
    public String pay(){

        return "Payment.html";
    }

    @GetMapping("/order")
    public String order(){

        return "order.html";
    }

    @GetMapping("/orderComplete")
    public String orderComplete(){

        return "thank_you_order.html";
    }

}
