package sb223jy_lab2;

import java.util.Scanner;

public class HighLow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = (int) (Math.random() * 100) + 1;

        int guess = -1;
        int numOfguesses = 0;
        int i = 0;

        while (guess != n) {
            System.out.print("Gissning " + (++i) + ": ");
            guess = scanner.nextInt();

            if (++numOfguesses == 10) {
                System.out.println("Maximalt antal gissningar. Försök igen!");
                return;
            }

            if (guess < n)
                System.out.println("Ledtråd: Högre");
            else if (guess > n)
                System.out.println("Ledtråd: Lägre");
        }

        System.out.println("Rätt svar efter bara " + i + " gissningar - Strålande!");

        scanner.close();
    }
}
