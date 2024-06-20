package FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter file path (absolute path): ");
        String filePath = scanner.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            System.out.printf("Failed to read file: [%s]\n", filePath);
            System.out.println(e.getMessage());
        }
    }
}
