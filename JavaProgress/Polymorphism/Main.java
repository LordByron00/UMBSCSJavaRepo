package JavaProgress.Polymorphism;

public class Main {
    public static void main(String[] args) {
        Orange orange = new Orange();
        Apple apple = new Apple();
        Blender apple_Juice = new Blender();
        apple_Juice.makeJuice(orange);
        apple_Juice.makeJuice(apple);
        apple.taste();
        orange.twoTaste();
    }
}
