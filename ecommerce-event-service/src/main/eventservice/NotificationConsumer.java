package com.example.eventservice.consumer;

import com.example.eventservice.model.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(topics = "orders-topic", groupId = "notification-group")
    public void consumeOrderEvent(OrderEvent event) {
        System.out.println("Received Event for Processing: " + event.getOrderId());
        // Business logic for downstream notification/processing
    }
}