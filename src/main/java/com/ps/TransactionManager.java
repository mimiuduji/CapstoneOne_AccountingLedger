package com.ps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionManager {

    static private ArrayList<Transaction> transactions = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // Add a deposit
    public static void addDeposit() {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        System.out.println("Enter description of the deposit:");
        String description = scanner.nextLine();

        System.out.println("Enter deposit amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline

        System.out.println("Enter vendor:");
        String vendor = scanner.nextLine();

        Transaction deposit = new Transaction(date, time, description, amount, vendor);
        transactions.add(deposit);
        System.out.println("Deposit added.");

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("transactions.csv", true));
            bufferedWriter.write(String.format("\n%s|%s|%s|%.2f|%s",
                    deposit.getDate(),
                    deposit.getTime(),
                    deposit.getDescription(),
                    deposit.getAmount(),
                    deposit.getVendor()));

            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // Make a payment
    public static void makePayment() {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        System.out.println("Enter description of the payment:");
        String description = scanner.nextLine();

        System.out.println("Enter payment amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline
        amount *= -1;

        System.out.println("Enter vendor:");
        String vendor = scanner.nextLine();


        Transaction payment = new Transaction(date, time, description, amount, vendor);
        transactions.add(payment);
        System.out.println("Payment made.");

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("transactions.csv", true));
            bufferedWriter.write(String.format("\n%s|%s|%s|%.2f|%s",
                    payment.getDate(),
                    payment.getTime(),
                    payment.getDescription(),
                    payment.getAmount(),
                    payment.getVendor()));

            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // Show ledger
    public static void showLedger() {
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
    private static void showAllTransactions() {
        System.out.println("=== All Transactions ===");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    // Show deposits
    private static void showDeposits() {
        System.out.println("=== Deposits ===");
        for (Transaction t : transactions) {
            if (t.getAmount() > 0) {
                System.out.println(t);
            }
        }
    }

    // Show payments
    private static void showPayments() {
        System.out.println("=== Payments ===");
        for (Transaction t : transactions) {
            if (t.getAmount() < 0) {
                System.out.println(t);
            }
        }
    }
}

