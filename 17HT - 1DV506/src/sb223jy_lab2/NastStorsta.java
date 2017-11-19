package sb223jy_lab2;

import java.util.Scanner;

public class NastStorsta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bestäm hur många tal som ska jämföras genom att mata in ett positivt heltal: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        if (n <= 0) {
            System.out.println("Bara positiva heltal är tillåtna.");
            return;
        }

        System.out.print("Mata in " + n + " heltal avgränsade med ett mellanrum: ");
        String userNumStr = scanner.nextLine();

        int largest = Integer.MIN_VALUE;
        int secondLargest = 0;

        for (int i = 0, j = 0; i < n; i++, j++) {

            StringBuilder sb = new StringBuilder();

            while (userNumStr.charAt(j) != ' ') {
                sb.append(userNumStr.charAt(j));
                j++;

                if (j == userNumStr.length())
                    break;
            }

            int userNum = Integer.parseInt(sb.toString());

            if (userNum > largest) {
                secondLargest = largest;
                largest = userNum;
            }
        }

        System.out.println("Det näst största talet är: " + secondLargest);

        scanner.close();
    }
}
