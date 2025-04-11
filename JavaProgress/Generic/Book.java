package JavaProgress;

public class Book implements Retriever<String> {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String retrieveData() {
        return this.name;
    }
}
