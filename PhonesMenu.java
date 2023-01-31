import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.LinkedList;

public class PhonesMenu {
    private static boolean global_Loop = true, removePhoneLoop;
    private static LinkedList Phones = new LinkedList<>();
    private static void phoneChoice(int phone) {

        if (phone == 1) {
            Phones.add("Samsung");
        } else if (phone == 2) {
            Phones.add("Vivo");
        } else if (phone == 3) {
            Phones.add("Oppo");
        } else if (phone == 4) {
            Phones.add("Nokia");
        } else if (phone == 5) {
            Phones.add("Huawie");
        } else {
            System.out.println("Phone unavailable. Pick again!\n");
        }
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        while (global_Loop) {
            System.out.println("[1]ADD PHONES\n[2]REMOVE PHONES\n[3]DISPLAY PHONES\n[4]EXIT");
            int choice = inputScanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("How many do you want to add?");
                    int addPhoneSize = inputScanner.nextInt();
                    System.out.println("\nPHONE LIST:\n[1]SAMSUNG\n[2]VIVO\n[3]OPPO \n[4]NOKIA\n[5]HUAWIE\n");
                    for (int i = 0; i < addPhoneSize; i++) {
                        System.out.print("Phone " + (i + 1) + "#: ");
                        int phoneChoice = inputScanner.nextInt();
                        phoneChoice(phoneChoice);
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println(Phones);
                    do {
                        System.out.println("PHONE TO REMOVE:");
                        String removePhoneChoice = inputScanner.next();
                        removePhoneChoice = removePhoneChoice.substring(0, 1).toUpperCase() + removePhoneChoice.substring(1).toLowerCase();
                        Phones.remove(removePhoneChoice);
                        System.out.println(Phones);
                        System.out.println("Wanna continue?[Y][N]:");
                        String continueR = inputScanner.next();
                        continueR = continueR.toUpperCase();
                        switch (continueR) {
                            case "Y":
                                removePhoneLoop = true;
                                break;
                            case "N":
                                removePhoneLoop = false;
                                break;
                            default:
                                removePhoneLoop = false;
                                break;
                        }
                    } while (removePhoneLoop);


                    break;
                case 3:
                    System.out.println("PHONES PICKED:");
                    for (Object phone : Phones) {
                        System.out.println(phone);
                    }
                    break;
                case 4:
                    global_Loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}
