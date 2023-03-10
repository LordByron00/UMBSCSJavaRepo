package crudfilejava;

import java.io.File;
import java.io.FileOutputStream;
import java.io.*;
import java.lang.Exception;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Scanner;

public class StudentDemo {


    public static void main(String arg[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        Scanner tsc = new Scanner(System.in);
        File file = new File("Students.txt");

        ArrayList<students> al = new ArrayList<>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            al = (ArrayList<students>) ois.readObject();
            ois.close();
        }


        int choice = -1;

        do {
            System.out.println("1.ADD");
            System.out.println("2.DISPLAY");
            System.out.println("3.DELETE");
            System.out.println("4.UPDATE");
            System.out.println("0.EXIT");
            System.out.print("$: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:

                    for (int i = 0; i < 10; i++) {
                        System.out.print("Enter Student ID: ");
                        int SID = sc.nextInt();

                        System.out.print("Enter Student Name: ");
                        String Sname = tsc.nextLine();

                        System.out.print("Enter Math grades: ");
                        int math = sc.nextInt();
                        System.out.print("Enter Science grades: ");
                        int science = sc.nextInt();
                        System.out.print("Enter english grades: ");
                        int english = sc.nextInt();
                        System.out.print("Enter Filipino grades: ");
                        int Filipino = sc.nextInt();
                        System.out.print("Enter Social Studies grades: ");
                        int Social_Studies = sc.nextInt();
                        int average = (math + science + english + Filipino + Social_Studies) / 5;
                        al.add(new students(SID, Sname, math, science, english, Filipino, Social_Studies, average));
                    }
                    oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(al);
                    oos.close();
                    break;
                case 2:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<students>) ois.readObject();
                        ois.close();
                        li = al.listIterator();

                        int av = 0;
                        int counter = 0;
                        System.out.println("AVERAGE GRADES:");
                        while (li.hasNext()) {
                            students e = (students) li.next();
                            av += e.average;
                            System.out.println(e.Sname + "(" + e.SID + "): " + e.average);
                            counter++;
                        }
                        int average = av / counter;
                        System.out.println("\nClass Average: " + average + "\n");
                    } else {
                        System.out.println("File Not Exists...!");
                    }
                    break;
                case 3:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<students>) ois.readObject();
                        ois.close();

                        Boolean found = false;
                        System.out.println("Enter the ID number to Delete: ");
                        int SID = sc.nextInt();
                        System.out.println("------------------------");
                        li = al.listIterator();

                        while (li.hasNext()) {
                            students e = (students) li.next();
                            if (e.SID == SID) {
                                // System.out.println(e);
                                li.remove();
                                found = true;
                            }
                        }
                        if (found) {
                            oos = new ObjectOutputStream(new FileOutputStream(file));
                            oos.writeObject(al);
                            oos.close();
                            System.out.println("Record Deleted Successfully...!");
                        } else {
                            System.out.println("Record Not Found...!");
                        }
                        System.out.println("------------------------");
                    } else {
                        System.out.println("File Not Exists...!");
                    }
                    break;
                case 4:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<students>) ois.readObject();
                        ois.close();

                        Boolean found = false;
                        System.out.println("Enter the ID number to Update: ");
                        int SID = sc.nextInt();
                        System.out.println("------------------------");
                        li = al.listIterator();

                        while (li.hasNext()) {
                            students e = (students) li.next();
                            if (e.SID == SID) {
                                System.out.print("Enter New Student Name: ");
                                String Sname = tsc.nextLine();
                                System.out.print("Enter new Math grades: ");
                                int math = sc.nextInt();
                                System.out.print("Enter new Science grades: ");
                                int science = sc.nextInt();
                                System.out.print("Enter new english grades: ");
                                int english = sc.nextInt();
                                System.out.print("Enter new Filipino grades: ");
                                int Filipino = sc.nextInt();
                                System.out.print("Enter new Social Studies grades: ");
                                int Social_Studies = sc.nextInt();
                                int average = (math + science + english + Filipino + Social_Studies) / 5;
                                li.set(new students(SID, Sname, math, science, english, Filipino, Social_Studies, average));

                                // System.out.println(e);
                                //li.remove();
                                found = true;
                            }
                        }
                        if (found) {
                            oos = new ObjectOutputStream(new FileOutputStream(file));
                            oos.writeObject(al);
                            oos.close();
                            System.out.println("Record Updates Successfully...!");
                        } else {
                            System.out.println("Record Not Found...!");
                        }
                        System.out.println("------------------------");
                    } else {
                        System.out.println("File Not Exists...!");
                    }
                    break;
            }
        } while (choice != 0);
    }
}