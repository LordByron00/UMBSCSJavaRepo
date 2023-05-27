package CCE.Activities;

import java.util.Scanner;

public class Quiz {

    public static int stars, i, j;
    public static String[] starsNum;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("************* STAR **************");
        System.out.println("Enter number of stars: ");
        stars = input.nextInt();
        for (i = 0; stars >= 0; stars--) {
            for (j = 0; j <= stars - 1; j++) {
                System.out.print(" * ");
            }
            System.out.println();

        }
    }
}
