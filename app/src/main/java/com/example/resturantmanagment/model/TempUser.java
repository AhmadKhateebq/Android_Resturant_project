package com.example.resturantmanagment.model;

public class TempUser {
    String username;
    String password;

    public TempUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public TempUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}