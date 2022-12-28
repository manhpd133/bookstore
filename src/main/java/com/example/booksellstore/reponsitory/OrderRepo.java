package com.example.booksellstore.reponsitory;

import com.example.booksellstore.dto.OrderDTO;
import com.example.booksellstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

        @Query(value = "SELECT o.orderid as orderId, o.quantity as quantity, o.ship_address as shipAddress , o.ship_phone as shipPhone, o.ship_name, o.status as status, o.total_amount as totalAmount, p.name_product as nameProduct, us.full_name as fullName, p.image as image " +
                "FROM orders o " +
                "JOIN product p on o.id_product = p.productid " +
                "JOIN users us on us.id_users = o.id_user", nativeQuery = true)
        List<OrderDTO> getAllBy();

        List<Order> deleteOrderBy();
}
