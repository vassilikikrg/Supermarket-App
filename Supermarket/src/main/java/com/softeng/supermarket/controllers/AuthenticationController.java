package com.softeng.supermarket.controllers;

import com.softeng.supermarket.models.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String processLogin(@Valid @ModelAttribute("userModel") User userModel, BindingResult bindingResult, Model model){
        //with binding result,we take user input and send it to the controller to check if there was an error in the validation
        if(bindingResult.hasErrors()){
            //return the model to the form again
            model.addAttribute("userModel",userModel);
            return "loginForm.html";
        }
        model.addAttribute("userModel",userModel);
        return "loginTest";
    }
}
