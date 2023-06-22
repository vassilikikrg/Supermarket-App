package com.softeng.supermarket.controllers;

import com.softeng.supermarket.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class WebController {
    @GetMapping("/login")
    public String displayLoginForm(Model model){
        return "login_form_customer";
    }

   @GetMapping("/customer")
   public String loginPage(){
        return "hellopage";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "hellopage";
    }
    @GetMapping("/403")
    public String accessDenied(){
        return "403.html";
    }
}
