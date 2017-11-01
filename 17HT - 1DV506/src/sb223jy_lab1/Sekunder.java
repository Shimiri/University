package sb223jy_lab1;

import java.util.Scanner;

public class Sekunder {
    public static void main(String[] args) {
        int tid[] = new int[3];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv in 3 heltal (timmar, minuter, sekunder): ");

        for (int i = 0; i < 3; i++) {
            tid[i] = scanner.nextInt();
        }

        System.out.println("Timmar: " + tid[0]);
        System.out.println("Minuter: " + tid[1]);
        System.out.println("Sekunder: " + tid[2] + "\n");

        System.out.println("Totala antal sekunder: " + ((tid[0] * 3600) + (tid[1] * 60) + (tid[2])));

        scanner.close();
    }
}
