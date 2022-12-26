package com.example.service;

import com.example.dto.OrderDto;
import com.example.dto.OrderRequestDto;
import com.example.repository.ModuleCoreCustomerRepository;
import com.example.repository.ModuleCoreOrderRepository;
import com.example.entity.Customer;
import com.example.entity.Orders;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * OrderService.java
 * Class 설명을 작성하세요.
 *
 * @author sgh
 * @since 2022.12.26
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final ModuleCoreOrderRepository orderRepository;
    private final ModuleCoreCustomerRepository customerRepository;

    public Orders saveOrder(OrderRequestDto orderRequestDto) throws Exception {
        Customer customer = customerRepository.findById(orderRequestDto.getCustomerId()).get();
        Orders order;
        if (customer != null) {
            order = OrderDto.builder()
                    .orderItem(orderRequestDto.getOrderItem())
                    .orderStoreName(orderRequestDto.getOrderStoreName())
                    .orderStoreAddress(orderRequestDto.getOrderStoreAddress())
                    .orderPrice(orderRequestDto.getOrderPrice())
                    .customer(customer)
                    .build().toEntity();
            orderRepository.save(order);
        } else {
            throw new Exception("customer 가 없습니다. ");
        }

        return order;
    }

    public List<Orders> getOrders(){
        return orderRepository.findAll();
    }

}
