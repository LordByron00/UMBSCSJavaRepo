package CCEFinalProject;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class burgers extends JPanel {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private double price, prepTime;
	private String name;
	private ImageIcon burgerIcon;
	private int quantity = 0;
	private JLabel burgerLabel, burgerPrice, bIcon;
	private Boolean isSelected = false;

	burgers(double price, String name, ImageIcon icon) {
//		super(icon);
		this.price = price;
		this.name = name;
		this.burgerIcon = icon;

		burgerLabel = new JLabel();
		burgerPrice = new JLabel();
		burgerPrice.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		bIcon = new JLabel();
		bIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bIcon.setVerticalAlignment(SwingConstants.TOP);
		bIcon.setHorizontalAlignment(SwingConstants.CENTER);

		burgerLabel.setText(this.name);
		burgerLabel.setVerticalTextPosition(JLabel.BOTTOM);
		burgerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		burgerLabel.setVerticalAlignment(SwingConstants.TOP);

		burgerPrice.setText("PHP: " + this.price);
		burgerPrice.setHorizontalTextPosition(JLabel.CENTER);
		burgerPrice.setVerticalTextPosition(JLabel.BOTTOM);
		burgerPrice.setHorizontalAlignment(SwingConstants.CENTER);
		burgerPrice.setVerticalAlignment(SwingConstants.BOTTOM);

		bIcon.setIcon(this.burgerIcon);
		burgerPrice.setHorizontalAlignment(JLabel.CENTER);
		burgerPrice.setVerticalAlignment(JLabel.CENTER);

		this.add(bIcon);
		this.add(burgerLabel);
		this.add(burgerPrice);
		this.setBackground(null);
//		this.setVisible(true);
//		this.setVerticalAlignment(BOTTOM);
//		this.setBounds(300, 300, 25, 25);
	}

	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public ImageIcon getIcon() {
		return burgerIcon;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public boolean isSelected() {
		return isSelected;
	}
	public void select() {
		this.isSelected = true;
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

	}
	public void deselect() {
		this.isSelected = false;
		this.setBorder(null);
	}

}
