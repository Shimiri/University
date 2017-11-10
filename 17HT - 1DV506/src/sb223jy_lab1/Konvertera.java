package sb223jy_lab1;

import java.util.Scanner;

public class Konvertera {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ange tempraturen i Fahrenheit: ");

        double fahrenheit = scanner.nextDouble();
        double celsius = ((fahrenheit - 32) * 5) / 9;

        System.out.format(fahrenheit + " Fahrenheit i Celsius är:\n"
            + "%.1f", celsius);

        scanner.close();
    }
}
