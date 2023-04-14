package FinalProject;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PopupWindowExample {
    public static void main(String[] args) {
        String[] columnNames = {"Name", "Age", "Gender"};
        Object[][] data = {
            {"John", 25, "Male"},
            {"Jane", 30, "Female"},
            {"Bob", 40, "Male"},
            {"Mary", 20, "Female"}
        };
        
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        
        JOptionPane.showMessageDialog(null, scrollPane, "Table Example", JOptionPane.PLAIN_MESSAGE);
    }
}
