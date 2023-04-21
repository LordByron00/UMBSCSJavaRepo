package JavaProgress.Polymorphism;

public class fruits {
    protected String fruit_Name;

    public fruits(String name) {
        this.fruit_Name = name;
    }

    protected void taste() {
        System.out.println("It tastes like normal Juice.");
    }
}
