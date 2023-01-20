
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.table.*;

public class fileHandling {
    private static String name, birthday, gender;
    private static int age, contactNum;
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        // for (int i = 0; i < 1; i++) {
        //     int counter = i + 1;
        //     System.out.println("Person #" + counter);
        //     System.out.println("Enter your name: ");
        //     name = inputScanner.next();
        //     System.out.println("Enter your birthday: ");
        //     birthday = inputScanner.next();
        //     System.out.println("Gender: ");
        //     gender = inputScanner.next();
        //     System.out.println("Enter age: ");
        //     age = inputScanner.nextInt();
        //     System.out.println("Contact Number: ");
        //     contactNum = inputScanner.nextInt();
        //     System.out.println();

        //     try {
        //         FileWriter fw = new FileWriter("phonebook.txt", true);
        //         BufferedWriter bw = new BufferedWriter(fw);
        //         bw.write(name + " " + age + " " + birthday + " " + gender + " " + age + " " + contactNum + " \n");
        //         bw.close();
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }
        // }
        
        System.out.println("[1]Read File\n[2]Exit");
        int choice = inputScanner.nextInt();
        String[] columnNames = {"Name", "Birthday", "Gender", "Age", "Contact Number"};
        
        if (choice == 1) {
            Object[][] data = new Object[5][10];
            try {
                FileReader fr = new FileReader("phonebook.txt");
                BufferedReader br = new BufferedReader(fr);
                String dataValue;
                
                int i = 0;
                while((dataValue = br.readLine()) != null) {
                    System.out.println(dataValue);
                    for (int j = 0; j < data.length; j++) {
                        data[i] = dataValue.split(" ");
                    }
                    i++;
                }

                br.close();
    
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            JTable table = new JTable(data, columnNames);
            JScrollPane JScrollPane = new JScrollPane(table);
            JFrame frame = new JFrame("10 students' information.");
            frame.add(JScrollPane);
            frame.setSize(600, 300);
            frame.setVisible(true);
        }
        


    }
}

/* Performance task. 
Create a program that will creata list of contacts of 10 persons. Name your text file with "phonebook.txt" 
that contains data item to be stored: name, birthday, gender, age, and contact number. The program allows the user to input data 
and store it in a "phonebook.txt" file, and read the data from the text. */