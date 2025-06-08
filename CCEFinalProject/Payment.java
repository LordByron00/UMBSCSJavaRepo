package CCEFinalProject;


import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.util.Date;

import javax.swing.*;
public class Payment extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
	private double totalToPay;
	@SuppressWarnings("unused")
	private double Wealth = 999999999;
	private JTextArea textArea;
    private JRadioButton GcashRadio, creditRadio, BankRadio;

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}

	public Payment(double Totalpayment) {
        new javax.swing.JTable();
		setBounds(new Rectangle(500, 130, 0, 0));
		this.totalToPay = Totalpayment;

		panel = new JPanel();
		panel.setBackground(new Color(30, 60, 60));

		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("SELECT PAYMENT METHOD:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Athletic", Font.PLAIN, 26));
		lblNewLabel.setBounds(35, 92, 376, 57);
		panel.add(lblNewLabel);
		this.setTitle("Payment Method");
		this.setSize(950, 720);
		this.setVisible(true);

		ButtonGroup group = new ButtonGroup();


		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(168, 168, 168));
		panel_1.setBounds(639, 0, 295, 681);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(64, 128, 128));
		panel_2.setBounds(20, 0, 253, 648);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(-349, 205, 1252, 455);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("CCEFinalProject\\resources\\burger3.png"));

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("CCEFinalProject\\resources\\Logo3small.png"));
		lblNewLabel_2.setBounds(-20, 11, 293, 249);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("CCEFinalProject\\resources\\visamaster.png"));
		lblNewLabel_3.setBounds(160, 327, 150, 54);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("CCEFinalProject\\resources\\BPI.jpg"));
		lblNewLabel_4.setBounds(169, 260, 59, 36);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("CCEFinalProject\\resources\\Metro.png"));
		lblNewLabel_5.setBounds(238, 260, 72, 36);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon("CCEFinalProject\\resources\\gcash.png"));
		lblNewLabel_4_1.setBounds(169, 192, 50, 44);
		panel.add(lblNewLabel_4_1);

		JButton btnNewButton = new JButton("Proceed");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wealth -= totalToPay;
				String message = "Sucessfully paid! " + "PHP: " + totalToPay ;
				if (group.getSelection() != null) {
					if (GcashRadio.isSelected()) {
					      textArea.setText(textArea.getText() + "Payment Method: Gcash \nStatus: Fully Paid!");
					} else if (creditRadio.isSelected()) {
						  textArea.setText(textArea.getText() + "Payment Method: Credit card \nStatus: Fully Paid!");
					} else if(BankRadio.isSelected()) {
						  textArea.setText(textArea.getText() + "Payment Method: Bank Account \nStatus: Fully Paid!");
					}
		            ImageIcon regIcon = new ImageIcon("CCEFinalProject\\resources\\check.png");
		            JOptionPane.showMessageDialog(null, message, "Payment completed!", JOptionPane.DEFAULT_OPTION, regIcon);
		            String[] responses = {"Print", "No"};
					ImageIcon icon = new ImageIcon("CCEFinalProject\\resources\\print.png");
					int answer = JOptionPane.showOptionDialog(null, "Do you want to print your receipt?", "Receipt Confirmation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, icon, responses, 0);
					switch (answer) {
						case 0:
						try {
							textArea.print();
						} catch (PrinterException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							break;
						case 1:
							break;
					}
		            close();
		            Menu menu = new Menu();
		    		menu.Paid();
				} else {
					JOptionPane.showMessageDialog(null,"Please select your payment method!.","Empty",JOptionPane.ERROR_MESSAGE);
				}


			}
		});


		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(24, 73, 73));
		btnNewButton.setBounds(248, 450, 125, 44);
		panel.add(btnNewButton);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(68, 82, 96));
		panel_3.setBounds(0, 0, 596, 647);
		panel.add(panel_3);
		panel_3.setLayout(null);

		creditRadio = new JRadioButton("Credit Card");
		creditRadio.setBounds(38, 341, 109, 23);
		panel_3.add(creditRadio);
		creditRadio.setForeground(new Color(255, 255, 255));
		creditRadio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		creditRadio.setBackground((Color) null);
		group.add(creditRadio);

		 BankRadio = new JRadioButton("Bank Transfer");
		BankRadio.setBounds(38, 273, 109, 23);
		panel_3.add(BankRadio);
		BankRadio.setForeground(new Color(255, 255, 255));
		BankRadio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BankRadio.setBackground((Color) null);
		group.add(BankRadio);

		GcashRadio = new JRadioButton("G-Cash");
		GcashRadio.setBounds(38, 207, 77, 23);
		panel_3.add(GcashRadio);
		GcashRadio.setForeground(new Color(255, 255, 255));
		GcashRadio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GcashRadio.setBackground(null);
		group.add(GcashRadio);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(129, 129, 129));
		panel_4.setBounds(0, 0, 596, 45);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBackground(new Color(129, 129, 129));
		panel_4_1.setBounds(0, 602, 596, 45);
		panel_3.add(panel_4_1);

		textArea = new JTextArea();
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setEditable(false);
		textArea.setBackground(new Color(87, 123, 145));
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
		textArea.setBounds(341, 149, 231, 230);
		panel_3.add(textArea);
		this.setVisible(false);
	}

	public void setter(String name, String price, String quantity, String fullname) {
		  textArea.setText("================================\n");
		  textArea.setText(textArea.getText()+"       *HEISEN[B]URGER* \n");
		  textArea.setText(textArea.getText()+"================================\n");
	      Date obj = new Date();
	      String date = obj.toString();


	      textArea.setText(textArea.getText()+"DATE: "+date+"\n");
	      textArea.setText(textArea.getText() + "Name:" + fullname + "\n\n");

	      textArea.setText(textArea.getText()+"Item"+"\t\t"+"Price"+"\t"+"Quantity\n\n");
	      textArea.setText(textArea.getText() + name+"\t"+price+"\t   "+quantity+"\t");
	      textArea.setText(textArea.getText()+"\n\n");
	      textArea.setText(textArea.getText()+"================================\n");

	}
}
