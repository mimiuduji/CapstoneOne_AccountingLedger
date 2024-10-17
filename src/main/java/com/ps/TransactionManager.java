package com.ps;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TransactionManager {

    public static void addDeposit() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter deposit description: ");
        String description = scanner.nextLine();

        System.out.println("Enter vendor: ");
        String vendor = scanner.nextLine();

        System.out.println("Enter amount: ");
        double amount = scanner.nextDouble();

        // Create a new transaction for the deposit
        Transaction deposit = new Transaction(description, vendor, amount);

        // Save the transaction to the CSV file
        saveTransactionToFile(deposit);
        System.out.println("Deposit added successfully.");
    }

    public static void saveTransactionToFile(Transaction transaction) {
        try (FileWriter fileWriter = new FileWriter("transactions.csv", true)) {
            fileWriter.write(transaction.getTransactionDetails() + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the transaction.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        displayHomeScreenMenu();
    }

    // The existing method for the home screen menu
    public static void displayHomeScreenMenu() {
        System.out.println("Welcome to the Accounting Ledger Application");
        System.out.println("Please choose an option:");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment (Debit)");
        System.out.println("L) View Ledger");
        System.out.println("X) Exit");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().toUpperCase();

        switch (choice) {
            case "D":
                addDeposit();
                break;
            case "P":
                makePayment();
                break;
            case "X":
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option, please try again.");
                displayHomeScreenMenu();
                break;
        }
    }

    // Adding a payment (similar to deposit)
    public static void makePayment() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter payment description: ");
        String description = scanner.nextLine();

        System.out.println("Enter vendor: ");
        String vendor = scanner.nextLine();

        System.out.println("Enter amount: ");
        double amount = scanner.nextDouble();

        // A payment is a negative transaction
        Transaction payment = new Transaction(description, vendor, -amount);

        // Save the transaction to the CSV file
        saveTransactionToFile(payment);
        System.out.println("Payment added successfully.");
    }
}
