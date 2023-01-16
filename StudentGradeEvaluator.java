import java.util.Scanner;

public class StudentGradeEvaluator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ENTER NAME: ");
        String name = scanner.nextLine();

        System.out.print("ENTER AGE: ");
        int age = scanner.nextInt();

        System.out.print("ENTER GRADE LEVEL: ");
        int gradeLevel = scanner.nextInt();

        if (age <= 5 && age >= 7) {
            if (gradeLevel == 1) {
                System.out.println(name + " is at the right level!");
            } else {
                System.out.println(name + " is not at the right level.");
            }
        } else if (age == 8) {
            if (gradeLevel == 2) {
                System.out.println(name + " is at the right level!");
            } else {
                System.out.println(name + " is not at the right level.");
            }
        } else if (age == 9) {
            if (gradeLevel == 3) {
                System.out.println(name + " is at the right level!");
            } else {
                System.out.println(name + " is not at the right level.");
            }
        } else if (age == 10) {
            if (gradeLevel == 4) {
                System.out.println(name + " is at the right level!");
            } else {
                System.out.println(name + " is not at the right level.");
            }
        } else if (age == 11) {
            if (gradeLevel == 5) {
                System.out.println(name + " is at the right level!");
            } else {
                System.out.println(name + " is not at the right level.");
            }
        } else if (age == 12) {
            if (gradeLevel == 6) {
                System.out.println(name + " is at the right level!");
            } else {
                System.out.println(name + " is not at the right level.");
            }
        } else {
            System.out.println("Invalid age input.");
        }
    }
}