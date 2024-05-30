package ErrorsAndException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            getAge();
            doSomething();
        } catch (InvalidAgeException | MyException e) {
            System.out.println(e.getMessage());
            System.out.println("Custom exception caught!");
        }
    }

    static void doSomething() throws MyException {
        throw new MyException("Something went wrong. Custom exception!! :(");
    }

    static void getAge() throws InvalidAgeException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        if (age < 21) throw new InvalidAgeException();

        System.out.println("Verified!");
    }
}
