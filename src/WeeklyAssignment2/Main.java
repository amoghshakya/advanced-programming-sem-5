package WeeklyAssignment2;

import WeeklyAssignment2.Exceptions.InvalidAccountNumberException;
import WeeklyAssignment2.Exceptions.UserNotFoundException;

import java.util.HashMap;
import java.util.InputMismatchException;
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
                    System.out.println("Create a new account.");
                    createAccount();
                    break;

                case 2:
                    System.out.println("Deposit sum");
                    deposit();
                    break;

                case 3:
                    System.out.println("Withdraw sum");
                    withdraw();
                    break;

                case 4:
                    System.out.println("Display account info");
                    displayAccountInfo();
                    break;

                case 5:
                    System.out.println("Calculate interest");
                    calculateInterest();
                    break;

                case 6:
                    System.out.println("User authentication");
                    authenticateUser();
                    break;

                case 7:
                    System.out.println("Bye bye!");
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

    //    util method
    private static Customer getCustomer(int accountNumber) {
        return customers.get(accountNumber);
    }

    private static void createAccount() {
        try {
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
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input. Please enter numbers.");
        }
    }

    private static void deposit() {
        System.out.print("Enter account number: ");
        int accountNumber;
        try {
            try {
                accountNumber = scanner.nextInt(); // may throw InputMismatchException
            } catch (InputMismatchException e) {
//                we catch the InputMismatchException so that we can throw our custom exception
//                could there be any better approaches?
                throw new InvalidAccountNumberException();
            }
            if (customers.containsKey(accountNumber)) {
                Customer customer = getCustomer(accountNumber);
                if (!customer.authenticateCustomer()) {
                    System.out.println("Invalid PIN. Unauthorized.");
                    return;
                }
                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();
                customer.getAccount().deposit(amount);
            } else {
                throw new UserNotFoundException();
            }
        } catch (UserNotFoundException | InvalidAccountNumberException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void withdraw() {
        System.out.print("Enter account number: ");
        int accountNumber;
        try {
            try {
                accountNumber = scanner.nextInt();
            } catch (InputMismatchException e) {
                throw new InvalidAccountNumberException();
            }
            if (customers.containsKey(accountNumber)) {
                Customer customer = getCustomer(accountNumber);
                if (!customer.authenticateCustomer()) {
                    System.out.println("Invalid PIN. Unauthorized.");
                    return;
                }
                System.out.print("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();
                customer.getAccount().withdraw(amount);
            } else {
                throw new UserNotFoundException();
            }
        } catch (UserNotFoundException | InvalidAccountNumberException e) {
            System.out.println(e.getMessage());
        }
    }


    private static void displayAccountInfo() {
        System.out.print("Enter account number: ");
        int accountNumber;

        try {
            try {
                accountNumber = scanner.nextInt();
            } catch (InputMismatchException e) {
                throw new InvalidAccountNumberException();
            }
            if (customers.containsKey(accountNumber)) {
                Customer customer = getCustomer(accountNumber);
                if (!customer.authenticateCustomer()) {
                    System.out.println("Invalid PIN. Unauthorized.");
                    return;
                }
                customer.getAccount().displayAccountInfo();
            } else {
                throw new UserNotFoundException();
            }
        } catch (UserNotFoundException | InvalidAccountNumberException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void calculateInterest() {
        System.out.print("Enter account number: ");
        int accountNumber;
        try {
            try {
                accountNumber = scanner.nextInt();
            } catch (InputMismatchException e) {
                throw new InvalidAccountNumberException();
            }
            if (customers.containsKey(accountNumber)) {
                double interest = customers.get(accountNumber).getAccount().calculateMonthlyInterest();
                System.out.printf("Your interest is $%.2f.\n", interest);
            } else {
                throw new UserNotFoundException();
            }
        } catch (UserNotFoundException | InvalidAccountNumberException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void authenticateUser() {
        System.out.print("Enter account number: ");
        int accountNumber;
        try {
            try {
                accountNumber = scanner.nextInt();
            } catch (InputMismatchException e) {
                throw new InvalidAccountNumberException();
            }

            if (customers.containsKey(accountNumber)) {
                boolean authenticated = customers.get(accountNumber).authenticateCustomer();
                if (!authenticated) {
                    System.out.println("Invalid PIN. Unauthorized.");
                    return;
                }
                System.out.println("Authentication successful!");
            } else {
                throw new UserNotFoundException();
            }
        } catch (UserNotFoundException | InvalidAccountNumberException e) {
            System.out.println(e.getMessage());
        }
    }
}
