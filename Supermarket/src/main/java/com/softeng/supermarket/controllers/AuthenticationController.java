package com.softeng.supermarket.controllers;

import com.softeng.supermarket.models.Customer;
import com.softeng.supermarket.models.User;
import jakarta.servlet.http.HttpSession;
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
    //For customers
    //Login
    @GetMapping("/customer/login")
    public String displayLoginForm(Model model){
        model.addAttribute("userModel", new Customer());
        return "loginForm";
    }
    @PostMapping("/customer/processLogin")
    public String processLogin(@Valid @ModelAttribute("userModel") User userModel, BindingResult bindingResult, HttpSession session, Model model){
        //with binding result,we take user input and send it to the controller to check if there was an error in the validation
        if(bindingResult.hasErrors()){
            //return the model to the form again
            model.addAttribute("userModel",userModel);
            return "loginForm.html";
        }
        model.addAttribute("userModel",userModel);
        session.setAttribute("username", userModel.getUsername());
        return "redirect:/home";
    }
    //Register
    @GetMapping("/customer/register")
    public String displayRegisterForm(Model model){
        model.addAttribute("userModel", new Customer());
        return "registerForm";
    }
    @PostMapping("/customer/processRegister")
    public String processRegister(@Valid @ModelAttribute("userModel") User userModel, BindingResult bindingResult, Model model){
        //with binding result,we take user input and send it to the controller to check if there was an error in the validation
        if(bindingResult.hasErrors()){
            //return the model to the form again
            model.addAttribute("userModel",userModel);
            return "registerForm";
        }
        model.addAttribute("userModel",userModel);
        return "loginTest";
    }
    //Logout
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("username");
        return "redirect:/home";
    }
}
