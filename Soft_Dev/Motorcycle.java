package Soft_Dev;

public class Motorcycle extends Vehicle {
    private static final String type = "Motorcycle";
    public Motorcycle(String make, String model, int year) {
        super(make, model, year, type);
    }

    @Override
    protected void displayInfo() {
        super.displayInfo();
    }
}
