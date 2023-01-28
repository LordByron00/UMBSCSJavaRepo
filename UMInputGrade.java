import java.util.Scanner;
import java.util.Arrays;

public class UMInputGrade{
    /* INSTRUCTION:

    Create a code using Java and submit your file in pdf with source code and output.
    If input grade is less than 50, it will not store the input.
    A user can load up to 5 subject loads.
    Follow the corresponding output.
    Any late submission will be deducted.
    The input grade must only be in whole numbers.
    Round off the average grade. */
    
    public static String name, choice;
    public static int ID, code;
    public static int max=0, min=0, average=0, sum;
    public static void main(String[] args) {

        // Enter personal information
        Scanner Grade_Input = new Scanner(System.in);
        System.out.println("****************EVALUATING SYSTEM**************");
        System.out.println("Name: ");
        name = Grade_Input.next();
        System.out.println("ID: ");
        ID = Grade_Input.nextInt();
        System.out.println("Code: ");
        code = Grade_Input.nextInt();

        // Input the number of subjects
        System.out.println("Enter the number of subjects: ");
        int gradeNum = Grade_Input.nextInt();
        while (gradeNum > 5) {
            System.out.println("Enter no more than 5 subjects:");
            gradeNum = Grade_Input.nextInt();
        }


        int[] gradeArray = new int[gradeNum];
        System.out.println("Enter " + gradeNum + " subject grades: ");
        
        // Create an array through our input
        for(int i = 0; i < gradeNum;) {
            gradeArray[i] = Grade_Input.nextInt();
            if (gradeArray[i] >= 50 && gradeArray[i] <= 100) {
                i++;
            } else {
                System.out.println("Input grades between 50-100.");
            }
        }

        //Option to proceed 
        System.out.println("Do you want to proceed?(Y/N):");
        choice = Grade_Input.next();
        
        // The execution of codes depends on the case or the choice that has been chosen.
        switch (choice) {
            case "Y":
                System.out.println("Yes");
                System.out.println("*********************************[SWITCH AND IF STATEMENT*********************************");
                System.out.println("The input grades are: ");

                //Print each element on the array subject grades
                for(int k = 0; k < gradeNum; k++) {
                    System.out.println(gradeArray[k]);
                }

                //Print the entire array of subject grades
                System.out.println(Arrays.toString(gradeArray));
                
                // Finding the max, min and average of the Grade array.
                //Identify wether the grade is passed or fail.
                for(int j = 0; j < gradeNum; j++) {
                    sum += gradeArray[j];
                    if (max < gradeArray[j]) { // 0 < 55, 55 < 65
                        max = gradeArray[j]; //55, max = 65
                    }
                    min = max; // min = 55, min = 65
                    if (j <= gradeNum) {
                        for (int k = 0; k < gradeNum; k++) {
                            if (min > gradeArray[k]) { //55 > 55, 65 > 65
                                min = gradeArray[k];
                            }
                        }
                    }
                    
                    /* int UMGrades = gradeArray[j];
                    if(UMGrades > 75) {
                        System.out.println(UMGrades + " is a passing grade. Congratulation!");
                    } else {
                        System.out.println(UMGrades + " is a failing grade. Try harder next time!");
                    } */
                }
                average = Math.round(sum / gradeArray.length);
                System.out.println("Name: " + name + " ID: " + ID + " code: " + code);
                System.out.println("Highest grade: " + max);
                System.out.println("Lowest grade: " + min);
                System.out.println("Average: " + average);

                if (average > 75) {
                    System.out.println(name + " has passed the subject!");
                    System.out.println("*************************************");
                } else {
                    System.out.println(name + " has failed the subject");
                    System.out.println("*************************************");
                }
                break;
            case "N":
                System.out.println("Thank you for your time.");
                break;
            default:
                System.out.println("Pick the right choice.");
                break;
        }
    }
}