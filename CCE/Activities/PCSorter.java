package CCE.Activities;

import java.util.Scanner;
import java.util.Arrays;


public class PCSorter {
    public static String Composite = "", Prime = "";
    public static int[] Numbers = new int[10];

    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        System.out.println("Enter 10 numeric value: ");
        for (int i = 0; i < Numbers.length; i++) {
            int NumInput = Input.nextInt();
            while (NumInput < 2) {
                System.out.println("It is neither a prime or composite. Enter value greater than 1.");
                NumInput = Input.nextInt();

            }
            if (NumInput % 2 == 0) {
                Numbers[i] = NumInput;
                Prime += NumInput + ", ";
            } else {
                Numbers[i] = NumInput;
                Composite += NumInput + ", ";
            }
        }
        System.out.println("Prime Numbers: " + Prime);
        System.out.println("Composite Numbers: " + Composite);
        System.out.println("Array: " + Arrays.toString(Numbers));
    }
}
