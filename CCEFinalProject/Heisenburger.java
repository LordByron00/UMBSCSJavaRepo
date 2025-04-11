package CCEFinalProject;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Heisenburger extends JFrame implements MouseListener {

	private JPanel panel;
	private ImageIcon food, addToCart;
	private JLabel addToCartLabel;
	private Image foodLogo;
	private burgers burger;
	private addedToCart orderedWindow;

	public Heisenburger() {
		burger = new burgers(500, "Ham Burger", new ImageIcon("C:\\Users\\nilsa\\OneDrive\\Documents\\Lelouch\\Java\\LearningJava\\Java Repository\\Javava\\src\\FinalProject\\burger1.png"));
		addToCart = new ImageIcon("D:\\EJ files\\downloads\\Images\\menu cce\\final\\check.png");
		foodLogo = new ImageIcon("C:\\Users\\nilsa\\OneDrive\\Documents\\Lelouch\\Java\\LearningJava\\Java Repository\\Javava\\src\\FinalProject\\burger1.png").getImage();

		panel = new JPanel();
		panel.setBounds(0, 0, 950, 720);
		panel.setBackground(Color.decode("#30a6cc"));

		addToCartLabel = new JLabel();
		addToCartLabel.setHorizontalAlignment(JLabel.LEFT);
		addToCartLabel.setHorizontalTextPosition(JLabel.LEFT);
		addToCartLabel.setIcon(addToCart);

		burger.addMouseListener(this);
		addToCartLabel.addMouseListener(this);


		add(panel);
		panel.add(burger);
		panel.add(addToCartLabel);

		setTitle("Heisenburger");
		setIconImage(foodLogo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setSize(950, 720);
		setVisible(true);

	}
	public static void main(String[] args) {
		new Heisenburger();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		addedToCart orderWindow = new addedToCart();
		if (e.getSource() == burger) {
				String[] responses = {"Order", "Add to cart", "Cancel"};
				ImageIcon icon = new ImageIcon("C:\\Users\\nilsa\\OneDrive\\Documents\\Lelouch\\Java\\LearningJava\\Java Repository\\Javava\\src\\FinalProject\\burger1.png");
				int answer = JOptionPane.showOptionDialog(null, "Are you sure?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, icon, responses, 0);

				switch(answer) {
					case 0:
							Object[] why = {burger.getName(), burger.getPrice(), burger.getIcon()};
							 orderedWindow = new addedToCart();
				}
			} else if (e.getSource() == addToCartLabel){
//				orderedWindow.setVisible();
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

}
