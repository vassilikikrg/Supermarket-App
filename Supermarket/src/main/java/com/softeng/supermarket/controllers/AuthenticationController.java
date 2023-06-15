package com.softeng.supermarket.controllers;

import com.softeng.supermarket.models.Admin;
import com.softeng.supermarket.models.Customer;
import com.softeng.supermarket.models.User;
import com.softeng.supermarket.repositories.AdminRepository;
import com.softeng.supermarket.repositories.CustomerRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private AdminRepository adminRepo;
    @Autowired
    private CustomerRepository customerRepos;
    //For customers
    //Login
    @GetMapping("/customer/login")
    public String displayLoginForm(Model model){
        model.addAttribute("customerModel", new Customer());
        return "login_form_customer";
    }
    @PostMapping("/customer/processLogin")
    public String processLogin(@Valid @ModelAttribute("customerModel") Customer customerModel, BindingResult bindingResult, HttpSession session, Model model){
        //with binding result,we take user input and send it to the controller to check if there was an error in the validation
        if(bindingResult.hasErrors()){
            //return the model to the form again
            model.addAttribute("customerModel",customerModel);
            return "login_form_customer";
        }
        model.addAttribute("customerModel",customerModel);
        session.setAttribute("username", customerModel.getUsername());
        return "redirect:/home";
    }

    //Register
    @GetMapping("/customer/register")
    public String displayRegisterForm(Model model){
        model.addAttribute("customerModel", new Customer());
        return "register_form_customer";
    }
    @PostMapping("/customer/processRegister")
    public String processRegister(@Valid @ModelAttribute("customerModel") Customer customerModel, BindingResult bindingResult,HttpSession session, Model model){
        //with binding result,we take user input and send it to the controller to check if there was an error in the validation
        if(bindingResult.hasErrors()){
            //return the model to the form again
            model.addAttribute("customerModel",customerModel);
            return "register_form_customer";
        }
        model.addAttribute("customerModel",customerModel);
        session.setAttribute("username", customerModel.getUsername());
        return "redirect:/home";
    }

    //For Admins
    //Login
    @GetMapping("/admin/login")
    public String displayLoginFormAdmin(Model model){
        model.addAttribute("adminModel", new Admin());
        return "login_form_admin";
    }
    @PostMapping("/admin/processLogin")
    public String processLoginAdmin(@Valid @ModelAttribute("adminModel") Admin adminModel, BindingResult bindingResult, HttpSession session, Model model){
        //with binding result,we take user input and send it to the controller to check if there was an error in the validation
        if(bindingResult.hasErrors()){
            //return the model to the form again
            model.addAttribute("adminModel",adminModel);
            return "login_form_admin";
        }
        model.addAttribute("adminModel",adminModel);
        session.setAttribute("username", adminModel.getUsername());
        return "redirect:/home";
    }

    //Logout
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("username");
        return "redirect:/home";
    }
}
