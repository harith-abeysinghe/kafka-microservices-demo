package com.kafkamicroservicesdemo.orderproducer.service;

import com.kafkamicroservicesdemo.orderproducer.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    @Value("${spring.kafka.topic.name:orders}")
    private String topicName;

    public void produceOrder(Order order) {
        kafkaTemplate.send(topicName, order.getOrderId(), order);
        log.info("Produced order to Kafka: {}", order);
    }
}
