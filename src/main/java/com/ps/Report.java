package com.ps;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Report {

    private Ledger ledger;

    public Report(Ledger ledger) {
        this.ledger = ledger;
    }

    // Display Month to Date transactions
    public void monthToDate() {
        LocalDate today = LocalDate.now();
        LocalDate startOfMonth = today.withDayOfMonth(1);

        System.out.println("Month to Date Transactions:");
        ledger.getTransactions().stream()
                .filter(transaction -> transaction.getDateTime().toLocalDate().isAfter(startOfMonth.minusDays(1)))
                .forEach(System.out::println);
    }

    // Display Previous Month transactions
    public void previousMonth() {
        LocalDate today = LocalDate.now();
        LocalDate startOfPreviousMonth = today.minusMonths(1).withDayOfMonth(1);
        LocalDate endOfPreviousMonth = today.withDayOfMonth(1).minusDays(1);

        System.out.println("Previous Month Transactions:");
        ledger.getTransactions().stream()
                .filter(transaction -> transaction.getDateTime().toLocalDate().isAfter(startOfPreviousMonth.minusDays(1))
                        && transaction.getDateTime().toLocalDate().isBefore(endOfPreviousMonth.plusDays(1)))
                .forEach(System.out::println);
    }

    // Search by Vendor
    public void searchByVendor(String vendor) {
        System.out.println("Transactions for Vendor: " + vendor);
        ledger.getTransactions().stream()
                .filter(transaction -> transaction.getVendor().equalsIgnoreCase(vendor))
                .forEach(System.out::println);
    }
}
