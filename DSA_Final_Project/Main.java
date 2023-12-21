package DSA_Final_Project;

import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Medical_Condition> MD = Med_Con_Config.generateMedConfig();

//    public static Triage selectTriage() {
//        Scanner io = new Scanner(System.in);
//        System.out.println("[1]EMERGENCY\n[2]URGENT\n[3]IMPORTANT\n[4]ROUTINE");
//        Triage x = null;
//        while (x == null) {
//            int choice = io.nextInt();
//            switch (choice) {
//                case 1:
//                    x = Triage.EMERGENCY;
//                    break;
//                case 2:
//                    x = Triage.URGENT;
//                    break;
//                case 3:
//                    x = Triage.IMPORTANT;
//                    break;
//                case 4:
//                    x= Triage.ROUTINE;
//                    break;
//                default:
//                    System.out.println("Incorrect choice!");
//                    io.nextInt();
//            }
//        }
//        return x;
//    }

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        Patient_Management_System system = new Patient_Management_System();

        //Menu
        while(true) {
            System.out.println("[1]PATIENT ENTRY\n[2]PATIENT QUEUE\n[3]RESOURCE ALLOCATION\n[4]GENERATE REPORT\n[5]EXIT");
            int menu_Choice = io.nextInt();
            switch (menu_Choice) {
                case 1:
                    io.nextLine();
                    while (true) {
                        System.out.println("-----------------PATIENT ENTRY-----------------");
                        System.out.print("Name:");
                        String name = io.nextLine();
                        System.out.print("Age:");
                        int age = io.nextInt();
                        io.nextLine();
                        Medical_Condition matched_med_Con = null;
                        do {
                            System.out.print("Medical Condition:");
                            String med_Con = io.nextLine();
                            matched_med_Con = match_Med_Con(med_Con);
//                            System.out.println(matched_med_Con.getMD());
                            if (matched_med_Con == null) {
                                System.out.println("No medical condition found.");
                            }
                        }
                        while (matched_med_Con == null);
                        Triage triage = matched_med_Con.getTriage();
                        Patient patient = new Patient(name, age, matched_med_Con);
                        system.addPatient(patient);
                        system.prioritizePatients(patient);
                        System.out.println("Add more? type [YES]|[NO]");
                        String addChoice = io.nextLine();
                        if (!addChoice.equalsIgnoreCase("yes")) {
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("-----------------PATIENT QUEUE-----------------");
                    system.displayPatient();
                    break;
                case 3:
                    System.out.println("-----------------RESOURCE ALLOCATION-----------------");
                    system.resource_Allocation();
                    break;
                case 4:
                    System.out.println("-----------------GENERATE REPORT-----------------");
                    while(true) {
                        System.out.println("[1]BY NAME\n[2]BY AGE");
                        int reportsOption = io.nextInt();
                        switch (reportsOption) {
                            case 1 -> system.generateReport("name");
                            case 2 -> system.generateReport("age");
                            default -> {
                            }
                        }
                        String conReport = io.nextLine();
                        if(!conReport.equalsIgnoreCase("yes")) {
                            break;
                        }
                    }
                    break;
                case 5:
                    system.serialize_patient();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect choice!");
            }
        }
    }

    private static Medical_Condition match_Med_Con(String med_Con_Input) {
        double maxPerc = 0;
        Medical_Condition bestMatch = null;
        for (Medical_Condition x : MD) {
            double matchPercentage = calMatchPerc(x.getMD(), med_Con_Input);
            if (matchPercentage >= .60 && matchPercentage > maxPerc) {
                maxPerc = matchPercentage;
                bestMatch = x;
            }
        }
        return bestMatch;
    }

    private static double calMatchPerc(String MD, String MD_Input) {
        double foundWord = 0;
        String[] userInput = MD_Input.split("\\s+");
        String[] medicalCondition = MD.split("\\s+");
        for (String word : userInput) {
            for (String x : medicalCondition) {
                if (word.equalsIgnoreCase(x)) {
                    foundWord++;
//                    System.out.println("found " + foundWord + (foundWord / medicalCondition.length));
                    break;
                }
            }
        }
        return (double) foundWord / medicalCondition.length;
    }
}
