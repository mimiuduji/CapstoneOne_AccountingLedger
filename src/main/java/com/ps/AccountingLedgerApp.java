package com.ps;

import java.util.Scanner;

public class AccountingLedgerApp {

    public static void main (String[] args){
        // Start application showing the home screen menu
        showMenu();
    }

        // The method to display home screen menu
    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        String choice = "";

        // Keep showing the menu until the user decides to exit
        while (!choice.equalsIgnoreCase("X")) {
        System.out.println("Welcome to the Accounting Ledger Application!");
        System.out.println("Please choose an option:");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment");
        System.out.println("L) Ledger");
        System.out.println("X) Exit");

        // Get the user's choice
        System.out.print("Enter your choice");
        choice = scanner.nextLine();

        // Handle the user's choice
         switch (choice.toUpperCase()) {
             case "D":
            System.out.println("You chose to Add Deposit");
            // Call a method to add deposit here
              break;
             case "P":
                 System.out.println("You chose to make payment.");
                 // call a method to display ledger here
                 break;
             case "L":
                 System.out.println("You chose to view the Ledger.");
                 // call a method to display ledger here
                 break;
             case "X":
                 System.out.println("Exiting the application. Goodbye!");
                 break;
             default:
                 System.out.println("Invalid choice. Please choose a valid option.");

         }
        }
        scanner.close();
    }
}
