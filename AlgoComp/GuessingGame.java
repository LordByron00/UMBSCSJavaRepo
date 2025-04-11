package AlgoComp;

import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author JhameelaF
 */
public class GuessingGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        Random random = new Random();
        
        int numberToGuess = random.nextInt(100) + 1; // random number between 1 and 100
        System.out.println(numberToGuess);

        int userGuess = 0;
        // welcome user to number game and ask user to guess the random number
        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("I have selected a number between 1 and 100. Try to guess!");

        while (userGuess != numberToGuess) {
            System.out.println("Enter your number: ");
            userGuess = scanner.nextInt();
            // results of the guessing game
            if (userGuess > numberToGuess)
                System.out.println("Too high, try again.");
            else if (userGuess < numberToGuess)
                System.out.println("Too low, try again.");
            else
                System.out.println("Congratulations! You guessed the right number!");
        }


    }
    
}
