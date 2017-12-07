package sb223jy_lab3;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int n, int d) {
        this.numerator = n;
        if (d != 0)
            denominator = d;
        else
            System.out.println("Denominator can't be zero.");
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public boolean isNegative() {
        return numerator < 0 ^ denominator < 0;
    }

    public boolean isEqualTo(Fraction f) {
        return denominator == f.getDenominator() && numerator == f.getNumerator();
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    /*
        1. D1 * N2 + D2 * N1 = Numerator
        2. D1 * D2 = Denominator
     */
    public Fraction addition(Fraction f) {
        return new Fraction((denominator * f.numerator) + (denominator * f.denominator), numerator * f.numerator);
    }

    public Fraction subtraction(Fraction f) {
        return this;
    }

    public Fraction division(Fraction f) {
        return this;
    }

    public Fraction multiplication(Fraction f) {
        return this;
    }

}
