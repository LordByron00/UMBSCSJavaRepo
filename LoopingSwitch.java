import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class LoopingSwitch {
    public static double height, base, area;
    public static boolean looping = true, loopingglb = true;
    public static String userString;
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        System.out.println("*************JAVA************");
        System.out.println("Enter 1 to proceed: ");
        int userInput = Input.nextInt();
        while (loopingglb) {
        if (userInput == 1) {
            System.out.println("MAIN MENU SELECTION: \n [1] FORMULA FOR PARALLELOGRAM \n [2] LOOP \n [3] ARRAY \n [4] EXIT");
            userInput = Input.nextInt();
            looping = true;
            switch (userInput) {
                case 1:
                    while (looping) {
                        looping = true;
                        System.out.println("\n CALCULATIONS FOR PARALLELOGRAM: \n [1]SOLVE AREA \n [2]SOLVE HEIGHT \n [3]SOLVE BASE \n");
                        userInput = Input.nextInt();
                        switch (userInput) {
                            case 1:
                                System.out.println("ENTER HEIGHT: ");
                                height = Math.abs(Input.nextDouble());
                                System.out.println("ENTER BASE: ");
                                base = Math.abs(Input.nextDouble());
                                area = height * base;
                                System.out.printf("AREA: %.2f", area);
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("ENTER AREA: ");
                                area = Math.abs(Input.nextDouble());
                                System.out.println("ENTER BASE: ");
                                base = Math.abs(Input.nextDouble());
                                height = area / base;
                                System.out.printf("HEIGHT: %.2f", height);
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("ENTER AREA: ");
                                area = Math.abs(Input.nextDouble());
                                System.out.println("ENTER HEIGHT: ");
                                height = Math.abs(Input.nextDouble());
                                base = area / height;
                                System.out.printf("HEIGHT: %.2f", base);
                                System.out.println();
                                break;
                            default:
                                userInput = 1;
                                looping = false;
                                System.out.println("Thank you for using. \n");
                                continue;
                        }
                    }
                    break;
                case 2:
                    looping = true;
                    while (looping) {
                        System.out.println("ENTER VALUE OF STAR: ");
                        userInput = Input.nextInt();
                        while (userInput <= 0) {
                            System.out.println("Enter positive value.");
                            userInput = Input.nextInt();
                        }
                        for (int i = userInput; i > 0; i--) {
                            for (int j = 0; j < i; j++) {
                                System.out.print(" * ");
                            }
                            System.out.println();
                        }
                        
                        for (int k = 0; k < userInput; k++) {
                            for (int l = 0; l <= k; l++) {
                                System.out.print(" * ");
                            }
                            System.out.println();
                        }
                        System.out.println("Do you want to proceed?[Y/N]");
                        String userInput1 = Input.next();
                        switch (userInput1) {
                            case "y":
                                looping = true;
                                break;
                            case "Y":
                                looping = true;
                                break;
                            default:
                                userInput = 1;
                                looping = false;
                                continue;
                        }
                    } 
                    break;
                case 3:
                int elemValue;
                System.out.println("ENTER THE VALUE YOU WANT TO STORE:");
                ArrayList<String> ElementArray = new ArrayList<String>();
                while (Input.hasNextInt()) {
                    elemValue = Input.nextInt();
                    while (elemValue < 0) {
                        System.out.println("Input positive value.");
                        elemValue = Input.nextInt();
                    }
                    String ArrayString = String.valueOf(elemValue);
                    ElementArray.add(ArrayString);
                }
                // other method
                // String[] arrayElem = ElementArray.toArray(new String[0]);
                // System.out.println(Arrays.toString(arrayElem));
                int size = ElementArray.size();
                String[] ArrayElem2 = new String[size];
                for (int i = 0; i < ElementArray.size(); i++) {
                    ArrayElem2[i] = ElementArray.get(i);
                }
                System.out.println(Arrays.toString(ArrayElem2));
                looping = false;
                break;
                case 4:
                    loopingglb = false;
                    break;
                default:
                    System.out.println("Choose the right number.");
                    userInput = 1;
                    continue;
            }
        } else {
            loopingglb = false;
            System.out.println("Thank you. See you next time.");
        }
    }
    }
}
