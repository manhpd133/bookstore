package com.example.booksellstore.reponsitory;

import com.example.booksellstore.dto.ProductInfo;
import com.example.booksellstore.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepo extends JpaRepository<ProductCategory,Long> {
    ProductCategory findByName(String name);

//get product category Manga
    @Query( value = "SELECT p.productid,p.name_product as nameProduct,p.image,p.price" +
            " FROM product p " +
            " WHERE p.id_product_category = 1 ",nativeQuery = true)
    List<ProductInfo> getByProduct1();

//get product category Truyện
    @Query( value = "SELECT p.productid,p.name_product as nameProduct,p.image,p.price" +
        " FROM product p " +
        " WHERE p.id_product_category = 2 ",nativeQuery = true)
    List<ProductInfo> getByProduct2();

//get product category Đồ trang trí
    @Query( value = "SELECT p.productid,p.name_product as nameProduct,p.image,p.price" +
            " FROM product p " +
            " WHERE p.id_product_category = 4 ",nativeQuery = true)
    List<ProductInfo> getByProduct4();

    //get product category Đồ chơi
    @Query( value = "SELECT p.productid,p.name_product as nameProduct,p.image,p.price" +
            " FROM product p " +
            " WHERE p.id_product_category = 5 ",nativeQuery = true)
    List<ProductInfo> getByProduct5();

    //get product category Tiểu Thuyết
    @Query( value = "SELECT p.productid,p.name_product as nameProduct,p.image,p.price" +
            " FROM product p " +
            " WHERE p.id_product_category = 6 ",nativeQuery = true)
    List<ProductInfo> getByProduct6();
}
