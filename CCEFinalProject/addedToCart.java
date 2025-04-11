package CCEFinalProject;

import java.util.Arrays;

import javax.swing.*;

public class addedToCart {
    private static Object[][] orders = new Object[10][3];
    static JFrame popup;



    public static void setVisible() {
        System.out.println(Arrays.deepToString(orders));
        popup.setVisible(true);
    }

    public static void setterObject(Object[] order) {
        int count = 0;
        for (int row = 0; row < orders.length && count < order.length; row++) {
            for (int col = 0; col < orders[row].length && count < order.length; col++) {
                orders[row][col] = order[count];
                count++;
            }
        }
        System.out.println(Arrays.deepToString(orders));
    }

    public static void main(String[] args) {
        popup = new JFrame("Table Popup");
        String[] colNames = {"Name", "Price", "Photo"};
        JTable ordersTable = new JTable(orders, colNames);
        ordersTable.setShowGrid(false);
        JScrollPane orderPane = new JScrollPane(ordersTable);
        popup.add(orderPane);
        popup.setSize(300, 300);
        popup.setVisible(false);
    }

}

