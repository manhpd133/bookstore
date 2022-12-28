package com.example.booksellstore.service;

import com.example.booksellstore.dto.ProductInfo;
import com.example.booksellstore.reponsitory.ProductCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepo productCategoryRepo;

    public List<ProductInfo> getCategory1(){
        return productCategoryRepo.getByProduct1();
    }

    public List<ProductInfo> getCategory2(){
        return productCategoryRepo.getByProduct2();
    }
    public List<ProductInfo> getCategory4(){
        return productCategoryRepo.getByProduct4();

    }public List<ProductInfo> getCategory5(){
        return productCategoryRepo.getByProduct5();

    }public List<ProductInfo> getCategory6(){
        return productCategoryRepo.getByProduct6();
    }



}
