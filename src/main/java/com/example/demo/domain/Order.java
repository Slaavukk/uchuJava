package com.example.demo.domain;


import javax.persistence.*;

@Entity
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    private String product;         //Не уверен, но кажись должно быть private Product product но какая тогда связь
    private int NumberOfGoods;

    @ManyToOne
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
