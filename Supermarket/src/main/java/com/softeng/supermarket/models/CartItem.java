package com.softeng.supermarket.models;

public class CartItem extends Product {
    private Integer quantity;
    private Integer maxStock;
    private String storeId;

    public CartItem(Product product, Integer quantity,String storeId,Integer maxStock) {
        super(product.getId(),product.getName(), product.getDescription(), product.getCategoryID(), product.getPrice(), product.getImageSource());
        this.quantity = quantity;
        this.maxStock=maxStock;
        this.storeId=storeId;
    }

    /// For Jackson JS
    public CartItem(){}

    public CartItem(int id, String name, String description, String categoryID, String price, String imageSource, int quantity, int maxStock, String storeId) {
        super(id, name, description, categoryID, price, imageSource);
        this.quantity = quantity;
        this.maxStock = maxStock;
        this.storeId = storeId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Integer getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
