package JavaProgress.Lambda;

public class Main {
    public static void main(String[] args) {
        Cat mew = new Cat();
        print_Animal(mew);
        Printable printable = (e) -> System.out.println("I am printable. " + e);
        print_Animal(printable);
        print_Animal((e) -> System.out.println("I am an animal. " + e));
    }

    private static void print_Animal(Printable x) {
        x.print("Parameter!");
    }
}
