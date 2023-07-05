package com.softeng.supermarket.controllers;

import com.softeng.supermarket.models.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class WebController {
    @GetMapping("/403")
    public String accessDenied(){
        return "403.html";
    }

    @GetMapping("/clearSession")
    public String clearSession(HttpSession session, @RequestParam(value = "product_id", required = true) String productId){
        session.removeAttribute("store");
        session.removeAttribute("storeName");
        session.removeAttribute("Cart");
        return "redirect:/productPage?id="+productId;
    }
}
