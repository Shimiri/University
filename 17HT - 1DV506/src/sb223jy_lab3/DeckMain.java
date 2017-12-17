package sb223jy_lab3;

public class DeckMain {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffleDeck();

        for (int i = 0; i < 10; i++) {
            System.out.println(deck.dealCard().toString());
        }
        System.out.println("Number of cards in deck: " + deck.getNumOfCards());
    }
}
