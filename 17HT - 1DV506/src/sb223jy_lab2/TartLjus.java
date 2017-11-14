package sb223jy_lab2;

public class TartLjus {
    public static void main(String[] args) {
        final int CANDLE_BOX = 24;

        int numOfBoxes;
        int usedCandles = 0;
        int remainingCandles = 0;
        int totalNumOfBoxes = 1;

        for (int age = 1; age <= 100; age++) {
            numOfBoxes = 0;
            usedCandles += age;

            while (usedCandles > CANDLE_BOX) {
                numOfBoxes++;
                usedCandles = usedCandles - CANDLE_BOX;
            }

            if (numOfBoxes > 0)
                System.out.println("Before birthday " + age + ", buy " + numOfBoxes + " box(es)");

            totalNumOfBoxes += numOfBoxes;
            remainingCandles = CANDLE_BOX - usedCandles;
        }

        System.out.println("\nTotal number of boxes: " + totalNumOfBoxes + ", Remaining candles: " + remainingCandles);
    }
}
