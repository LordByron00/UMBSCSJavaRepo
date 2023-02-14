import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.List;

public class CodeTester {
    private static boolean GlobalLoop = true;


    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        System.out.println("[1]ADD[2]READ[3]UPDATE[4]DELETE");

        File ifExist = new File("Test.txt");
        List<String> list = new ArrayList<>();
        while (GlobalLoop) {
            int choice = console.nextInt();
            BufferedReader BR = new BufferedReader(new FileReader(ifExist));
            switch (choice) {
                case 1:
                    System.out.println("Name:");
                    String name = console.next();
                    System.out.println("Age:");
                    int age = console.nextInt();
                    System.out.println("Gender:");
                    String gender = console.next();
                    BufferedWriter BW = new BufferedWriter(new FileWriter(ifExist, true));
                    BW.write(name + " " + age + " " + gender);
                    BW.newLine();
                    BW.close();
                    break;
                case 2:
                    if (!ifExist.exists()) {
                        ifExist.createNewFile();
                    }
                    list.clear();
                    String dataValue;
                    while ((dataValue = BR.readLine()) != null) {
                        list.add(dataValue);
//                    System.out.println(dataValue);
                    }
                    System.out.println(list);
                    break;
                case 3:
                    System.out.println(list.size());
                    System.out.println("Enter the index:");
                    int indexChange = console.nextInt();
                    System.out.println("Name:");
                    name = console.next();
                    System.out.println("Age:");
                    age = console.nextInt();
                    System.out.println("Gender:");
                    gender = console.next();
                    list.set(indexChange, name + " " + age + " " + gender);
                    BW = new BufferedWriter(new FileWriter(ifExist));
                    for (String elem : list) {
                        BW.write(elem);
                        BW.newLine();
                    }
                    BW.close();
                    break;
                case 4:
                    System.out.println("Enter the index:");
                    int indexNum = console.nextInt();
                    list.remove(indexNum);
                    System.out.println(list);
                    BW = new BufferedWriter(new FileWriter(ifExist));
                    BW.write(list.toString());
                    BW.close();
                    break;
                default:
                    GlobalLoop = false;
            }
        }


    }
}
