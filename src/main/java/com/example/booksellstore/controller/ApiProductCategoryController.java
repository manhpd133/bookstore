package com.example.booksellstore.controller;

import com.example.booksellstore.dto.ProductInfo;
import com.example.booksellstore.service.ProductCategoryService;
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
public class ApiProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("category_menu1")
    public List<ProductInfo> getProductCate1Page(@RequestParam(name = "ProductCategory", defaultValue = "1") Long id) {

        List<ProductInfo> productCate1 = productCategoryService.getCategory1();
        log.info(productCate1.toString());

        return productCate1;
    }

    @GetMapping("category_menu2")
    public List<ProductInfo> getProductCate2Page(@RequestParam(name = "ProductCategory", defaultValue = "1") Long id) {

        List<ProductInfo> productCate2 = productCategoryService.getCategory2();
        log.info(productCate2.toString());

        return productCate2;
    }

    @GetMapping("category_menu4")
    public List<ProductInfo> getProductCate4Page(@RequestParam(name = "ProductCategory", defaultValue = "1") Long id) {

        List<ProductInfo> productCate4 = productCategoryService.getCategory4();
        log.info(productCate4.toString());

        return productCate4;
    }
    @GetMapping("category_menu5")
    public List<ProductInfo> getProductCate5Page(@RequestParam(name = "ProductCategory", defaultValue = "1") Long id) {

        List<ProductInfo> productCate5 = productCategoryService.getCategory5();
        log.info(productCate5.toString());

        return productCate5;
    }
    @GetMapping("category_menu6")
    public List<ProductInfo> getProductCate6Page(@RequestParam(name = "ProductCategory", defaultValue = "1") Long id) {

        List<ProductInfo> productCate6 = productCategoryService.getCategory6();
        log.info(productCate6.toString());

        return productCate6;
    }


}
