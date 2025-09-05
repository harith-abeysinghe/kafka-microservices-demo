package com.kafkamicroservicesdemo.orderproducer.controller;

import com.kafkamicroservicesdemo.orderproducer.model.Order;
import com.kafkamicroservicesdemo.orderproducer.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        try {
            orderService.produceOrder(order);
            log.info("✅ Order produced: {}", order);
            return ResponseEntity.status(201).body(order);
        } catch (Exception e) {
            log.error("❌ Failed to produce order: {}", order, e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
