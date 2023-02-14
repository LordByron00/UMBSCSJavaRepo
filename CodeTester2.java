import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CodeTester2 extends JFrame {
    CodeTester2() {

        ImageIcon logo = new ImageIcon("Youtube.png");
        Border border = BorderFactory.createLineBorder(Color.white, 3);

        JLabel label = new JLabel();
        label.setText("You are assertive! You are confident! You are strong! You are capable! Show your potential!");
        label.setIcon(logo);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(new Color(0, 0, 0));
        label.setFont(new Font("MV Boli", Font.ITALIC, 12));
        label.setIconTextGap(10);
        label.setBackground(Color.gray);
        label.setOpaque(true);
        label.setBorder(border);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
//        label.setBounds(125, 125, 250, 250);

        this.setTitle("Frame");
        this.setSize(500, 500);
//        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(label);
//        this.setLayout(null);

        this.pack();

        this.setIconImage(logo.getImage());
        this.getContentPane().setBackground(new Color(5,180, 200));

    }

    public static void main(String[] args) {

    }
}
