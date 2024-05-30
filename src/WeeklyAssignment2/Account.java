package WeeklyAssignment2;

import java.util.Random;

public abstract class Account {
    //    private int accountCounter = 10000;

    private final int accountNumber;
    private final String accountHolder;
    private double balance;

    public Account(String accountHolder, double balance) {
        //    System.currentTimeMillis() as a seed for random number
        //    This gives us a unique random number (hopefully)
        Random rand = new Random(System.currentTimeMillis());
        this.accountNumber = rand.nextInt(100000, 20000000);
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.printf("Deposited $%.2f. New balance is $%.2f.\n", amount, this.balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance. ");
            return;
        }
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. ");
            return;
        }
        balance -= amount;
        System.out.printf("Withdrew $%.2f. New balance is $%.2f.\n", amount, this.balance);
    }

    public void displayAccountInfo() {
        System.out.println(this);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public abstract double calculateMonthlyInterest();

    @Override
    public String toString() {
        return "Account{" + "accountNumber='" + accountNumber + '\'' + ", accountHolder='" + accountHolder + '\'' + String.format(", balance=%.2f", balance) + '}';
    }
}
