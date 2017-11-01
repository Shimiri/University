package sb223jy_lab1;

import java.util.Scanner;

public class Citat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Skriv in en rad text: ");
        String text = scanner.nextLine();

        System.out.println("\nCitat: \"" + text + "\"");

        scanner.close();
    }
}
