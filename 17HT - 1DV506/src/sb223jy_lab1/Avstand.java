package sb223jy_lab1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Avstand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Skriv in koordinat x1: ");
        int x1 = scanner.nextInt();

        System.out.print("Skriv in koordinat y1: ");
        int y1 = scanner.nextInt();

        System.out.print("Skriv in koordinat x2: ");
        int x2 = scanner.nextInt();

        System.out.print("Skriv in koordinat y2: ");
        int y2 = scanner.nextInt();

        double dist = Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));

        DecimalFormat dFormat = new DecimalFormat("#.###");
        String distance = dFormat.format(dist);

        System.out.format("Avståndet mellan (" + x1 + "," + y1 + ") och (" + x2 + "," + y2 + ") = " + distance);

        scanner.close();
    }
}
