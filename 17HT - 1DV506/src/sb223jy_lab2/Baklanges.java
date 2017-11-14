package sb223jy_lab2;

import java.util.Scanner;

public class Baklanges {
    public static void main(String[] args) {
        StringBuilder reversed = new StringBuilder();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Mata in en text rad: ");
        String text = scanner.nextLine();

        for (int i = text.length() - 1; i >= 0; i--) {
            reversed.append(text.charAt(i));
        }

        System.out.println("Baklänges: " + reversed);

        scanner.close();
    }
}
