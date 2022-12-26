package com.example.dto;

import com.example.entity.Customer;
import com.example.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * OrderDto.java
 * Class 설명을 작성하세요.
 *
 * @author sgh
 * @since 2022.12.26
 */

@Builder
@AllArgsConstructor
@Data
public class OrderDto {

    private String orderStoreName;
    private String orderStoreAddress;
    private String orderItem;
    private int orderPrice;
    private Customer customer;

    public Orders toEntity(){
        return Orders.builder()
                .orderPrice(orderPrice)
                .orderStoreName(orderStoreName)
                .orderStoreAddress(orderStoreAddress)
                .customer(customer)
                .orderItem(orderItem)
                .build();
    }
}
