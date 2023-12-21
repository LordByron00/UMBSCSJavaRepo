package DSA_Carlo;

import java.util.Scanner;

public class Main {

    public static Priority selectTriage() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("[1]EMERGENCY\n[2]URGENT\n[3]NONCRITICAL");
        Priority x = null;
        while (x == null) {
            int choice = userInput.nextInt();
            switch (choice) {
                case 1:
                    x = Priority.EMERGENCY;
                    break;
                case 2:
                    x = Priority.URGENT;
                    break;
                case 3:
                    x = Priority.NONCRITICAL;
                    break;
                default:
                    System.out.println("Incorrect choice!");
            }
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Management system = new Management();

        while(true) {
            System.out.println("1. Patient Entry\n2. Patient Queue\n3. Allocation \n4. Report Generation\n5. Exit");
            int mC = userInput.nextInt();
            switch (mC) {
                case 1:
                    userInput.nextLine();
                    while (true) {
                        System.out.println("-----------------PATIENT ENTRY-----------------");
                        System.out.print("Name:");
                        String name = userInput.nextLine();
                        System.out.print("Age:");
                        int age = userInput.nextInt();
                        userInput.nextLine();
                        System.out.print("Medical Condition:");
                        String med_Con = userInput.nextLine();
                        Priority priority = selectTriage();

                        People people = new People(name, age, med_Con, priority);
                        system.addPatient(people);

                        System.out.println("Add more? type [YES]|[NO]");
                        String addChoice = userInput.nextLine();
                        if (!addChoice.equalsIgnoreCase("yes")) {
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Patient queue:");
                    system.patientQueue();
                    break;
                case 3:
                    System.out.println("Allocation:");
                    system.allocation();
                    break;
                case 4:
                    System.out.println("Generate Report:");
                        System.out.println("1. Report by Name \n2. Report by Age");
                        int reportsOption = userInput.nextInt();
                        switch (reportsOption) {
                            case 1 -> system.reportGen("name");
                            case 2 -> system.reportGen("age");
                            default -> {
                            }
                        }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
