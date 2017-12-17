package sb223jy_lab3;

public enum Rank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    public static Rank getRank(int code) {
        switch (code) {
            case 0:
                return ACE;
            case 1:
                return TWO;
            case 2:
                return THREE;
            case 3:
                return FOUR;
            case 4:
                return FIVE;
            case 5:
                return SIX;
            case 6:
                return SEVEN;
            case 7:
                return EIGHT;
            case 8:
                return NINE;
            case 9:
                return TEN;
            case 10:
                return JACK;
            case 11:
                return QUEEN;
            case 12:
                return KING;
            default:
                return null;
        }
    }
}
