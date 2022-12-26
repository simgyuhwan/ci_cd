package com.example.repository;

import com.example.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ModuleCoreOrderRepository.java
 * Class 설명을 작성하세요.
 *
 * @author sgh
 * @since 2022.12.26
 */
public interface ModuleCoreOrderRepository extends JpaRepository<Orders, Long> {
}
