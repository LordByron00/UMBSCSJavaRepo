package CCEFinalProject;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class TableExample {

    public static void main(String[] args) {

        // Create a table model with two columns: Name and Image
    	DefaultTableModel model = new DefaultTableModel(new Object[][]{
    	    {"Image 1", null},
    	    {"Image 2", null}
    	}, new Object[]{"Name", "Image"});

    	// create the image icons and set them in the table model
    	ImageIcon icon1 = new ImageIcon("D:\\EJ files\\downloads\\Images\\menu cce\\final\\check.png");
    	ImageIcon icon2 = new ImageIcon("D:\\EJ files\\downloads\\Images\\menu cce\\final\\check.png");
    	model.setValueAt(icon1, 0, 1);
    	model.setValueAt(icon2, 1, 1);

    	// Create a table with the model
    	JTable table = new JTable(model);
    	table.setShowGrid(false);
    	// Set the cell renderer for the Image column
    	TableColumnModel columnModel = table.getColumnModel();
    	columnModel.getColumn(1).setCellRenderer(new ImageRenderer());

    	// Add the table to a scroll pane and display it in a frame
    	JScrollPane scrollPane = new JScrollPane(table);
    	JFrame frame = new JFrame("Table Example");
    	frame.add(scrollPane);
    	frame.pack();
    	frame.setVisible(true);
    }
}

