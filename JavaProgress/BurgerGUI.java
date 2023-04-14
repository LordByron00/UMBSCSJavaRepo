package JavaProgress;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class BurgerGUI extends JFrame {
    private JLabel label;
    private JLabel price;

    public BurgerGUI() {
        super("Burger");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Load the burger image from a URL
        try {
            URL url = new URL("https://a.rgbimg.com/users/x/xy/xymonau/600/ttLhPMi.jpg");
            Image image = ImageIO.read(url);
            ImageIcon icon = new ImageIcon(image);
            label = new JLabel(icon);
        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
            label = new JLabel("Error loading image");
        }

        // Create a panel to display the burger label and price
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel("Burger label: "), BorderLayout.WEST);
        panel.add(new JLabel("Cheeseburger"), BorderLayout.CENTER);
        panel.add(new JLabel("Price: "), BorderLayout.SOUTH);
        panel.add(new JLabel("$4.99"), BorderLayout.EAST);
        add(panel, BorderLayout.SOUTH);

        // Add the burger image to the frame
        add(label, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BurgerGUI();
    }
}
