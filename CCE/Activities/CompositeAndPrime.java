package CCE.Activities;

import java.util.Scanner;
import java.util.ArrayList;

// CREATE A JAVA PROGRAM USING ARRAY TO DISPLAY COMPOSITE AND PRIME NUMBERS.
//Chan
public class CompositeAndPrime {
    public static ArrayList<Integer> Composite = new ArrayList<Integer>();
    public static ArrayList<Integer> prime = new ArrayList<Integer>();
    public static ArrayList<Integer> ArrayNumbers = new ArrayList<Integer>();

    public static boolean looping = true;

    public static void isComposite(int toAdd) {
        Composite.add(toAdd);
        System.out.println("Composite Numbers: " + Composite.toString() + "\n");
    }

    public static void isPrime(int toAdd) {
        prime.add(toAdd);
        System.out.println("Prime Numbers: " + prime.toString() + "\n");
    }

    public static void main(String[] args) {
        //Declarations
        Scanner Input = new Scanner(System.in);

        //Program Commencex
        System.out.println("[1]Automatic sorting. \n[2]Array sorting.");
        int swtichOpt = Input.nextInt();
        switch (swtichOpt) {
            case 1:
                while (looping) {
                    System.out.println("Enter the numeric value:");
                    int InputElement = Input.nextInt();
                    if (InputElement >= 2) {
                        int i = 2;
                        if (InputElement % i != 0) {
                            isPrime(InputElement);
                        } else {
                            isComposite(InputElement);
                        }
                    } else {
                        System.out.println("\nIt is niether a prime or composite number. Try again.");
                        looping = false;
                    }
                }
                break;
            case 2:
                while (looping) {
                    System.out.println("\n[0|1] FOR EXIT.\nEnter the numeric value:");
                    int InputElement = Input.nextInt();

                    if (InputElement >= 2) {
                        ArrayNumbers.add(InputElement);
                    } else {
                        for (int i = 0; i < ArrayNumbers.size(); i++) {
                            int j = 2;
                            if (ArrayNumbers.get(i) % j != 0) {
                                prime.add(ArrayNumbers.get(i));
                            } else {
                                Composite.add(ArrayNumbers.get(i));
                            }

                        }
                        System.out.println("All Array elements: " + ArrayNumbers.toString());
                        System.out.println("Prime Numbers: " + prime.toString());
                        System.out.println("Composite Numbers: " + Composite.toString() + "\n");
                        looping = false;
                    }

                }
                break;
            default:
                System.out.println("Choose a correct option.");
                break;
        }


    }
}
