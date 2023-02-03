package com.example.booksellstore.controller;

import com.example.booksellstore.dto.OrderDTO;
import com.example.booksellstore.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/")
public class ApiOrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public List<OrderDTO> getOrderPage( @RequestParam(name = "Order",defaultValue = "1") Long orderId){
        List<OrderDTO> orderDTOS = orderService.getAllOrderDetail();
        log.info(orderDTOS.toString());

        return orderDTOS;
    }
}
