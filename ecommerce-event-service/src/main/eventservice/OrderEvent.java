package com.example.eventservice.model;

import java.io.Serializable;

public class OrderEvent implements Serializable {
    private String orderId;
    private String product;
    private double price;

    public OrderEvent() {}

    public OrderEvent(String orderId, String product, double price) {
        this.orderId = orderId;
        this.product = product;
        this.price = price;
    }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}