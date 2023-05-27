package CCE.Activities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.*;

public class UniversityEnrollmentSystem extends JFrame implements ActionListener {
    private JLabel lblName, lblID, lblDepartment, lblCGPA, lblResult;
    private JTextField txtName, txtID, txtDepartment, txtCGPA;
    private JButton btnSubmit, btnReset;
//    private Connection conn = null;
//    private PreparedStatement pst = null;

    public UniversityEnrollmentSystem() {
        setTitle("University Enrollment System");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblName = new JLabel("Name:");
        lblName.setBounds(50, 50, 100, 30);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(150, 50, 200, 30);
        add(txtName);

        lblID = new JLabel("ID:");
        lblID.setBounds(50, 100, 100, 30);
        add(lblID);

        txtID = new JTextField();
        txtID.setBounds(150, 100, 200, 30);
        add(txtID);

        lblDepartment = new JLabel("Department:");
        lblDepartment.setBounds(50, 150, 100, 30);
        add(lblDepartment);

        txtDepartment = new JTextField();
        txtDepartment.setBounds(150, 150, 200, 30);
        add(txtDepartment);

        lblCGPA = new JLabel("CGPA:");
        lblCGPA.setBounds(50, 200, 100, 30);
        add(lblCGPA);

        txtCGPA = new JTextField();
        txtCGPA.setBounds(150, 200, 200, 30);
        add(txtCGPA);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(100, 300, 100, 30);
        add(btnSubmit);
        btnSubmit.addActionListener(this);

        btnReset = new JButton("Reset");
        btnReset.setBounds(250, 300, 100, 30);
        add(btnReset);
        btnReset.addActionListener(this);

        lblResult = new JLabel();
        lblResult.setBounds(50, 350, 400, 30);
        add(lblResult);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            String name = txtName.getText();
            String id = txtID.getText();
            String department = txtDepartment.getText();
        }
    }
}