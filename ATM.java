import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.Date;

public class ATM {        

    public static double balance, withdraw, deposit, amount, withdrawLimit = 20000, initDept, initLimit = 2000, creditlimit = 100000;
    public static String name, user, password, id, userTempt, passTempt, userLine, passLine, IDInput, surname, balanceTempt;
    public static boolean global_Loop = true, login_loop = true;
    public static Scanner InputScanner = new Scanner(System.in);
    public static int PINInput, balanceLine;
    public static Date currDate = new Date();
    public static void main(String[] args) throws IOException {

        
        File IDFile = new File("IDlist.txt");
        File PINFile = new File("PINlist.txt");
        File nameFile = new File("namelist.txt");
        File surnameFile = new File("surnamelist.txt");
        File balanceFile = new File("balanceFile.txt");
        
        while(login_loop) { 
            try {
                if (!IDFile.exists() || !PINFile.exists() || !nameFile.exists() || !surnameFile.exists() || !balanceFile.exists()) {
                    IDFile.createNewFile();
                    PINFile.createNewFile();
                    nameFile.createNewFile();
                    surnameFile.createNewFile();
                    balanceFile.createNewFile();
                }
                Scanner IDScanner = new Scanner(IDFile);
                Scanner PINScanner = new Scanner(PINFile);
                Scanner nameScanner = new Scanner(nameFile);
                Scanner surnameScanner = new Scanner(surnameFile);
                Scanner balanceScanner = new Scanner(balanceFile);
                    if (IDScanner.hasNextLine() && PINScanner.hasNextLine()) {
                        System.out.println("---------------------------------------");
                        System.out.println("WELCOME TO THE UM BANKING SYSTEM.");
                        System.out.println("---------------------------------------");
                        System.out.print("ID: ");
                        IDInput = InputScanner.next();
                        System.out.print("PIN: ");
                        PINInput = InputScanner.nextInt();
                        String PINString = Integer.toString(PINInput);
                        balanceLine = 0;
                        while (IDScanner.hasNextLine() || PINScanner.hasNextLine()) {
                                balanceTempt = Files.readAllLines(Paths.get("balanceFile.txt")).get(balanceLine);
                                balance = Double.parseDouble(balanceTempt);
                                userLine = IDScanner.nextLine();
                                passLine = PINScanner.nextLine();
                                name = nameScanner.nextLine();
                                surname = surnameScanner.nextLine();
                                // balance = balanceScanner.nextDouble();
                                // Debug
                                // System.out.println(balanceTempt + " " + userLine + " " + passLine + + balanceLine);
                                balanceLine++;
                            if (IDInput.equals(userLine) && PINString.equals(passLine)) {
                                System.out.println("\n---------------------------------------");
                                System.out.println("Welcome " + name + " " + surname + ".");
                                global_Loop = true;
                                ATMmain();
                                login_loop = false;
                                break;
                            } else {
                                    if (!IDScanner.hasNextLine() && !PINScanner.hasNextLine()) {
                                    System.out.println("\nIncorrect ID or PIN.\n[1]Try again.\n[2]Create new account");
                                    int choice = InputScanner.nextInt();
                                    switch (choice) {
                                        case 1:
                                            System.out.println();
                                            continue;
                                        case 2:
                                            CreateAcc();
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            }
                        }
                        
                    } else {
                        CreateAcc();
                    }
                    
            } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
        }
    }
    
    public static void CreateAcc() throws IOException {
        System.out.println("\nCREATE ACCOUNT:");
        System.out.print("Enter name:");
        name = InputScanner.next();
        System.out.print("Enter surname: ");
        surname = InputScanner.next();
        System.out.print("Enter PIN: ");
        PINInput = InputScanner.nextInt();
        IDInput = "";
        System.out.print("Initial deposit: ");
        initDept = InputScanner.nextDouble();
        while (initDept < initLimit) {
            System.out.println("Minimum initial deposit is $2000.");
            System.out.print("Initial deposit: ");
            initDept = InputScanner.nextDouble();
        }
        for (int i = 0; i < 6; i++) {
            IDInput += (int)Math.floor(Math.random() * 10);
        }
        FileWriter IDWriter = new FileWriter("IDlist.txt", true);
        FileWriter PINWriter = new FileWriter("PINlist.txt", true);
        FileWriter nameWriter = new FileWriter("namelist.txt", true);
        FileWriter surnameWriter = new FileWriter("surnamelist.txt", true);
        FileWriter balanceWriter = new FileWriter("balanceFile.txt", true);
        File TransactFile = new File(String.format("%s.txt", IDInput));
        TransactFile.createNewFile();
        IDWriter.write(IDInput + "\r\n" );
        PINWriter.write(PINInput + "\r\n" );
        nameWriter.write(name + "\r\n" );
        surnameWriter.write(surname + "\r\n");
        balanceWriter.write(initDept + "\r\n");
        IDWriter.close();
        PINWriter.close();
        nameWriter.close();
        surnameWriter.close();
        balanceWriter.close();
        System.out.println("\n-----INFORMATION-----\nID: " + IDInput + "\nName: " + name + "\nSurname: " + surname + "\nInitial deposit: " + initDept + "\n" + "REMEMBER THE ID AND PIN!\n");
    }
    public static void StoreBalance() throws IOException {
        balanceTempt = Double.toString(balance);
        List<String> balanceSet = Files.readAllLines(Paths.get("balanceFile.txt"));
        balanceSet.set(balanceLine -1, balanceTempt);
        Files.write(Paths.get("balanceFile.txt"), balanceSet);
    }
    public static void storeTransaction(Date transDsate, String action, double old, String operation, double amount, double newBal) throws IOException {
        FileWriter TransactionWriter = new FileWriter(String.format("%s.txt", userLine), true);
        TransactionWriter.write(transDsate + " " + action + "$" + old + " " + operation + " " +  "$" + amount + " Balance: " + "$" + newBal + " " + "\r\n");
        TransactionWriter.close();
    }
    public static void fileChecker() throws IOException {
        File TransactFile = new File(String.format("%s.txt", IDInput));
        if (!TransactFile.exists()) {
            TransactFile.createNewFile();
        }
    }
    public static void withdraw() throws IOException {
        double oldBal = balance;
        balance -= amount;
        System.out.println("***************************************");
        System.out.println("You successfully withdrawn " + "$" + amount);
        System.out.println("***************************************");
        fileChecker();
        StoreBalance();
        storeTransaction(currDate, "*Withdraw* ", oldBal, "-", amount, balance);
    }
    public static void ATMmain() throws IOException {
        while (global_Loop) {
            System.out.println("---------------------------------------");
            System.out.println("[1]Withdrawal\n[2]Deposit\n[3]Balance Inquiry\n[4]Transaction History\n[5]Exit");
            System.out.println("---------------------------------------");
            int choice = InputScanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\nAMOUNT TO WITHDRAW: ");
                    System.out.print("$");
                    amount = InputScanner.nextDouble();
                    while (amount <= 0) {
                        System.out.println("Minimum withdrawal is $200.");
                        System.out.print("$");
                        amount = InputScanner.nextDouble();
                    }
                    while (amount > withdrawLimit) {
                        System.out.println("Maximum withdrawal is $20,000.");
                        System.out.print("$");
                        amount = InputScanner.nextDouble();
                    }
                    if (balance > 0) {
                        if (balance - amount >= 300) {
                        withdraw();
                        } else if (balance - amount < 0) {
                            System.out.println("\n.......................................");
                            System.out.println("Insufficient balance.");
                            System.out.println(".......................................");
                        } else {
                            withdraw();
                            System.out.println("Minimum balance fee is $300. This may lead to account closure after 30 days.");
                            
                        }
                    } 
                    break;
                case 2:
                    System.out.println("\nAMOUNT TO DEPOSIT: ");
                    System.out.print("$");
                    deposit = InputScanner.nextDouble();
                    while(deposit <= 0) {
                        System.out.println("Invalid amount.\n");
                        System.out.print("$");
                        deposit = InputScanner.nextDouble();
                    }
                    if (deposit < creditlimit && balance + deposit <= creditlimit) {
                        Double oldBal = balance;
                        balance += deposit;
                        System.out.println("***************************************");
                        System.out.println("You deposited: " + "$" + deposit);
                        System.out.println("***************************************");
                        fileChecker();
                        StoreBalance();
                        storeTransaction(currDate, "*Deposit* ", oldBal, "+", deposit, balance);
                    } else {
                        System.out.println("\nYour deposit amount exceeded the bank limit($200000) of your account. Please enter the appropriate amount.");
                    }
                    break;
                case 3:
                    System.out.println("\n.......................................");
                    System.out.println("Balance: " + "$" + balance);
                    System.out.println(".......................................");
                    break;
                case 4:
                    fileChecker();
                    System.out.println("\nTransaction History:");
                    System.out.println(".....................................................................");
                    List<String> transHistoryList = Files.readAllLines(Paths.get(String.format("%s.txt", userLine)));
                    for (int i = 0; i < transHistoryList.size(); i++) {
                        System.out.println(transHistoryList.get(i));
                    }
                    if (transHistoryList.isEmpty()) {
                        System.out.println("There is no transaction yet.");
                    }
                    System.out.println(".....................................................................");
                    break;
                case 5:
                    System.out.println();
                    global_Loop = false;
                    login_loop = true;
                    main(null);
                    break;
                default:
                    System.out.println("CHOSE CORRECTLY!!!");
                    continue;
            }
    }
    }

}
