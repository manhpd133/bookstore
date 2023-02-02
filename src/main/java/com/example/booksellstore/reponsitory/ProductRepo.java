package com.example.booksellstore.reponsitory;

import com.example.booksellstore.dto.ProductDetailInfo;
import com.example.booksellstore.dto.ProductInfo;
import com.example.booksellstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Query(value = "Select p.productid as productID,p.name_product as nameProduct,p.image as image,p.price as price " + "from  product p " + "order by p.price ASC ", nativeQuery = true)
    List<ProductInfo> getProductsByPriceAsc();

    @Query(value = "Select p.productid as productID,p.name_product as nameProduct,p.image as image,p.price as price " + "from  product p " + "order by p.price DESC ", nativeQuery = true)
    List<ProductInfo> getProductsByPriceDesc();

    @Query(value = "Select p. productid as productId,p. name_product as nameProduct,p. image as image,p. price as price, p.detail as detail, p.author as author, p.supplier as supplier, p.quantity as quantity, p.created_date as createdDate" +
            " from product p " ,nativeQuery = true)
    List<ProductDetailInfo> getProductsByDetail();

    @Query(value = "Select p. productid as productId,p. name_product as nameProduct,p. image as image,p. price as price, p.detail as detail, p.author as author, p.supplier as supplier, p.quantity as quantity, p.created_date as createdDate" +
            " from product p " +
            "where p.productid = ?1",nativeQuery = true)
    List<ProductDetailInfo> getProductsDetail(long idProduct);


    @Query( value = "Select p.productid as productID, p.name_product as nameProduct,p.image,p.price " +
            "from product p " +
            "where p.name_product LIKE CONCAT('%',?1,'%') ",nativeQuery = true)
    List<ProductInfo> findByNameProduct(String nameProduct);

    @Transactional
    @Modifying
    @Query("delete from Product p where p.productID = ?1")
    int deleteByProductID(long productID);

    List<Product> getAllBy();

    @Transactional
    @Modifying
    @Query("update Product p set p.nameProduct = ?1, p.price = ?2, p.image = ?3 where p.productID = ?4")
    int updateProduct( long productID);

}
