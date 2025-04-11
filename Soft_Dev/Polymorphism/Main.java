package Soft_Dev.Polymorphism;

public class Main {

    public static void main(String[] args) {
        Shape newShape = new Shape();
        Shape newCircle = new Circle();
        Shape newRect = new Rectangle();
        newShape.drawShape();
        newCircle.drawShape();
        newRect.drawShape();
    }

}
