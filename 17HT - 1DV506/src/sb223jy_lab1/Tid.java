package sb223jy_lab1;

import java.util.Scanner;

public class Tid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange antal sekunder: ");
        int time = scanner.nextInt();

        int hours = (time / 3600);
        int minutes = ((time - (hours * 3600)) / 60);
        int seconds = (time - ((hours * 3600) + (minutes * 60)));

        System.out.println("Detta motsvarar: " + hours + " Timmar, " + minutes + " Minuter, " + seconds + " Sekunder");

        scanner.close();
    }
}
