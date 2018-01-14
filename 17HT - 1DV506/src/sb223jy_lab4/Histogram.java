package sb223jy_lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        File textFile = new File(args[0]);
        System.out.println("Läser text från filen: " + args[0]);
        ArrayList<Integer> numbers = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(textFile);
            while (scanner.hasNext()) {
                numbers.add(Integer.parseInt(scanner.nextLine()));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int validNumCounter = 0;
        for (Integer number : numbers) {
            if (number >= 1 && number <= 100) {
                validNumCounter++;
            }
        }

        System.out.println("Antal i intervallet [1, 100]: " + validNumCounter
                            + "\nÖvriga: " + (numbers.size() - validNumCounter));

        System.out.print("Histogram: ");
        System.out.print("\n  1 - 10 | ");
        for (int n : numbers) {
            if (n >= 1 && n <= 10)
                System.out.print("*");
        }

        System.out.print("\n  11 - 20 | ");
        for (int n : numbers) {
            if (n >= 11 && n <= 20)
                System.out.print("*");
        }


        System.out.print("\n  21 - 30 | ");
        for (int n : numbers) {
            if (n >= 21 && n <= 30)
                System.out.print("*");
        }


        System.out.print("\n  31 - 40 | ");
        for (int n : numbers) {
            if (n >= 31 && n <= 40)
                System.out.print("*");
        }


        System.out.print("\n  41 - 50 | ");
        for (int n : numbers) {
            if (n >= 41 && n <= 50)
                System.out.print("*");
        }


        System.out.print("\n  51 - 60 | ");
        for (int n : numbers) {
            if (n >= 51 && n <= 60)
                System.out.print("*");
        }

        System.out.print("\n  61 - 70 | ");
        for (int n : numbers) {
            if (n >= 61 && n <= 70)
                System.out.print("*");
        }


        System.out.print("\n  71 - 80 | ");
        for (int n : numbers) {
            if (n >= 71 && n <= 80)
                System.out.print("*");
        }

        System.out.print("\n  81 - 90 | ");
        for (int n : numbers) {
            if (n >= 81 && n <= 90)
                System.out.print("*");
        }

        System.out.print("\n  91 - 100 | ");
        for (int n : numbers) {
            if (n >= 91 && n <= 100)
                System.out.print("*");
        }
    }
}
