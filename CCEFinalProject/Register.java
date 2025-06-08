package CCEFinalProject;


import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField nameTF;
	private JTextField surnameTF;
	private JTextField userTF;
	private JPasswordField passTF;
	private JTextField emailTF;
	private JTextField numberTF;
	private JTextField addressTF;
	private ImageIcon regIcon;

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Register() {


		setIconImage(Toolkit.getDefaultToolkit().getImage("CCEFinalProject\\resources\\icon.png"));
		setTitle("Registration");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 950, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(168, 168, 168));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		surnameTF = new JTextField();
		surnameTF.setFocusTraversalPolicyProvider(true);
		surnameTF.setFocusTraversalKeysEnabled(false);
		surnameTF.setColumns(10);
		surnameTF.setBounds(497, 237, 316, 20);
		contentPane.add(surnameTF);

		JLabel userLabel = new JLabel("Username :");
		userLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
		userLabel.setForeground(new Color(255, 255, 255));
		userLabel.setBounds(497, 265, 420, 14);
		contentPane.add(userLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(389, 0, 545, 681);
		contentPane.add(panel);
		panel.setLayout(null);

		addressTF = new JTextField();
		addressTF.setFocusTraversalKeysEnabled(false);
		addressTF.setFocusTraversalPolicyProvider(true);
		addressTF.setBounds(107, 481, 316, 20);
		panel.add(addressTF);
		addressTF.setColumns(10);

		numberTF = new JTextField();
		numberTF.setFocusTraversalKeysEnabled(false);
		numberTF.setFocusTraversalPolicyProvider(true);
		numberTF.setBounds(107, 433, 316, 20);
		panel.add(numberTF);
		numberTF.setColumns(10);

		JLabel addressLabel = new JLabel("Address :");
		addressLabel.setBounds(107, 464, 420, 14);
		panel.add(addressLabel);
		addressLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
		addressLabel.setForeground(new Color(255, 255, 255));

		JLabel nameLabel = new JLabel("First Name :");
		nameLabel.setBounds(107, 167, 420, 14);
		panel.add(nameLabel);
		nameLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
		nameLabel.setForeground(new Color(255, 255, 255));

		nameTF = new JTextField();
		nameTF.setFocusTraversalPolicyProvider(true);
		nameTF.setFocusTraversalKeysEnabled(false);
		nameTF.setBounds(107, 186, 316, 20);
		panel.add(nameTF);
		nameTF.setColumns(10);

		JLabel numberLabel = new JLabel("Phone Number :");
		numberLabel.setBounds(107, 416, 420, 14);
		panel.add(numberLabel);
		numberLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
		numberLabel.setForeground(new Color(255, 255, 255));

		emailTF = new JTextField();
		emailTF.setFocusTraversalKeysEnabled(false);
		emailTF.setFocusTraversalPolicyProvider(true);
		emailTF.setBounds(107, 385, 316, 20);
		panel.add(emailTF);
		emailTF.setColumns(10);

		passTF = new JPasswordField();
		passTF.setFocusTraversalKeysEnabled(false);
		passTF.setFocusTraversalPolicyProvider(true);
		passTF.setBounds(107, 335, 316, 20);
		panel.add(passTF);
		passTF.setColumns(10);

		userTF = new JTextField();
		userTF.setFocusTraversalKeysEnabled(false);
		userTF.setFocusTraversalPolicyProvider(true);
		userTF.setBounds(107, 287, 316, 20);
		panel.add(userTF);
		userTF.setColumns(10);

		JLabel emailLabel = new JLabel("Email :");
		emailLabel.setBounds(107, 366, 420, 14);
		panel.add(emailLabel);
		emailLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
		emailLabel.setForeground(new Color(255, 255, 255));

		JLabel surnameLabel = new JLabel("Last Name :");
		surnameLabel.setBounds(107, 217, 420, 14);
		panel.add(surnameLabel);
		surnameLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
		surnameLabel.setForeground(new Color(255, 255, 255));

		JLabel passLabel = new JLabel("Password : ");
		passLabel.setBounds(107, 318, 420, 14);
		panel.add(passLabel);
		passLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 13));
		passLabel.setForeground(new Color(255, 255, 255));

		JLabel lblNewLabel_3 = new JLabel("REGISTER");
		lblNewLabel_3.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 46));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(131, 63, 265, 76);
		panel.add(lblNewLabel_3);

		JButton Home = new JButton("Login");
		Home.setFont(new Font("Cambria", Font.BOLD, 12));
		Home.setBorderPainted(false);
		Home.setBackground(new Color(192, 192, 192));
		Home.setBounds(274, 636, 85, 20);
		panel.add(Home);

		JButton registerBtn = new JButton("Register");
		registerBtn.setFont(new Font("Cambria", Font.BOLD, 17));
		registerBtn.setBackground(new Color(255, 255, 255));
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameTF.getText();
				String surname = surnameTF.getText();
		        String username = userTF.getText();
		        char[] password = passTF.getPassword();
		        String email = emailTF.getText();
		        int number = Integer.parseInt(numberTF.getText());
		        String address = addressTF.getText();

		        // Create a User object with the input data
		        User userObject = new User(name, surname, username, password, email, number, address);

		        // Write the User object to file
		        try (
		        		FileOutputStream fileOutputStream = new FileOutputStream("CCEFinalProject\\users.ser", true);
		        		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			            objectOutputStream.writeObject(userObject);
			            regIcon = new ImageIcon("CCEFinalProject\\resources\\check.png");
			            JOptionPane.showMessageDialog(null, "Successfully Registered!", "Heisenburger", JOptionPane.DEFAULT_OPTION, regIcon);
			            
		        } catch (IOException ex) {
		            System.out.println("Error: " + ex.getMessage());
		        }
			}
		});
		registerBtn.setBounds(212, 531, 100, 35);
		panel.add(registerBtn);

		JLabel haveAcc = new JLabel("Already have an account?");
		haveAcc.setForeground(new Color(255, 255, 255));
		haveAcc.setDisplayedMnemonicIndex(0);
		haveAcc.setBackground(new Color(255, 255, 255));
		haveAcc.setBounds(107, 624, 185, 46);
		panel.add(haveAcc);

		Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				Login abri = new Login();
				abri.setVisible(true);
			}
		});

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("CCEFinalProject\\resources\\Logo3small.png"));
		lblNewLabel_1.setBounds(39, 34, 294, 188);
		contentPane.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(20, 22, 347, 633);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(46, 184, 610, 418);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("CCEFinalProject\\resources\\burger3.png"));
	}
}
