package com.example.resturantmanagment.dto;

public class ItemDto {
    private String name;
    private int quantity;
    private double price;

    @Override
    public String toString() {
        return name + " X" + quantity + " " + price + "$";
    }

    public ItemDto(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
