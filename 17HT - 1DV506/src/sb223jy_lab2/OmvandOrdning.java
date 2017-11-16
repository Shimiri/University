package sb223jy_lab2;


import java.util.ArrayList;
import java.util.Scanner;

public class OmvandOrdning {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();

        int i = -1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Mata in positiva heltal. Avsluta med ett negativt.");

        do {
            System.out.print("Tal " + (i + 2) + ": ");
            integers.add(scanner.nextInt());
            i++;
        } while (integers.get(i) > 0);

        System.out.println("Antal positiva: " + i + "\nBaklänges: ");
        for (int j = integers.size() - 2; j >= 0; j--) {
            if (j == 0)
                System.out.print(integers.get(j));
            else
                System.out.print(integers.get(j) + ", ");
        }

        scanner.close();
    }
}
