package sb223jy_lab1;

import java.util.Scanner;

public class KortNamn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Skriv in ditt förnamn: ");
        String name = scanner.nextLine();

        if (name.length() == 0)
            return;

        System.out.print("Skriv in ditt efternamn: ");
        String surname = scanner.nextLine();

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < surname.length() && i < 4) {
            sb.append(surname.charAt(i));
            i++;
        }


        System.out.println(String.valueOf(name.charAt(0)).toUpperCase() + ". " + sb.toString());

        scanner.close();
    }
}
