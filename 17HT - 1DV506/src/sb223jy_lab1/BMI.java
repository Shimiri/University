package sb223jy_lab1;

import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange din langd i meter: ");
        double length = scanner.nextDouble();

        System.out.print("Ange din vikt i kilogram: ");
        double weight = scanner.nextDouble();

        System.out.println("Ditt BMI är: " + Math.round(weight/(length * length)));

        scanner.close();
    }
}
