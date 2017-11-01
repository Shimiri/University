package sb223jy_lab1;

import java.util.Scanner;

public class SummaAvTre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange ett tre-siffrigt heltal: ");
        int n = scanner.nextInt();

        int a = n / 100;
        int b = (n / 10) % 10;
        int c = n % 10;

        System.out.println("Summan av siffrorna i heltalet är: " + (a + b + c));
    }
}
