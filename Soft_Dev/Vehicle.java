package Soft_Dev;

public class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected String type;

    protected void displayInfo() {
        System.out.println("----------------------------------------------------");
        System.out.println("You successfully created a " + this.make + " " + this.type + " model " + this.model + " of" + this.year + ".");
        System.out.println("----------------------------------------------------");
    }

    public Vehicle(String make, String model, int year, String type) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
    }
}
