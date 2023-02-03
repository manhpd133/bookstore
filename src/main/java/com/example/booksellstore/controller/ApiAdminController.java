package com.example.booksellstore.controller;

import com.example.booksellstore.model.Product;
import com.example.booksellstore.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/admin/")
public class ApiAdminController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add_product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        productService.createProduct(product);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit_product/{id}")
    public int updateProduct (@PathVariable("id") long idProduct) {
        int products =  productService.updateProduct(idProduct);

        return products;
    }
    @DeleteMapping("/delete_product/{id}")
    public int delteProduct (@PathVariable("id") long productId) {
        int products = productService.deleteProductId(productId);

        return products;
    }
}
