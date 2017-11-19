package sb223jy_lab2;

public class Frekvenstabell {
    public static void main(String[] args) {
        final int DICE_ROLLS = 6000;
        int[] diceResults = new int[6];

        for (int i = 0; i < DICE_ROLLS; i++) {
            int dice = (int) (Math.random() * 6 + 1);
            switch (dice) {
                case 1:
                    diceResults[0]++; break;
                case 2:
                    diceResults[1]++; break;
                case 3:
                    diceResults[2]++; break;
                case 4:
                    diceResults[3]++; break;
                case 5:
                    diceResults[4]++; break;
                case 6:
                    diceResults[5]++; break;
                default:
                    break;
            }
        }

        System.out.println("Frequencies when rolling a dice 6000 times.");

        for (int i = 0; i < 6; i++) {
            System.out.println((i + 1) + ": " + diceResults[i]);
        }
    }
}
