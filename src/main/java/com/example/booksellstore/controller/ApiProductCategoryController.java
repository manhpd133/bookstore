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

    @GetMapping("category_manga")
    public List<ProductInfo> getProductCateManga(@RequestParam(name = "ProductCategory", defaultValue = "1") Long id) {
        List<ProductInfo> productCateManga = productCategoryService.getCategory1();
        log.info(productCateManga.toString());

        return productCateManga;
    }

    @GetMapping("category_story")
    public List<ProductInfo> getProductCateStory(@RequestParam(name = "ProductCategory", defaultValue = "1") Long id) {
        List<ProductInfo> productCateStory = productCategoryService.getCategory2();
        log.info(productCateStory.toString());

        return productCateStory;
    }

    @GetMapping("category_toy")
    public List<ProductInfo> getProductCateToy(@RequestParam(name = "ProductCategory", defaultValue = "1") Long id) {
        List<ProductInfo> productCateToy = productCategoryService.getCategory4();
        log.info(productCateToy.toString());

        return productCateToy;
    }
    @GetMapping("category_decorations")
    public List<ProductInfo> getProductCateDecorations(@RequestParam(name = "ProductCategory", defaultValue = "1") Long id) {
        List<ProductInfo> productCateDecorations = productCategoryService.getCategory5();
        log.info(productCateDecorations.toString());

        return productCateDecorations;
    }
    @GetMapping("category_novel")
    public List<ProductInfo> getProductCateNovel(@RequestParam(name = "ProductCategory", defaultValue = "1") Long id) {
        List<ProductInfo> productCateNovel = productCategoryService.getCategory6();
        log.info(productCateNovel.toString());

        return productCateNovel;
    }


}
