package sb223jy_lab2;

import java.util.Scanner;

public class RaknaA {
    public static void main(String[] args) {
        int numOfa = 0;
        int numOfA = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Mata in en textrad: ");
        String text = scanner.nextLine();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'a')
                numOfa++;
            if (text.charAt(i) == 'A')
                numOfA++;
        }

        System.out.println("Antal 'a': " + numOfa + "\nAntal 'A': " + numOfA);

        scanner.close();
    }
}
