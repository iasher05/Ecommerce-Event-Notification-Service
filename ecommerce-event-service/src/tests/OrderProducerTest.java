package com.example.eventservice;

import com.example.eventservice.model.OrderEvent;
import com.example.eventservice.producer.OrderProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaTemplate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

class OrderProducerTest {

    @Mock
    private KafkaTemplate<String, Object> kafkaTemplate;

    @InjectMocks
    private OrderProducer orderProducer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendOrderEvent_Success() {
        OrderEvent event = new OrderEvent("ORD-123", "Laptop", 1200.00);
        orderProducer.sendOrderEvent(event);
        verify(kafkaTemplate).send("orders-topic", "ORD-123", event);
    }

    @Test
    void testSendOrderEvent_InvalidId_ThrowsException() {
        OrderEvent event = new OrderEvent("", "Laptop", 1200.00);
        assertThrows(IllegalArgumentException.class, () -> orderProducer.sendOrderEvent(event));
    }
}