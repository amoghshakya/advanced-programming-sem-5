import java.time.Year;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter 1 for Sign up.");
            System.out.println("Please enter 2 for Quit.");
            System.out.print("Enter your choice: ");
            int userOption = scanner.nextInt();

            if (userOption == 1) {
                scanner.nextLine();

                String userName = askUserName();
                String mobileNumber = askUserNumber();
                String password = askUserPassword();

                System.out.print("Please enter your Date of Birth (DD/MM/YYYY)[no spaces]: ");
                String date = scanner.nextLine();

//                Regular expression to match dd/mm/yyyy
                if (!date.matches("\\d{2}/\\d{2}/\\d{4}")) {
                    System.out.println("Invalid date format. Please make sure the date is in the format DD/MM/YYYY with no spaces.");
                    System.out.println("Please try again.");
                    continue;
                }

//            because we get [dd,mm,yyyy]
                String[] dateSplit = date.split("/");
                int currentYear = Integer.parseInt(String.valueOf(Year.now()));
                int year = Integer.parseInt(dateSplit[2]);
                boolean isEligible = currentYear - year >= 21;

                if (!isEligible) {
                    System.out.println("You are not eligible to sign up. You must be at least 21 years old.");
                    continue;
//                    break;
                }

                User newUser = new User(userName, mobileNumber, password, date);
                System.out.println("Sign up completed!");
                System.out.println(newUser);
            } else if (userOption == 2) {
                System.out.println("Thank you for using the application!");
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    public static String askUserName() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter your full name: ");
            String userName = scanner.nextLine();
            if (userName.length() <= 4) {
                System.out.println("Name too short. Is that your full name?");
                continue;
            }

            return userName;
        }
    }

    public static String askUserNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter your mobile number: ");
            String mobileNumber = scanner.nextLine();
            if (mobileNumber.length() < 10) {
                System.out.println("Not a valid number. Please try again.");
                continue;
            }

            return mobileNumber;
        }
    }

    public static String askUserPassword() {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.print("Please enter your password: ");
            String password = scanner.nextLine();

//            Regex to match valid passwords :(
//            example of valid passwords are John@123, John&035
            if (!password.matches("^\\w+[@&]\\d+$")) {
                System.out.println("""
                        Your password must initiate with an alphabets followed
                        by either one of [@,&] and ending with numbers.""");
                continue;
            }

            System.out.print("Please confirm your password: ");
            String confirmPassword = scanner.nextLine();

//                If passwords do not match
            if (!confirmPassword.equals(password)) {
                System.out.println("Your passwords do not match.");
                System.out.println("Please try again.");
                continue;
            }

            return password;

        }
    }
}