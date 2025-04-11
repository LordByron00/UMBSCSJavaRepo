package JavaProgress;

public class genericContainer<T> implements Retriever<T> {
    private T data;

    public genericContainer(T data) {
        this.data = data;
    }

    public T getdata() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public T retrieveData() {
        return this.data;
    }
}
