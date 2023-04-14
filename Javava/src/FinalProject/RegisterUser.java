package FinalProject;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterUser extends JFrame implements ActionListener {

    private JLabel userLabel;
    private JTextField userTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton registerButton;

    public RegisterUser() {
        super("Register User");

        // Create and set up the GUI components
        userLabel = new JLabel("User:");
        userTextField = new JTextField(20);
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        registerButton = new JButton("Register");
        registerButton.addActionListener(this);

        // Add the components to a panel using GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 0;
        panel.add(userLabel, c);
        c.gridx = 1;
        panel.add(userTextField, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(passwordLabel, c);
        c.gridx = 1;
        panel.add(passwordField, c);
        c.gridx = 1;
        c.gridy = 2;
        panel.add(registerButton, c);

        // Add the panel to the frame
        add(panel, BorderLayout.CENTER);

        // Set the frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RegisterUser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the user input from the GUI components
//        String username = userTextField.getText();
//        String password = new String(passwordField.getPassword());
//
//        // Create a User object with the input data
//        User userObject = new User(username, password);
//
//        // Write the User object to file
//        try (FileOutputStream fileOutputStream = new FileOutputStream("Users.ser", true);
//             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
//
//            objectOutputStream.writeObject(userObject);
//            System.out.println("User registration successful.");
//        } catch (IOException ex) {
//            System.err.println("Error: " + ex.getMessage());
//        }

        // Reset the GUI components
        userTextField.setText("");
        passwordField.setText("");
    }

}
