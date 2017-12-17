package sb223jy_lab3;

public enum Suit {
    DIAMONDS, HEART, SPADES, CLUBS;

    public static Suit getSuit(int code) {
        switch (code) {
            case 0:
                return DIAMONDS;
            case 1:
                return HEART;
            case 2:
                return SPADES;
            case 3:
                return CLUBS;
            default:
                return null;
        }
    }
}
