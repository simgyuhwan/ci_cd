package com.example.controller;

import com.example.dto.OrderRequestDto;
import com.example.entity.Orders;
import com.example.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * OrderController.java
 * Class 설명을 작성하세요.
 *
 * @author sgh
 * @since 2022.12.26
 */
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public List<Orders> getOrders(){
        return orderService.getOrders();
    }

    @PostMapping("/orders")
    public Orders saveOrders(@RequestBody OrderRequestDto orderRequestDto) throws Exception {
        return orderService.saveOrder(orderRequestDto);
    }
}
