package com.example.dto;

import com.example.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CustomerDto.java
 * Class 설명을 작성하세요.
 *
 * @author sgh
 * @since 2022.12.26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private String customerNickName;
    private String customerAddress;

    public Customer toEntity(){
        return new Customer(this.customerNickName, this.customerAddress);
    }
}
