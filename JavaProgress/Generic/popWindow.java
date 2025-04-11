package JavaProgress;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class popWindow {


    public static void main(String[] args) {
        JFrame popup = new JFrame("Table Popup");

        // Create a JTable object with some data
        Object[][] data = {{"Soft_Dev", "John Doe", "john@example.com"},
                {"2", "Jane Smith", "jane@example.com"}};
        String[] columnNames = {"ID", "Name", "Email"};
        JTable table = new JTable(data, columnNames);

        // Add the JTable object to a JScrollPane object
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the JScrollPane object to the JFrame object
        popup.add(scrollPane);

        // Set the size and visibility of the JFrame object
        popup.setSize(300, 200);
        popup.setVisible(true);

        // Create a JButton object that will open the popup window
        JButton button = new JButton("Show Table");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                popup.setVisible(true);
            }
        });

    }

}
