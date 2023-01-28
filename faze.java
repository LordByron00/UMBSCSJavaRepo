import java.util.Scanner;
import java.util.Arrays;
public class faze{

	public static void main(String[] args) {
		Scanner mn = new Scanner(System.in);
		Boolean loop=true;
		int arn=0;
		do{
		System.out.println("Main Menu Selection: \n[1]Calculation \n[2]Loop \n[3]Array");
		String mu=mn.nextLine();
		int nmu=Integer.parseInt(mu);
		String art="";
		switch(nmu){
		case 1:
			System.out.println();
			System.out.println("[Calculation] \n \nArea of a Triangle \nPlease input your height");
			int h=mn.nextInt();
			System.out.println("Please input your base");
			int b=mn.nextInt();
			double a=h*b/2;
			System.out.printf("%5.1f ",a);
			loop=false;
			break;
		case 2:
			System.out.println("[Loop] \n*Stars* \nEnter Value of Stars");
			int s=mn.nextInt();
			for(int i=s-1;i>=0;i--){
				for(int j=0;j<=i;j++){
					if(i %2==0){
					System.out.print("*");}}
			System.out.println();
			}
			loop=false;
			break;
		case 3:
			System.out.println("[Array]");
			System.out.println("Please input your values now");
			boolean ar=true;
			while(ar){
				if(mn.hasNextInt()) {
				    arn = mn.nextInt();
				
				String arr=String.valueOf(arn);
				art+=" ";
				art+=arr;
				}
				else{ar=false;}
			}
			String[] alt=art.split(" ");
			String[] prox = new String[alt.length-1];
			
			 for (int i = 0;i<=prox.length-1; i++){
				 prox[i]=alt[i+1];
			 }
			 System.out.println(Arrays.toString(prox));
			loop=false;
			break;
		default:
			System.out.println("invalid input try again");
			System.out.println();
		}
		}while(loop);
		System.out.println("Thanks for using");
		}
	}