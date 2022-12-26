package com.example.entity;

import com.example.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

/**
 * Orders.java
 * Class 설명을 작성하세요.
 *
 * @author sgh
 * @since 2022.12.26
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
public class Orders extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column
    private String orderUUID;

    @Column
    @NonNull
    private String orderStoreName;

    @Column
    @NonNull
    private String orderStoreAddress;

    @Column
    @NonNull
    private String orderItem;

    @Column
    @NonNull
    private int orderPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="customerId")
    private Customer customer;

    @Builder
    public Orders(@NonNull String orderStoreName, @NonNull String orderStoreAddress, @NonNull String orderItem, int orderPrice, Customer customer) {
        this.orderStoreName = orderStoreName;
        this.orderStoreAddress = orderStoreAddress;
        this.orderItem = orderItem;
        this.orderPrice = orderPrice;
        this.customer = customer;
    }
}
