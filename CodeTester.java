import java.io.*;

public class CodeTester {
    public static void main(String[] args) {
        try {
            // Create a FileInputStream object
            BufferedWriter br = new BufferedWriter(new FileWriter("Example.txt"));
//
//            // Read the first byte of the file
//            int data = input.read();
//
//            // Keep reading bytes until the end of the file
//            while (data != -1) {
//                // Do something with the byte
//                System.out.print((char) data);
//
//                // Read the next byte
//                data = input.read();
//            }
            
            // Close the FileInputStream
            // input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
