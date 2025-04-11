package progLanguages;

public class Book {

    private String title;
    private String author;
    private String year;
    private String ISBN;

    public Book(String title, String author, String year, String ISBN) {
        this.title = title;
        this.author = author;
        this.year =  year;
        this.ISBN = ISBN;
    }

    //Getter
    public String getTitle(){
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getYear() {
        return this.year;
    }

    public String getISBN() {
        return this.ISBN;
    }

    //Setter
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public void setYear(String newYear) {
        this.year = newYear;
    }

    public void setISBN(String newISBN) {
        this.ISBN = newISBN;
    }

    public void updateBook(String newTitle, String newAuthor, String newYear, String newISBN) {
        if (newTitle != null)  setTitle(newTitle);
        if (newAuthor != null)  setAuthor(newAuthor);
        if (newYear != null)  setYear(newYear);
        if (newISBN != null)  setISBN(newISBN);
    }

    public void description() {
        System.out.println("Title: " + getTitle() + "\n" + "Author: " + getAuthor() + "\n"
        + "Year: " + getYear() + "\n" + "ISBN: " + getISBN());
    }

}
