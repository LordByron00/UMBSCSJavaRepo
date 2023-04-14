package CCEFinalProject;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Menuas extends JFrame{
	private JLabel addToCartLabel;
	private ImageIcon food, addToCart;
	private Image foodLogo;
	private addedToCart orderedWindow;
	private burgers burger1, burger2, burger3, combo1, combo2, combo3, drink1, drink2, drink3;

	public Menuas() {
		
		//initialization
		burger1 = new burgers(500, "Ham Burger", new ImageIcon("C:\\Users\\nilsa\\OneDrive\\Documents\\Lelouch\\Java\\LearningJava\\Java Repository\\Javava\\src\\FinalProject\\pics\\breakfast burger.png"));
		burger1.setBounds(224, 50, 150, 100);
		burger2 = new burgers(500, "Ham Burger", new ImageIcon("C:\\Users\\nilsa\\OneDrive\\Documents\\Lelouch\\Java\\LearningJava\\Java Repository\\Javava\\src\\FinalProject\\pics\\chicken burger.png"));
		burger2.setBounds(342, 60, 99, 69);
		burger3 = new burgers(500, "Ham Burger", new ImageIcon("C:\\Users\\nilsa\\OneDrive\\Documents\\Lelouch\\Java\\LearningJava\\Java Repository\\Javava\\src\\FinalProject\\pics\\cheeseburger.png"));
		burger3.setBounds(494, 50, 99, 69);
		
		combo1 = new burgers(500, "Ham Burger", new ImageIcon("C:\\Users\\nilsa\\OneDrive\\Documents\\Lelouch\\Java\\LearningJava\\Java Repository\\Javava\\src\\FinalProject\\burger1.png"));
		combo1.setBounds(209, 152, 99, 69);
		combo2 = new burgers(500, "Ham Burger", new ImageIcon("C:\\Users\\nilsa\\OneDrive\\Documents\\Lelouch\\Java\\LearningJava\\Java Repository\\Javava\\src\\FinalProject\\burger1.png"));
		combo2.setBounds(355, 152, 99, 69);
		combo3 = new burgers(500, "Ham Burger", new ImageIcon("C:\\Users\\nilsa\\OneDrive\\Documents\\Lelouch\\Java\\LearningJava\\Java Repository\\Javava\\src\\FinalProject\\burger1.png"));
		combo3.setBounds(494, 163, 99, 69);
		
		drink1 = new burgers(500, "Ham Burger", new ImageIcon("C:\\Users\\nilsa\\OneDrive\\Documents\\Lelouch\\Java\\LearningJava\\Java Repository\\Javava\\src\\FinalProject\\burger1.png"));
		drink1.setBounds(209, 270, 99, 69);
		drink2 = new burgers(500, "Ham Burger", new ImageIcon("C:\\Users\\nilsa\\OneDrive\\Documents\\Lelouch\\Java\\LearningJava\\Java Repository\\Javava\\src\\FinalProject\\burger1.png"));
		drink2.setBounds(355, 270, 99, 69);
		drink3 = new burgers(500, "Ham Burger", new ImageIcon("C:\\Users\\nilsa\\OneDrive\\Documents\\Lelouch\\Java\\LearningJava\\Java Repository\\Javava\\src\\FinalProject\\burger1.png"));
		drink3.setBounds(503, 268, 99, 69);
		
		
		
		//adding to components
		getContentPane().add(burger1);
		getContentPane().add(burger2);
		getContentPane().add(burger3);
		getContentPane().add(combo1);
		getContentPane().add(combo2);
		getContentPane().add(combo3);
		getContentPane().add(drink1);
		getContentPane().add(drink2);
		getContentPane().add(drink3);
		
		
		//Jframe setting
		setTitle("Heisenburger");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(950, 720);
		setVisible(true);

		
	}
	
	public static void main(String[] args) {
		Menuas frame = new Menuas();
	}
}
