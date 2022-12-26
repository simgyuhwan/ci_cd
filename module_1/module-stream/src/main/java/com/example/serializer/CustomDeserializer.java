package com.example.serializer;

import com.example.controller.dto.OrderProducerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

/**
 * CustomDeserializer.java
 * Class 설명을 작성하세요.
 *
 * @author sgh
 * @since 2022.12.26
 */
public class CustomDeserializer implements Deserializer<OrderProducerDto> {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public OrderProducerDto deserialize(String topic, byte[] data) {
        try{
            if(data == null){
                System.out.println("Null received at deserializing");
                return null;
            }
            System.out.println("Deserializing...");
            return objectMapper.readValue(new String(data, "UTF-8"), OrderProducerDto.class);
        }catch(Exception e){
            throw new SerializationException("Error when deserializing byte[] to OrderProducerDto");
        }
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
