package JavaProgress;

import java.awt.*;

public class Main {
    private static String bookName = "48 laws of Power";
    private static int num = 1006;

    public static void main(String[] args) {
        Retriever<String> psychoBook = new Book(bookName);
        Retriever<Integer> bookContainer = new genericContainer<>(num);
        Retriever<String> psychoContainer = new genericContainer<>("Plastic");
        System.out.println(psychoBook.retrieveData());
        System.out.println(bookContainer.retrieveData());
        System.out.println(psychoContainer.retrieveData());
    }
}
