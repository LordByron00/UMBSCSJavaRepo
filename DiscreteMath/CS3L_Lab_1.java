package DiscreteMath;
import java.util.Scanner;
public class CS3L_Lab_1 {
    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            int prev = 1;
            int current = 1;
            for (int i = 3; i <= n; i++) {
                int nextFibonacci = prev + current;
                prev = current;
                current = nextFibonacci;
            }
            return current;
        }
    }

    public static double harmonic_Series(double n) {
        double sum = 0.0;

        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }
    public static int calculateSum(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + calculateSum(n - 1);
        }
    }

    public static int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return calculateGCD(b, a % b);
        }
    }

    public static void HailstoneSequence(int n) {
        while (n != 1) {
            System.out.print(n + " ");

            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
        }

        System.out.print(n);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nFibonacci: ");
        int n = scanner.nextInt();
        int result = fibonacci(n);
        System.out.println("The " + n + "th Fibonacci number is: " + result);

        System.out.print("\nHarmonic series: ");
        int terms = scanner.nextInt();
        double sum = harmonic_Series(terms);
        System.out.println("The sum of the harmonic series with " + terms + " terms is: " + sum);

        System.out.print("\nEnter a positive integer n: ");
        int n2 = scanner.nextInt();
        int sumOfN = calculateSum(n2);
        System.out.println("The sum of numbers from 1 to " + n + " is: " + sumOfN);

        System.out.println("\nGreatest Common Divisor (GCD):");
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();
        int gcd = calculateGCD(num1, num2);
        System.out.println("The GCD of " + num1 + " and " + num2 + " is: " + gcd);

        System.out.print("\nHailstone sequence: ");
        int n3 = scanner.nextInt();
        System.out.println("Hailstone Sequence for " + n3 + ":");
        HailstoneSequence(n3);

    }
}