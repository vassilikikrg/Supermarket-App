package com.softeng.supermarket.models;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Cart {
    private List<CartItem> cartItems;
    public Cart(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
    //custom functions
    public void addItem(CartItem cartItem){
        this.cartItems.add(cartItem);
    }
    public boolean updateQuantity(long productId,Integer newQuantity){
        if(this.containsProduct(productId)){
            CartItem cartItem= this.cartItems.stream()
                    .filter(item->item.getId()==productId)
                    .findFirst()
                    .get();//access cart item with the specific product id

            cartItem.setQuantity(newQuantity); //update the Quantity
            return true;
        }
        return false;
    }
    public boolean containsProduct(long productId) { //checks if cartItems list contains a product with a certain product id
        return this.cartItems
                .stream()
                .anyMatch(item -> item.getId()==productId);
    }
}
