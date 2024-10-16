package com.ps;

import java. time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Transaction {
    private String date;
    private String time;
    private String description;
    private String vendor;
    private double amount;

    // Constructor
    public Transaction(String description, String vendor, double amount) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");


        this.date = now.format(dateFormatter);
        this.date = now.format(dateFormatter);
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    // Getter method for formatting transaction details for the CSV file
    public String getTransactionDetails() {
        return date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
    }
}
