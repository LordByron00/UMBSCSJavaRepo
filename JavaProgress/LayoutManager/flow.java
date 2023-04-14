package JavaProgress.LayoutManager;

import javax.swing.*;
import java.awt.*;

public class flow extends JFrame {

    public flow() {
        setSize(400, 300);
        setTitle("My Swing Application");

        JButton button1 = new JButton("Button 1");
        add(button1);

        JButton button2 = new JButton("Button 2");
        add(button2);

        JButton button3 = new JButton("Button 3");
        add(button3);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());
        button1.setHorizontalAlignment(SwingConstants.RIGHT);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new flow();
    }
}
