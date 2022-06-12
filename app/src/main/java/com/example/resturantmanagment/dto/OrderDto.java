package com.example.resturantmanagment.dto;

import com.example.resturantmanagment.model.enums.STATUS;

import java.util.List;

public class OrderDto {
    private static int idC = 3;
    int orderId;
    String customerName;
    STATUS status;
    int id;
    List<ItemDto> items;

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
        return sb.toString() ;
    }

    public String toSpinner(){
        return "Order "+orderId +" for customer "+customerName+" "+status;
    }
    public OrderDto() {
        this.id = idC++;
        status = STATUS.WAITING;
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
