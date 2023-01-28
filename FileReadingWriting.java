package filereadingwriting;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class FileReadingWriting {
public static void main(String[] args) {
		String menu[] = {"Add Data","View Data","Exit"};
		String name = "", diagnosis = "", treatment = "", labtest="",option="";
		int age = 0, payment = 0;
		try{
			FileWriter wr = new FileWriter(new File("Patient Report.txt"), true);
			do{
		option = JOptionPane.showInputDialog(null,"Select","Menu",2,null,menu,menu[0]).toString();
		switch(option){
		case "Add Data":
		
		name = JOptionPane.showInputDialog("Enter your name: ");
		wr.write("\n" + name);
		age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age: "));
		wr.write("\t" + age);
		diagnosis = JOptionPane.showInputDialog("Enter diagnosis: ");
		wr.write("\t" + diagnosis);
		treatment = JOptionPane.showInputDialog("Enter treatment: ");
		wr.write("\t" + treatment);
		labtest = JOptionPane.showInputDialog("Enter labtest: ");
		wr.write("\t" + labtest);

		if(treatment.equalsIgnoreCase("cobalt")){
			payment = 25000;
			wr.write("\t" + "\t" + payment);
		}else if(treatment.equalsIgnoreCase("chemotherapy")){
			payment = 20000;
			wr.write("\t" + "\t" + payment);
		}else if(treatment.equalsIgnoreCase("Open Surgery")){
			payment = 50000;
			wr.write("\t" + "\t" + payment);
		}else if(treatment.equalsIgnoreCase("laser")){
			payment = 30000;
			wr.write("\t" + "\t" + payment);
		}else if(treatment.equalsIgnoreCase("shock wave")){
			payment = 50000;
			wr.write("\t" + "\t" + payment);
		}else if(treatment.equalsIgnoreCase("oral medicine")){
			payment = 5000;
			wr.write("\t" + "\t" + payment);
		}
			
			
	
		
		
		
		wr.flush();
		wr.close();
		
		break;
		case"View Data":
			view();
			break;
		
		}
			}while(!option.equals("Exit"));
		}catch(IOException ex){
			JOptionPane.showMessageDialog(null, "Error");
		
		}		
		
	}

	private static void view() {
		FileReader fr;
		Scanner sc;
		fr = null;
		sc = null;
		File file = new File("Patient Report.txt");
		String all = " ";
		try {
			fr = new FileReader("Patient Report.txt");
			sc = new Scanner(file);
			while(sc.hasNext()){
				all += sc.nextLine()+"\n";
			}
			JOptionPane.showMessageDialog(null,new JTextArea("Name" + "\t" + "Age" + "\t" + "Diagnosis" + "\t" + "Treatment" + "\t" + "LabTest Conducted" + "\t" + "Payment" + "\t" + all + "\n"));
			sc.close();
		}catch(IOException ex){
			
		}
		
	}
}
