package com.example.entity;

import com.example.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

/**
 * Cusotmer.java
 * Class 설명을 작성하세요.
 *
 * @author sgh
 * @since 2022.12.26
 */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NonNull
    @Column
    private String customerNickName;

    @NonNull
    @Column
    private String customerAddress;

    public Customer(@NonNull String customerNickName, @NonNull String customerAddress) {
        this.customerNickName = customerNickName;
        this.customerAddress = customerAddress;
    }
}
