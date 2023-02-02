package com.example.booksellstore.service;

import com.example.booksellstore.dto.UserCartDTO;
import com.example.booksellstore.model.UserCart;
import com.example.booksellstore.reponsitory.UserCartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCartService {

    @Autowired
    private UserCartRepo userCartRepo;

    public List<UserCart> getUserCart() {
        return userCartRepo.findAll();
    }

    public  List<UserCartDTO> getProductCart() {
        return userCartRepo.getUserCart();
    }

    public void addToCart(long productId) {
        UserCart userCart = UserCart.builder()
                .userId(1L)
                .quantity(1)
                .productID(productId).build();
         userCartRepo.save(userCart);
    }

    public int deleteCart(long productId) {
        return userCartRepo.deleteCart(productId);
    }
}
