package progLanguages;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Library {
    static Scanner io = new Scanner(System.in);
    static List<Book> allBooks = new ArrayList<>();

    //Book class

    //list of Book Class
    //Main
    //UPDATE -

    public static void main(String[] args) {

        boolean loop = true;
        while (loop) {
            System.out.println("""
                    LIBRARY SYSTEM:
                    [1] ADD BOOK
                    [2] VIEW BOOKS
                    [3] UPDATE BOOK
                    [4] DELETE BOOK""");
            int option = io.nextInt();
            switch(option) {
                case 1:
                    Book newBook = addBook();
                    allBooks.add(newBook);
                    break;
                case 2:

                    if (!allBooks.isEmpty()) {
                        int num = 0;
                        for (Book x : allBooks) {
                            num++;
                            System.out.println(num + ". " + x.getTitle());
                            x.description();
                        }
                    } else {
                        System.out.println("There is no book availabe.");
                    }

                    break;
                case 3:
                    System.out.print("""
                            ******UPDATE BOOK******
                            SELECT A BOOK [NAME|NUMBER]:
                            """);
                    Object input;
                    if (io.hasNextInt()) {
                        input = io.nextInt();
                        int num = (Integer) input;
                        updateBook(--num);
                    } else {
                        input = io.next();
                        String inputt = (String) input;
                        List<Book> searched = allBooks.stream().filter(
                                book -> book.getTitle().contains(inputt)
                        ).toList();
                        int num = 0;
                        for (Book boos : searched) {
                            num++;
                            System.out.println(num + ". " + boos.getTitle());
                        }

                        System.out.println("BOOK NUMBER:");
                        int inputtt = -2;
                        int Size = searched.size(); //2
                        do {
                            inputtt = io.nextInt();
                        } while (inputtt > Size);

                        inputtt = inputtt - 1;
                        updateBook(allBooks.indexOf(searched.get(inputtt)));
                    }

                    break;
                case 4:

                    break;
                default:

                    break;
            }
        }

    }

    private static Book addBook() {

        System.out.print("Title: ");
        io.nextLine();
        String title = io.nextLine();
        System.out.print("Author: ");
        String author = io.nextLine();
        System.out.print("Publication Year: ");
        String year = io.next();
        System.out.print("ISBN: ");
        String ISBN = io.next();
        return new Book(title, author, year, ISBN);
    }

    private static void updateBook(int num) {
        Book tbuBook = allBooks.get(num);

        System.out.print("Title: ");
        io.nextLine();
        String title = io.nextLine();
        System.out.print("Author: ");
        String author = io.nextLine();
        System.out.print("Publication Year: ");
        String year = io.next();
        System.out.print("ISBN: ");
        String ISBN = io.next();

        tbuBook.updateBook(title, author, year, ISBN);
        tbuBook.description();
    }

}
