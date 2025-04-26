package progLanguages.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bayron_ATM {

    static Scanner io = new Scanner(System.in);
    static List<bankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {
        boolean mainloop = true;

        //Dashboard for account creation, login, ang exit
        while (mainloop) {
            System.out.println("===========WELCOME TO UM BANK==========");
            System.out.println("[1] CREATE ACCOUNT");
            System.out.println("[2] LOGIN");
            System.out.println("[3] EXIT");
            //input for option above
            int choice = io.nextInt();
            //associating the input with the right function
            switch (choice) {
                case 1 -> createAccount();
                case 2 -> login();
                case 3 -> mainloop = false;
                default -> {
                }
            }
        }

    }


    //Creates an account, asks for input details
    public static void createAccount() {
        boolean loop = true;
        System.out.println("\nCREATE ACCOUNT:");
        io.nextLine();
        System.out.print("Enter fullname:");
        String name = io.nextLine();

        int PINInput = 0;
        //simple check if 4digit
        while (PINInput > 9999 || PINInput < 1000) {
            System.out.print("Enter 4-digit PIN: ");
            PINInput = io.nextInt();
        }

        System.out.print("Initial deposit: ");
        double initDept = io.nextDouble();

        int initLimit = 2000;
        //checks if initial limit is met
        while (initDept < initLimit) {
            System.out.println("Minimum initial deposit is $2000.");
            System.out.print("Initial deposit: ");
            initDept = io.nextDouble();
        }
        //create account number
        int accNum = createAcctNum();
        //appends new account to accounts list
        //send create new transaction for transaction history
        accounts.add(new bankAccount(name, accNum, PINInput, initDept, new transaction("Account Created", initDept)));
        System.out.println("\n-----INFORMATION-----\nID: " + accNum + "\nName: " + name + "\nInitial deposit: " + initDept + "\n" + "REMEMBER THE ID AND PIN!\n");
    }

    private static int createAcctNum() {
        int IDInput = 0;
        //randomized account number
        IDInput = (int) Math.floor(Math.random() * 1000000);
        return IDInput;
    }

    public static void login() {
        System.out.println("---------------------------------------");
        System.out.println("WELCOME TO THE UM BANKING SYSTEM.");
        System.out.println("---------------------------------------");
        System.out.print("ID: ");
        int IDInput = io.nextInt();
        System.out.print("PIN: ");
        int PINInput = io.nextInt();
        // invoke checkCredentials function with PIN and ID for validation
        //returns account if credential is found
        bankAccount loggedAcc = checkCredentials(PINInput, IDInput);
        //if account is null, wrong credentials or does not exist
        // send the validated account to dashboard fjunction
        if (loggedAcc == null) {
            System.out.print("Incorrect credentials!\n");
        } else {
            dashboard(loggedAcc);
        }
    }

    public static bankAccount checkCredentials(int PIN, int AN) {
        bankAccount x = null;
        //checking every account stored in accounts list if the PIN AND account number exist
        for (bankAccount account : accounts) {
            if (PIN == account.getPIN() && AN == account.getAccountNum()) {
                //if found break away from the loop
                x = account;
                break;
            }
        }
        //return the found account
        return x;
    }

    //Main page to perform operations such as withdraw, deposit, balance inquiry, and transaction history
    public static void dashboard(bankAccount loggedAcc) {
        boolean loop = true;
        System.out.println("------------------------");
        System.out.println("WELCOME " + loggedAcc.getName());
        System.out.println("------------------------");
        while (loop) {
            System.out.println("[1] WITHDRAWAL");
            System.out.println("[2] DEPOSIT");
            System.out.println("[3 BALANCE");
            System.out.println("[4] TRANSACTION HISTORY");
            System.out.println("[5] EXIT");

            int choice = io.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("amount: ");
                    double value = 0;
                    while (value <= 0) {
                        value = io.nextDouble();
                    }
                    //sends data to account's withdraw method
                    loggedAcc.withdraw(value);
                    System.out.println("***************************************");
                    System.out.println("You successfully withdrawn " + "$" + value);
                    System.out.println("***************************************");
                    loggedAcc.addTransaction(new transaction("deposited", value));
                }
                case 2 -> {
                    System.out.print("amount: ");
                    double value2 = 0;
                    while (value2 <= 0) {
                        value2 = io.nextDouble();
                    }
                    //sends data to account's deposit method
                    //stores transaction
                    loggedAcc.deposit(value2);
                    System.out.println("***************************************");
                    System.out.println("You deposited: " + "$" + value2);
                    System.out.println("***************************************");
                    loggedAcc.addTransaction(new transaction("deposited", value2));
                }
                case 3 -> {
                    //just displays the balance
                    //stores transaction
                    System.out.println("***************************************");
                    System.out.println("Current Balance: " + "$" + loggedAcc.getBalance());
                    System.out.println("***************************************");
                    loggedAcc.addTransaction(new transaction("checked balance", 0));

                }
                case 4 -> {
                    // getting transaction history of an account using  getHistory method
                    List<transaction> transHistory = loggedAcc.getHistory();
                    System.out.println("TRANSACTION HISTORY");
                    //display the transaction history by looping to account's transaction history
                    for (transaction history : transHistory) {
                        System.out.println(".....................................................");
                        System.out.println(history.getDate() + " *" + history.getAction() + "* " + history.getValue());
                        System.out.println(".....................................................");
                    }
                }
                case 5 -> loop = false;
                default -> System.out.println("Incorrect option!");
            }
        }


    }

}
