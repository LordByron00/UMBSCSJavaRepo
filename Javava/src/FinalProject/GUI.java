package FinalProject;
import javax.swing.*;
import java.awt.*;

public class GUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("User Authentication");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> {
            RegisterGUI registerGUI = new RegisterGUI();
            registerGUI.setVisible(true);
        });

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.setVisible(true);
        });

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        panel.add(registerButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        panel.add(loginButton, constraints);

        frame.add(panel);
        frame.setVisible(true);
    }
}
