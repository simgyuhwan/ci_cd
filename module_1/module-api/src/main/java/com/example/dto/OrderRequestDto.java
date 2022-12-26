package com.example.dto;

import lombok.Data;

/**
 * OrderRequestDto.java
 * Class 설명을 작성하세요.
 *
 * @author sgh
 * @since 2022.12.26
 */

@Data
public class OrderRequestDto {

    private String orderStoreName;
    private String orderStoreAddress;
    private String orderItem;
    private int orderPrice;
    private Long customerId;
}
