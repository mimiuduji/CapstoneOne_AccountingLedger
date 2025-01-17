package com.ps;

import java.time.LocalDateTime;

public class Transaction {
    private String date;
    private String time;
    private String description;
    private double amount;
    private String vendor;

    public Transaction(String date, String time, String description, double amount, String vendor) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.amount = amount;
        this.vendor = vendor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", vendor='" + vendor + '\'' +
                '}';
    }
}

    // Getters
