package JavaProgress;

public class generic<T> {
    private T dataInput;

    public generic(T data) {
        this.dataInput = data;
    }

    public T getData() {
        return this.dataInput;
    }

    public void setData(T data) {
        this.dataInput = data;
    }

    public static void main(String[] args) {
        generic<Integer> number = new generic<>(45);
        System.out.println(number.getData());
        number.setData(35);
        System.out.println(number.getData());

    }
}

