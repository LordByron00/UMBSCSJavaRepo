package CCE.Activities;

import java.util.Scanner;

public class BMIClass {
    public static void main(String[] args) {

        String Name;
        String Surname;
        int weight;
        float height;
        float BMI;

        System.out.println("Enter first name:");
        Scanner input = new Scanner(System.in);
        Name = input.nextLine();
        System.out.println("Enter surname:");
        Surname = input.nextLine();
        System.out.println("Enter your weight(kg):");
        weight = input.nextInt();
        System.out.println("Enter your height(m):");
        height = input.nextFloat();
        BMI = weight / (height * height);
        System.out.println("Welcome " + Name + " to the " + Surname + " family. Your weight is " + weight +
                "kg and your height is " + height + "m." + "\n Your Body Mass Index is " + BMI);
        input.close();
    }
}

