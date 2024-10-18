package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Ledger {
    private List<Transaction> transactions;

    public Ledger() {
        this.transactions = new ArrayList<>();
    }

    // Add transaction to the ledger
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Get the list of transactions
    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Display all transactions
    public void displayAllTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            System.out.println("All Transactions:");
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    // Display only deposits (positive transactions)
    public void displayDeposits() {
        boolean found = false;
        System.out.println("Deposits:");
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() > 0) {
                System.out.println(transaction);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No deposits available.");
        }
    }

    // Display only payments (negative transactions)
    public void displayPayments() {
        boolean found = false;
        System.out.println("Payments:");
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                System.out.println(transaction);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No payments available.");
        }
    }
}
