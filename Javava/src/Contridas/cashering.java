package Contridas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;

import javax.swing.table.*;


public class cashering extends JFrame {

    private static final long serialVersionUID = 1L;

    // Declare components
    private JLabel lblReceiptNumber, lblItemName, lblItemQuantity, lblItemPrice;
    private JTextField txtReceiptCode, txtItem, txtQuantity, txtPrice;
    private JButton btnAdd, btnSearch, btnClear, btnUpdate, btnClose;
    private JTable tblTotalBuys, tblInfoBuys;
    private DefaultTableModel totalBuysModel, infoBuysModel;
    private JButton printbtn;

    public cashering() {
        // Set up GUI
        setTitle("CON3DAZ's Pharmacy Cashiering");
        getContentPane().setBackground(Color.cyan);
        getContentPane().setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 600);

        // Initialize components
        lblReceiptNumber = new JLabel("Receipt Number:");
        txtReceiptCode = new JTextField(10);
        lblItemName = new JLabel("Item Name:");
        txtItem = new JTextField(10);
        lblItemQuantity = new JLabel("Item Quantity:");
        txtQuantity = new JTextField(10);
        lblItemPrice = new JLabel("Item Price:");
        txtPrice = new JTextField(10);
        btnAdd = new JButton("Add");
        btnSearch = new JButton("Search");
        btnClear = new JButton("Clear");
        btnUpdate = new JButton("Update");
        btnClose = new JButton("Close");
        totalBuysModel = new DefaultTableModel(new String[]{"Receipt Number", "Total Price"}, 0);
        infoBuysModel = new DefaultTableModel(new String[]{"Receipt Number", "Item Name", "Item Quantity", "Item Price"}, 0);
        tblTotalBuys = new JTable(totalBuysModel);
        tblInfoBuys = new JTable(infoBuysModel);

        // Add components to GUI
        getContentPane().add(lblReceiptNumber);
        getContentPane().add(txtReceiptCode);
        getContentPane().add(lblItemName);
        getContentPane().add(txtItem);
        getContentPane().add(lblItemQuantity);
        getContentPane().add(txtQuantity);
        getContentPane().add(lblItemPrice);
        getContentPane().add(txtPrice);
        getContentPane().add(btnAdd);
        getContentPane().add(btnSearch);

        printbtn = new JButton("Print");
        printbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    tblTotalBuys.print();
                } catch (PrinterException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        getContentPane().add(printbtn);
        getContentPane().add(new JScrollPane(tblTotalBuys));
        getContentPane().add(new JScrollPane(tblInfoBuys));
        getContentPane().add(btnClear);
        getContentPane().add(btnUpdate);
        getContentPane().add(btnClose);

        // Add button action listeners
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get user input
                String receiptCode = txtReceiptCode.getText();
                String item = txtItem.getText();
                String quantity = txtQuantity.getText();
                String price = txtPrice.getText();

                // Add to info buys table
                infoBuysModel.addRow(new Object[]{receiptCode, item, quantity, price});

                // Calculate total price
                double totalPrice = Double.parseDouble(quantity) * Double.parseDouble(price);

                // Check if receipt already exists in total buys table
                boolean exists = false;
                for (int i = 0; i < totalBuysModel.getRowCount(); i++) {
                    if (totalBuysModel.getValueAt(i, 0).equals(receiptCode)) {
                        exists = true;
                        double currentTotal = Double.parseDouble(totalBuysModel.getValueAt(i, 1).toString());
                        totalBuysModel.setValueAt(currentTotal + totalPrice, i, 1);
                        break;
                    }
                }

                // Add to total buys table if receipt doesn't exist
                if (!exists) {
                    totalBuysModel.addRow(new Object[]{receiptCode, totalPrice});

                }

                // Clear input fields
                txtReceiptCode.setText("");
                txtItem.setText("");
                txtQuantity.setText("");
                txtPrice.setText("");
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get user input
                String receiptCode = txtReceiptCode.getText();
                // Check if receipt exists in total buys table
                boolean exists = false;
                for (int i = 0; i < totalBuysModel.getRowCount(); i++) {
                    if (totalBuysModel.getValueAt(i, 0).equals(receiptCode)) {
                        exists = true;
                        // Select the row in total buys table
                        tblTotalBuys.setRowSelectionInterval(i, i);
                        // Clear info buys table
                        infoBuysModel.setRowCount(0);
                        // Add all items from that receipt to info buys table
                        for (int j = 0; j < infoBuysModel.getRowCount(); j++) {
                            if (infoBuysModel.getValueAt(j, 0).equals(receiptCode)) {
                                infoBuysModel.addRow(new Object[]{infoBuysModel.getValueAt(j, 1), infoBuysModel.getValueAt(j, 2), infoBuysModel.getValueAt(j, 3)});
                            }
                        }
                        break;
                    }
                }

                // Show error message if receipt doesn't exist
                if (!exists) {
                    JOptionPane.showMessageDialog(null, "Receipt not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear all input fields and tables
                txtReceiptCode.setText("");
                txtItem.setText("");
                txtQuantity.setText("");
                txtPrice.setText("");
                totalBuysModel.setRowCount(0);
                infoBuysModel.setRowCount(0);
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get selected row from info buys table
                int selectedRow = tblInfoBuys.getSelectedRow();

                // Update the row with user input
                infoBuysModel.setValueAt(txtItem.getText(), selectedRow, 1);
                infoBuysModel.setValueAt(txtQuantity.getText(), selectedRow, 2);
                infoBuysModel.setValueAt(txtPrice.getText(), selectedRow, 3);

                // Calculate new total price for the receipt
                String receiptCode = txtReceiptCode.getText();
                double totalPrice = 0;
                for (int i = 0; i < infoBuysModel.getRowCount(); i++) {
                    if (infoBuysModel.getValueAt(i, 0).equals(receiptCode)) {
                        double itemPrice = Double.parseDouble(infoBuysModel.getValueAt(i, 3).toString());
                        double itemQuantity = Double.parseDouble(infoBuysModel.getValueAt(i, 2).toString());
                        totalPrice += itemPrice * itemQuantity;
                    }
                }

                // Update total price in total buys table
                for (int i = 0; i < totalBuysModel.getRowCount(); i++) {
                    if (totalBuysModel.getValueAt(i, 0).equals(receiptCode)) {
                        totalBuysModel.setValueAt(totalPrice, i, 1);
                        break;
                    }
                }

                // Clear input fields
                txtReceiptCode.setText("");
                txtItem.setText("");
                txtQuantity.setText("");
                txtPrice.setText("");

            }
        });

        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the program
//                System.exit(0);
                setVisible(false);
                new LogIn();
            }
        });

        // Show GUI
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run the program
        new cashering();
    }
}