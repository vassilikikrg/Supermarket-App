package com.softeng.supermarket.models;

public class Product {
    private String Id;
    private String SupermarketId;
    private String CategoryID;
    private String Price;
    private String Info;
    private String Quantity;
    private String SourceOfImage;

    public Product(String id, String supermarketId, String categoryID, String price, String info, String quantity, String sourceOfImage) {
        Id = id;
        SupermarketId = supermarketId;
        CategoryID = categoryID;
        Price = price;
        Info = info;
        Quantity = quantity;
        SourceOfImage = sourceOfImage;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getSupermarketId() {
        return SupermarketId;
    }

    public void setSupermarketId(String supermarketId) {
        SupermarketId = supermarketId;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String categoryID) {
        CategoryID = categoryID;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getSourceOfImage() {
        return SourceOfImage;
    }

    public void setSourceOfImage(String sourceOfImage) {
        SourceOfImage = sourceOfImage;
    }
}
