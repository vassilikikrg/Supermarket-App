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
    List<User> users = List.of(
            new User("johny","12345","john@unipi.gr"),
            new User("maro","12345","mar1@webmail.cs.unipi.gr")
    );
    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model){
        String result = "No user found...";
        Optional<User> userOptional = users.stream()
                .filter(u->user.getUsername().equals(u.getUsername()) && user.getPassword().equals(u.getPassword()))
                .findAny();
        if (userOptional.isPresent()){
            result = "Login sucess! Your e-mail is:"+userOptional.get().getEmail();
        }
        model.addAttribute("message",result);
        return "hellopage";
    }

    @GetMapping("/home")
    public String home(){

        return "productPage.html";
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("user",new User());
        return "loginpage";
    }
}
