import java.io.FileInputStream;
import java.io.IOException;

public class CodeTester {
    public static void main(String[] args) {
        try {
            // Create a FileInputStream object
            FileInputStream input = new FileInputStream("example.txt");
            
            // Read the first byte of the file
            int data = input.read();
            
            // Keep reading bytes until the end of the file
            while (data != -1) {
                // Do something with the byte
                System.out.print((char) data);
                
                // Read the next byte
                data = input.read();
            }
            
            // Close the FileInputStream
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
