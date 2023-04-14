package Contridas;

import javax.swing.JFrame;


public class LogIn {

	public LogIn() {
	    OfficialLogin frame = new OfficialLogin();
        frame.setTitle("Cashier's Login Form");
        frame.setVisible(true);
        frame.setBounds(650, 100, 400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
	}
    public static void main(String[] a) {
    	new LogIn();

    }
}