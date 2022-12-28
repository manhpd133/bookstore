package com.example.booksellstore.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * A DTO for the {@link com.example.booksellstore.model.Product} entity
 */
@Builder
@Data
public class ProductDto implements Serializable {
    private final long productID;
    private final String nameProduct;
    private final float price;
    private final String detail;
    private final int quantity;
    private final Date createdDate;
    private final String image;
    private final String author;
    private final String supplier;
    private final long categoryID;
    private final long productCategoryID;
}