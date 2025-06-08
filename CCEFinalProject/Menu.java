package CCEFinalProject;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Menu extends JFrame implements MouseListener, Serializable {



	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private burgers burger1, burger2, burger3, combo1, combo2, combo3, drink1, drink2, drink3;
	private JButton addToCartBtn;
	private JLabel nameLabel;
	private String fullname;
	private javax.swing.JTable tableClients;
    private javax.swing.JPanel jPanel1;
    private  JLabel totalLabel;
    private double totalPayment;
    private JPanel panel_1;
    private JLabel lblNewLabel_1;
    private JPanel panel_2;
    private JButton btnLogOut;
    private JPanel panel_3;
    private JPanel panel_4;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});
	}

	public Menu() {


		burger1 = new burgers(45, "Breakfast Burger", new ImageIcon("CCEFinalProject\\resources\\itemburger1.png"));
		FlowLayout flowLayout = (FlowLayout) burger1.getLayout();
		burger1.setBounds(238, 168, 117, 127);
		burger1.addMouseListener(this);
		burger2 = new burgers(60, "Chicken Burger", new ImageIcon("CCEFinalProject\\resources\\itemburger2.png"));
		burger2.setBounds(520, 150, 95, 145);
		burger2.addMouseListener(this);
		burger3 = new burgers(40, "Ham Burger", new ImageIcon("CCEFinalProject\\resources\\itemburger3.png"));
		burger3.setBounds(374, 143, 117, 152);
		burger3.addMouseListener(this);



		drink1 = new burgers(20, "Royal\n", new ImageIcon("CCEFinalProject\\resources\\itemDrink1.png"));
		drink1.setBounds(258, 442, 75, 152);
		drink1.addMouseListener(this);
		drink2 = new burgers(20, "Sprite", new ImageIcon("CCEFinalProject\\resources\\itemDrink3.png"));
		drink2.setBounds(394, 442, 75, 145);
		drink2.addMouseListener(this);
		drink3 = new burgers(20, "Coca Cola", new ImageIcon("CCEFinalProject\\resources\\itemDrink2.png"));
		drink3.setBounds(526, 442, 75, 145);
		drink3.addMouseListener(this);

		combo1 = new burgers(75, "Combo Meal A", new ImageIcon("CCEFinalProject\\resources\\itemCombo2.png"));
		combo1.setBounds(384, 291, 95, 140);
		combo1.addMouseListener(this);
		combo2 = new burgers(85, "Combo Meal B", new ImageIcon("CCEFinalProject\\resources\\itemCombo1.png"));
		combo2.setBounds(520, 291, 95, 145);
		combo2.addMouseListener(this);
		combo3 = new burgers(50, "French Fries", new ImageIcon("CCEFinalProject\\resources\\itemCombo3.png"));
		combo3.setBounds(248, 286, 95, 145);
		combo3.addMouseListener(this);


		setIconImage(Toolkit.getDefaultToolkit().getImage("CCEFinalProject\\resources\\icon.png"));
		setBounds(100, 100, 1140, 704);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(500, 0, 0, 0));
		contentPane.setBackground(new Color(78, 78, 78));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JList list = new JList();
		list.setBounds(169, 506, 1, 1);
		contentPane.add(list);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 222, 681);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("CCEFinalProject\\resources\\flyingfood.jpg"));
		lblNewLabel.setBounds(-471, -244, 935, 1052);
		panel.add(lblNewLabel);

		initComponents();
		setVisible(true);
	}

	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        setTitle("Heisenburger");
        setBackground(new java.awt.Color(128, 128, 128));
        setMinimumSize(new java.awt.Dimension(841, 522));

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new Color(192, 192, 192));

        addToCartBtn = new JButton("Add to cart");
        addToCartBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        	}
        });

        contentPane.add(addToCartBtn);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 1124, Short.MAX_VALUE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE))
        );

        jPanel1.setLayout(null);

        jPanel1.add(burger1);
        jPanel1.add(burger2);
        jPanel1.add(burger3);

		jPanel1.add(combo1);
		jPanel1.add(combo2);
        jPanel1.add(combo3);

        jPanel1.add(drink1);
		jPanel1.add(drink2);
		jPanel1.add(drink3);

        getContentPane().setLayout(layout);
        contentPane.setBackground(null);

        jPanel1.setBackground(null);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        JButton checkOutBtn = new JButton("Checkout");
        checkOutBtn.setBackground(new Color(232, 232, 232));
        checkOutBtn.setBorderPainted(false);
        checkOutBtn.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
        checkOutBtn.setBounds(937, 608, 154, 37);
        jPanel1.add(checkOutBtn);
        checkOutBtn.setIcon(new ImageIcon("CCEFinalProject\\resources\\cart.png"));

        checkOutBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int row = tableClients.getRowCount();
        	    if (row <= 0) {
        	         JOptionPane.showMessageDialog(null,"Empty cart, please add items.","Empty",JOptionPane.ERROR_MESSAGE);
        	    } else {
        	    	close();
        	    	Payment x = new Payment(totalPayment);
        	    	x.setVisible(true);
        			      DefaultTableModel model = (DefaultTableModel)tableClients.getModel();

        			      for(int i = 0; i<tableClients.getRowCount(); i++){
        			    	  String burgername = tableClients.getValueAt(i,0).toString();
        			    	  String burgerprice   = tableClients.getValueAt(i,1).toString();
        			    	  String burgerquantity   = tableClients.getValueAt(i,2).toString();
        			    	  x.setter(burgername, burgerprice, burgerquantity, fullname);
        			      }

        	    }
        	    }
        	});

        panel_1 = new JPanel();
        panel_1.setBackground(new Color(69, 69, 69));
        panel_1.setBounds(649, 88, 465, 498);
        jPanel1.add(panel_1);
        panel_1.setLayout(null);
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setBounds(33, 29, 409, 389);
        panel_1.add(jScrollPane1);
        jScrollPane1.setBackground(null);
        tableClients = new javax.swing.JTable();

                tableClients.setFont(new java.awt.Font("Tahoma", 1, 12));
                tableClients.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {

                    },
                    new String [] {
                        "Order", "Price", "Quantity"
                    }
                ));
                jScrollPane1.setViewportView(tableClients);
                tableClients.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                tableClients.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                tableClients.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                tableClients.setBackground(new Color(255, 255, 255));
                tableClients.setBackground(null);
                tableClients.setShowGrid(false);
                                javax.swing.JButton btndelete = new javax.swing.JButton();
                                btndelete.setBounds(322, 453, 117, 34);
                                panel_1.add(btndelete);
                                btndelete.setForeground(new Color(255, 255, 255));
                                btndelete.setBorderPainted(false);
                                btndelete.setBackground(new Color(0, 0, 0));

                                        btndelete.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
                                        btndelete.setIcon(null);
                                        btndelete.setText("Remove Item");
                                        btndelete.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                btndeleteActionPerformed(evt);
                                            }
                                        });

                                        lblNewLabel_1 = new JLabel("");
                                        lblNewLabel_1.setIcon(new ImageIcon("CCEFinalProject\\resources\\Logo3small.png"));
                                        lblNewLabel_1.setBounds(265, -94, 266, 212);
                                        jPanel1.add(lblNewLabel_1);



                                        panel_2 = new JPanel();
                                        panel_2.setBounds(292, -6, 10, 10);
                                        jPanel1.add(panel_2);

                                        btnLogOut = new JButton();
                                        btnLogOut.addActionListener(new ActionListener() {
                                        	public void actionPerformed(ActionEvent e) {
                                        		close();
                                				Login abri = new Login();
                                				abri.setVisible(true);
                                        	}
                                        });
                                        btnLogOut.setText("Log Out");
                                        btnLogOut.setForeground(Color.WHITE);
                                        btnLogOut.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
                                        btnLogOut.setBorderPainted(false);
                                        btnLogOut.setBackground(new Color(41, 84, 84));
                                        btnLogOut.setBounds(1012, 21, 102, 34);
                                        jPanel1.add(btnLogOut);

                                        panel_3 = new JPanel();
                                        panel_3.setBackground(new Color(0, 0, 0));
                                        panel_3.setBounds(217, 127, 422, 5);
                                        jPanel1.add(panel_3);

                                        panel_4 = new JPanel();
                                        panel_4.setBackground(Color.BLACK);
                                        panel_4.setBounds(217, 605, 422, 5);
                                        jPanel1.add(panel_4);

        pack();
    }
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
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
               FileInputStream file = new FileInputStream("CCEFinalProject\\file.txt");
               ObjectInputStream input = new ObjectInputStream(file);

               Vector<Vector> tableData = (Vector<Vector>) input.readObject();
               input.close();
               file.close();
               DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
               for(int i = 0; i< tableData.size();i++){
                   Vector row = tableData.get(i);
                    model.addRow(new Object[] {row.get(0),row.get(1),row.get(2)});
               }

	            double total = 0;
	            for (int i = 0; i < tableClients.getRowCount(); i++) {
	                double q = Double.parseDouble(tableClients.getValueAt(i, 2).toString());
	            	double t = Double.parseDouble(tableClients.getValueAt(i, 1).toString());
	            	double tq = q * t;
	                total += tq;
	            }
	            this.totalPayment = total;
	            totalLabel = new JLabel("Total value: " + total);
	            totalLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
	            totalLabel.setForeground(Color.WHITE);
	            totalLabel.setBounds(29, 453, 200, 34);
	            panel_1.add(totalLabel);

           } catch (Exception ex){
               ex.printStackTrace();
           }
    }



	private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {
	    int row = tableClients.getSelectedRow();
	    if (row < 0) {
	         JOptionPane.showMessageDialog(this,"No row is selected!, please select row","Select row",JOptionPane.ERROR_MESSAGE);
	    } else{
	         DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
	         Vector<Vector> tableData = model.getDataVector();
	         model.removeRow(row);
	         try{
	               FileOutputStream file = new FileOutputStream("CCEFinalProject\\file.txt");
	               ObjectOutputStream output = new ObjectOutputStream(file);

	               output.writeObject(tableData);
	               output.close();
	               file.close();

	           } catch (Exception ex){
	               ex.printStackTrace();
	           }

	         double total = 0;
		        for (int i = 0; i < tableClients.getRowCount(); i++) {
		            total += Double.parseDouble(tableClients.getValueAt(i, 1).toString());

		        }
		        this.totalPayment = total;
		        totalLabel.setText("Total value: " + total);
	    }





	}


	  public void Paid() {
		         DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
		         Vector<Vector> tableData = model.getDataVector();

		         double total = 0;
			        for (int i = 0; i < tableClients.getRowCount(); i++) {
			            total += Double.parseDouble(tableClients.getValueAt(i, 1).toString());
			            model.removeRow(i);
			        }

			         try{
			               FileOutputStream file = new FileOutputStream("CCEFinalProject\\file.txt");
			               ObjectOutputStream output = new ObjectOutputStream(file);
			               output.writeObject(tableData);
			               output.close();
			               file.close();

			           } catch (Exception ex){
			               ex.printStackTrace();
			           }

		    }

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof burgers) {
	        burgers orderedBurger = (burgers) e.getSource();
			String[] responses = {"Add to cart", "Cancel"};
			ImageIcon icon = new ImageIcon("CCEFinalProject\\resources\\walter.png");
			int answer = JOptionPane.showOptionDialog(null, "Are you sure?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, icon, responses, 1);

			switch(answer) {
				case 0:

						String newQuan = JOptionPane.showInputDialog(null, "Quantity:", 1);
						orderedBurger.setQuantity(Integer.valueOf(newQuan));

					 	String name = orderedBurger.getName();
					 	double price = orderedBurger.getPrice();
					 	ImageIcon buricon = orderedBurger.getIcon();
					 	int quantity = orderedBurger.getQuantity();
					 	DefaultTableModel model = (DefaultTableModel) tableClients.getModel();
					 	Vector<Vector> tableData = model.getDataVector();
				        model.addRow(new Object[] {name, price, quantity});

				           try{
				               FileOutputStream file = new FileOutputStream("CCEFinalProject\\file.txt");
				               ObjectOutputStream output = new ObjectOutputStream(file);

				               output.writeObject(tableData);
				               output.close();
				               file.close();

				           } catch (Exception ex){
				               ex.printStackTrace();
				           }

			            double total = 0;
			            for (int i = 0; i < tableClients.getRowCount(); i++) {
			            	double q = Double.parseDouble(tableClients.getValueAt(i, 2).toString());
			            	double t = Double.parseDouble(tableClients.getValueAt(i, 1).toString());
			            	double tq = q * t;
			                total += tq;
			            }
			            this.totalPayment = total;
			            totalLabel.setText("Total value: " + total);
				case 1:

					break;
			}
		}

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseEntered(MouseEvent e) {
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	}

	@Override
	public void mouseExited(MouseEvent e) {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

	}

	public void profileInfo(String fullname) {
		this.fullname = fullname;

		nameLabel = new JLabel(this.fullname);
		nameLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		nameLabel.setIcon(new ImageIcon("CCEFinalProject\\resources\\prof.png"));
		nameLabel.setBounds(860, -4, 200, 81);
        jPanel1.add(nameLabel);
	}
}
