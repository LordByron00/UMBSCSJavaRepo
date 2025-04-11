package Soft_Dev.Swing;

import javax.swing.*;
import java.awt.*;

public class Act_9_JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(300, 300);
        JLabel errLabel = new JLabel("Enter Numbers:");
        errLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel fLabel = new JLabel("First number:");
        JLabel sLabel = new JLabel("Second number:");
        JTextField firstTF = new JTextField(10);
        JTextField secondTF = new JTextField(10);
        JButton calButton = new JButton("Calculate");
        Font fontLabel = new Font("Arial", Font.PLAIN, 13);
        Font fontBold = new Font("Arial", Font.BOLD, 14);
        errLabel.setFont(fontBold);
        fLabel.setFont(fontLabel);
        sLabel.setFont(fontLabel);
        firstTF.setFont(fontLabel);
        secondTF.setFont(fontLabel);
        calButton.setFont(fontBold);



        calButton.addActionListener(e -> {
            Double num1 = null;
            Double num2 = null;

            try {
                num1 = Double.valueOf(firstTF.getText());
                num2 = Double.valueOf(secondTF.getText());
            } catch (NumberFormatException er) {
                errLabel.setText("Invalid input. Must be numerical Value!");
            }

            try {
                if (num1 != null && num2 != null ) {
                    double sum = num1 + num2;
                    double sub = num1 - num2;
                    double div = num1 / num2;
                    double mul = num1 * num2;

                    JFrame resultFrame = new JFrame("Calculation");
                    resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    resultFrame.setSize(300, 300);

                    JLabel operationLabel = new JLabel("Arithmetic Operations of " + num1 + " " + num2 + ":");
                    JLabel sumLabel = new JLabel("Sum: " + sum);
                    JLabel subLabel = new JLabel("Difference: " + sub);
                    JLabel divLabel = new JLabel("Quotient: " + div);
                    JLabel mulLabel = new JLabel("Product: " + mul);
                    Font font2 = new Font("Arial", Font.PLAIN, 18);
                    sumLabel.setFont(font2);
                    subLabel.setFont(font2);
                    divLabel.setFont(font2);
                    mulLabel.setFont(font2);
                    operationLabel.setBounds(40, 30, 220, 20);
                    sumLabel.setBounds(65, 60, 200, 20);
                    subLabel.setBounds(65, 90, 200, 20);
                    divLabel.setBounds(65, 120, 200, 20);
                    mulLabel.setBounds(65, 150, 200, 20);

                    resultFrame.add(sumLabel);
                    resultFrame.add(subLabel);
                    resultFrame.add(divLabel);
                    resultFrame.add(mulLabel);
                    resultFrame.setLayout(null);
                    resultFrame.setVisible(true);
                    frame.dispose();
                } else {
                    errLabel.setText("Enter number values!");
                }



            } catch (Exception ex) {
                errLabel.setText("Something went wrong. Try again!");
            }
        });

        errLabel.setBounds(30, 20, 240, 30);
        fLabel.setBounds(30, 70, 100, 30);
        sLabel.setBounds(30, 120, 100, 30);
        firstTF.setBounds(135, 70, 130, 30);
        secondTF.setBounds(135, 120, 130, 30);
        calButton.setBounds(95, 170, 110, 40);

        frame.add(errLabel);
        frame.add(fLabel);
        frame.add(sLabel);
        frame.add(secondTF);
        frame.add(firstTF);
        frame.add(secondTF);
        frame.add(calButton);

        frame.setLayout(null);
        frame.setVisible(true);
    }



}
