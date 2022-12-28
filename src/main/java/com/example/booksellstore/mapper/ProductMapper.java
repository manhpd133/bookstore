package com.example.booksellstore.mapper;

import com.example.booksellstore.dto.ProductResDTO;
import com.example.booksellstore.model.Product;

public class ProductMapper {
    public static ProductResDTO toProductDTO(Product product) {
        ProductResDTO productResDTO = new ProductResDTO();
        productResDTO.setProductID(product.getProductID());
        productResDTO.setNameProduct(product.getNameProduct());
        productResDTO.setPrice(product.getPrice());
        productResDTO.setImage(product.getImage());
        return productResDTO;
    }
}
