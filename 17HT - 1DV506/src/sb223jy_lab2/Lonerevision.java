package sb223jy_lab2;

import java.util.ArrayList;
import java.util.Scanner;

public class Lonerevision {
    public static void main(String[] args) {
        ArrayList<Integer> salaries = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mata in löner, avsluta med 'X': ");

        int numOfEntries = 0;
        while (scanner.hasNextInt()) {
            salaries.add(scanner.nextInt());
            numOfEntries++;
        }

        salaries.sort(null);

        int difference = salaries.get(numOfEntries - 1) - salaries.get(0);

        int medianSalary;
        if (numOfEntries % 2 == 0)
            medianSalary = (salaries.get((numOfEntries / 2) - 1) + salaries.get(numOfEntries / 2)) / 2;
        else
            medianSalary = salaries.get((numOfEntries / 2));

        int totalAmount = 0;
        for (int salary : salaries)
            totalAmount += salary;

        int averageSalary = totalAmount / numOfEntries;

        System.out.println("Medianlön: " + medianSalary + "\nMedellön: " + averageSalary +
                "\nLönespridning: " + difference);

        scanner.close();
    }
}
