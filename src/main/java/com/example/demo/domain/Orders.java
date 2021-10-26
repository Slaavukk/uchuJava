package com.example.demo.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Orders {
    @Id
    private String product;
    private int NumberOfGoods;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getNumberOfGoods() {
        return NumberOfGoods;
    }

    public void setNumberOfGoods(int numberOfGoods) {
        NumberOfGoods = numberOfGoods;
    }
}
