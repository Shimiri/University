package sb223jy_lab1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class VindAvkylning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange tempratur (C): ");
        double t = scanner.nextDouble();

        System.out.print("Ange vindhastigheten (m/s): ");
        double v = scanner.nextDouble() * 3.6;

        System.out.println("\nUpplevd tempratur: " + calculateTwc(t, v));

        scanner.close();
    }

    private static double calculateTwc(double t, double v) {
        double twc = 13.12 + 0.6215 * t - 11.37 * Math.pow(v, 0.16) + 0.3965 * t * Math.pow(v, 0.16);

        DecimalFormat dFormat = new DecimalFormat("#.#");
        return Double.parseDouble(dFormat.format(twc));
    }
}
