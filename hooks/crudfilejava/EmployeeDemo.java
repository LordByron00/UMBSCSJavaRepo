//CLASS EMPLOYEE RECORD
package hooks.crudfilejava;

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

public class EmployeeDemo {


    public static void main(String arg[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        Scanner tsc = new Scanner(System.in);
        File file = new File("employee.txt");

        ArrayList<Employee> al = new ArrayList<>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            al = (ArrayList<Employee>) ois.readObject();
            ois.close();
        }


        int choice = -1;

        do {
            System.out.println("1.INSERT");
            System.out.println("2.DISPLAY");
            System.out.println("3.SEARCH");
            System.out.println("4.DELETE");
            System.out.println("5.UPDATE");
            System.out.println("6.SORT By Empno - On Screen ");
            System.out.println("7.SORT By Empno - In File ");
            System.out.println("8.SORT By Ename - On Screen ");
            System.out.println("9.SORT By Ename - In File ");
            System.out.println("10.SORT By Salary Descending - On Screen ");
            System.out.println("11.SORT By Salary Ascending - In File ");
            System.out.println("0.EXIT");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter how many employees you want? ; ");
                    int n = sc.nextInt();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter Employee No.: ");
                        int empno = sc.nextInt();

                        System.out.print("Enter Employee Name: ");
                        String ename = tsc.nextLine();

                        System.out.print("Enter Employee Salary: ");
                        int salary = sc.nextInt();

                        al.add(new Employee(empno, ename, salary));
                    }
                    oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(al);
                    oos.close();
                    break;
                case 2:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        ois.close();

                        System.out.println("------------------------");
                        li = al.listIterator();

                        while (li.hasNext())
                            System.out.println(li.next());
                        System.out.println("------------------------");
                    } else {
                        System.out.println("File Not Exists...!");
                    }

                    break;
                case 3:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        ois.close();

                        Boolean found = false;
                        System.out.println("Enter the Employee Number to Search: ");
                        int empno = sc.nextInt();
                        System.out.println("------------------------");
                        li = al.listIterator();

                        while (li.hasNext()) {
                            Employee e = (Employee) li.next();
                            if (e.empno == empno) {
                                System.out.println(e);
                                found = true;
                            }
                        }
                        if (!found)
                            System.out.println("Record Not Found...!");
                        System.out.println("------------------------");
                    } else {
                        System.out.println("File Not Exists...!");
                    }
                    break;
                case 4:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        ois.close();

                        Boolean found = false;
                        System.out.println("Enter the Employee Number to Delete: ");
                        int empno = sc.nextInt();
                        System.out.println("------------------------");
                        li = al.listIterator();

                        while (li.hasNext()) {
                            Employee e = (Employee) li.next();
                            if (e.empno == empno) {
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
                case 5:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        ois.close();

                        Boolean found = false;
                        System.out.println("Enter the Employee Number to Update: ");
                        int empno = sc.nextInt();
                        System.out.println("------------------------");
                        li = al.listIterator();

                        while (li.hasNext()) {
                            Employee e = (Employee) li.next();
                            if (e.empno == empno) {
                                System.out.print("Enter New Employee Name: ");
                                String ename = tsc.nextLine();

                                System.out.print("Enter New Salary: ");
                                int sal = sc.nextInt();
                                li.set(new Employee(empno, ename, sal));

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
                case 6:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        ois.close();

                        Collections.sort(al, new Comparator<Employee>() {
                            public int compare(Employee e1, Employee e2) {
                                return e1.empno - e2.empno;
                            }
                        });
                        System.out.println("------------------------");
                        li = al.listIterator();

                        while (li.hasNext())
                            System.out.println(li.next());
                        System.out.println("------------------------");
                    } else {
                        System.out.println("File Not Exists...!");
                    }

                    break;
                case 7:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        ois.close();

                        Collections.sort(al, new Comparator<Employee>() {
                            public int compare(Employee e1, Employee e2) {
                                return e1.empno - e2.empno;
                            }
                        });

                        oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(al);
                        oos.close();

                        System.out.println("------------------------");
                        li = al.listIterator();

                        while (li.hasNext())
                            System.out.println(li.next());
                        System.out.println("------------------------");
                    } else {
                        System.out.println("File Not Exists...!");
                    }

                    break;
                case 8:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        ois.close();

                        Collections.sort(al, new Comparator<Employee>() {
                            public int compare(Employee e1, Employee e2) {
                                return e1.ename.compareTo(e2.ename);
                            }
                        });
                        System.out.println("------------------------");
                        li = al.listIterator();

                        while (li.hasNext())
                            System.out.println(li.next());
                        System.out.println("------------------------");
                    } else {
                        System.out.println("File Not Exists...!");
                    }

                    break;
                case 9:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        ois.close();

                        Collections.sort(al, new Comparator<Employee>() {
                            public int compare(Employee e1, Employee e2) {
                                return e1.ename.compareTo(e2.ename);
                            }
                        });

                        oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(al);
                        oos.close();

                        System.out.println("------------------------");
                        li = al.listIterator();

                        while (li.hasNext())
                            System.out.println(li.next());
                        System.out.println("------------------------");
                    } else {
                        System.out.println("File Not Exists...!");
                    }

                    break;
                case 10:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        ois.close();

                        Collections.sort(al, new Comparator<Employee>() {
                            public int compare(Employee e1, Employee e2) {
                                return e2.salary - e1.salary;
                            }
                        });
                        System.out.println("------------------------");
                        li = al.listIterator();

                        while (li.hasNext())
                            System.out.println(li.next());
                        System.out.println("------------------------");
                    } else {
                        System.out.println("File Not Exists...!");
                    }

                    break;
                case 11:
                    if (file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        ois.close();

                        Collections.sort(al, new Comparator<Employee>() {
                            public int compare(Employee e1, Employee e2) {
                                return e1.salary - e2.salary;
                            }
                        });

                        oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(al);
                        oos.close();

                        System.out.println("------------------------");
                        li = al.listIterator();

                        while (li.hasNext())
                            System.out.println(li.next());
                        System.out.println("------------------------");
                    } else {
                        System.out.println("File Not Exists...!");
                    }

                    break;
            }
        } while (choice != 0);
    }
}