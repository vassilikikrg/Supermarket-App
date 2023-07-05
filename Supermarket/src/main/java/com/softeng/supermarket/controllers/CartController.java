package com.softeng.supermarket.controllers;

import com.softeng.supermarket.models.Cart;
import com.softeng.supermarket.models.CartItem;
import com.softeng.supermarket.models.Product;
import com.softeng.supermarket.services.ShoppingCartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    @PostMapping("/update")
    public ResponseEntity<List<CartItem>> updateCart(@RequestBody String updatedCartItemsJson, HttpSession session) {

        try {
            // Create an instance of ObjectMapper from Jackson library
            ObjectMapper objectMapper = new ObjectMapper();
            // Convert the JSON string into a List<CartItem>
            List<CartItem> updatedCartItems = objectMapper.readValue(updatedCartItemsJson, new TypeReference<List<CartItem>>() {});
            // Fetch the current cart from the session
            Cart cart = (Cart) session.getAttribute("Cart");

            if (cart != null) {
                // Update the quantities of cart items based on the received updatedCartItems
                cart = shoppingCartService.updateCart(cart, updatedCartItems);

                // Save the updated cart back to the session
                session.setAttribute("Cart", cart);

                // Return the updated cart items as a response
                return ResponseEntity.ok(cart.getCartItems());
            } else {
                // Cart not found in the session, handle this situation based on your requirements
                // For example, you might want to create a new cart or handle it differently
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Return an error response in case of any exceptions during the update process
            return ResponseEntity.status(500).build();
        }
    }
}
