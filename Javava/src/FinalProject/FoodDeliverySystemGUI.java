package FinalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodDeliverySystemGUI extends JFrame implements ActionListener {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JPanel loginPanel;
  private JPanel menuPanel;
  private JTextField usernameField;
  private JPasswordField passwordField;
  private JTextArea menuTextArea;

  public FoodDeliverySystemGUI() {
    // Set up the login panel
	// Set up the login panel
	  loginPanel = new JPanel(new GridBagLayout());
	  GridBagConstraints gbc = new GridBagConstraints();

	  gbc.insets = new Insets(5, 5, 5, 5);
	  gbc.gridx = 0;
	  gbc.gridy = 0;
	  gbc.anchor = GridBagConstraints.LINE_END;
	  loginPanel.add(new JLabel("Username:"), gbc);

	  gbc.gridx = 1;
	  gbc.anchor = GridBagConstraints.LINE_START;
	  usernameField = new JTextField(20);
	  loginPanel.add(usernameField, gbc);

	  gbc.gridx = 0;
	  gbc.gridy = 1;
	  gbc.anchor = GridBagConstraints.LINE_END;
	  loginPanel.add(new JLabel("Password:"), gbc);

	  gbc.gridx = 1;
	  gbc.anchor = GridBagConstraints.LINE_START;
	  passwordField = new JPasswordField(20);
	  loginPanel.add(passwordField, gbc);

	  gbc.gridx = 0;
	  gbc.gridy = 2;
	  gbc.gridwidth = 2;
	  gbc.fill = GridBagConstraints.HORIZONTAL;
	  JButton loginButton = new JButton("Login");
	  loginButton.addActionListener(this);
	  loginPanel.add(loginButton, gbc);

	  gbc.gridy = 3;
	  JButton clearButton = new JButton("Clear");
	  clearButton.addActionListener(this);
	  loginPanel.add(clearButton, gbc);


    // Set up the menu panel
    menuPanel = new JPanel(new BorderLayout());
    menuTextArea = new JTextArea();
    menuTextArea.setEditable(false);
    JScrollPane menuScrollPane = new JScrollPane(menuTextArea);
    menuPanel.add(menuScrollPane, BorderLayout.CENTER);
    JButton orderButton = new JButton("Order");
    orderButton.addActionListener(this);
    menuPanel.add(orderButton, BorderLayout.SOUTH);

    // Set up the frame
    setTitle("Food Delivery System");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 300);
    setLocationRelativeTo(null);
    setResizable(false);
    setLayout(new CardLayout());
    add(loginPanel, "login");
    add(menuPanel, "menu");
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Login")) {
      String username = usernameField.getText();
      String password = new String(passwordField.getPassword());
      if (username.equals("admin") && password.equals("password")) {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "menu");
        menuTextArea.setText("1. Pizza\n2. Burger\n3. Salad\n4. Fries");
      } else {
        JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
      }
    } else if (e.getActionCommand().equals("Clear")) {
      usernameField.setText("");
      passwordField.setText("");
    } else if (e.getActionCommand().equals("Order")) {
      // Show a dialog box to get the user's order
      String order = JOptionPane.showInputDialog(this, "Enter the number of the item you want to order:");
      if (order != null) {
        try {
          int itemNumber = Integer.parseInt(order);
          switch (itemNumber) {
            case 1:
              JOptionPane.showMessageDialog(this, "You ordered Pizza");
              break;
            case 2:
              JOptionPane.showMessageDialog(this, "You ordered Burger");
              break;
            case 3:
              JOptionPane.showMessageDialog(this, "You ordered Salad");
              break;
            case 4:
              JOptionPane.showMessageDialog(this, "You ordered Fries");
              break;
            default:
              JOptionPane.showMessageDialog(this, "Invalid item number", "Error", JOptionPane.ERROR_MESSAGE);
          }
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(this, "Invalid item number", "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    }
  }

  public static void main(String[] args) {
    FoodDeliverySystemGUI frame = new FoodDeliverySystemGUI();
    frame.setVisible(true);
  }
}
