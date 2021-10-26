package com.example.demo.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private String name;
    private byte number;
    private String salesman;
    private String review;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getNumber() {
        return number;
    }

    public void setNumber(byte number) {
        this.number = number;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
