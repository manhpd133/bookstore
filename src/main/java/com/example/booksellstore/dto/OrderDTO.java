package com.example.booksellstore.dto;

public interface OrderDTO {
    long getOrderID();

    String getFullName();

    boolean isStatus();

    String getNameProduct();

    String getImage();

    int getQuantity();

    float getTotalAmount();

    String getShip_name();

    String getShipPhone();

    String getShipAddress();


}
