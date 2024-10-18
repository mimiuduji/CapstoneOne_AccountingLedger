 # Financial Ledger 

This is a simple command-line application to manage financial transactions. Users can add deposits, make payments, and view their transaction ledger.

## Features

- Add Deposit: Record a deposit to the ledger.
  Make Payment (Debit): Record a payment or expense.
  View Ledger: View all transactions, only deposits, or only payments.
  Generate Reports: View predefined reports, including:
    Month-to-date
    Previous month
     Year-to-date
    Previous year
    Search by vendor.

## Screens

Home Screen:
The application starts with the following options:

D - Add Deposit
P - Make Payment (Debit)
L - View Ledger
R - Reports
X - Exit

Ledger Screen:
View all transactions, deposits, or payments.
Report Screen
Generate predefined reports or search by vendor.


## Screenshots
Home Screen
https://github.com/mimiuduji/CapstoneOne_AccountingLedger/blob/main/screenshots/HomeScreenMenu%20.png?raw=true


## Interesting Code

Here is a simple method for adding a deposit to the ledger:

https://github.com/mimiuduji/CapstoneOne_AccountingLedger/blob/main/screenshots/InterestingCode.png?raw=true

public void addDeposit(Scanner scanner) {
System.out.println("Enter description of the deposit:");
String description = scanner.nextLine();

## Function of the code

The addDeposit method prompts the user to enter a description for a deposit.
It reads the user's input using the Scanner and stores it in the description variable. This is the first step to collecting details for adding a deposit, which can later be saved or processed in the application.