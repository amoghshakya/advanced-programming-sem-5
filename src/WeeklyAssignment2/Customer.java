package WeeklyAssignment2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Customer {
    private int customerId;
    private String name;
    private int PIN;
    private Account account;

    public Customer(String name, int PIN, Account account) {
        this.customerId = new Random().nextInt();
        this.name = name;
        this.PIN = PIN;
        this.account = account;
    }

    public void updatePIN() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your old PIN: ");
        int oldPIN = scanner.nextInt();
        if (oldPIN != this.PIN) {
            System.out.println("Invalid PIN. Aborting.");
            return;
        }
        System.out.print("Enter new PIN: ");
        int newPIN = scanner.nextInt();
        if (newPIN == this.PIN) {
            System.out.println("New PIN cannot be the same as old PIN. ");
        }
        this.PIN = newPIN;
    }

    public boolean authenticateCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();
        return pin == this.PIN;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account; // an Account object
    }
}
