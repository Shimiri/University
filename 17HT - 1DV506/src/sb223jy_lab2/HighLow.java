package sb223jy_lab2;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class HighLow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = (int) (Math.random() * 100) + 1;
        System.out.println("N = " + n);

        int guess = -1;
        int i = 0;

        while (guess != n) {
            System.out.print("Gissning " + (++i) + ": ");
            guess = scanner.nextInt();

            if (guess < n)
                System.out.println("Ledtråd: Högre");
            else if (guess > n)
                System.out.println("Ledtråd: Lägre");
        }

        System.out.println("Rätt svar efter bara " + i + " gissningar - Strålande!");

        scanner.close();
    }
}
