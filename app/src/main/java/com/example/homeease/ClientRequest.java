package com.example.homeease;

public class ClientRequest {
    public String name;
    public String location;
    public String phone;
    public String category;
    public String price;

    public ClientRequest(String name, String location, String phone, String category, String price) {
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.category = category;
        this.price = price;
    }
}
