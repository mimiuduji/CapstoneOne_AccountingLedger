package com.ps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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

    public static void readTransactions() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("transactions.csv"));

            // Read the header line (not used)
            String firstLine = br.readLine();
            String input;

            // Read each line of the CSV file
            while ((input = br.readLine()) != null) {
                String[] transactionArr = input.split("\\|");
                String date = transactionArr[0];
                String time = transactionArr[1];
                String description = transactionArr[2];
                double amount = Double.parseDouble(transactionArr[3]);
                String vendor = transactionArr[4];

                // Add a new Transaction object to the list
                transactions.add(new Transaction(date, time, description, amount, vendor));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions during file reading
        }
    }
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
        int option;

        do {
            System.out.println("=== Ledger Screen ===");
            System.out.println("1) All");
            System.out.println("2) Deposits");
            System.out.println("3) Payments");
            System.out.println("4) Reports");
            System.out.println("0) Home");

            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    showAllTransactions();
                    break;
                case 2:
                    showDeposits();
                    break;
                case 3:
                    showPayments();
                    break;
                case 4:
//                    reports();
                    break;
                case 0:
                    System.out.println("Returning to home screen...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (true);
    }

    // Show all transactions
    private static void showAllTransactions() {
        System.out.println("=== All Transactions ===");
        for (int i = transactions.size()-1; i >= 0; i--){
           Transaction transaction = transactions.get(i);

           System.out.printf("Date: %s, Time: %s, Description: %s, Amount: $%.2f, Vendor: %s\n",
                   transaction.getDate(),
                   transaction.getTime(),
                   transaction.getDescription(),
                   transaction.getAmount(),
                   transaction.getVendor());
        }
    }

    // Show deposits
    private static void showDeposits() {
        System.out.println("=== Deposits ===");
        for (int i = transactions.size()-1; i >= 0; i--){
            Transaction transaction = transactions.get(i);
            if (transaction.getAmount()>0){
                System.out.println(transaction);
            }

            System.out.printf("Date: %s, Time: %s, Description: %s, Amount: $%.2f, Vendor: %s\n",
                    transaction.getDate(),
                    transaction.getTime(),
                    transaction.getDescription(),
                    transaction.getAmount(),
                    transaction.getVendor());
        }
    }

    // Show payments
    private static void showPayments() {
        System.out.println("=== Payments ===");
        for (int i = transactions.size()-1; i >= 0; i--){
            Transaction transaction = transactions.get(i);
            if (transaction.getAmount()>0){
                System.out.println(transaction);
            }

            System.out.printf("Date: %s, Time: %s, Description: %s, Amount: $%.2f, Vendor: %s\n",
                    transaction.getDate(),
                    transaction.getTime(),
                    transaction.getDescription(),
                    transaction.getAmount(),
                    transaction.getVendor());
        }
    }
}


