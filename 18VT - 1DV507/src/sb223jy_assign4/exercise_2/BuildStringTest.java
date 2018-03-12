package sb223jy_assign4.exercise_2;

public class BuildStringTest {
    public static void main(String[] args) {
        appendStrings();
    }

    private static void concatStrings() {
        String str = "";
        String shortStr = "a";
        String longStr = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        int numOfConcat = 0;
        long timeStart = 0;
        long endTime = 0;

        System.out.println("Time Start!");
        timeStart = System.nanoTime();
        while (1000 > ((endTime - timeStart) / 1000000)) {
            str = str + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"; numOfConcat++;
            endTime = System.nanoTime();
        }
        System.out.println("Time End!");

        System.out.println("Short string results:\n\tTime: " + ((endTime - timeStart) / 1000000) +"MS\n\tNumber of concatenations: " + numOfConcat + "\n\t" + "Length of string: " + str.length());

    }

    private static void appendStrings() {
        StringBuilder sb = new StringBuilder();
        String shortStr = "a";
        String longStr = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        int numOfAppend = 0;
        long startTime = 0;
        long endTime = 0;

        System.out.println("Time Start!");
        startTime = System.nanoTime();
        while (1000 > ((endTime - startTime) / 1000000)) {
            sb.append("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"); numOfAppend++;

            endTime = System.nanoTime();
        }
        System.out.println("Time End!");

        String str = sb.toString();
        System.out.println("Short string results:\n\tTime: " + ((endTime - startTime) / 1000000) +"MS\n\tNumber of appends: " + numOfAppend + "\n\t" + "Length of string: " + str.length());
    }
}
