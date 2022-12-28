package com.example.booksellstore.service;

import com.example.booksellstore.dto.OrderDTO;
import com.example.booksellstore.model.Order;
import com.example.booksellstore.reponsitory.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    public List<Order> deleteOrder() {
        return orderRepo.deleteOrderBy();
    }

    public List<OrderDTO> getAllOrderDetail() {
        return  orderRepo.getAllBy();
    }
}
