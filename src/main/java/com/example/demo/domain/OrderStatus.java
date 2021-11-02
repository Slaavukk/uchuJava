package com.example.demo.domain;

import com.example.demo.domain.enums.OrderStatusEnum;

import javax.persistence.*;

@Entity
@Table(name = "orderStatus")
public class OrderStatus {
    @Id
    private long id;
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }
}
