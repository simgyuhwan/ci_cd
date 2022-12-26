package com.example.repository;

import com.example.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ModuleCoreCustomerRepository.java
 * Class 설명을 작성하세요.
 *
 * @author sgh
 * @since 2022.12.26
 */
public interface ModuleCoreCustomerRepository extends JpaRepository<Customer, Long> {

}
