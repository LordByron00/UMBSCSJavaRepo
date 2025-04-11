package Soft_Dev;

public class Car extends Vehicle {
    private final static String type = "Car";
    public Car(String make, String model, int year) {
        super(make, model, year, type);
    }

    @Override
    protected void displayInfo() {
        super.displayInfo();
    }
}
