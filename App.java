public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("*********ASTERISK***********");
        int i, j, max = 10;

        for(i=0; i <= max; i++) { //0 < 1                                       0 + 1 = 1   1 <= 10
            for(j=0; j <= i; j++) { // 0 <= 0               0+1 = 1  1 <= i(0)                      j(1) <= i(1) = 
                System.out.print("\t * "); // execute
            }
            System.out.println();
        }
        for(i = max-1; i >= 0; i--) {
            for(j = 0; j <= i-1; j++) {
                System.out.print("\t * ");
            }
            System.out.println();
            
        }
    }
}
