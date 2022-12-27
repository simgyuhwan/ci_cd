package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.entity.Customer;
import com.example.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CustomerController.java
 * Class 설명을 작성하세요.
 *
 * @author sgh
 * @since 2022.12.26
 */
@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody CustomerDto customerDto){
        return this.customerService.saveCustomers(customerDto);
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
//        Assert.hasText("", "no message");
        return customerService.getCustomers();
    }

}
