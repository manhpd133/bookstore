package com.example.booksellstore.dto;

/**
 * A Projection for the {@link com.example.booksellstore.model.Product} entity
 */
public interface ProductInfo {
    Long getProductID();

    String getNameProduct();

    Float getPrice();

    String getImage();
}