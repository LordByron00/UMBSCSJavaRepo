package AlgoComp;

//Algorithm Running Time

import java.util. *;
import java.util.Random;

public class Test {
    private long start = 0;


    public Test() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
    private static long constant_value(long parameter) {
        long l = 0L;
        for (int i = 0; i < parameter; i++)
            l += 1L;
        return l;
    }

    private static long logarithmic(long parameter1, long parameter2) {
        long l = 0L;
        for (int i = 1; i + i <= parameter1; i += i)
            l += constant_value(parameter2);
        return l;
    }
    private static long sqrt(long parameter1, long parameter2) {
        long l = 0L;
        int i = 0; for (int j = 0; j < parameter1; i++) {
            l += constant_value(parameter2);j += i;
        }
        return l;
    }

    public static long linearithmic(long parameter1, long parameter2) {
        if (parameter1 == 0) return 0L;
        long l = 0L;
        for (int i = 0; i < parameter1; i++)
            l += constant_value(parameter2);
        return linearithmic(parameter1 / 2, parameter2) + l + linearithmic(parameter1 / 2, parameter2);
    }
    private static long linear(long parameter1, long parameter2) {
        long l = 0L;
        for (int i = 0; i < parameter1; i++)
            l += constant_value(parameter2);
        return l;
    }
    private static long linearsqrt(long parameter1, long parameter2) {
        long l = 0L;
        for (int i = 0; i < parameter1; i++) {
            l += sqrt(parameter1, parameter2);
        }
        return l;
    }
    private static long quadratic(long parameter1, long parameter2) {
        long l = 0L;
        for (int i = 0; i < parameter1; i++)
            for (int j = 0; j < parameter1; j++)
                l += constant_value(parameter2);
        return l;
    }

    private static long exponential(long parameter1, long parameter2) {
        if (parameter1 == 0) return constant_value(parameter2);
        return exponential(parameter1 - 1, parameter2) + exponential(parameter1 - 1, parameter2);
    }

    private static long factorial(long parameter1, long parameter2) {
        if (parameter1 == 0) return constant_value(parameter2);
        long l = 0L;
        for (int i = 0; i < parameter1; i++)
            l += factorial(parameter1 - 1, parameter2);
        return l;
    }
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        long n1;
        long n2;
        long x;
        int y;

        Random randomno = new Random();
        randomno.setSeed(777280);

        System.out.println("Factorial");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter value for Parameter 1: ");
            n1 = input.nextInt();
            System.out.print("Enter value for Parameter 2: ");
            n2 = input.nextInt();

            Test timeStart = new Test();
            x = factorial(n1, n2);
            double timer1 = timeStart.elapsedTime();
            System.out.print("Value:  "+ x );
            System.out. println("\tTime Elapsed: " + timer1);
        }

        System.out.println("Constant Value");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter value for Parameter 1: ");
            n1 = input.nextInt();

            Test timeStart = new Test();
            x = constant_value(n1);
            double timer1 = timeStart.elapsedTime();
            System.out.print("Value:  "+ x );
            System.out. println("\tTime Elapsed: " + timer1);
        }

        System.out.println("Logarithmic");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter value for Parameter 1: ");
            n1 = input.nextInt();
            System.out.print("Enter value for Parameter 2: ");
            n2 = input.nextInt();

            Test timeStart = new Test();
            x = logarithmic(n1, n2);
            double timer1 = timeStart.elapsedTime();
            System.out.print("Value:  "+ x );
            System.out. println("\tTime Elapsed: " + timer1);
        }

        System.out.println("Square Root");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter value for Parameter 1: ");
            n1 = input.nextInt();
            System.out.print("Enter value for Parameter 2: ");
            n2 = input.nextInt();

            Test timeStart = new Test();
            x = sqrt(n1, n2);
            double timer1 = timeStart.elapsedTime();
            System.out.print("Value:  "+ x );
            System.out. println("\tTime Elapsed: " + timer1);
        }

        System.out.println("Linearithmic");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter value for Parameter 1: ");
            n1 = input.nextInt();
            System.out.print("Enter value for Parameter 2: ");
            n2 = input.nextInt();

            Test timeStart = new Test();
            x = linearithmic(n1, n2);
            double timer1 = timeStart.elapsedTime();
            System.out.print("Value:  "+ x );
            System.out. println("\tTime Elapsed: " + timer1);
        }

        System.out.println("Linear");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter value for Parameter 1: ");
            n1 = input.nextInt();
            System.out.print("Enter value for Parameter 2: ");
            n2 = input.nextInt();

            Test timeStart = new Test();
            x = linear(n1, n2);
            double timer1 = timeStart.elapsedTime();
            System.out.print("Value:  "+ x );
            System.out. println("\tTime Elapsed: " + timer1);
        }

        System.out.println("Linear Square Root");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter value for Parameter 1: ");
            n1 = input.nextInt();
            System.out.print("Enter value for Parameter 2: ");
            n2 = input.nextInt();

            Test timeStart = new Test();
            x = linearsqrt(n1, n2);
            double timer1 = timeStart.elapsedTime();
            System.out.print("Value:  "+ x );
            System.out. println("\tTime Elapsed: " + timer1);
        }

        System.out.println("Quadratic");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter value for Parameter 1: ");
            n1 = input.nextInt();
            System.out.print("Enter value for Parameter 2: ");
            n2 = input.nextInt();

            Test timeStart = new Test();
            x = quadratic(n1, n2);
            double timer1 = timeStart.elapsedTime();
            System.out.print("Value:  "+ x );
            System.out. println("\tTime Elapsed: " + timer1);
        }

        System.out.println("Exponential");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter value for Parameter 1: ");
            n1 = input.nextInt();
            System.out.print("Enter value for Parameter 2: ");
            n2 = input.nextInt();

            Test timeStart = new Test();
            x = exponential(n1, n2);
            double timer1 = timeStart.elapsedTime();
            System.out.print("Value:  "+ x );
            System.out. println("\tTime Elapsed: " + timer1);
        }
    }

}
