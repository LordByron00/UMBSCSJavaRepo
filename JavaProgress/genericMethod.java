package JavaProgress;

public class genericMethod {
    private String text;

    public <T> boolean getData(T object) {
        return object + "hahaha" instanceof String;
    }

    public static void main(String[] args) {
        genericMethod money = new genericMethod();
        System.out.println(money.getData(5));
    }
}
