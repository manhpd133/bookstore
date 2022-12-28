package com.example.booksellstore.controller;

import com.example.booksellstore.dto.ProductResDTO;
import com.example.booksellstore.model.UserCart;
import com.example.booksellstore.service.ProductService;
import com.example.booksellstore.service.UserCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserCartController {

    @Autowired
    private UserCartService userCartService;

    @Autowired
    private ProductService productService;


    @GetMapping("/user_cart")
    public String getUserCartPage(Model model,
                                  @RequestParam(name = "UserCart",defaultValue = "1") Long userCartID){

        List<UserCart> userCarts  = userCartService.getUserCart();
        model.addAttribute("userCart", userCarts);
        System.out.println(userCarts.toString());

        List<ProductResDTO> productResDTOS = productService.getGroupProduct();
        model.addAttribute("product", productResDTOS);
        System.out.println(productResDTOS.toString());

        return "index";
    }
}
