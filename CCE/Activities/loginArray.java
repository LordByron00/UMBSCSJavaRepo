package CCE.Activities;

import java.util.ArrayList;
import java.util.Scanner;

public class loginArray {
    public static ArrayList<String> usernamelist = new ArrayList<String>();
    public static ArrayList<String> passwordlist = new ArrayList<String>();
    public static String username, password;

    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        for (int x = 0; x < 3; x++) {
            System.out.print("Enter username: ");
            username = Input.next();
            usernamelist.add(username);
            System.out.print("Enter password: ");
            password = Input.next();
            passwordlist.add(password);
        }

        System.out.println(usernamelist.toString() + " " + passwordlist.toString());
        System.out.println("Username: ");
        username = Input.nextLine();
        System.out.println("Password: ");
        password = Input.nextLine();
        for (int i = 0; i < usernamelist.size(); i++) {
            if (username.equals(usernamelist.get(i)) && password.equals(passwordlist.get(i))) {
                System.out.println("Welcome to the banking system.");
                break;
            }
            if (i == usernamelist.size() - 1) {
                if (!username.equals(usernamelist.get(usernamelist.size() - 1)) && !password.equals(passwordlist.get(passwordlist.size() - 1))) {
                    System.out.println("Incorrect username or password.");
                }
            }
        }
    }
}
