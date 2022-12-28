package com.example.booksellstore.service;

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
}
