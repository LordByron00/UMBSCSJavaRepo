package officiallogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginAddition implements ActionListener {
    JFrame addFrame = new JFrame("ADDITION");
    JLabel fNum = new JLabel("First Number: ");
    JTextField fField = new JTextField();
    JLabel sNum = new JLabel("Second Number: ");
    JTextField sField = new JTextField();
    JLabel resultLabel = new JLabel("Result: ");
    JTextField resultField = new JTextField();
    JButton addButton = new JButton("ADD");
    JButton resetButton = new JButton("RESET");

    loginAddition() {

        fNum.setBounds(50, 150, 100, 30);
        fField.setBounds(150, 150, 150, 30);
        sNum.setBounds(50, 220, 100, 30);
        sField.setBounds(150, 220, 150, 30);
        resultLabel.setBounds(50, 280, 100, 30);
        resultField.setBounds(150, 280, 150, 30);
        resultField.setEditable(false);
        addButton.setBounds(50, 330, 100, 30);
        resetButton.setBounds(200, 330, 100, 30);

        addFrame.add(fNum);
        addFrame.add(fField);
        addFrame.add(sNum);
        addFrame.add(sField);
        addFrame.add(resultLabel);
        addFrame.add(resultField);
        addFrame.add(addButton);
        addFrame.add(resetButton);
        addFrame.setLayout(null);

        addButton.addActionListener(this);
        resetButton.addActionListener(this);

        addFrame.setBounds(600, 100, 370, 600);
        addFrame.setVisible(true);
        addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addFrame.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int a = Integer.parseInt(fField.getText());
        int b = Integer.parseInt(sField.getText());
        int c;
        if (e.getSource() == addButton) {
            c = a + b;
            resultField.setText(String.valueOf(c));

        } else if (e.getSource() == resetButton) {
            fField.setText("");
            sField.setText("");
            resultField.setText("");
        }
    }
}
