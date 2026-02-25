package com.example.homeease;

public class Record {
    private String status;
    private String date;
    private String name;
    private String address;
    private String phone;
    private String service;
    private String price;
    private int profileImage;

    public Record(String status, String date, String name, String address, String phone, String service, String price, int profileImage) {
        this.status = status;
        this.date = date;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.service = service;
        this.price = price;
        this.profileImage = profileImage;
    }

    public String getStatus() { return status; }
    public String getDate() { return date; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getService() { return service; }
    public String getPrice() { return price; }
    public int getProfileImage() { return profileImage; }
}
