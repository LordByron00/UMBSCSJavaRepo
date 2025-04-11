package Soft_Dev.Swing;
import javax.swing.*;
public class Act_7 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Arithmetic Operations");

        String num1 = JOptionPane.showInputDialog(frame, "first number:");

        String num2 = JOptionPane.showInputDialog(frame, "second number:");

        int a = Integer.valueOf(num1);

        int b = Integer.valueOf(num2);


        String ouput = "Arithmetic Operations of " + num1 + " and " + num2 + "\n\nResult:\n" + "Addition: " + add(a, b) +
                "\nSubstraction: " + subt(a, b) + "\nDivision: " + div(a, b) + "\nMultiplication: " + mult(a, b);

        JOptionPane.showMessageDialog(frame, ouput);

    }


    static int add(int a, int b) {

        return a + b;

    }

    static int subt(int a, int b) {

        return a - b;

    }


    static int div(int a, int b) {

        return a / b;

    }

    static int mult(int a, int b) {

        return a * b;

    }
}
