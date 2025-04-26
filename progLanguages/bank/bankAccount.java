package progLanguages.bank;

import java.util.ArrayList;
import java.util.List;

public class bankAccount {
    private final String fullName;
    private final int accountNum;
    private final int PIN;
    private double balance;
    private final List<transaction> history = new ArrayList<>();

    public bankAccount(String name, int accNum, int PIN, double balance, transaction history) {
        this.fullName = name;
        this.accountNum = accNum;
        this.PIN = PIN;
        this.balance = balance;
        this.history.add(history);
    }

    public String getName() {
        return this.fullName;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getAccountNum() {
        return this.accountNum;
    }

    public int getPIN() {
        return this.PIN;
    }

    public List<transaction> getHistory() {
        return this.history;
    }

    public void addTransaction(transaction transaction) {
        history.add(transaction);
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void deposit(double value2) {
        this.balance += value2;
    }

}
