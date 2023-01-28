package src;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;


public class fileHandling {
    private static String name;
    private static String birthday;
    private static String gender;
    private static int age, contactNum, person_Count, lineCounter = 0;
    private static boolean looping = true;
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        String[] columnNames = {"Name", "Birthday", "Gender", "Age", "Contact Number"};
        Object[][] data = new Object[10][5];


        while(looping) {
            System.out.println("[1]ADD PERSON\n[2]READ DATA\n[3]EXIT");
            int choice = inputScanner.nextInt();
            switch (choice) {
                case 1:

                    try {
                        // To find if there are informations already stored in the files through iterating if the file has next line.
                        FileWriter wr = new FileWriter("phonebook.txt", true);
                        BufferedReader brLine = new BufferedReader(new FileReader("phonebook.txt"));
                        String textLine = brLine.readLine();
                        while (textLine != null) {
                            lineCounter++;
                            textLine = brLine.readLine();
                        }
                        brLine.close();
                    } catch (Exception e) {
                        System.err.print("IOException error");
                        e.printStackTrace();
                    }
                    //Set the lineCounter as the person_Count to start the iteration there. Ask for input to be stored.
                    for (person_Count = lineCounter; person_Count < data.length; person_Count++) {
                        int counter = person_Count + 1;
                        System.out.println("Person #" + counter);
                        System.out.println("Enter your name: ");
                        name = inputScanner.next();
                        System.out.println();
                        System.out.println("Enter your birthday: ");
                        System.out.print("Month: ");
                        birthday = inputScanner.next() + " ";
                        System.out.print("Day: ");
                        birthday = birthday + inputScanner.next() + " ";
                        System.out.print("Year: ");
                        birthday = birthday + inputScanner.next();
                        System.out.println();
                        System.out.println("Gender: ");
                        gender = inputScanner.next();
                        System.out.println();
                        System.out.println("Enter age: ");
                        age = inputScanner.nextInt();
                        System.out.println("Contact Number: ");
                        contactNum = inputScanner.nextInt();
                        System.out.println();
                        //Write the information inputted to the file phonebook.txt
                        try {
                            FileWriter fw = new FileWriter("phonebook.txt", true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(name + ", " + birthday + ", " + gender + ", " + age + ", " + contactNum + ", ");
                            bw.newLine();
                            bw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    break;
                case 2:

                    try {
                        File exist = new File("phonebook.txt");
                        if (!exist.exists()) {
                            exist.createNewFile();
                        }
                        BufferedReader br = new BufferedReader(new FileReader("phonebook.txt"));
                        String dataValue;
                        int i = 0;
                        while((dataValue = br.readLine()) != null) {
                            System.out.println(dataValue);
                            if (i < data.length) {
                                data[i] = dataValue.split(", ");
                            }
                            i++;
                        }
                        br.close();
//                        System.out.println(Arrays.deepToString(data));

                    } catch (IOException e) {
                        System.err.print("IOException error");
                        e.printStackTrace();
                    }
                    JTable table = new JTable(data, columnNames);
                    JScrollPane JScrollPane = new JScrollPane(table);
                    JFrame frame = new JFrame("10 students' information.");
                    frame.add(JScrollPane);
                    frame.setSize(700, 400);
                    frame.setVisible(true);
                    DefaultTableCellRenderer CenterRender = new DefaultTableCellRenderer();
                    CenterRender.setHorizontalAlignment(JLabel.CENTER);
                    table.setDefaultRenderer(Object.class, CenterRender);
                    break;
                case 3:
                    System.out.println("Good bye!");
                    looping = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.\n");
                    break;
            }
        }

    }
}
