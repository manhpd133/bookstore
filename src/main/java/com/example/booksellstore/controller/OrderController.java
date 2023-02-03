package com.example.booksellstore.controller;

import com.example.booksellstore.dto.OrderDTO;
import com.example.booksellstore.model.Order;
import com.example.booksellstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public String getOrderPage(Model model, @RequestParam(name = "Order",defaultValue = "1") Long orderId){
        List<OrderDTO> orderDTOS = orderService.getAllOrderDetail();
        model.addAttribute("orderDetailList", orderDTOS);
        System.out.println(orderDTOS.toString());

        return "index";
    }

    @DeleteMapping("/delete_order")
    public String deleteOrderPage(Model model, @RequestParam(name = "Order",defaultValue = "1") Long orderId){
        List<Order> orderInfoList = orderService.deleteOrder();
        model.addAttribute("deleteOrder", orderInfoList);
        System.out.println(orderInfoList.toString());

        return "index";
    }

}
