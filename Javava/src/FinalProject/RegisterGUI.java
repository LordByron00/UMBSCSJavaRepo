package FinalProject;

import javax.swing.*;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class RegisterGUI extends JFrame {
    private JPanel panel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public RegisterGUI() {
        setTitle("Register");
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints gbc = new GridBagConstraints();

	  	  gbc.insets = new Insets(5, 5, 5, 5);
	  	  gbc.gridx = 0;
	  	  gbc.gridy = 0;
	  	  add(new JLabel("Username:"), gbc);
	
	  	  gbc.gridx = 1;
	  	  gbc.anchor = GridBagConstraints.LINE_START;
	  	  usernameTextField = new JTextField(20);
	  	  add(usernameTextField, gbc);
	
	  	  gbc.gridx = 0;
	  	  gbc.gridy = 1;
	  	  gbc.anchor = GridBagConstraints.LINE_END;
	  	  add(new JLabel("Password:"), gbc);
	
	  	  gbc.gridx = 1;
	  	  gbc.anchor = GridBagConstraints.LINE_START;
	  	  add(passwordField, gbc);
        pack();
        setLocationRelativeTo(null);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = new String(passwordField.getPassword());

                User user = new User(username, password);
                saveUser(user);

                JOptionPane.showMessageDialog(RegisterGUI.this, "User registered successfully!");
                dispose();
            }
        });
    }

    private void saveUser(User user) {
        try {
            FileOutputStream fileOut = new FileOutputStream("users.ser", true);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(user);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
