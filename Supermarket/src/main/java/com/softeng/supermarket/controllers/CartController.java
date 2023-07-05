package com.softeng.supermarket.controllers;

import com.softeng.supermarket.models.Cart;
import com.softeng.supermarket.models.CartItem;
import com.softeng.supermarket.models.Product;
import com.softeng.supermarket.services.ShoppingCartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ShoppingCartService shoppingCartService;
    @PostMapping("/add")
    public @ResponseBody String addToCart(HttpSession session, Model model, @RequestParam("id") long id, @RequestParam("quantity") int quantity,@RequestParam("storeId") String storeId, @RequestParam("maxStock") int maxStock) throws Exception {
        try {
            Cart sessionCart=(Cart) session.getAttribute("Cart");
            if(sessionCart==null){
                Cart cart=shoppingCartService.addToCartFirstTime(id,quantity,storeId,maxStock);
                session.setAttribute("Cart",cart);
            }
            else{
                Cart updatedCart=shoppingCartService.addToExistingCart(id,quantity,storeId,maxStock,sessionCart);
                session.setAttribute("Cart",updatedCart);
            }
            return "Added to cart";
        }
        catch (Exception e){
            e.printStackTrace();
            return "Couldn't add item to cart...Please try again";
        }
    }

    @GetMapping(path = "/view", produces = "application/json")
    public @ResponseBody List<CartItem> viewCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("Cart");
        return cart != null ? cart.getCartItems() : null;
    }


}
