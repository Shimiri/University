package sb223jy_lab3;

public class FractionMain {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 3);
        try {
            System.out.println(f1.addition(f2));
        } catch (DenominatorIsZeroException e) { }
        try {
            System.out.println(f1.subtraction(f2));
        } catch (DenominatorIsZeroException e) { }
        try {
            System.out.println(f1.multiplication(f2));
        } catch (DenominatorIsZeroException e) { }
        try {
            System.out.println(f1.division(f2));
        } catch (DenominatorIsZeroException e) { }

        System.out.println();

        Fraction f3 = new Fraction(-1, 5);
        Fraction f4 = new Fraction(-1, 5);
        System.out.println("Fraction is negative: " + f3.isNegative());
        System.out.println("Fractions are equal: " + f3.isEqualTo(f4));
    }
}
