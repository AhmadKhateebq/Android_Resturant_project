package com.example.resturantmanagment.model;

import com.example.resturantmanagment.model.enums.STATUS;

public class Order {
    private int id;
    private int customerId;
    private boolean outside;
    private STATUS status;

    public Order(int id, int customerId, boolean outside, STATUS status) {
        this.id = id;
        this.customerId = customerId;
        this.outside = outside;
        this.status = status;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", status='" + status + '\'' +
                '}';
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

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public boolean isOutside() {
        return outside;
    }

    public void setOutside(boolean outside) {
        this.outside = outside;
    }
}
