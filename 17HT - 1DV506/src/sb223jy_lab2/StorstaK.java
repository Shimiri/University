package sb223jy_lab2;

import java.util.Scanner;

public class StorstaK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Mata in ett positivt heltal: ");
        int n = scanner.nextInt();
        int k = 0;
        int i = 0;

        if(n <= 0) {
            System.out.println("Bara positiva heltal är tillåtna.");
            return;
        }

        while (k < n) {
            i++;
            k += i * 2;
        }

        System.out.println("Största tal K sådant att 0+2+4+6+...+K < " + n + ": " + (i - 1) * 2);

        scanner.close();
    }
}
