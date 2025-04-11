package Soft_Dev;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String make, model;
        int year, choice;
        boolean repeat = true;
        Scanner io = new Scanner(System.in);

        while(repeat) {
            System.out.println("CREATE VEHICLE:");
            System.out.println("Car[1] | Motorcycle[2] | EXIT[0]");
            choice = io.nextInt();

            switch (choice) {
                case 1 -> {
                    io.nextLine();
                    System.out.print("Make:");
                    make = io.nextLine();
                    System.out.print("Model:");
                    model = io.nextLine();
                    System.out.print("Year:");
                    year = io.nextInt();
                    Car newCar = new Car(make, model, year);
                    newCar.displayInfo();
                }
                case 2 -> {
                    io.nextLine();
                    System.out.print("Make:");
                    make = io.nextLine();
                    System.out.print("Model:");
                    model = io.nextLine();
                    System.out.print("Year:");
                    year = io.nextInt();
                    Motorcycle newMotor = new Motorcycle(make, model, year);
                    newMotor.displayInfo();
                }
                case 0 -> {
                    io.nextLine();
                    System.out.println("Vehicle production has stopped!");
                    repeat = false;
                }
                default -> System.out.println("Incorrect selection!");
            }
        }
    }
}
