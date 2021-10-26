package com.example.demo.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Basket {
    @Id
    private String user;
    private String product;
    private int numberOfGoods;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getNumberOfGoods() {
        return numberOfGoods;
    }

    public void setNumberOfGoods(int numberOfGoods) {
        this.numberOfGoods = numberOfGoods;
    }
}
