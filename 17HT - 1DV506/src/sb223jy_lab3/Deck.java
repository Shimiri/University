package sb223jy_lab3;

import java.util.Random;

public class Deck {
    private Card[] deck;
    private int numOfCards;
    private Random random;

    public Deck() {
        deck = new Card[52];
        numOfCards = 52;
        random = new Random();

        for (int i = 0, k = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++, k++) {
                deck[k] = new Card(Suit.getSuit(j), Rank.getRank(i));
            }
        }
    }

    public void shuffleDeck() {
        if (numOfCards == 52) {
            for (int i = 0; i < 10000; i++)
                swapCards(random.nextInt(52), random.nextInt(52));
        } else {
            System.out.println("Can only shuffle deck if there are 52 cards.");
        }
    }

    private void swapCards(int a, int b) {
        Card cardA = deck[a];
        deck[a] = deck[b];
        deck[b] = cardA;
    }

    public Card dealCard() {
        Card card = deck[random.nextInt(52)];
        numOfCards--;
        return card;
    }

    public int getNumOfCards() {
        return numOfCards;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : deck)
            sb.append(card.toString()).append("\n");
        return sb.toString();
    }
}
