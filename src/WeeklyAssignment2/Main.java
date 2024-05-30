package WeeklyAssignment2;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    //    Key, Value pairs
    private static final HashMap<Integer, Customer> customers = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createAccount();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    displayAccountInfo();
                    break;

                case 5:
                    calculateInterest();
                    break;

                case 6:
                    authenticateUser();
                    break;

                case 7:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private static void showMenu() {
        System.out.println("Welcome to IIM Finance!");
        System.out.println("\n1. Create account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Display Account Info");
        System.out.println("5. Calculate Interest");
        System.out.println("6. User Authentication");
        System.out.println("7. Exit");

        System.out.print("Enter your choice: ");
    }

    private static void createAccount() {
        Account newAccount;

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter account type (Saving/Current): ");
        System.out.println("1. Savings");
        System.out.println("2. Current");
        System.out.print("Enter your choice: ");
        int type = scanner.nextInt();

        if (type == 1) {
            newAccount = new SavingsAccount(name, balance);
        } else if (type == 2) {
            newAccount = new CurrentAccount(name, balance);
        } else {
            System.out.println("Invalid value. Aborting process.");
            return;
        }

        System.out.print("Enter new PIN for your account: ");
        int pin = scanner.nextInt();

        Customer customer = new Customer(name, pin, newAccount);
        customers.put(newAccount.getAccountNumber(), customer);

        System.out.println("Account created successfully.");
        System.out.println("Your account no. is: " + newAccount.getAccountNumber());
    }

    private static void deposit() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        if (customers.containsKey(accountNumber)) {
            Customer customer = customers.get(accountNumber);
            if (!customer.authenticateCustomer()) {
                System.out.println("Invalid PIN. Unauthorized.");
                return;
            }
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            customer.getAccount().deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdraw() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        if (customers.containsKey(accountNumber)) {
            Customer customer = customers.get(accountNumber);
            if (!customer.authenticateCustomer()) {
                System.out.println("Invalid PIN. Unauthorized.");
                return;
            }
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            customer.getAccount().withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void displayAccountInfo() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        if (customers.containsKey(accountNumber)) {
            Customer customer = customers.get(accountNumber);
            if (!customer.authenticateCustomer()) {
                System.out.println("Invalid PIN. Unauthorized.");
                return;
            }
            customer.getAccount().displayAccountInfo();
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void calculateInterest() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        if (customers.containsKey(accountNumber)) {
            double interest = customers.get(accountNumber).getAccount().calculateMonthlyInterest();
            System.out.printf("Your interest is $%.2f.\n", interest);
        }
    }

    private static void authenticateUser() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();

        if (customers.containsKey(accountNumber)) {
            boolean authenticated = customers.get(accountNumber).authenticateCustomer();
            if (!authenticated) {
                System.out.println("Invalid PIN. Unauthorized.");
                return;
            }
            System.out.println("Authentication successful!");
        }
    }
}
