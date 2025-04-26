package progLanguages;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    static Scanner io = new Scanner(System.in);
    static List<Book> allBooks = new ArrayList<>();

    public static void main(String[] args) {

        boolean loop = true;
        while (loop) {
            System.out.println("""
                    LIBRARY SYSTEM:
                    [1] ADD BOOK
                    [2] VIEW BOOKS
                    [3] UPDATE BOOK
                    [4] DELETE BOOK
                    [5] EXIT""");
            int option = io.nextInt();
            switch (option) {
                case 1 -> {

                    boolean con = true;

                    while (con) {
                        Book newBook = addBook();
                        allBooks.add(newBook);
                        System.out.println("Add more books? [YES|NO]");
                        String addMore = io.next().toUpperCase();
                        if (addMore.equals("NO")) {
                            con = false;
                        }
                    }

//                    allBooks.add(new Book("The Pragmatic Programmer", "Andrew Hunt & David Thomas", "1999", "978-0135957059"));
//                    allBooks.add(new Book("Code: The Hidden Language of Computer Hardware and Software", "Charles Petzold", "1999", "978-0735611313"));
//                    allBooks.add(new Book("The Self-Taught Programmer", "Cory Althoff", "2017", "978-0999685907"));
//                    allBooks.add(new Book("The Art of Computer Programming, Vol. 1", "Donald Knuth", "1968", "978-0201896831"));
//                    allBooks.add(new Book("Astrophysics for People in a Hurry", "Neil deGrasse Tyson", "2017", "978-0393609394"));


                }
                case 2 -> {
                    if (!allBooks.isEmpty()) {
                        int num = 0;
                        for (Book x : allBooks) {
                            num++;
                            System.out.println(num + ". " + x.getTitle());
                            x.description();
                        }
                    } else {
                        System.out.println("There is no book available.");
                    }
                }
                case 3 -> {
                    System.out.print("""
                            ******UPDATE BOOK******
                            SELECT A BOOK [NAME|NUMBER]:""");
                    Object input;
                    int del;
                    if (io.hasNextInt()) {

                        do {
                            System.out.print("Number:");
                            input = io.nextInt();
                            del = (Integer) input;
                            if (del > allBooks.size()) {
                                System.out.println("Book does not exist.");
                            }
                        } while (del > allBooks.size());

                        updateBook((--del));

                    } else {

                        input = io.next();
                        String searchString = (String) input;
                        List<Book> searchedBooks = allBooks.stream().filter(
                                book -> book.getTitle().contains(searchString)
                        ).toList();
                        int num = 0;
                        
                        for (Book book : searchedBooks) {
                            num++;
                            System.out.println(num + ". " + book.getTitle());
                        }
//                        System.out.println(searchedBooks.size());

                        System.out.print("BOOK NUMBER:");
                        int inputtt;
                        int Size = searchedBooks.size(); //2

                        do {
                            while(!io.hasNextInt()) {
                                io.next();
                            }
                            inputtt = io.nextInt();
                        } while (inputtt > Size);

                        inputtt = inputtt - 1;
                        updateBook(allBooks.indexOf(searchedBooks.get(inputtt)));
                    }
                }
                case 4 -> {
                    System.out.println("********DELETE BOOK********");
                    System.out.print("[Title|Number]:");
                    Object inputdel;
                    int del;
                    if (io.hasNextInt()) {

                        do {
                            System.out.print("Number:");
                            inputdel = io.nextInt();
                            del = (Integer) inputdel;
                            if (del > allBooks.size()) {
                                System.out.print("Book does not exist.");
                            }
                        } while (del > allBooks.size());
                        del = del - 1;
                        System.out.println(allBooks.get(del).getTitle() + " successfully removed.");
                        allBooks.remove(del);

                    } else {

                        inputdel = io.next();
                        String deldel = (String) inputdel;
                        List<Book> searched = allBooks.stream().filter(
                                book -> book.getTitle().contains(deldel)
                        ).toList();

                        int num = 0;
                        for (Book boos : searched) {
                            num++;
                            System.out.println(num + ". " + boos.getTitle());
                        }

                        System.out.print("BOOK NUMBER:");
                        int delIO;
                        int Size = searched.size(); //2

                        do {
                            while (!io.hasNextInt()) {
                                io.next();
                            }
                            delIO = io.nextInt();
                        } while (delIO > Size);

                        delIO = delIO - 1;
                        System.out.println(allBooks.get(allBooks.indexOf(searched.get(delIO))).getTitle() + " successfully removed.");
                        allBooks.remove(searched.get(delIO));
                    }
                }
                case 5 -> loop = false;
                default -> System.out.println("Incorrect choice.");
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
        System.out.println(tbuBook.getTitle() + " Successfully updated.");
//        tbuBook.description();
    }

}
