package com.ps;

import java.util.Scanner;

public class AccountingLedgerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TransactionManager.readTransactions();


        int choice;

        do{
            System.out.println("Accounting Ledger Menu");
            System.out.println("1) Add Deposit");
            System.out.println("2) Make Payment");
            System.out.println("3) View Ledger");
            System.out.println("0) Exit");

            System.out.print("Choose an option: ");

             choice = scanner.nextInt();
             scanner.nextLine();

            switch (choice) {
                case 1:
                    TransactionManager.addDeposit();
                    break;
                case 2:
                    TransactionManager.makePayment();
                    break;
                case 3:
                    TransactionManager.showLedger();
                    break;
                case 0:
                    System.out.println("Exiting application.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (true);

    }
}
