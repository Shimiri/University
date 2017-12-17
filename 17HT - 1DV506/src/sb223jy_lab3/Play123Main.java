package sb223jy_lab3;

public class Play123Main {
    private static int turn = -1;

    public static void main(String[] args) {
        int numOfDefeats = 0;
        Deck deck = new Deck();
        deck.shuffleDeck();

        for (int i = 0; i < 10000; i++) {
            if (play123(deck.dealCard()))
                numOfDefeats++;
        }

        double propabilityOfLosing = (double) numOfDefeats / 10000;
        System.out.println(propabilityOfLosing * 100 + " %");
    }

    private static boolean play123(Card card) {
        if (turn == 2)
            turn = 0;
        else
            turn++;
        return card.getRank().ordinal() == turn;
    }
}
