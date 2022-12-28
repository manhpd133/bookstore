package com.example.booksellstore.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

/**
 * A Projection for the {@link com.example.booksellstore.model.Product} entity
 */
public interface ProductDetailInfo {
    long getProductID();

    String getNameProduct();

    float getPrice();

    String getDetail();

    int getQuantity();

    @JsonFormat(pattern="yyyy-MM-dd")
    Date getCreatedDate();

    String getImage();

    String getAuthor();

    String getSupplier();
}