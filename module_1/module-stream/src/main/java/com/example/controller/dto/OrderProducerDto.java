package com.example.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * OrderProducerDto.java
 * Class 설명을 작성하세요.
 *
 * @author sgh
 * @since 2022.12.26
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class OrderProducerDto {
    private String orderStoreName;
    private String orderStoreAddress;
    private String orderItem;
    private String orderPrice;
    private int customerId;
}
