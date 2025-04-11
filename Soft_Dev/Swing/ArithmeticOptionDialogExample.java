package Soft_Dev.Swing;
import javax.swing.*;

public class ArithmeticOptionDialogExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        // Define arithmetic operations and store them in an array
        String[] options = {"Addition", "Subtraction", "Multiplication", "Division"};

        // Show the option dialog
        int choice = JOptionPane.showOptionDialog(
                frame,
                "Select an arithmetic operation:",
                "Arithmetic Operations",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0] // Default selection
        );

        // Process the user's choice
        if (choice >= 0) {
            String selectedOperation = options[choice];
            performArithmeticOperation(selectedOperation);
        } else {
            System.out.println("Dialog was closed without a choice.");
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private static void performArithmeticOperation(String operation) {
        double result = 0.0;
        double operand1 = 10.0; // Example operand 1
        double operand2 = 5.0;  // Example operand 2

        switch (operation) {
            case "Addition":
                result = operand1 + operand2;
                break;
            case "Subtraction":
                result = operand1 - operand2;
                break;
            case "Multiplication":
                result = operand1 * operand2;
                break;
            case "Division":
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    JOptionPane.showMessageDialog(null, "Division by zero is not allowed.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }

        JOptionPane.showMessageDialog(null, "Result of " + operation + ": " + result, "Result", JOptionPane.INFORMATION_MESSAGE);
    }
}
