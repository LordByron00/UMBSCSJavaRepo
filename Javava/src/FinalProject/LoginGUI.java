package FinalProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoginGUI extends JFrame {
    private JPanel panel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginGUI() {
        setTitle("Login");
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = new String(passwordField.getPassword());

                User user = getUser(username);

                if (user == null) {
                    JOptionPane.showMessageDialog(LoginGUI.this, "User not found.");
                } else if (password.equals(user.getPass())) {
                    JOptionPane.showMessageDialog(LoginGUI.this, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(LoginGUI.this, "Incorrect password.");
                }
            }
        });
    }

    private User getUser(String username) {
        try {
            FileInputStream fileIn = new FileInputStream("users.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            User user;
            while ((user = (User) in.readObject()) != null) {
                if (user.getUser().equals(username)) {
                    in.close();
                    fileIn.close();
                    return user;
                }
            }
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
