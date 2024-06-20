package WeeklyAssignment3;

import java.io.*;
import java.util.Scanner;

/**
 * Answers Question 2:
 * Write a program to merge two files where merging should be done line by line.
 */
public class LineMerger {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("This Java program merges the following two files (line by line):");
        System.out.println("files/FirstName.txt");
        System.out.println("files/LastName.txt");

        String firstNamePath = "src/WeeklyAssignment3/files/FirstName.txt";
        String lastNamePath = "src/WeeklyAssignment3/files/LastName.txt";
        String fullNamePath = "src/WeeklyAssignment3/files/FullName.txt";

        try (BufferedReader firstNameReader = new BufferedReader(new FileReader(firstNamePath));
             BufferedReader lastNameReader = new BufferedReader(new FileReader(lastNamePath));
             BufferedWriter fullNameWriter = new BufferedWriter(new FileWriter(fullNamePath))) {

            String firstName, lastName;
            while (
                    (firstName = firstNameReader.readLine()) != null &&
                            (lastName = lastNameReader.readLine()) != null
            ) {
                System.out.printf("Merge '%s' and '%s' as '%s'? (y/n): ",
                        firstName,
                        lastName,
                        firstName + " " + lastName);
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    fullNameWriter.write(String.format("%s %s\n", firstName, lastName));
                }
            }

            System.out.println("Files merged.");
        } catch (IOException e) {
            System.out.println("Something went wrong.");
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
