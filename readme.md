 # Financial Ledger 

This is a simple command-line application to manage financial transactions. Users can add deposits, make payments, and view their transaction ledger.

## Features

- Add deposits and payments.
- View ledger entries with filtering options.

## Screenshots

![Home Screen](screenshots/home_screen_menu.png)


## Interesting Code

Here is a simple method for adding a deposit to the ledger:

public void addDeposit(Scanner scanner) {
System.out.println("Enter description of the deposit:");
String description = scanner.nextLine();

