import java.util.Arrays;

public class CodeTester {

    public static void main(String[] args){

        int x=3, y=5, z=10;

        int var = ++z + y - y + z + x++;
        System.out.println(var);
    }
}