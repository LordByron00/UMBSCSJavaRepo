package GUIReceipt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;


public class ThisFrame extends javax.swing.JFrame {

 
    public ThisFrame() {
        initComponents();
    }


    @SuppressWarnings("unchecked")                    
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        txfname = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        txfemail = new javax.swing.JTextField();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        txfphone = new javax.swing.JTextField();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        txfaddress = new javax.swing.JTextField();
        javax.swing.JButton btnadd = new javax.swing.JButton();
        javax.swing.JButton btnclear = new javax.swing.JButton();
        javax.swing.JButton btndelete = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tableClients = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnReport = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

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

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new ImageIcon("C:\\Users\\nilsa\\OneDrive\\Documents\\Lelouch\\Java\\LearningJava\\Java Repository\\CCE\\user.png")); // NOI18N
        jLabel1.setText("List of Clients");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Client", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 14))); // NOI18N
        jPanel3.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel2.setText("Name");

        txfname.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N

        txfemail.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel6.setText("Phone:");

        txfphone.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel7.setText("Address:");

        txfaddress.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N

        btnadd.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnadd.setIcon(new ImageIcon("C:\\Users\\nilsa\\OneDrive\\Documents\\Lelouch\\Java\\LearningJava\\Java Repository\\CCE\\add.png")); // NOI18N
        btnadd.setText("Add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnclear.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnclear.setIcon(new ImageIcon("C:\\Users\\nilsa\\OneDrive\\Documents\\Lelouch\\Java\\LearningJava\\Java Repository\\CCE\\eraser.png")); // NOI18N
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnadd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnclear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfaddress)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 172, Short.MAX_VALUE))
                    .addComponent(txfemail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txfname)
                    .addComponent(txfphone))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadd)
                    .addComponent(btnclear))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        btndelete.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btndelete.setIcon(new ImageIcon("C:\\Users\\nilsa\\OneDrive\\Documents\\Lelouch\\Java\\LearningJava\\Java Repository\\CCE\\delete.png")); // NOI18N
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        tableClients.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        tableClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Email", "Phone", "Address"
            }
        ));
        jScrollPane1.setViewportView(tableClients);

        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        txtArea.setRows(5);
        jScrollPane2.setViewportView(txtArea);

        btnReport.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnReport.setIcon(new ImageIcon("C:\\Users\\nilsa\\OneDrive\\Documents\\Lelouch\\Java\\LearningJava\\Java Repository\\CCE\\report.png")); // NOI18N
        btnReport.setText("Report");
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });

        btnPrint.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnPrint.setIcon(new ImageIcon("C:\\Users\\nilsa\\OneDrive\\Documents\\Lelouch\\Java\\LearningJava\\Java Repository\\CCE\\printing.png")); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnReset.setIcon(new ImageIcon("C:\\Users\\nilsa\\OneDrive\\Documents\\Lelouch\\Java\\LearningJava\\Java Repository\\CCE\\reset.png")); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btndelete)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnReport)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReset)
                                .addGap(18, 18, 18)
                                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addComponent(jScrollPane2))))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btndelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReport)
                    .addComponent(btnPrint)
                    .addComponent(btnReset))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {                                       
        String name = txfname.getText();
        String email = txfemail.getText();
        String phone = txfphone.getText();
        String address = txfaddress.getText();
        
        if(name.isEmpty()|| email.isEmpty() || phone.isEmpty() || address.isEmpty()){
            JOptionPane.showMessageDialog(this,"Please enter all fields", "Try again",JOptionPane.ERROR_MESSAGE);
        } 
        else {
            DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
            model.addRow(new Object[] {name, email, phone, address}); 
            
                       
            txfname.setText(" ");
            txfemail.setText(" ");
            txfphone.setText(" ");
            txfaddress.setText(" ");
            
        }
    }                                      

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {                                         
            txfname.setText(" ");
            txfemail.setText(" ");
            txfphone.setText(" ");
            txfaddress.setText(" ");
    }                                        

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
           
           //Saving of object in a file
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

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {                                          
      txtArea.setText("========================================================\n");
      txtArea.setText(txtArea.getText()+"*                               LIST OF CLIENTS                              *\n");
      txtArea.setText(txtArea.getText()+"========================================================\n");
      
      Date obj = new Date();
      String date = obj.toString();
      
      txtArea.setText(txtArea.getText()+"\n"+date+"\n\n");
      DefaultTableModel model = (DefaultTableModel)tableClients.getModel();
      
      txtArea.setText(txtArea.getText()+"NAME"+"\t"+"EMAIL"+"\t"+"PHONE"+"\t"+"ADDRESS\n");
      for(int i = 0; i<tableClients.getRowCount(); i++){
          String name    = tableClients.getValueAt(i,0).toString();
          String email   = tableClients.getValueAt(i,1).toString();
          String phone   = tableClients.getValueAt(i,2).toString();
          String address = tableClients.getValueAt(i,3).toString();
          txtArea.setText(txtArea.getText()+name+"\t"+email+"\t"+phone+"\t"+address+"\n");   
      }
      
      txtArea.setText(txtArea.getText()+"\n\n");
      txtArea.setText(txtArea.getText()+"========================================================\n\n");
      txtArea.setText(txtArea.getText()+"\t\t  Signature:______________________ \n");
      
    }                                         

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {                                         
       try{
           txtArea.print();
       }catch (Exception e){
           
       }
           
    }                                        

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {                                         
           txtArea.setText(" ");        
    }                                        


    public static void main(String args[]) {
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThisFrame().setVisible(true);
            }
        });
    }

                
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnReset;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableClients;
    private javax.swing.JTextField txfaddress;
    private javax.swing.JTextField txfemail;
    private javax.swing.JTextField txfname;
    private javax.swing.JTextField txfphone;
    private javax.swing.JTextArea txtArea;                
}