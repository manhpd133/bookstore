package com.example.booksellstore.service;

import com.example.booksellstore.dto.ProductDetailInfo;
import com.example.booksellstore.dto.ProductInfo;
import com.example.booksellstore.dto.ProductResDTO;
import com.example.booksellstore.mapper.ProductMapper;
import com.example.booksellstore.model.Product;
import com.example.booksellstore.model.ProductCategory;
import com.example.booksellstore.reponsitory.ProductRepo;
import com.example.booksellstore.reponsitory.ProductCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductCategoryRepo productcategoryRepo;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<ProductResDTO> getGroupProduct() {
        List<Product> products = productRepo.findAll();
        List<ProductResDTO> productResDTOS = new ArrayList<>();
        for (Product product: products) {
            productResDTOS.add(ProductMapper.toProductDTO(product));
        }
        return productResDTOS;
    }
    public List<ProductCategory> getAllProductCategory() {
        return productcategoryRepo.findAll();
    }

    public List<ProductInfo> getGroupPriceAsc() {
        return productRepo.getProductsByPriceAsc();
    }

    public List<ProductInfo> getGroupPriceDesc() {
        return productRepo.getProductsByPriceDesc();
    }

    public List<ProductDetailInfo> getProductDetail(long idProduct) {
        return productRepo.getProductsDetail(idProduct);
    }

    public List<ProductDetailInfo> getProductByDetail() {
        return productRepo.getProductsByDetail();
    }

    public List<ProductInfo> getProductName(String nameProduct) {
        return productRepo.findByNameProduct(nameProduct);
    }

    public List<Product> getPro() {
        return productRepo.getAllBy();
    }

//    public ResponseEntity<Product> handEditProduct(long productId, Product product) {
//        Optional<Product> productData = productRepo.findById(productId);
//        if (productData.isPresent()) {
//            Product productEdit = productData.get();
//            productEdit.setNameProduct(product.getNameProduct());
//            productEdit.setPrice(product.getPrice());
//            productEdit.setDetail(product.getDetail());
//            productEdit.setCreatedDate(product.getCreatedDate());
//            productEdit.setImage(product.getImage());
//            productEdit.setAuthor(product.getAuthor());
//            productEdit.setSupplier(productEdit.getSupplier());
//            productEdit.setCategoryID(product.getCategoryID());
//            productEdit.setProductCategoryID(product.getProductCategoryID());
//
//            return new ResponseEntity<>(productRepo.save(productEdit), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    public ResponseEntity<Product> createProduct(Product product) {
        try {
            Product productAdd = productRepo.save(new Product(
                    product.getProductID(), product.getNameProduct(), product.getPrice(), product.getDetail(), product.getQuantity(),
                    product.getCreatedDate(),product.getImage(), product.getAuthor(), product.getSupplier()
                    ,product.getCategoryID(), product.getProductCategoryID())
            );
            return new ResponseEntity<>(productAdd, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public int deleteProductId( long idProduct){
        return productRepo.deleteByProductID(idProduct);
    }

    public int updateProduct(long idProduct) {
        return productRepo.updateProduct(idProduct);
    }
}
