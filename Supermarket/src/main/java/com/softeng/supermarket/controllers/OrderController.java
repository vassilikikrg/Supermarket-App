package com.softeng.supermarket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    @GetMapping("/payment")
    public String pay(){

        return "Payment.html";
    }

}
