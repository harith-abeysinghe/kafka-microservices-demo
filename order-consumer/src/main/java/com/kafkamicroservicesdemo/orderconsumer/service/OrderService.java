package com.kafkamicroservicesdemo.orderconsumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @KafkaListener(topics = "orders", groupId = "order-group")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}
