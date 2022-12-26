package com.example.producer;

import com.example.controller.dto.OrderProducerDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * OrderProducer.java
 * Class 설명을 작성하세요.
 *
 * @author sgh
 * @since 2022.12.26
 */
@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final String KAFKA_ORDER_TOPIC = "order";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendOrderMessage(OrderProducerDto message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonMessage = objectMapper.writeValueAsString(message);

        kafkaTemplate.send(KAFKA_ORDER_TOPIC, jsonMessage);
    }

}
