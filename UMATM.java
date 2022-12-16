import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class UMATM {
    public static int IDtempt, PINTempt, withdraw, deposit;
    public static String name, username, userPath;
    static double balance;
    public static Date currDate = new Date();
    public static boolean loginLoop, ATMLoop, errorLoop;

    // Create Account
    public UMATM(double initBal, int newID, int newPIN, String newName, String newSurname) throws IOException {
        //While the IDnum exists, iterate over other IDnum. 
        int IDnum = 0;
        File IDiterate;
        do {
            IDnum++; // 1
            IDiterate = new File(String.format("010101%s", IDnum));
        } while (IDiterate.exists());
        IDiterate = new File(String.format("010101%s", IDnum));
        IDiterate.mkdir();
        String IDnumPath = String.format("010101%s", IDnum);
        File credential = new File(String.format(".\\%s\\Credentials", IDnumPath));
        credential.mkdir();
        File InfoFolder = new File(String.format(".\\%s\\Info", IDnumPath));
        InfoFolder.mkdir();
        File balaFolder = new File(String.format(".\\%s\\Balance", IDnumPath));
        balaFolder.mkdir();
        String IDStr = Integer.toString(newID);
        File IDFile = new File(String.format(".\\%s\\Credentials\\%s", IDnumPath, IDStr));
        String PINStr = Integer.toString(newPIN);
        File PINFile = new File(String.format(".\\%s\\Credentials\\%s", IDnumPath, PINStr));
        File nameFile = new File(String.format(".\\%s\\Info\\%s", IDnumPath, newName));
        File surFile = new File(String.format(".\\%s\\Info\\%s", IDnumPath, newSurname));
        String balStr = Double.toString(initBal);
        File balFile = new File(String.format(".\\%s\\Balance\\Balance.txt", IDnumPath));
        File transactioFile = new File(String.format(".\\%s\\Balance\\TransactionHistory.txt", IDnumPath));
        FileWriter balWriter = new FileWriter(balFile);
        balWriter.write(balStr);
        balWriter.close();
        IDFile.createNewFile();
        PINFile.createNewFile();
        nameFile.createNewFile();
        surFile.createNewFile();
        balFile.createNewFile();
        transactioFile.createNewFile();
        // balance = initBal;

    }
    // Ask for information
    public static void createAccount() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("CREATE ACCOUNT:");
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.print("Enter Surname: ");
        String surname = sc.next();
        System.out.print("Enter PIN: ");
        int PIN = sc.nextInt();
        System.out.print("Enter initial deposit: ");
        double balance = sc.nextDouble();
        String ID = "";
        for (int i = 0; i < 6; i++) {
            ID += (int)Math.floor(Math.random() * 10);
        }
        int IDint = Integer.parseInt(ID);
        System.out.println("INFORMATION:\n" + "Name: " + name + "\nSurname: " + surname + "\nID: " + ID + "\nPIN: " + PIN);
        System.out.println("Remember your ID and PIN.");
        UMATM account = new UMATM(balance, IDint, PIN, name, surname);
    }
    public static void storeBalance(Date transDsate, String action, double old, String operation, double amount) throws IOException {
        File balFile = new File(String.format(".\\%s\\Balance\\Balance.txt", userPath));
        File TransactFile = new File(String.format(".\\%s\\Balance\\TransactionHistory.txt", userPath));
        FileWriter balWriter = new FileWriter(balFile);
        FileWriter transactWriter = new FileWriter(TransactFile);
        String newBal = Double.toString(balance);
        balWriter.write(newBal);
        balWriter.close();
        transactWriter.write(transDsate + " " + action + "$" + old + " " + operation + " " +  "$" + amount + " Balance: " + "$"  + newBal + " " + "\r\n");
        transactWriter.close();
    }

    public static void withdraw(Double toWithdraw) throws IOException {
        Double oldBal = balance;
        balance -= toWithdraw;
        storeBalance(currDate, "Withdraw", oldBal, "-", toWithdraw);
        System.out.println("You just withdrew: " + toWithdraw);
    }
    public static void deposit(double toDeposit) throws IOException {
        Double oldBal = balance;
        balance += toDeposit;
        storeBalance(currDate, "Deposit", oldBal, "+", toDeposit);
        System.out.println("You deposited: " + toDeposit);
    }
    public static void checkBalance() {
        System.out.println("Balance: " + balance);
    }
    public static void TransactionHistory() throws FileNotFoundException {
        File TransactFile = new File(String.format(".\\%s\\Balance\\TransactionHistory.txt", userPath));
        Scanner SCTrScanner = new Scanner(TransactFile);
        while (SCTrScanner.hasNextLine()) {
            System.out.println(SCTrScanner.nextLine());
        }
    }
    public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    loginLoop = true;
    while (loginLoop) {
        System.out.println("WELCOME TO THE UM BANKING SYSTEM.");
        System.out.print("ID: ");
        int ID = sc.nextInt();
        System.out.print("PIN: ");
        int PIN = sc.nextInt();
        int IDnum = 0;
        File IDiterate;
        do {
            IDnum++;
            IDiterate = new File(String.format("010101%s", IDnum));
            userPath = String.format("010101%s", IDnum);
            File IDchecker = new File(String.format(".\\010101%s\\Credentials\\%s", IDnum, ID));
            File PINchecker = new File(String.format(".\\010101%s\\Credentials\\%s", IDnum, PIN));
            if (IDchecker.exists() && PINchecker.exists()) {
                File balanceFile = new File(String.format(".\\010101%s\\Balance\\Balance.txt", IDnum));
                Scanner SCbalance = new Scanner(balanceFile);
                if (SCbalance.hasNext()) {
                    balance = SCbalance.nextDouble();
                }
                ATMLoop = true;
                while (ATMLoop) {
                    System.out.println("WELCOME TO UM BANKING SYSTEM!\n[1]Withdraw\n[2]Deposit\n[3]Balance Inquiry\n[4]Transaction History[+\n[5]Exit");
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Amount to withdraw:");
                            Double amountWithdraw = sc.nextDouble();
                            withdraw(amountWithdraw);
                            break;
                        case 2:
                            System.out.println("Amount to withdraw:");
                            Double amounDeposit = sc.nextDouble();
                            deposit(amounDeposit);
                            break;
                        case 3:
                            checkBalance();
                            break;
                        case 4:
                            TransactionHistory();
                            break;
                        case 5:
                            ATMLoop = false;
                            errorLoop = false;
                            break;
                        default:
                            System.out.println("Choose correctly!");
                            break;
                    }
                }
            }

        } while (IDiterate.exists());
        if (!IDiterate.exists()) {
            errorLoop = true;
            while (errorLoop) {
                System.out.println("Incorrect ID or PIN!\n[1]Login\n[2]Create account");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        errorLoop = false;
                        continue;
                    case 2:
                        createAccount();
                        errorLoop = false;
                        break;
                    default:
                        System.out.println("Choose correctly");
                        break;
                }
            }
        }
    }
    }
}
