package com.example.booksellstore.controller;

import com.example.booksellstore.dto.ProductDetailInfo;
import com.example.booksellstore.dto.ProductInfo;
import com.example.booksellstore.model.Product;
import com.example.booksellstore.service.ProductService;
import com.example.booksellstore.service.UserCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserCartService userCartService;


    @GetMapping("/")
    public String getHomePage(Model model, @RequestParam(name = "Product", defaultValue = "1") String nameProduct, Product product, Long idProduct) {
        List<ProductInfo> productAsc = productService.getGroupPriceAsc();
        model.addAttribute("priceAsc", productAsc);
        System.out.println(productAsc.toString());

        List<ProductInfo> productDesc = productService.getGroupPriceDesc();
        model.addAttribute("priceDesc", productDesc);
        System.out.println(productDesc.toString());

        List<ProductInfo> productInf = productService.getProductName(nameProduct);
        model.addAttribute("productInf", productInf);
        System.out.println(productInf.toString());

        return "index";
    }

    @GetMapping("/product_detail/{id}")
    public String getProductDetailPage(Model model,
                              @RequestParam(name = "Product",defaultValue = "1") Long productId){

        List<ProductDetailInfo> productDetailDTOS = productService.getProductDetail(productId);
        model.addAttribute("productDetail", productDetailDTOS);
        System.out.println(productDetailDTOS.toString());
        return "index";
    }

    @PostMapping ("/add_product")
    public ResponseEntity<?> addProduct(Model model,@RequestBody Product product) {

         productService.createProduct(product);
         model.addAttribute("addProduct", product);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
