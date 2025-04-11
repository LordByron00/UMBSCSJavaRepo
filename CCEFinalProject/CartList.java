package CCEFinalProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;


public class CartList extends javax.swing.JFrame {
    private javax.swing.JTable tableClients;

    public CartList() {
        initComponents();
    }


    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JButton btndelete = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tableClients = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        setBackground(new java.awt.Color(153, 255, 153));
        setMinimumSize(new java.awt.Dimension(841, 522));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(null);
        jLabel1.setText("List of Clients");

        btndelete.setFont(new java.awt.Font("Segoe Print", 1, 12));
        btndelete.setIcon(null);
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        tableClients.setFont(new java.awt.Font("Segoe Print", 1, 12));
        tableClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Label", "Price", "Photo", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(tableClients);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(320)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(263, Short.MAX_VALUE))
        		.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        			.addContainerGap(442, Short.MAX_VALUE)
        			.addComponent(btndelete)
        			.addGap(385))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addComponent(jLabel1)
        			.addGap(58)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
        			.addComponent(btndelete)
        			.addGap(33))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {

         int row = tableClients.getSelectedRow();
        if (row < 0) {
             JOptionPane.showMessageDialog(this,"No row is selected!, please select row","Select row",JOptionPane.ERROR_MESSAGE);
        } else{
             DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
             model.removeRow(row);
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
           Vector<Vector> tableData = model.getDataVector();


           try{
               FileOutputStream file = new FileOutputStream("file.txt");
               ObjectOutputStream output = new ObjectOutputStream(file);

               output.writeObject(tableData);
               output.close();
               file.close();

           } catch (Exception ex){
               ex.printStackTrace();
           }

    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        try{
               FileInputStream file = new FileInputStream("file.txt");
               ObjectInputStream input = new ObjectInputStream(file);

               Vector<Vector> tableData = (Vector<Vector>) input.readObject();
               input.close();
               file.close();

               DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
               for(int i = 0; i< tableData.size();i++){
                   Vector row = tableData.get(i);
                    model.addRow(new Object[] {row.get(0),row.get(1),row.get(2),row.get(3)});
               }
           } catch (Exception ex){
               ex.printStackTrace();
           }
    }

   public void infoSettter(String name, double price, ImageIcon icon, int quantity) {
	   System.out.println(name + price + quantity + icon);
	   DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
	   model.addRow(new Object[] {name, price, quantity, icon});
   }

    public static void main(String args[]) {


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CartList().setVisible(true);
            }
        });
    }



}

