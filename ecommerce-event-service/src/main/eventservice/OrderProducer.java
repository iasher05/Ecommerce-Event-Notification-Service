package com.example.eventservice.producer;

import com.example.eventservice.model.OrderEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private static final String TOPIC = "orders-topic";

    public OrderProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderEvent(OrderEvent event) {
        if (event.getOrderId() == null || event.getOrderId().isEmpty()) {
            throw new IllegalArgumentException("Invalid Order ID");
        }
        kafkaTemplate.send(TOPIC, event.getOrderId(), event);
    }
}