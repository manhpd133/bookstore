package com.example.booksellstore.dto;

/**
 * A Projection for the {@link com.example.booksellstore.model.UserCart} entity
 */
public interface UserCartInfo {
    long getUserCartID();

    int getQuantity();
}