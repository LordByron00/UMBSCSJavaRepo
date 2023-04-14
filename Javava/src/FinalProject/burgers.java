package FinalProject;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class burgers extends JLabel {
	
	private double price, prepTime;
	private String name;
	private ImageIcon burgerIcon;
	
	burgers(int price, String name, ImageIcon icon) {
//		super(icon);
		this.price = price;
		this.name = name;
		this.burgerIcon = icon;
		
		this.setText(name + " PHP: " + price);
		this.setIcon(icon);
		this.setHorizontalTextPosition(JLabel.CENTER);
		this.setVerticalTextPosition(JLabel.BOTTOM);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.CENTER);
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
}
