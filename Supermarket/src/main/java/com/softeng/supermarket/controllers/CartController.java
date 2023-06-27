package com.softeng.supermarket.controllers;

import com.softeng.supermarket.models.Cart;
import com.softeng.supermarket.services.ShoppingCartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ShoppingCartService shoppingCartService;
    @PostMapping("/add")
    public @ResponseBody String addToCart(HttpSession session, Model model, @RequestParam("id") long id, @RequestParam("quantity") int quantity) throws Exception {
        try {
            Cart sessionCart=(Cart) session.getAttribute("Cart");
            if(sessionCart==null){
                Cart cart=shoppingCartService.addToCartFirstTime(id,quantity);
                session.setAttribute("Cart",cart);
            }
            else{
                Cart updatedCart=shoppingCartService.addToExistingCart(id,quantity,sessionCart);
                session.setAttribute("Cart",updatedCart);
            }
            return "Added to cart";
        }
        catch (Exception e){
            e.printStackTrace();
            return "Couldn't add item to cart...Please try again";
        }
    }

    @GetMapping("/view")
    public String viewCart(HttpSession session,Model model){
        Cart cart= (Cart) session.getAttribute("Cart");
        if(cart==null) model.addAttribute("mymessage","Your cart is empty");
        else {
        model.addAttribute("cartItems",cart.getCartItems() );
        }
        return "cartSection";
    }
}
