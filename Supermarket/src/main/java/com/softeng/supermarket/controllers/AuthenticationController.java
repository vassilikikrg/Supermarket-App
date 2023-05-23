package com.softeng.supermarket.controllers;

import com.softeng.supermarket.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    @GetMapping("/login")
    public String displayLoginForm(Model model){
        model.addAttribute("userModel", new User());
        return "loginForm";
    }
    @PostMapping("/processLogin")
    public String processLogin(User userModel,Model model){
        model.addAttribute("userModel",userModel);
        return "loginTest";
    }
}
