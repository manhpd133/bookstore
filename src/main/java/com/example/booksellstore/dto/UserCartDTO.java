package com.example.booksellstore.dto;

public interface UserCartDTO {
    Long getId();
    Long getProductID();
    int getQuantity();
    String getNameProduct();
    Float getPrice();
    String getImage();
}
