package AlgoComp;

//Function Growth
import java.util.Scanner;

public class FunctionGrowth {

    private long start = 0;


    public FunctionGrowth() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
    private static long constant_value(long paramInt) {
        long l = 0L;
        for (int i = 0; i < paramInt; i++)
            l += 1L;
        return l;
    }

    private static long logarithmic(long paramInt1, long paramInt2) {
        long l = 0L;
        for (int i = 1; i + i <= paramInt1; i += i)
            l += constant_value(paramInt2);
        return l;
    }
    private static long sqrt(long paramInt1, long paramInt2) {
        long l = 0L;
        int i = 0; for (int j = 0; j < paramInt1; i++) {
            l += constant_value(paramInt2);j += i;
        }
        return l;
    }

    public static long linearithmic(long paramInt1, long paramInt2) {
        if (paramInt1 == 0) return 0L;
        long l = 0L;
        for (int i = 0; i < paramInt1; i++)
            l += constant_value(paramInt2);
        return linearithmic(paramInt1 / 2, paramInt2) + l + linearithmic(paramInt1 / 2, paramInt2);
    }
    private static long linear(long paramInt1, long paramInt2) {
        long l = 0L;
        for (int i = 0; i < paramInt1; i++)
            l += constant_value(paramInt2);
        return l;
    }
    private static long linearsqrt(long paramInt1, long paramInt2) {
        long l = 0L;
        for (int i = 0; i < paramInt1; i++) {
            l += sqrt(paramInt1, paramInt2);
        }
        return l;
    }
    private static long quadratic(long paramInt1, long paramInt2) {
        long l = 0L;
        for (int i = 0; i < paramInt1; i++)
            for (int j = 0; j < paramInt1; j++)
                l += constant_value(paramInt2);
        return l;
    }

    private static long exponential(long paramInt1, long paramInt2) {
        if (paramInt1 == 0) return constant_value(paramInt2);
        return exponential(paramInt1 - 1, paramInt2) + exponential(paramInt1 - 1, paramInt2);
    }

    private static long factorial(long paramInt1, long paramInt2) {
        if (paramInt1 == 0) return constant_value(paramInt2);
        long l = 0L;
        for (int i = 0; i < paramInt1; i++)
            l += factorial(paramInt1 - 1, paramInt2);
        return l;
    }

    public static long Order(long N)  {
        long num = 0L;

        int sum = 0;

        for(int i=0; i < N; i++) {
            for(int j = 1; j <= N*N; j=j*2 ) {
                sum++;
            }
        }
        num=sum;
        return num;

    }
    static Scanner input = new Scanner(System.in);



    public static void main(String[] args) {
        long n1;
        long n2;
        long value = 0L;

        System.out.println("CONSTANT");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter parameter: ");
            n1 = input.nextInt();
            value = Order(constant_value(n1));
            System.out.println("Constant Result: " + value);
        }

        System.out.println("Logarithmic");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter parameter 1: ");
            n1 = input.nextInt();
            System.out.print("Enter parameter 2: ");
            n2 = input.nextInt();
            value = Order(logarithmic(n1,n2));
            System.out.println("Logarithmic Result: " +value);
        }

        System.out.println("Square Root");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter parameter 1: ");
            n1 = input.nextInt();
            System.out.print("Enter parameter 2: ");
            n2 = input.nextInt();
            value = Order(sqrt(n1,n2));
            System.out.println("Sqrt Result: " +value);
        }

        System.out.println("Linearithmic");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter parameter 1: ");
            n1 = input.nextInt();
            System.out.print("Enter parameter 2: ");
            n2 = input.nextInt();
            value = Order(linearithmic(n1,n2));
            System.out.println("Linearithmic Result: " +value);
        }

        System.out.println("Linear");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter parameter 1: ");
            n1 = input.nextInt();
            System.out.print("Enter parameter 2: ");
            n2 = input.nextInt();
            value = Order(linear(n1,n2));
            System.out.println("Linear Result: " +value);
        }

        System.out.println("Linear Square Root");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter parameter 1: ");
            n1 = input.nextInt();
            System.out.print("Enter parameter 2: ");
            n2 = input.nextInt();
            value = Order(linearsqrt(n1,n2));
            System.out.println("Linear Sqrt Result: " +value);
        }

        System.out.println("Quadratic");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter parameter 1: ");
            n1 = input.nextInt();
            System.out.print("Enter parameter 2: ");
            n2 = input.nextInt();
            value = Order(quadratic(n1,n2));
            System.out.println("Quadratic Result: " +value);
        }

        System.out.println("Exponential");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter parameter 1: ");
            n1 = input.nextInt();
            System.out.print("Enter parameter 2: ");
            n2 = input.nextInt();
            value = Order(exponential(n1,n2));
            System.out.println("Exponential Result: " +value);
        }

        System.out.println("Factorial");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter parameter 1: ");
            n1 = input.nextInt();
            System.out.print("Enter parameter 2: ");
            n2 = input.nextInt();
            value = Order(factorial(n1,n2));
            System.out.println("Factorial Result: " +value);
        }




    }

}
