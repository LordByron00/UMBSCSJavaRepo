package FinalProject;

public class Ordered {
	Object[][] orders = new Object[10][3];;
	
	public Ordered(Object[] order) {
		 int count = 0;
	        for (int row = 0; row < orders.length && count < order.length; row++) {
	        	 for (int col = 0; col < orders[row].length && count < order.length; col++ ) {
	                    orders[row][col] = order[count];
	                    count++;
	        	 }
	        }
	}
}
