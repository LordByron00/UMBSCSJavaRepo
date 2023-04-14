package FinalProject;

import java.util.Arrays;

import javax.swing.*;

public class addedToCart{
	Object[][] orders = new Object[10][3];;
	JFrame popup;
	
	public addedToCart(Object[] order) {
			popup = new JFrame("Table Popup");
			int count = 0;
	        for (int row = 0; row < orders.length && count < order.length; row++) {
	        	 for (int col = 0; col < orders[row].length && count < order.length; col++ ) {
	                    orders[row][col] = order[count];
	                    count++;
	        	 }
	        }
	     String[] colNames = {"Name", "Price", "Photo"};
	     JTable ordersTable = new JTable(orders, colNames);
	     JScrollPane orderPane = new JScrollPane(ordersTable);
	     popup.add(orderPane);
	     popup.setSize(300, 300);
	     popup.setVisible(false);
	}
	

	
	public void setVisible() {
		System.out.println(Arrays.deepToString(orders));
		popup.setVisible(true);
	}

}
	
