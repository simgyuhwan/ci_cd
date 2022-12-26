package com.example.service;

import com.example.dto.CustomerDto;
import com.example.repository.ModuleCoreCustomerRepository;
import com.example.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CustomerService.java
 * Class 설명을 작성하세요.
 *
 * @author sgh
 * @since 2022.12.26
 */
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final ModuleCoreCustomerRepository customerRepository;

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Customer saveCustomers(CustomerDto customerDto){
        return this.customerRepository.save(customerDto.toEntity());
    }

}
