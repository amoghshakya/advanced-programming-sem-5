package WeeklyAssignment3;

import java.io.*;

/**
 * Answers Question 1:
 * Write a program to read data from two different files and merge those files into a single file.
 */
public class Merger {
    public static void main(String[] args) {
        System.out.println("This Java program merges the following two files:");
        System.out.println("files/FirstName.txt");
        System.out.println("files/LastName.txt");

        String firstNamePath = "src/WeeklyAssignment3/files/FirstName.txt";
        String lastNamePath = "src/WeeklyAssignment3/files/LastName.txt";
        String fullNamePath = "src/WeeklyAssignment3/files/FullName.txt";

        try (
                BufferedReader firstNameReader = new BufferedReader(new FileReader(firstNamePath));
                BufferedReader lastNameReader = new BufferedReader(new FileReader(lastNamePath));
                PrintWriter fullNameWriter = new PrintWriter(new FileWriter(fullNamePath))
        ) {
            String firstName, lastName;

            while ((firstName = firstNameReader.readLine()) != null &&
                    (lastName = lastNameReader.readLine()) != null) {
                fullNameWriter.printf("%s %s\n", firstName, lastName);
            }

            System.out.println("Merged files.");
        } catch (IOException e) {
            System.out.println("Failed to merge files.");
            System.out.println(e.getMessage());
        }
    }
}
