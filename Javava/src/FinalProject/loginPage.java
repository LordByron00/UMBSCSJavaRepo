package FinalProject;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class loginPage {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner x = new Scanner(System.in);
		System.out.println("User:");
		String username = x.nextLine();
		System.out.println("Password:");
		String password = x.nextLine();
		FileInputStream file = new FileInputStream("Users.ser");
		ObjectInputStream ObjectReader = new ObjectInputStream(file);
		User userObject;

		// Checking whether the user exists
		boolean userFound = false;
		try {
			while ((userObject = (User) ObjectReader.readObject()) != null) {
				if (username.equals(userObject.getUser())) {
					userFound = true;
					if (password.equals(userObject.getPass())) {
						System.out.println("Hello, " + userObject.getUser());
					} else {
						System.out.println("Incorrect password!");
					}
					break;
				}
			}
		} catch (EOFException e) {
			// End of file reached
		}

		if (!userFound) {
			System.out.println("User not found!");
		}

		ObjectReader.close();
		file.close();
	}
}