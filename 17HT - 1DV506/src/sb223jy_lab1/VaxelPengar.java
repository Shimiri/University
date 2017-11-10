package sb223jy_lab1;

import java.util.Scanner;

public class VaxelPengar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange kostanaden: ");
        double cost = scanner.nextDouble();

        System.out.print("Ange erhållet belopp: ");
        double value = scanner.nextInt();

        int change = (int) Math.round(value - cost);

        if (change < 0)
            return;

        System.out.println("Tillbaka: " + change);

        //1000-lappar
        System.out.println("1000-lappar: " + (change / 1000));

        //500-lappar
        int fiveHundredBill = (change / 100) % 10;
        if (fiveHundredBill >= 5)
            System.out.println("500-lappar: 1");
        else
            System.out.println("500-lappar: 0");

        //100-lappar
        int oneHundredBill = (change / 100) % 10;
        if (fiveHundredBill >= 5)
            oneHundredBill -= 5;

        if (oneHundredBill < 5)
            System.out.println("100-lappar: " + oneHundredBill);
        else
            System.out.println("100-lappar: 0");

        //50-lappar
        int fiftyBill = (change / 10) % 10;
        if (fiftyBill >= 5)
            System.out.println("50-lappar: 1");
        else
            System.out.println("50-lappar: 0");

        //20-lappar
        int twentyBill = (change / 10) % 10;
        if (fiftyBill >= 5)
            twentyBill -= 5;

        if (twentyBill == 4)
            System.out.println("20-lappar: 2");
        else if (twentyBill == 3 || twentyBill == 2)
            System.out.println("20-lappar: 1");
        else
            System.out.println("20-lappar: 0");

        //10-kronor
        int tenCoins = (change / 10) % 10;
        if (fiftyBill >= 5)
            tenCoins -= 5;
        if (twentyBill == 4)
            tenCoins -= 4;
        else if (twentyBill == 3 || twentyBill == 2)
            tenCoins -= 2;

        System.out.println("10-kronor: " + tenCoins);

        //5-kronor
        int fiveCoins = change % 10;
        if (fiveCoins >= 5)
            System.out.println("5-kronor: 1");
        else
            System.out.println("5-kronor: 0");

        //1-kronor
        int oneCoins = change % 10;
        if (fiveCoins >= 5)
            oneCoins -= 5;

        if (oneCoins < 5)
            System.out.println("1-kronor: " + oneCoins);
        else
            System.out.println("1-kronor: 0");

        scanner.close();
    }
}
