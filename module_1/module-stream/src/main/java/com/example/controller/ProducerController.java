package com.example.controller;

import com.example.controller.dto.OrderProducerDto;
import com.example.producer.OrderProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProducerController.java
 * Class 설명을 작성하세요.
 *
 * @author sgh
 * @since 2022.12.26
 */
@RestController
@RequiredArgsConstructor
public class ProducerController {
    private final OrderProducer orderProducer;

    @PostMapping("/order-produce")
    public void produceOrder(@RequestBody OrderProducerDto orderDto) throws JsonProcessingException {
        orderProducer.sendOrderMessage(orderDto);
    }

}
