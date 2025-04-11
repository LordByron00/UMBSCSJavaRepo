package CCEFinalProject;


import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

public class Ordered implements Serializable {
	private static ArrayList<burgers> OrderedBurgers;

	Ordered(burgers burger) {
		OrderedBurgers = new ArrayList<burgers>();
		OrderedBurgers.add(burger);
		 for (burgers p : OrderedBurgers) {
	            System.out.println(p.getName() + " is " + p.getPrice() + " years old");
	            System.out.println(OrderedBurgers.toString());
	        }
	}

	 public void remover(String burgerName) {
//		 String name1 = name;
		 for (burgers p : OrderedBurgers) {
			 if (p.getName().equals(burgerName)) {
				 OrderedBurgers.remove(p);
	            }
			 System.out.println(OrderedBurgers.toString());
	        }
	 }
	 public static void main(String[] args) {

	 }

}
