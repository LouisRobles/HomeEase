package com.example.homeease;

public class Transaction {
    private String title;
    private String date;
    private String amount;
    private boolean isCredit;

    public Transaction(String title, String date, String amount, boolean isCredit) {
        this.title = title;
        this.date = date;
        this.amount = amount;
        this.isCredit = isCredit;
    }

    public String getTitle() { return title; }
    public String getDate() { return date; }
    public String getAmount() { return amount; }
    public boolean isCredit() { return isCredit; }
}
