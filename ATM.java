import java.util.Scanner;

public class ATM {        

    public static double balance, withdraw, deposit, amount, limit = 500000;
    public static String name, user, password, id, log;
    public static boolean global_Loop = true;
    public static void main(String[] args) {

        Scanner InputScanner = new Scanner(System.in);
        
        while (global_Loop) {
            System.out.println("\n[1]Withdraw\n[2]Deposit\n[3]Check Balance\n[4]Exit");
            int choice = InputScanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\nEnter the amount you want to withdraw");
                    amount = InputScanner.nextDouble();
                    while (amount <= 0) {
                        System.out.println("Enter more than 0 amount.");
                        amount = InputScanner.nextDouble();
                    }
                    if (balance > 0) {
                        if (balance - amount >= 0) {
                        balance -= amount;  
                        System.out.println("You successfully withdraw " + amount);
                        System.out.println("Balance: " + balance + "\n");
                        } else {
                            System.out.println("You do not have enough balance");
                        }
                    } else {
                        System.out.println("You have empty balance.");
                    }
                    
                    break;
                case 2:
                    System.out.println("\nEnter the amount you want to deposit: ");
                    deposit = InputScanner.nextDouble();
                    while(deposit <= 0) {
                        System.out.println("Enter amount more than 0. \n");
                        deposit = InputScanner.nextDouble();
                    } 
                    if (deposit < limit && balance + deposit <= limit) {
                        balance += deposit;
                        System.out.println("You deposited: " + deposit);
                    } else {
                        System.out.println("Your deposit amount exceeded the bank limit of your account. Please enter the appropriate amount. \n");
                    }
                    break;
                case 3:
                    System.out.println("\nBalance: " + balance);
                    break;
                case 4:
                    global_Loop = false;
                    break;
            
                default:
                    System.out.println("Choose the correct option.");
                    global_Loop = false;
                    break;
            }
    }
    }
}
