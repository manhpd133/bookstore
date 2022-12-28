package com.example.booksellstore.controller;

import com.example.booksellstore.dto.ProductDetailInfo;
import com.example.booksellstore.dto.ProductInfo;
import com.example.booksellstore.dto.ProductResDTO;
import com.example.booksellstore.model.Product;
import com.example.booksellstore.model.ProductCategory;
import com.example.booksellstore.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/")
public class ApiProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public List<ProductResDTO> getProductPage(@RequestParam(name = "product", defaultValue = "1") Long idProduct) {

        List<ProductResDTO> productResDTOS = productService.getGroupProduct();
        log.info(productResDTOS.toString());


        return productResDTOS;
    }

    @GetMapping("/product_category")
    public List<ProductCategory> getProductCategoryPage(@RequestParam(name = "product_category", defaultValue = "1") Long idProductCategory) {

        List<ProductCategory> productCategories = productService.getAllProductCategory();
        log.info(productCategories.toString());

        return productCategories;
    }

    @GetMapping("/product_price_asc")
    public List<ProductInfo> getProductAscPage(@RequestParam(name = "product", defaultValue = "1") Long idProduct) {
        List<ProductInfo> productAsc = productService.getGroupPriceAsc();
        log.info(productAsc.toString());

        return productAsc;
    }

    @GetMapping("/product_price_desc")
    public List<ProductInfo> getProductDescPage(@RequestParam(name = "product", defaultValue = "1") Long idProduct) {

        List<ProductInfo> productDesc = productService.getGroupPriceDesc();
        log.info(productDesc.toString());
        return productDesc;
    }

    @GetMapping("/product_detail/{id}")
    public List<ProductDetailInfo> getProductDetailPage(@PathVariable(name = "id") long productId) {

        List<ProductDetailInfo> productDetailDTOS = productService.getProductDetail(productId);
        log.info(productDetailDTOS.toString());

        return productDetailDTOS;
    }

    @PostMapping("/add_product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {

        productService.createProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/")
    public List<Product> getPro(@RequestParam(name = "Product", defaultValue = "1") Long productId) {
        List<Product> products = productService.getPro();
        return products;
    }

    @PutMapping("/edit_product/{id}")
    public int updateProduct (@PathVariable("id") String nameProduct,float price, String img,long idProduct) {

        int products =  productService.updateProduct(nameProduct, price, img, idProduct);
        return products;
    }
    @DeleteMapping("/delete_product/{id}")
    public int delteProduct (@PathVariable("id") long productId) {

        int products = productService.deleteProductId(productId);
        return products;
    }

    @GetMapping("/find_name/{name}")
    public List<ProductInfo> getProductByName(@PathVariable(name = "name") String nameProduct) {

        List<ProductInfo> productInfos = productService.getProductName(nameProduct);
        log.info(productInfos.toString());
        return productInfos;
    }

}
