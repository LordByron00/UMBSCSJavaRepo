import java.util.Scanner;
public class tsumBagonTakaRonATM {
    private static double balance = 10000;
    private static String personal_Info = "Mr. Tsum Bagon Taka Ron";
    private static boolean looping = true;

    public static void withdraw(double amount) {
        balance -= amount;
        System.out.println("Balance: PHP" + balance);
    }
    public static void deposit(double amount) {
        balance += amount;
        System.out.println("You successfuly deposited: PHP" + amount + "\nBalance: " + balance);
    
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("****UM BANKING SYSTEM*****");
        System.out.println("Welcome Mr. Tsum Bagon Taka Ron.");
        while (looping) {
        System.out.println("----------------------------------------------------");   
        System.out.println("[1]Withdraw\n[2]Deposit\n[3]Balance Inquiry\n[4]EXIT");
        int choice = inputScanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("---Withdraw---");
                    System.out.print("PHP: ");
                    double withdrawAmount = inputScanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.println("---Deposit--- ");
                    System.out.print("PHP: ");
                    double depositAmount = inputScanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    
                    System.out.println("---Balance Inquiry----");
                    System.out.println(personal_Info + " account:");
                    System.out.println("Balance: PHP" + balance);
                    break;
                case 4:
                    System.out.println("Until our next transaction!");
                    looping = false;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}