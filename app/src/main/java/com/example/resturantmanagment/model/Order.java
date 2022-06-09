package com.example.resturantmanagment.model;

public class Order {
    int id;
    int customerId;
    String status;

    public Order(int id, int customerId, String status) {
        this.id = id;
        this.customerId = customerId;
        this.status = status;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
