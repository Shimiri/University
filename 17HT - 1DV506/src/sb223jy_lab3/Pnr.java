package sb223jy_lab3;

public class Pnr {
    private static final int PNR_LENGTH = 11;
    private static final int VALID_YEAR_DOWN = 1;
    private static final int VALID_YEAR_UP = 99;
    private static final int VALID_MONTH_DOWN = 1;
    private static final int VALID_MONTH_UP = 12;
    private static final int VALID_DAYS_DOWN = 1;
    private static final int[] VALID_DAYS_UP = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        String personNumber = "950826-6799";
        System.out.println("First part of a pnr: " + getFirstPart(personNumber));
        System.out.println("Second part of a pnr: " + getSecondPart(personNumber));
        System.out.println("Is female number: " + isFemaleNumber(personNumber));
        System.out.println("Is male number: " + isMaleNumber(personNumber));
        System.out.println("Two pnr numbers are equal: " + areEqual("950826-6799", "950826-6789"));
        System.out.println("Pnr is correct: " + isCorrect(personNumber));
    }

    private static String getFirstPart(String pnr) {
        return pnr.substring(0, 6);
    }

    private static String getSecondPart(String pnr) {
        return pnr.substring(7, 11);
    }

    private static boolean isFemaleNumber(String pnr) {
        return Integer.parseInt(String.valueOf(pnr.charAt(9))) % 2 == 0;
    }

    private static boolean isMaleNumber(String pnr) {
        return Integer.parseInt(String.valueOf(pnr.charAt(9))) % 2 == 1;
    }

    private static boolean areEqual(String pnrOne, String pnrTwo) {
        for (int i = 0; i < PNR_LENGTH; i++) {
            if (pnrOne.charAt(i) != pnrTwo.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCorrect(String pnr) {
        int year = Integer.parseInt(pnr.substring(0, 2));
        int month = Integer.parseInt(pnr.substring(2, 4));
        int day = Integer.parseInt(pnr.substring(4, 6));

        if (year < VALID_YEAR_DOWN || year > VALID_YEAR_UP)
            return false;
        if (month < VALID_MONTH_DOWN || month > VALID_MONTH_UP)
            return false;
        if (day < VALID_DAYS_DOWN || day > VALID_DAYS_UP[month - 1])
            return false;

        String modifiedPnr = pnr.substring(0, 6) + pnr.substring(7, 11);
        int sum = ChecksumFormula(modifiedPnr);
        return sum % 10 == 0;
    }

    private static int ChecksumFormula(String pnr) {
        int pnrLength = pnr.length();
        int sum = 0;

        boolean isDouble = false;

        for (int i = pnrLength - 1; i >= 0; i--) {
            int digit = Integer.parseInt(String.valueOf(pnr.charAt(i)));
            if (isDouble) {
                sum += DoubleDigitSum(digit);
                isDouble = false;
            }
            else {
                sum += digit;
                isDouble = true;
            }
        }

        return sum;
    }

    private static int DoubleDigitSum(int digit) {
        int sum = digit * 2;
        if (sum >= 10) {
            sum = 1 + (sum % 10);
        }
        return sum;
    }
}

