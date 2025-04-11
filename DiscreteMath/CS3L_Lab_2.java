package DiscreteMath;

import java.text.DecimalFormat;
import java.util.Scanner;
public class CS3L_Lab_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the raw score: ");
        double rawScore = scanner.nextDouble();

        double mean = 0.0;
        double stdDeviation = 1.0;
        double zScore = (rawScore - mean) / stdDeviation;

        double areaUnderCurve = calculateAreaUnderCurve(zScore) * 100;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String roundedArea = decimalFormat.format(areaUnderCurve);

        System.out.println("Z-score: " + zScore);
        System.out.println("Area under the curve: " + roundedArea + "%");

    }


    private static double calculateAreaUnderCurve(double zScore) {

        if (zScore < -8.0) {
            return 0.0;
        } else if (zScore > 8.0) {
            return 1.0;
        } else {
            double integral = 0.5 * (1.0 + erf(zScore / Math.sqrt(2.0)));
            return Math.min(Math.max(integral, 0.0), 1.0);
        }
    }
    private static double erf(double x) {
        double t = 1.0 / (1.0 + 0.5 * Math.abs(x));

        double tau = t * Math.exp(-x * x - 1.26551223 +
                1.00002368 * t +
                0.37409196 * t * t +
                0.09678418 * t * t * t -
                0.18628806 * t * t * t * t +
                0.27886807 * t * t * t * t * t -
                1.13520398 * t * t * t * t * t * t +
                1.48851587 * t * t * t * t * t * t * t -
                0.82215223 * t * t * t * t * t * t * t * t +
                0.17087277 * t * t * t * t * t * t * t * t * t);

        return x >= 0 ? 1.0 - tau : tau - 1.0;
    }
}


