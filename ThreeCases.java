import java.util.ArrayList;
import java.util.Scanner;

public class ThreeCases {
    public static int userInput, base, height, calculation, starIn, elemValue;
    public static boolean looping = true;
    public static void main(String[] args) {

        Scanner InputScanner = new Scanner(System.in);
        
        System.out.println("*************** JAVA ******************");
        

        while (looping) {
            System.out.println("MAIN MENU SELECTION: \n[1]CALCULATION \n[2]LOOP \n[3]ARRAY ");
            userInput = InputScanner.nextInt();
        switch (userInput) {
            case 1:
                System.out.println("ENTER THE BASE:");
                base = InputScanner.nextInt();
                System.out.println("ENTER THE HEIGHT:");
                height = InputScanner.nextInt();
                calculation = (base * height) / 2;
                System.out.println("AREA OF TRIANGLE: " + calculation + ".");
                System.out.println("Thank you for using! \n");
                break;
            case 2:
                System.out.println("ENTER THE NUMBER OF STARS:");
                starIn = InputScanner.nextInt();
                for (int i = starIn; i > 0; i--) {
                    for (int j = 0; j < i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                System.out.println("Thank you for using loop. \n");
                break;
            case 3:
                System.out.println("ENTER THE VALUE YOU WANT TO STORE:");
                ArrayList<String> ElementArray = new ArrayList<String>();
                while (InputScanner.hasNextInt()) {
                    elemValue = InputScanner.nextInt();
                    String ArrayString = String.valueOf(elemValue);
                    ElementArray.add(ArrayString);
                }
                System.out.println(ElementArray);
                looping = false;
                break;
            default:
                System.out.println("Choose the right option[1-3] \n");
                break;
        }
        }
        
    }
}
