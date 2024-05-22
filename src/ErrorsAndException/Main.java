package ErrorsAndException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(10 / 0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.out.println("Cannot divide by zero.");
        }
    }
}
