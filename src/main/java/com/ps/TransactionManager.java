package com.ps;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionManager {

    private ArrayList<Transaction> transactions = new ArrayList<>();

    // Add a deposit
    public void addDeposit(Scanner scanner) {
        System.out.println("Enter description of the deposit:");
        String description = scanner.nextLine();

        System.out.println("Enter deposit amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline

        System.out.println("Enter vendor:");
        String vendor = scanner.nextLine();

        Transaction deposit = new Transaction(LocalDateTime.now(), description, amount, vendor);
        transactions.add(deposit);
        System.out.println("Deposit added.");
    }

    // Make a payment
    public void makePayment(Scanner scanner) {
        System.out.println("Enter description of the payment:");
        String description = scanner.nextLine();

        System.out.println("Enter payment amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline

        System.out.println("Enter vendor:");
        String vendor = scanner.nextLine();


        Transaction payment = new Transaction(LocalDateTime.now(), description, amount, vendor);
        transactions.add(payment);
        System.out.println("Payment made.");
    }

    // Show ledger
    public void showLedger(Scanner scanner) {
        String option;

        do {
            System.out.println("=== Ledger Screen ===");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");

            System.out.print("Choose an option: ");
            option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "A":
                    showAllTransactions();
                    break;
                case "D":
                    showDeposits();
                    break;
                case "P":
                    showPayments();
                    break;
                case "R":
                    // You can implement reports screen later
                    System.out.println("Reports not implemented yet.");
                    break;
                case "H":
                    System.out.println("Returning to home screen...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (!option.equals("H"));
    }

    // Show all transactions
    private void showAllTransactions() {
        System.out.println("=== All Transactions ===");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    // Show deposits
    private void showDeposits() {
        System.out.println("=== Deposits ===");
        for (Transaction t : transactions) {
            if (t.getAmount() > 0) {
                System.out.println(t);
            }
        }
    }

    // Show payments
    private void showPayments() {
        System.out.println("=== Payments ===");
        for (Transaction t : transactions) {
            if (t.getAmount() < 0) {
                System.out.println(t);
            }
        }
    }
}

