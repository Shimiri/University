package sb223jy_lab2;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Mata in ett udda heltal: ");
        int n = scanner.nextInt();

        if (n % 2 != 1) {
            System.out.println("Bara udda heltal är tillåtna.");
            return;
        }

        System.out.println("\nRätvinklig triangel:");
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < (n - 1)) {
                System.out.print(" ");
                j++;
            }

            j = 0;
            while (j <= i) {
                System.out.print("*");
                j++;
            }

            System.out.println();
        }

        n = n / 2;
        System.out.println("\nLikbent triangel:");
        for (int i = 0, j = n; i <= n; i++, j--) {
            int k = 0;
            while (k < j) {
                System.out.print(" ");
                k++;
            }

            k = 0;
            while (k < (i * 2) + 1) {
                System.out.print("*");
                k++;
            }

            System.out.println();
        }

        scanner.close();
    }
}
