package JavaProgress.Polymorphism;

public class Apple extends fruits {
    Apple() {
        super("Apple");
    }

    @Override
    protected void taste() {
        System.out.println("It tastes sweet.");
    }
}

