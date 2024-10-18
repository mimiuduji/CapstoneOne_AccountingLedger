package com.ps;

import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime dateTime;
    private String description;
    private double amount;
    private String vendor;

    public Transaction(LocalDateTime dateTime, String description, double amount, String vendor) {
        this.dateTime = dateTime;
        this.description = description;
        this.amount = amount;
        this.vendor = vendor;
    }

    // Getters
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getVendor() {
        return vendor;
    }

    @Override
    public String toString() {
        return dateTime + " | " + description + " | " + vendor + " | " + amount;
    }
}
