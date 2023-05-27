package CCE.Activities;

import java.util.Scanner;

public class StudentGradeEvaluator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean looping = true;

        System.out.println("*****Student Grade level evaluator*****");


        while (looping) {
            System.out.println("ENTER NAME: ");
            String name = scanner.next();
            System.out.println();
            System.out.println("ENTER AGE[5-12]: ");
            int age = scanner.nextInt();
            System.out.println();
            if (age >= 5 && age <= 7) {
                System.out.print("ENTER GRADE LEVEL[1-6]: \n");
                int gradeLevel = scanner.nextInt();
                System.out.println();
                if (gradeLevel == 1) {
                    System.out.println(name + " is at the right grade level, Grade 1!\n");
                } else {
                    System.out.println(name + " is not at the right grade level.\nYou are supposed to be Grade 1.\n");
                }
            } else if (age == 8) {
                System.out.print("ENTER GRADE LEVEL[1-6]: \n");
                int gradeLevel = scanner.nextInt();
                System.out.println();
                if (gradeLevel == 2) {
                    System.out.println(name + " is at the right grade level, Grade 2!\n");
                } else {
                    System.out.println(name + " is not at the right grade level.\nYou are supposed to be Grade 2.\n");
                }
            } else if (age == 9) {
                System.out.print("ENTER GRADE LEVEL[1-6]: \n");
                int gradeLevel = scanner.nextInt();
                System.out.println();
                if (gradeLevel == 3) {
                    System.out.println(name + " is at the right grade level, Grade 3!\n");
                } else {
                    System.out.println(name + " is not at the right grade level.\nYou are supposed to be Grade 3.\n");
                }
            } else if (age == 10) {
                System.out.print("ENTER GRADE LEVEL[1-6]: \n");
                int gradeLevel = scanner.nextInt();
                System.out.println();
                if (gradeLevel == 4) {
                    System.out.println(name + " is at the right grade level, Grade 4!\n");
                } else {
                    System.out.println(name + " is not at the right grade level.\nYou are supposed to be Grade 4.\n");
                }
            } else if (age == 11) {
                System.out.print("ENTER GRADE LEVEL[1-6]: \n");
                int gradeLevel = scanner.nextInt();
                System.out.println();
                if (gradeLevel == 5) {
                    System.out.println(name + " is at the right grade level, Grade 5!\n");
                } else {
                    System.out.println(name + " is not at the right grade level.\nYou are supposed to be Grade 5.\n");
                }
            } else if (age == 12) {
                System.out.print("ENTER GRADE LEVEL[1-6]: \n");
                int gradeLevel = scanner.nextInt();
                System.out.println();
                if (gradeLevel == 6) {
                    System.out.println(name + " is at the right grade level, Grade 6!\n");
                } else {
                    System.out.println(name + " is not at the right grade level.\nYou are supposed to be Grade 6.\n");
                }
            } else {
                System.out.println("Invalid age input.\n");
            }
        }
    }
}