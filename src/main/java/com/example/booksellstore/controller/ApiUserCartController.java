package com.example.booksellstore.controller;

import com.example.booksellstore.dto.UserCartDTO;
import com.example.booksellstore.model.UserCart;
import com.example.booksellstore.service.UserCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/")
public class ApiUserCartController {

    @Autowired
    private UserCartService userCartService;

    @GetMapping("user_cart")
    public List<UserCart> getUserCart(@RequestParam(name = "userCart", defaultValue = "1") Long userCartID) {
        List<UserCart> userCarts = userCartService.getUserCart();
        log.info(userCarts.toString());

        return userCarts;
    }

    @GetMapping("product_cart")
    public List<UserCartDTO> getUserCartPage(@RequestParam(name = "userCart", defaultValue = "1") Long userCartID) {
        List<UserCartDTO> userCart = userCartService.getProductCart();
        log.info(userCart.toString());

        return userCart;
    }

    @PostMapping("add_to_cart/{id}")
    public void addToCart(@PathVariable("id") long productId) {
        userCartService.addToCart(productId);
        System.out.println("thêm thành công");
    }

    @DeleteMapping("delete_cart/{id}")
    public int deleteCart(@PathVariable("id") long productId) {
        int userCartList = userCartService.deleteCart(productId);

        return userCartList;
    }
}
