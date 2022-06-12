package com.example.resturantmanagment.dto;

import com.example.resturantmanagment.model.enums.STATUS;

import java.util.List;

public class OrderDto {
    private int orderId;
    private String customerName;
    private STATUS status;
    private List<ItemDto> items;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("for customer : ")
                .append(customerName)
                .append("\nItems:\n");
        for (ItemDto item : items) {
            sb.append(item.toString()).append("\n");
        }
        sb.append("Order Status : ")
                .append(status)
                .append("\n").append("RECEIPT : ").append(orderId);
        return sb.toString();
    }

    public String toSpinner() {
        return "Order " + orderId + " for customer " + customerName + " " + status;
    }

    public OrderDto() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }
}
