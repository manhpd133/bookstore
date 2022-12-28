package com.example.booksellstore.controller;

import com.example.booksellstore.model.UserCart;
import com.example.booksellstore.service.UserCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/")
public class ApiUserCartController {

    @Autowired
    private UserCartService userCartService;

    @GetMapping("user_cart")
    public List<UserCart> getUserCartPage(@RequestParam(name = "userCart", defaultValue = "1") Long userCartID) {

        List<UserCart> userCarts = userCartService.getUserCart();
        log.info(userCarts.toString());

        return userCarts;
    }
}
