import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class swingOperations implements ActionListener {
    JTextField tf1, tf2, tf3;
    JLabel lbl1, lbl2, lbl3;
    JButton b1, b2, b3, b4, b5;

    swingOperations() {
        JFrame f = new JFrame("Mathematical Operations");

        lbl1 = new JLabel("First Number:");
        lbl1.setBounds(50, 50, 100, 35);
        tf1 = new JTextField();
        tf1.setBounds(150, 50, 150, 35);

        lbl2 = new JLabel("Second Number: ");
        lbl2.setBounds(50, 100, 100, 35);
        tf2 = new JTextField();
        tf2.setBounds(150, 100, 150, 35);

        lbl3 = new JLabel("Result: ");
        lbl3.setBounds(50, 150, 150, 35);
        tf3 = new JTextField();
        tf3.setBounds(150, 150, 150, 35);
        tf3.setEditable(false);

        b1 = new JButton("Add");
        b1.setBounds(50, 200, 100, 50);
        b2 = new JButton("Subtract");
        b2.setBounds(170, 200, 100, 50);
        b3 = new JButton("Multiply");
        b3.setBounds(50, 260, 100, 50);
        b4 = new JButton("Divide");
        b4.setBounds(170, 260, 100, 50);
        b5 = new JButton("Clear");
        b5.setBounds(110, 320, 100, 50);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        f.add(lbl1);
        f.add(lbl2);
        f.add(lbl3);
        f.add(tf1);
        f.add(tf2);
        f.add(tf3);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);

        f.setSize(350, 500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s1 = tf1.getText();
        String s2 = tf2.getText();

        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = 0;

        if (e.getSource() == b1) {
            c = a + b;
        } else if (e.getSource() == b2) {
            c = a - b;
        } else if (e.getSource() == b3) {
            c = a * b;
        } else if (e.getSource() == b4) {
            c = a / b;
        } else if (e.getSource() == b5) {
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
        }
        String result = String.valueOf(c);
        tf3.setText(result);
    }

    public static void main(String[] args) {
        new swingOperations();

    }

}