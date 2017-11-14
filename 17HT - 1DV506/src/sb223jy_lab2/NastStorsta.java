package sb223jy_lab2;

import java.util.Scanner;

public class NastStorsta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = 0;
        int second = 0;

        for (int i = 0; i < 10; i++) {
            int userNum = scanner.nextInt();

            if (userNum > first)
                first = userNum;
            else if (userNum > second)
                second = userNum;
        }

        System.out.println("Det näst största talet är: " + second);

        scanner.close();
    }
}
