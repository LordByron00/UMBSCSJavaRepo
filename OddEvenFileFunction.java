
package oddevenfilefunction;
import java.io.*;
import java.util.*;

public class OddEvenFileFunction {

    
    public static void main(String[] args) throws FileNotFoundException {
        Even_Odd();
                
    }
    
    public static void Even_Odd() throws FileNotFoundException{
        int counter, value, count_even,count_odd, sum_even, sum_odd;
        counter = value = count_even = count_odd = sum_even = sum_odd = 0;
        
        Scanner inFile = new Scanner(new FileReader("C:\\Users\\user\\Desktop\\numbers.txt"));
        
        while(counter < 10){
            value = inFile.nextInt();
            switch(value%2){
                case 0: count_even++; sum_even = value+sum_even; break;
                case 1:
                case -1:
                    count_odd++; sum_odd = value + sum_odd;
            }
            counter++;
        }
        Display_output(count_even, sum_even, count_odd, sum_odd);
        inFile.close();
    }
    
    public static void Display_output(int a, int b, int c, int d){
        System.out.println("Total even number: "+a);
        System.out.println("Sum of all even numbers: "+b);
         System.out.println("Total odd number: "+c);
        System.out.println("Sum of all odd numbers: "+d);
    }
    
}