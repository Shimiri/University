package sb223jy_lab2;

import java.util.Scanner;

public class RaknaSiffror {
    public static void main(String[] args) {
        int odd = 0, even = 0, zero = 0;

        System.out.print("Mata in ett heltal: ");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String strNum = String.valueOf(n);

        for (int i = 0; i < strNum.length(); i++) {
            int j = Character.getNumericValue(strNum.charAt(i));

            if (j == 0)
                zero++;
            else if (j % 2 == 0)
                even++;
            else
                odd++;
        }

        System.out.println("Nollor: " + zero + "\nUdda: " + odd + "\nJämna: " + even);

        scanner.close();
    }
}
