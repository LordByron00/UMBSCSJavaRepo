import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Login {
    public static String userTempt, passTempt, userInput, passInput, name, surname;
    public static boolean login_loop = true;
    public static void main(String[] args) throws IOException {

        Scanner Input = new Scanner(System.in);
        File userfile = new File("userlist.txt");
        File passfile = new File("passlist.txt");
        
        while(login_loop) { 
            try {
                userfile.createNewFile();
                passfile.createNewFile();
                Scanner userScanner = new Scanner(userfile);
                Scanner passScanner = new Scanner(passfile);
                    if (userScanner.hasNextLine() && passScanner.hasNextLine()) {
                        System.out.print("Username: ");
                        userInput = Input.nextLine();
                        System.out.print("Password: ");
                        passInput = Input.nextLine();
                        while (userScanner.hasNextLine() || passScanner.hasNextLine()) {
                            userTempt = userScanner.nextLine();
                            passTempt = passScanner.nextLine();
                            if (userInput.equals(userTempt) && passInput.equals(passTempt)) {
                                System.out.println("Welcome " + name + " " + surname);
                                login_loop = false;
                            }
                        }
                        
                        login_loop = false;
                    } else {
                        System.out.println("CREATE ACCOUNT:");
                        System.out.print("Enter name:");
                        name = Input.nextLine();
                        System.out.print("Enter surname: ");
                        surname = Input.nextLine();
                        System.out.print("Enter username:");
                        userInput = Input.nextLine();
                        System.out.print("Enter password: ");
                        passInput = Input.nextLine();
                        FileWriter userWriter = new FileWriter("userlist.txt");
                        FileWriter passWriter = new FileWriter("passlist.txt");
                        userWriter.write(userInput);
                        passWriter.write(passInput);
                        userWriter.close();
                        passWriter.close();
                        
                    }
                
    
            } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }
        }
    }
}
