import java.util.Scanner;

public class UMLogin {
    private static String username = "user", userInput, password = "1234", passInput;
    private static boolean looping = true;
    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);
        System.out.println("****Welcome to UM LOGIN PAGE****");
        while (looping) {
            System.out.println("--------------------------------");
            System.out.print("Username: ");
            userInput = inputScanner.next();
            System.out.print("Password: ");
            passInput = inputScanner.next();
            System.out.println();
            if (passInput.equals(password) && userInput.equals(username)) {
                int load = 0;
                System.out.print("Loading: ");
                for (int i = 0; i < 10; i++) {
                    load++;
                    System.out.print(load + "0%...");
                }
                System.out.println("\n\n-------------University of Mindanao-------------");
                System.out.println("Welcome to student portal, " + username + ".");
                System.out.println("ID: 538021");
                System.out.println("Second Semester 2022-2023.");
                System.out.println("1st Year Bachelor Of Science In Computer Science.");
                System.out.println("-------------------------------------------------");
                looping = false;
            } else {
                System.out.println("Invalid username or password. Try again.\n");
            }
        }
    }

}