package com.example.demo.domain;

import com.example.demo.domain.enums.OrderStatus;

import javax.persistence.*;

@Entity
@Table(name = "orderStatus")
public class OrderStatuss {
    @Id
    private long id;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
