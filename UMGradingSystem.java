import java.util.Scanner;
public class UMGradingSystem {
    public static double initialgrade, totalscore, grade; 
    public static void main(String[] args) {
        Scanner initialgrade1 = new Scanner(System.in);
        System.out.println("Enter Score:");
        
        //MAKE INITIAL GRADE AS YOUR INPUT
        initialgrade = initialgrade1.nextDouble();
        System.out.println("Enter Total Score:");
        totalscore = initialgrade1.nextDouble();
        grade = ((initialgrade/totalscore) * 85) + 15;
        if(grade > 75) {
            System.out.println("You have passsed the exam:"+grade);
        } else {
            System.out.println("You have failed the exam:"+grade);
        }
    }
}