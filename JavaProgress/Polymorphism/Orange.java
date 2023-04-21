package JavaProgress.Polymorphism;

public class Orange extends fruits {
    Orange() {
        super("Orange");
    }

    @Override
    protected void taste() {
        System.out.println("This tastes so sour!");
    }

    void twoTaste() {
        taste();
        super.taste();
    }
}
