package com.example.consumer;

import org.springframework.kafka.annotation.KafkaListener;

/**
 * OrderConsumer.java
 * Class 설명을 작성하세요.
 *
 * @author sgh
 * @since 2022.12.26
 */
public class OrderConsumer {

    @KafkaListener(topics = "order", groupId = "order-consumer")
    public void consume(String message){
        System.out.println("======================================");
        System.out.println(message);
        System.out.println("======================================");
    }
}
