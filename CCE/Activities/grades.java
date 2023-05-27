package CCE.Activities;

import java.util.*;
import java.lang.String;
import java.util.Arrays;

public class grades {
    static int[] findBigSmall(int[] count, int length) {
        int small = count[0];
        int big = count[0];
        for (int i = 0; i < length; i++) {
            if (count[i] < small) {
                small = count[i];
            } else if (count[i] > big) {
                big = count[i];
            }
        }
        int[] ans = new int[2];
        ans[0] = small;
        ans[1] = big;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Do you want to proceed?");

        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        switch (choice) {
            case "yes":
            case "y":
            case "YES":
            case "Y":
            case "sige lods":
            case "Yes":

                Scanner grade = new Scanner(System.in);
                System.out.println("Enter your first name:");
                String fn = grade.nextLine();
                System.out.println("Enter your last name:");
                String ln = grade.nextLine();
                System.out.println("Enter your ID number:");
                String idnumber = grade.nextLine();
                System.out.println("Enter your code:");
                String code = grade.nextLine();

                System.out.println("How many subjects do you want to load?");
                int[] count = new int[5];
                int subcount = grade.nextInt();
                if (subcount > 5) {
                    System.out.println("There are only 5 subjects available. Please try again.");
                    break;
                } else {
                    System.out.println("Enter grade of your subjects: ");
                    {
                        for (int i = 0; i < subcount; i++) {
                            int value;
                            value = grade.nextInt();
                            count[i] = value;
                            if (value < 50) {
                                System.out.println("Invalid Grade");
                            }
                        }
                        int length = count.length;
                        int sum = 0;
                        for (int j = 0; j < count.length; j++) {
                            Math.round(sum += count[j]);
                        }
                        int average = Math.round(sum / length);

                        System.out.println("**************EVALUATING SYSTEM**************");
                        System.out.println("");
                        System.out.println("Name: " + fn + " " + ln);
                        System.out.println("ID: " + idnumber);
                        System.out.println("Code: " + code);
                        System.out.println("");

                        java.util.Collections.reverse(Arrays.asList(count));
                        System.out.println(Arrays.toString(count));
                        System.out.println("");

                        int[] ans = findBigSmall(count, length);
                        System.out.println("Highest grade is " + ans[1]);
                        System.out.println("Lowest grade is " + ans[0]);
                        System.out.println("Average: " + average);

                        System.out.println("");
                        if (average > 75) {
                            System.out.println(ln + " has passed the subjects.");
                        } else {
                            System.out.println(ln + " has failed a subject.");
                        }
                        System.out.println("");

                        break;
                    }
                }
            case "no":
            case "n":
            case "N":
            case "NO":
            case "kapoy":
            case "dili":
            case "No":

                break;
        }
        System.out.println("*****************THANK YOU!*****************");

    }
}





