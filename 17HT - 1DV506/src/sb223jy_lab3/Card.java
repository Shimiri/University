package sb223jy_lab3;

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getColor() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String toString() {
        return suit + " " + rank;
    }
}

