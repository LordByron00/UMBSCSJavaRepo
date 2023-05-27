package CCE.Activities;

import java.util.Arrays;

public class code {
    public static void main(String[] args) {
        int arr_num[] = {17, 42, 1, 9, 74, 21, 84, 67, 51, 95};
        int key = 0, x, y;
        System.out.println(Arrays.toString(arr_num));
        for (x = 1; x < arr_num.length; x++) {
            key = arr_num[x]; //42
            for (y = x - 1; y >= 0; y--) { //y = x -1 = 1 -1 = 0;
                arr_num[y + 1] = arr_num[y]; //arr_num[1] = 42 = arr_num[0] = 17;
            }
            arr_num[y + 1] = key;
            for (int z = 0; z < arr_num.length; z++) {
                System.out.print(arr_num[z] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int a = 0; a < arr_num.length; a++) {
            System.out.print(arr_num[a] + " ");
        }
    }
}
