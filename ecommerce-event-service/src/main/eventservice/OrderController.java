package com.example.eventservice.controller;

import com.example.eventservice.model.OrderEvent;
import com.example.eventservice.producer.OrderProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderEvent orderEvent) {
        orderProducer.sendOrderEvent(orderEvent);
        return ResponseEntity.ok("Order event published successfully to Kafka.");
    }
}