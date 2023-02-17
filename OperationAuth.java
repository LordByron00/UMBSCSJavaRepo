
import java.util.Scanner;

public class OperationAuth {
    public static int addition(int x, int y) {
        int total = x + y;
        return total;
    }

    public static int subtraction(int x, int y) {
        int total = x - y;
        return total;
    }

    public static int multiplication(int x, int y) {
        int total = x * y;
        return total;
    }

    public static int division(int x, int y) {
        int total = x / y;
        return total;
    }


    public static void main(String[] args) {
        String username, password;
        int sum, number1, number2 = 0;
        char Ans;

        do {
            Scanner s = new Scanner(System.in);
            System.out.print("Enter username: ");
            username = s.nextLine();
            System.out.print("Enter password: ");
            password = s.nextLine();

            if (username.equals("user") && password.equals("user")) {
                System.out.println("Authentication successful\n");
                System.out.println("[1]ADDITION\n[2]SUBTRACTION\n[3]MULTIPLICATION\n[4]DIVISION");
                int opChoice = s.nextInt();
                switch (opChoice) {
                    case 1:
                        System.out.println("ADDITION OPERATION");
                        System.out.print("Enter number 1: ");
                        number1 = s.nextInt();
                        System.out.println(" ");
                        System.out.print("Enter number 2: ");
                        number2 = s.nextInt();
                        System.out.println("Total: " + addition(number1, number2));
                        break;
                    case 2:
                        System.out.println("ADDITION OPERATION");
                        System.out.print("Enter number 1: ");
                        number1 = s.nextInt();
                        System.out.println(" ");
                        System.out.print("Enter number 2: ");
                        number2 = s.nextInt();
                        System.out.println("Total: " + subtraction(number1, number2));
                        break;
                    case 3:
                        System.out.println("ADDITION OPERATION");
                        System.out.print("Enter number 1: ");
                        number1 = s.nextInt();
                        System.out.println(" ");
                        System.out.print("Enter number 2: ");
                        number2 = s.nextInt();
                        System.out.println("Total: " + multiplication(number1, number2));
                        break;
                    case 4:
                        System.out.println("ADDITION OPERATION");
                        System.out.print("Enter number 1: ");
                        number1 = s.nextInt();
                        System.out.println(" ");
                        System.out.print("Enter number 2: ");
                        number2 = s.nextInt();
                        System.out.println("Total: " + division(number1, number2));
                        break;
                    default:
                        System.out.println("Invalid choice. Try again!");
                }


            } else {
                System.out.println("Authentication failed");
            }
            System.out.print("Try again? [Y/y]: ");
            Ans = s.next().charAt(0);

        } while ((Ans == 'Y') || (Ans == 'y'));
    }

}