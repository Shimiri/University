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

    public Fraction addition(Fraction f) throws DenominatorIsZeroException {
        if (denominator == 0 || f.denominator == 0)
            throw new DenominatorIsZeroException("Denominator can't be zero.");

        int newNum = denominator * f.numerator + f.denominator * numerator;
        int newDem = denominator * f.denominator;

        return new Fraction(newNum, newDem);
    }

    public Fraction subtraction(Fraction f) throws DenominatorIsZeroException {
        if (denominator == 0 || f.denominator == 0)
            throw new DenominatorIsZeroException("Denominator can't be zero.");

        int newNum = f.denominator * numerator - denominator * f.numerator;
        int newDem = denominator * f.denominator;

        return new Fraction(newNum, newDem);
    }

    public Fraction division(Fraction f) throws DenominatorIsZeroException {
        if (denominator == 0 || f.denominator == 0)
            throw new DenominatorIsZeroException("Denominator can't be zero.");

        int newNum = numerator * f.denominator;
        int newDem = denominator * f.numerator;

        return new Fraction(newNum, newDem);
    }

    public Fraction multiplication(Fraction f) throws DenominatorIsZeroException {
        if (denominator == 0 || f.denominator == 0)
            throw new DenominatorIsZeroException("Denominator can't be zero.");

        int newNum = numerator * f.numerator;
        int newDem = denominator * f.denominator;

        return new Fraction(newNum, newDem);
    }
}

class DenominatorIsZeroException extends Exception {
    DenominatorIsZeroException(String message) {
        System.out.println(message);
    }
}
