import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LearningProcess {
        public static void createElements(ArrayList<Integer> x) {
        x.add(1);
        x.add(1);
        x.add(1);
    }

    public static void main(String[] args) {

        ArrayList<String> students = new ArrayList<>();
        int[] Grade = new int[5];
        Grade = new int[]{1, 5, 6, 7, 4};
        String[] professor = {"adadasd", "asdasdasda", "hahahaha", "hahahahaadasd"};


        for (int i = 0; i < Grade.length; i++) {
              System.out.println(Grade[i]);
        }

        for (int x =0; x < professor.length; x++) {
            System.out.println(professor[x]);
        }

        students.add("asdasdas");
        students.add("11");
        students.add("123123");

        for (int j = 0; j < students.size(); j++) {
            System.out.println(students.get(j));
        }

        // While loop 
        ArrayList<Integer> Price = new ArrayList<>();

        createElements(Price);
        int Price_counter = 0;
        System.out.println(Price);
        while (Price_counter < Price.size()) {
            int Price_elem = Price.get(Price_counter);
            System.out.println("Original price: " + Price_elem);
            Price.set(Price_counter, Price_elem += 1);
            System.out.println("Inflation price: " + Price_elem);
            Price_counter++;
        }
        System.out.println(Price);

        
        int[] sumArray = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(sumArray));
        for (int sumCntr = 0; sumCntr < sumArray.length; sumCntr++) {
            if (sumCntr == sumArray.length -1) {
                System.out.println(sumArray[sumCntr]);
                int sumString = sumArray[sumCntr];
                sumArray[sumCntr] = sumString + sumString;
                System.out.println(Arrays.toString(sumArray));
                break;
            }
            int sumString = sumArray[sumCntr];
            System.out.println(sumString);
            sumArray[sumCntr] = sumString + sumArray[sumCntr+1];
            System.out.println(Arrays.toString(sumArray));
 
        }
        
        
    } 
}
