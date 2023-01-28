import java.util.Scanner;

public class loopingInput {
    public static int starInput, i, j, k, l;
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        System.out.println("******** STARS *************");
        System.out.println("Enter the number of stars:");
        starInput = Input.nextInt();
        if (starInput >= 2) {
            while ( starInput >= 2) {
                for (i = starInput; i > 0; i--) {
                    for (j = 0; j < i; j++) {
                        System.out.print(" * ");
                    }
                    System.out.println();
                }
            
                for (k = 0; k < starInput; k++) {
                    for (l = 0; l <= k; l++) {
                        System.out.print(" * ");
                    }
                    System.out.println();
                }
                
                System.out.println("Enter the number of stars:");
                starInput = Input.nextInt();
                while (starInput < 2) {
                    System.out.println("Enter the value not less than:");
                    starInput = Input.nextInt();
                }
            }
        } else {
            while (starInput < 2) {
                System.out.println("Enter the value not less than 2:");
                starInput = Input.nextInt();
                while ( starInput >= 2) {
                    System.out.println("number: " + starInput);
                    System.out.println("Enter the number of stars:");
                    starInput = Input.nextInt();
                }
            }
        }
    }
}
