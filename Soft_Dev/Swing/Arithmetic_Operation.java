package Soft_Dev.Swing;

import javax.swing.*;

public class Arithmetic_Operation {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Arithmetic Operations");
        String[] operations = {"Add", "Substract", "Divide", "Multiply"};
        int options = JOptionPane.showOptionDialog(frame,
                "Select an arithmetic Operations:",
                "Arithmetic Operation",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                operations,
                operations[0]);
        switch(options) {
            case 0:
                String add1 = JOptionPane.showInputDialog(frame, "Addition:", "first number");
                String add2 = JOptionPane.showInputDialog(frame, "Addition:", "second number");
                double addResult = Double.parseDouble(add1) + Double.parseDouble(add2);
                JOptionPane.showMessageDialog(frame, "Result: " + addResult, "Addition", JOptionPane.PLAIN_MESSAGE);
                break;
            case 1:
                String sub1 = JOptionPane.showInputDialog(frame, "Subtraction:", "first number");
                String sub2 = JOptionPane.showInputDialog(frame, "Subtraction:", "second number");
                double subResult = Double.parseDouble(sub1) - Double.parseDouble(sub2);
                JOptionPane.showMessageDialog(frame, "Result: " + subResult, "Subtraction", JOptionPane.PLAIN_MESSAGE);
                break;
            case 2:
                String div1 = JOptionPane.showInputDialog(frame, "Division:", "first number");
                String div2 = JOptionPane.showInputDialog(frame, "Division:", "second number");
                double divResult = Double.parseDouble(div1) / Double.parseDouble(div2);
                JOptionPane.showMessageDialog(frame, "Result: " + divResult, "Division", JOptionPane.PLAIN_MESSAGE);
                break;
            case 3:
                String mul1 = JOptionPane.showInputDialog(frame, "Multiplication:", "first number");
                String mul2 = JOptionPane.showInputDialog(frame, "Multiplication:", "second number");
                double mulResult = Double.parseDouble(mul1) * Double.parseDouble(mul2);
                JOptionPane.showMessageDialog(frame, "Result: " + mulResult, "Multiplication", JOptionPane.PLAIN_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(frame, "Something went wrong!", "Error occurred", JOptionPane.ERROR_MESSAGE);

        }
    }
}


