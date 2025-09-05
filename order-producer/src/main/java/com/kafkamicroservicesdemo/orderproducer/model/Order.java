package com.kafkamicroservicesdemo.orderproducer.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private String orderId;
    private String product;
    private int quantity;
}
