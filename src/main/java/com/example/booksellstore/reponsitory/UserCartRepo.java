package com.example.booksellstore.reponsitory;

import com.example.booksellstore.dto.ProductDetailInfo;
import com.example.booksellstore.dto.UserCartDTO;
import com.example.booksellstore.model.UserCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserCartRepo extends JpaRepository<UserCart, Long> {
    Optional<UserCart> findById(Long aLong);

    @Query(value = "SELECT uc.id as id, uc.id_product as productId, p.name_product as nameProduct , uc.quantity as quantity, p.image as image, p.price as price" +
            " FROM user_cart uc" +
            " JOIN product p on p.productid = uc.id_product" ,nativeQuery = true)
    List<UserCartDTO> getUserCart();

    @Query(value ="INSERT INTO user_cart(id_product, quantity, id_user)" +
    " VALUES (?1,1,1)" ,nativeQuery = true)
    void addToCart(Long productID);

    @Transactional
    @Modifying
    @Query(value = "DELETE" +
            " FROM user_cart uc" +
            " WHERE uc.id =?",nativeQuery = true)
    int deleteCart(Long productId);


//    @Query("delete from  uc where uc.id =?1")
//    int deleteCart(Long productID);


}
