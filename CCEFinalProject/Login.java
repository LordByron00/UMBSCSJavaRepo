package CCEFinalProject;


import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.*;

public class Login extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userLogField;
	private JPasswordField passLogField;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}

	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("CCEFinalProject\\resources\\icon.png"));
		setTitle("Heisenburger Login Page");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 950, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(423, 27, 517, 605);
		lblNewLabel_2.setBackground(new Color(72, 72, 72));
		lblNewLabel_2.setIcon(new ImageIcon("CCEFinalProject\\resources\\Logo2.png"));
		contentPane.add(lblNewLabel_2);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 413, 681);
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel userLabel = new JLabel("Username :");
		userLabel.setBounds(46, 220, 355, 27);
		userLabel.setFont(new Font("Serif", Font.BOLD, 18));
		panel.add(userLabel);
		userLabel.setForeground(new Color(255, 255, 255));

		userLogField = new JTextField();
		userLogField.setBounds(46, 254, 300, 27);
		panel.add(userLogField);
		userLogField.setColumns(10);

		JLabel passLabel = new JLabel("Password :");
		passLabel.setBounds(46, 303, 355, 16);
		passLabel.setFont(new Font("Serif", Font.BOLD, 18));
		panel.add(passLabel);
		passLabel.setForeground(new Color(255, 255, 255));

		passLogField = new JPasswordField();
		passLogField.setBounds(46, 328, 300, 27);
		panel.add(passLogField);
		passLogField.setColumns(10);

		JLabel signupBtn = new JLabel("Do not have an account yet?");
		signupBtn.setBounds(54, 379, 336, 14);
		signupBtn.setBackground(new Color(255, 0, 0));
		panel.add(signupBtn);
		signupBtn.setForeground(new Color(255, 255, 255));

		JButton btnNewButton = new JButton("SIGN UP");
		btnNewButton.setBounds(238, 375, 89, 23);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font(null, Font.BOLD, 12));
		panel.add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("WELCOME!");
		lblNewLabel_3.setBounds(80, 74, 346, 73);
		lblNewLabel_3.setFont(new Font("ROG Fonts", Font.PLAIN, 35));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(33, 157, 336, 8);
		panel_1.setBackground(new Color(255, 255, 255));
		panel.add(panel_1);

		JButton loginBtn = new JButton("LOGIN");
		loginBtn.addActionListener(this);

		loginBtn.setFont(new Font("Times New Roman", Font.BOLD, 23));
		loginBtn.setBorderPainted(false);
		loginBtn.setBackground(Color.LIGHT_GRAY);
		loginBtn.setBounds(134, 474, 134, 44);
		panel.add(loginBtn);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				Register abri = new Register();
				abri.setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String username = userLogField.getText();
		char[] password = passLogField.getPassword();
		FileInputStream file = null;
		ObjectInputStream objectReader = null;
		User userObject;

		// Checking whether the user exists
		boolean userFound = false;
		try {
			file = new FileInputStream("CCEFinalProject\\users.ser");
			objectReader = new ObjectInputStream(file);

			while ((userObject = (User) objectReader.readObject()) != null) {
				if (username.equals(userObject.getUser())) {
					userFound = true;
					if (Arrays.equals(password, userObject.getPass())) {
						close();
						Menu menu = new Menu();
						menu.profileInfo(userObject.getfullName());

//								x.setVisible(true);
					} else {
						System.out.println("Incorrect password!");
					}
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			if (ex instanceof EOFException) {
				// End of file reached
			} else {
				ex.printStackTrace();
			}
		} finally {
			if (objectReader != null) {
				try {
					objectReader.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			if (file != null) {
				try {
					file.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}

		if (!userFound) {
			System.out.println("User not found!");
		}
	}
}
