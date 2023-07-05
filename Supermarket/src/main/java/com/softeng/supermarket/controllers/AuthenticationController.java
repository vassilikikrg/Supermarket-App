package com.softeng.supermarket.controllers;

import com.softeng.supermarket.models.Admin;
import com.softeng.supermarket.models.Customer;
import com.softeng.supermarket.models.User;
import com.softeng.supermarket.repositories.AdminRepository;
import com.softeng.supermarket.repositories.CustomerRepository;
import com.softeng.supermarket.services.AdminService;
import com.softeng.supermarket.services.CustomerService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthenticationController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AdminService adminService;

    //For customers
    //Login
    @GetMapping("/login")
    public String displayLoginForm(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login_form_customer";
        }
        return "redirect:/home";
    }

    //Register
    @GetMapping("/register")
    public String displayRegisterForm(Model model){
        model.addAttribute("customerModel", new Admin());
        return "register_form_customer";
    }
    @PostMapping("/processRegister")
    public String processRegister(@Valid @ModelAttribute("customerModel") Admin customerModel, BindingResult bindingResult, RedirectAttributes redirectAttrs){
        Customer customerExists=customerService.findCustomerByUsername(customerModel.getUsername());
        if(customerExists!=null){
            bindingResult
                    .rejectValue("userName", "error.user",
                            "There is already a user registered with the user name provided");
            return "register_form_customer";
        }
        if(bindingResult.hasErrors()){
            return "register_form_customer";
        }
        else {
            adminService.saveAdmin(customerModel);
            redirectAttrs.addFlashAttribute("mymessage","You are successfully registered! Please log in to continue.");
            return "redirect:/login";
        }
    }

    //For Admins

    //For testing(DOESNT WORK)
    //curl http://localhost:8080/add -d username=AdminTest -d password=123456789 -d email=a@tt.gr -d phone=6971826960 -d firstname=adminn -d lastname=testtt
    @PostMapping(path="/admin/register")
    public @ResponseBody String addAdmin(@RequestParam String username,@RequestParam String password,@RequestParam String email,@RequestParam String phone,@RequestParam String firstname,@RequestParam String lastname){
    try {
        Admin admin=new Admin(username,password,email,phone,firstname,lastname);
        adminService.saveAdmin(admin);
        return "Saved";
    }catch (Exception e){
        return "Failed to save";
        }
    }
    @GetMapping("/login/admin")
    public String displayAdminLoginForm(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login_admin";
        }
        return "redirect:/home";
    }

}
